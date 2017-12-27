/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

import com.fasterxml.jackson.core.JsonProcessingException;
import static com.mycompany.netreali.BagOfWordsSimilarity.consineTextSimilarity;
import io.cortical.retina.client.LiteClient;
import io.cortical.retina.rest.ApiException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oshrat
 */
public class ArticleCompareHandler {

    private final double SIMILAR_SCORE = 0.5;
    private LiteClient lite;
    
    public ArticleCompareHandler(){
        // Create "lightweight" LiteClient instance
        this.lite =  new  io.cortical.retina.client.LiteClient("b5c27bf0-ea29-11e7-9586-f796ac0731fb");
    }

    public double compare(ArrayList<String> target, ArrayList<String> source) {
        if (target.isEmpty()) {
            return 0.0;
        }
        
        int foundCount = 0;
        Iterator<String> itr = target.iterator();
        while (itr.hasNext()) {
            String term = itr.next();                        
            if (source.contains(term)) {
                foundCount++;
            }
        }       
        
        return (double)foundCount / target.size();
    }

    public double calcSimilarity(Map<String, ArrayList<String>> target, Map<String, ArrayList<String>> source) {
        double settlementsScore = compare(target.get("settlements"), source.get("settlements"));
        double datetimesScore = compare(target.get("dates"), source.get("dates"));
        double namesScore = compare(target.get("names"), source.get("names"));       
        
        return (settlementsScore + datetimesScore + namesScore) / 3;
    }

    public void compareArticles(String target, int searchTaskId) {
        System.out.println("target: " + target);
        String[] targetBody = target.split(" ");
        for (int i = 0; i < targetBody.length; i++) {
            targetBody[i] = targetBody[i]
                    .toLowerCase()
                    .replace(",", "")
                    .replace(".", "")
                    .replace("\'", "")
                    .replace("\"", "")
                    .trim();
        }  
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "SELECT article_id, body from translated_articles";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            String insert = "INSERT INTO similar_articles (extracted_meta_id, article_id, search_task_id, similarity_score) VALUES(?, ?, ?, ?);";
            PreparedStatement insertPreparedStmt = conn.prepareCall(insert);

            ResultSet rs = preparedStmt.executeQuery();           
            while (rs.next()) {
                
                String[] articleBody = rs.getString("body").split(" ");
                for (int i = 0; i < articleBody.length; i++) {
                    articleBody[i] = articleBody[i]
                            .toLowerCase()
                            .replace(",", "")
                            .replace(".", "")
                            .replace("\'", "")
                            .replace("\"", "")
                            .trim();
                }                
                String joinedBody = String.join(" ", articleBody);
                String joinedTarget = String.join(" ", targetBody);
                //double similarityScore = consineTextSimilarity(targetBody, articleBody);
                
                // Compute the similarity between two texts
                double similarityScore = lite.compare(joinedTarget, joinedBody);
                System.out.println("similarityScore: " + similarityScore);
                if (similarityScore >= SIMILAR_SCORE) {
                    System.out.println("sScore: " + similarityScore);
                    insertPreparedStmt.setInt(1, 1);
                    insertPreparedStmt.setInt(2, rs.getInt("article_id"));
                    insertPreparedStmt.setInt(3, searchTaskId);
                    insertPreparedStmt.setDouble(4, similarityScore);

                    insertPreparedStmt.execute();
                }
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException | ApiException ex) {
            Logger.getLogger(ArticleCompareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}
