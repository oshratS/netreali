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

    public Map<String, ArrayList<String>> extract(String text) {
        String transText = null;
        try {
            // Translating the given text to english
            transText = TxtTranslator.translate(text);
            System.out.printf("Translation: %s%n", transText);
        } catch (Exception ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        Map<String, ArrayList<String>> extracted = new HashMap<>();

        try {
            // Extracting settlements
            SettlementExtractor SettlExtractor = new SettlementExtractor();
            ArrayList<String> settlExtracted = SettlExtractor.extract(transText);
            System.out.printf("Places: %s%n", settlExtracted.toString());

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
        Map<String, ArrayList<String>> extracted = extract(text);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            // the mysql insert statement
            String query = "INSERT INTO extracted_meta (article_id, settlements, dates, names)"
                    + " VALUES (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, articleId);
            preparedStmt.setString(2, extracted.get("settlements").toString());
            preparedStmt.setString(3, extracted.get("dates").toString());
            preparedStmt.setString(4, extracted.get("names").toString());

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void extractAndSave() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            // the mysql insert statement
            String query = "SELECT id, body FROM articles";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                extractAndSave(rs.getString("body"), rs.getInt("id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
