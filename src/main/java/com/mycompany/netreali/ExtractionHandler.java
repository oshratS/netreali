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
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author oshrat
 */
public class ExtractionHandler {

    public static Map<String, ArrayList<String>> extract(String text) { 
        Map<String, ArrayList<String>> extracted = new HashMap<>();

        try {
            // Extracting settlements
            SettlementExtractor SettlExtractor = new SettlementExtractor();
            ArrayList<String> settlExtracted = SettlExtractor.extract(text);          
            dedupe(settlExtracted);
            System.out.printf("Places: %s%n", settlExtracted);                                                
            
            extracted.put("settlements", settlExtracted);
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Extracting names
            NamesExtractor NamesExtractor = new NamesExtractor();
            ArrayList<String> namesExtracted = NamesExtractor.extract(text);
            dedupe(namesExtracted);
            System.out.printf("Names: %s%n", namesExtracted.toString());           
            
            extracted.put("names", namesExtracted);
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Extracting datetimes
        DateTimeExtractor dateExtractor = new DateTimeExtractor();
        ArrayList<String> datesExtracted = dateExtractor.extract(text);
        dedupe(datesExtracted);
        extracted.put("dates", datesExtracted);        
        System.out.printf("Dates: %s%n", datesExtracted.toString());

        return extracted;
    }

    public void extractAndSave(String text, int articleId) {
        String transText = null;
        try {
            // Translating the given text to english
            transText = TxtTranslator.translateAndSave(text, articleId);
            System.out.printf("Translation: %s%n", transText);
        } catch (Exception ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (transText == null || "".equals(transText.trim())) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, "Couldn't translate the text, ending extraction");
            return;
        }
        
        Map<String, ArrayList<String>> extracted = extract(text);
        if (extracted == null) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, "Couldn't extract meta for the text, ending extraction");
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
                }               
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // convert ArrayList to Set and back to remove duplicates
    private static void dedupe(ArrayList<String> list) {
        Set<String> hs = new HashSet<>();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);              
    }
    
    public static void main(String args[]) {
        String text = " The Ministerial Committee on Legislation approved Sunday the memorandum of the law submitted by Defense Minister Avigdor Lieberman to cancel the restriction on the realization of the monetary deposit for discharged soldiers. According to the new plan of the Ministry of Defense, every soldier will have the option of withdrawing the money for any purpose without restriction. This is contrary to the current law, according to which a discharged soldier can withdraw the deposit in the first five years after his release, for only five purposes: study, business, apartment purchase, marriage and driving lessons. The Finance Ministry initially objected to lifting the restrictions on the realization of the deposit, and explained its objection to the fact that the bill does not contain a new cost, but a change of NIS 4 billion is very significant in the state budget and a budget source must be found for the coming years. Before the ministerial committee discussion, Lieberman attacked the Finance Ministry&#39;s position and said, &quot;I was surprised that this is not an additional budget, but rather money that belongs entirely to the soldiers, by law and with that it is impossible to play.&quot; Hopes that the finance minister will instruct his ministry officials to support the bill in the ministerial committee on legislation. &quot";
        Map<String, ArrayList<String>> ext = ExtractionHandler.extract(text);                
    }
}
