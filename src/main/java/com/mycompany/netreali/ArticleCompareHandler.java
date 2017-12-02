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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oshrat
 */
public class ArticleCompareHandler {

    private final double SIMILAR_SCORE = 0.7;

    public double compare(ArrayList<String> target, ArrayList<String> source) {
        int foundCount = 0;
        Iterator<String> itr = target.iterator();
        while (itr.hasNext()) {
            String term = itr.next();
            if (source.contains(term)) {
                foundCount++;
            }
        }

        return foundCount / target.size();
    }

    public double calcSimilarity(Map<String, ArrayList<String>> target, Map<String, ArrayList<String>> source) {
        double settlementsScore = compare(target.get("settlements"), source.get("settlements"));
        double datetimesScore = compare(target.get("dates"), source.get("dates"));
        double namesScore = compare(target.get("names"), source.get("names"));

        return (settlementsScore + datetimesScore + namesScore) / 3;
    }

    public void compareArticles(Map<String, ArrayList<String>> target, int targetArticleId) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "SELECT * from extracted_meta";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            String insert = "INSERT INTO similar_articles (extracted_meta_id, article_id, similarity_score) VALUES(?, ?, ?);";
            PreparedStatement insertPreparedStmt = conn.prepareCall(insert);

            ResultSet rs = preparedStmt.executeQuery();

            Map<String, ArrayList<String>> extracted = new HashMap<>();
            while (rs.next()) {
                extracted.put("settlements", new ArrayList<>(Arrays.asList(rs.getString("settlements").split(","))));
                extracted.put("dates", new ArrayList<>(Arrays.asList(rs.getString("dates").split(","))));
                extracted.put("names", new ArrayList<>(Arrays.asList(rs.getString("names").split(","))));

                double similarityScore = calcSimilarity(target, extracted);
                if (similarityScore > SIMILAR_SCORE) {
                    insertPreparedStmt.setInt(1, rs.getInt("id"));
                    insertPreparedStmt.setInt(2, rs.getInt("article_id"));
                    insertPreparedStmt.setInt(3, targetArticleId);
                    insertPreparedStmt.setDouble(4, similarityScore);

                    insertPreparedStmt.execute();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
