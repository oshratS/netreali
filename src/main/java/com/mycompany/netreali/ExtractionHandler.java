/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;

/**
 *
 * @author oshrat
 */
public class ExtractionHandler {

    public Map<String, ArrayList<String>> extract(String text, int articleId) {
        String transText = null;
        try {
            // Translating the given text to english
            transText = TxtTranslator.translateAndSave(text, articleId);
            System.out.printf("Translation: %s%n", transText);
        } catch (Exception ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (transText == null || "".equals(transText.trim())) {
            return null;
        }
        
        Map<String, ArrayList<String>> extracted = new HashMap<>();

        try {
            // Extracting settlements
            SettlementExtractor SettlExtractor = new SettlementExtractor();
            ArrayList<String> settlExtracted = SettlExtractor.extract(transText);                     
            System.out.printf("Places: %s%n", settlExtracted);
            
            extracted.put("settlements", settlExtracted);
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Extracting names
            NamesExtractor NamesExtractor = new NamesExtractor();
            ArrayList<String> namesExtracted = NamesExtractor.extract(transText);
            System.out.printf("Names: %s%n", namesExtracted.toString());

            extracted.put("names", namesExtracted);
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Extracting datetimes
        DateTimeExtractor dateExtractor = new DateTimeExtractor();
        ArrayList<String> datesExtracted = dateExtractor.extract(transText);
        extracted.put("dates", datesExtracted);
        System.out.printf("Dates: %s%n", datesExtracted.toString());

        return extracted;
    }

    public void extractAndSave(String text, int articleId) {
        Map<String, ArrayList<String>> extracted = extract(text, articleId);
        if (extracted == null) {
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            // the mysql insert statement
            String query = "INSERT INTO extracted_meta (article_id, settlements, dates, names)"
                    + " VALUES (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, articleId);
            
            String strSettlements = "";
            for(String settlement : extracted.get("settlements")) {
                strSettlements += "," + settlement;
            }
            strSettlements = strSettlements.replaceFirst(",", "");             
            preparedStmt.setString(2, strSettlements);
            
            String strDates = "";
            for(String date : extracted.get("dates")) {
                strDates += "," + date;
            }
            strDates = strDates.replaceFirst(",", "");             
            preparedStmt.setString(3, strDates);
            
            String strNames = "";
            for(String name : extracted.get("names")) {
                strNames += "," + name;
            }
            strNames = strNames.replaceFirst(",", "");             
            preparedStmt.setString(4, strNames);

            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void extractAndSave() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {            
            String query = "SELECT id, body FROM articles";            
            String extractedQuery = "SELECT id, article_id FROM extracted_meta WHERE article_id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(query);            
            ResultSet rs = preparedStmt.executeQuery();
            
            PreparedStatement extractedPreparedStmt = conn.prepareStatement(extractedQuery);
            ResultSet extractedRs;

            while (rs.next()) {
                // check if already extracted
                extractedPreparedStmt.setInt(1, rs.getInt("id"));
                extractedRs = extractedPreparedStmt.executeQuery();
                if (!extractedRs.next()) {                
                    extractAndSave(rs.getString("body"), rs.getInt("id"));
                } else {
                    String transText = TxtTranslator.translateAndSave(rs.getString("body"), rs.getInt("id"));
                    System.out.printf("Translation: %s%n", transText);
                }               
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
