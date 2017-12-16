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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.deeplearning4j.text.corpora.sentiwordnet.SWN3;

/**
 *
 * @author oshrat
 */
public class SentimentAnalysisHandler {
    private final String pathToSWN = "/sentiment/sentiwordnet.txt";
    private final SWN3 swn;
 
    public SentimentAnalysisHandler() {
        swn = new SWN3(pathToSWN);
    }
    
    public Double analyseText(String text) {        
        Double total = 0.0;        
        String[] bodyArr = text.split(" ");
        for (int i = 0; i < bodyArr.length; i++) {
            String word = bodyArr[i]
                    .toLowerCase()
                    .replace(",", "")
                    .replace(".", "")
                    .replace("\'", "")
                    .replace("\"", "")
                    .trim();
                        
            total += swn.extract(word);
        }
        
        return (Double)(total / bodyArr.length) * 100;
    }
    
    public void AnalyseSimilarArticles(int searchTaskId) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "SELECT ss.article_id, ta.body FROM similar_articles AS ss "
                    + "LEFT JOIN translated_articles AS ta ON ta.article_id = ss.article_id "
                    + "WHERE ss.search_task_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, searchTaskId);

            String insert = "INSERT INTO sentiment_analysis_score (article_id, search_task_id, score) VALUES(?, ?, ?);";
            PreparedStatement insertPreparedStmt = conn.prepareCall(insert);

            ResultSet rs = preparedStmt.executeQuery();           
            Double score;
            while (rs.next()) {
                score = analyseText(rs.getString("body"));
                
                insertPreparedStmt.setInt(1, rs.getInt("article_id"));
                insertPreparedStmt.setInt(2, searchTaskId);
                insertPreparedStmt.setDouble(3, score);                
                
                insertPreparedStmt.execute();
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public static void main(String args[]) {        
        SentimentAnalysisHandler sa = new SentimentAnalysisHandler();
        
        String body = "A serious incident in the south: Palestinians fired mortar shells at an IDF force carrying out engineering work on the border of the Gaza Strip on Thursday, causing no casualties. As a result of the shooting, the railway between Ashkelon and Sderot was stopped. The trains from the south will reach Netivot, while the trains from the north will stop in Ashdod. Buses will operate when the stations for the welfare of passengers. Earlier, a red alert sounded in the Gaza vicinity area, but it was defined as a false warning. The IDF Spokesperson stated that \"a short while ago, the IDF attacked four terrorist targets in the Gaza Strip by means of tank and air force fire, in response to high trajectory fire at an IDF post in the northern Gaza Strip. To what is happening in the Gaza Strip. \"Two months ago, the IDF blew up an Islamic Jihad tunnel that had penetrated into Israel. In the incident, 12 members of the organization were killed, with five of them in the hands of Israel. After the incident Islamic Jihad threatened to take revenge on Israel, and as a result, Iron Dome batteries were deployed throughout the country. About two weeks ago, the IDF ordered the closure of tourist sites near the Gaza Strip following fears of sniper attacks and anti-tank fire from the Sunni terrorist organization. Last week it was reported that an indictment had been filed against a Hamas activist who had crossed the border from Gaza into Israel. Ahmed Abid, 23, from the Saja'iya neighborhood in Gaza City, joined the terrorist organization in 2013. He also participated in the digging of tunnels in his area of ​​residence and served as Hamas' Harrison Force (border security). A report on the activity of Hamas' tunnel network in the Gaza Strip - tunnels intended for attacks against Israel and tunnels intended for fighting IDF forces inside the Gaza Strip - revealed the terrorist activity of Hamas in the area of ​​tunnels to promote terrorist activity against the State of Israel On October 23, an indictment was submitted to the Be'er Sheva District Court A day before that it was reported that the Crossings Authority in the Ministry of Defense had foiled the smuggling of several tons of explosives on their way to the terror elements in Gaza.Recently, at the start of the laboratory, a truck carrying a load of car oils arrived at the Kerem Shalom Crossing, The security examiners suspected that samples of the oils had been transferred to the laboratory, which identified them as not innocent engine oil, but rather dangerous material intended for the manufacture of explosives in a very large quantity.";                
        // String body = "I went today to buy an icecream at the center of town. people looked happy, it was a terrific time out. then we heard a boom but it was just a baloon exploding. i fealt scared but just for a moment";        
      
        Double total = sa.analyseText(body);
        System.out.println("total : " + total);         
    }
}
