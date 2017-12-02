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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oshrat
 */
public class SearchHandler {

    final private String title;
    final private String body;
    final private String date;
    private int searchTaskId;

    public SearchHandler(String title, String body, String date) {
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public void search() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "INSERT INTO search_tasks (title, body, date)"
                    + " VALUES (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, title);
            preparedStmt.setString(2, body);
            preparedStmt.setString(3, date);

            // execute the preparedstatement
            preparedStmt.execute();

            try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("created search task successfully");
                    searchTaskId = generatedKeys.getInt(1);

                    // start scraping new articles from different sources
                    System.out.println("    scraping articles...");
                    ScrapingHandler scraper = new ScrapingHandler();
                    scraper.scrapeAndSave(searchTaskId);
                    System.out.println("scraped articles successfully");

                    // extract meta text for the articles
                    System.out.println("    extracting meta text...");
                    ExtractionHandler extractor = new ExtractionHandler();
                    extractor.extractAndSave();
                    System.out.println("extracted meta text successfully");

                    // extract meta text for the body of the search task                    
                    Map<String, ArrayList<String>> searchTaskExtractedMeta = extractor.extract(body);

                    // find similar articles (by term similarity)
                    System.out.println("    comparing articles...");
                    ArticleCompareHandler articleComparer = new ArticleCompareHandler();
                    articleComparer.compareArticles(searchTaskExtractedMeta, searchTaskId);

                    // perform sentiment analysis
                    // present results based on analysis
                } else {
                    throw new SQLException("Creating search task failed, no ID obtained.");
                }
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(netRealiGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void truncate_search_tables() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "TRUNCATE articles;";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated articles successfully");

            query = "TRUNCATE search_tasks;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated search_tasks successfully");

            query = "TRUNCATE extracted_meta;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated extracted_meta successfully");

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(netRealiGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        String title = "גבר נמצא ירוי ומת במכונית בצפון";
        String body = "גבר בשנות ה-50 לחייו נמצא הערב (יום ו') ירוי ומת במכונית ליד הכפר עין אל-אסד שבצפון.  חובשים ופרמדיקים של מגן דוד אדום שהוזעקו למקום נאלצו לקבוע את מותו. האיש נמצא פצוע בפלג גופו העליון, והמשטרה מסרה כי החשד הוא שמדובר ברצח.  הרקע למעשה אינו ברור וטרם נעצרו חשודים. תושבים בעין אל-אסד סיפרו כי בתחילה חשבו שהאיש נהרג בתאונה - ורק אחר כך התברר שהוא נורה למוות.  המשטרה מסרה כי היא בודקת כמה כיווני חקירה, ותעדכן בהתפתחויות בהמשך.";
        String date = "01.12.17 19:22";
        SearchHandler sh = new SearchHandler(title, body, date);
        sh.truncate_search_tables();
        sh.search();
    }
}
