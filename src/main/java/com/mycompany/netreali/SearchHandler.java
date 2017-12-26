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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

enum Services {
    SCRAPE,
    EXTRACT,
    TRANSLATE,
    COMPARE,
    ANALYZE,
};

/**
 *
 * @author oshrat
 */
public class SearchHandler {    
    final private String body; 
    final private UINetReali context;
    private int searchTaskId;      
    private final Map<Services, Boolean> services;

    public SearchHandler(String body, UINetReali context, Map<Services, Boolean> services) {        
        this.body = body;        
        this.context = context;
        
        this.services = new HashMap<>();
        this.services.put(Services.SCRAPE, (services != null && services.containsKey(Services.SCRAPE)) ? services.get(Services.SCRAPE) : true);
        this.services.put(Services.EXTRACT, (services != null && services.containsKey(Services.EXTRACT)) ? services.get(Services.EXTRACT) : false);
        this.services.put(Services.TRANSLATE, (services != null && services.containsKey(Services.EXTRACT)) ? services.get(Services.TRANSLATE) : true);
        this.services.put(Services.COMPARE, (services != null && services.containsKey(Services.EXTRACT)) ? services.get(Services.COMPARE) : true);
        this.services.put(Services.ANALYZE, (services != null && services.containsKey(Services.EXTRACT)) ? services.get(Services.ANALYZE) : true);        
    }

    public void search() {
        truncate_search_tables();
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "INSERT INTO search_tasks (body)"
                    + " VALUES (?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);            
            preparedStmt.setString(1, body);            

            // execute the preparedstatement
            preparedStmt.execute();
            try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("created search task successfully");
                    searchTaskId = generatedKeys.getInt(1);                                     

                    // start scraping new articles from different sources
                    if (services.get(Services.SCRAPE) == true) {
                        System.out.println("    scraping articles...");
                        ScrapingHandler scraper = new ScrapingHandler();
                        scraper.scrapeAndSave(searchTaskId);
                        System.out.println("scraped articles successfully");
                    }

                    // extract meta text for the articles
                    if (services.get(Services.EXTRACT) == true) {
                        System.out.println("    extracting meta text...");
                        ExtractionHandler extractor = new ExtractionHandler();
                        extractor.extractAndSave();
                        System.out.println("extracted meta text successfully");
                    }
                    
                    // Translate text of all articles
                    if (services.get(Services.TRANSLATE) == true) {
                        System.out.println("    translating text...");
                        TxtTranslator translator = new TxtTranslator();
                        translator.translateAndSave();
                        System.out.println("translated text successfully");
                    }

                    // translate the text for the body of the search task                    
                    String transBody = TxtTranslator.translate(body);
                    System.out.println("translated search task body: " + transBody);
                    
                    // extract meta text for the body of the search task                    
                    // Map<String, ArrayList<String>> searchTaskExtractedMeta = ExtractionHandler.extract(transBody);

                    // find similar articles (by term similarity)
                    if (services.get(Services.COMPARE) == true) {
                        System.out.println("    comparing articles...");
                        ArticleCompareHandler articleComparer = new ArticleCompareHandler();
                        articleComparer.compareArticles(transBody, searchTaskId);
                        System.out.println("compared articles successfully");
                    }

                    // perform sentiment analysis
                    if (services.get(Services.ANALYZE) == true) {
                        System.out.println("    performing sentiment analysis on similar articles...");
                        SentimentAnalysisHandler sentimentAnalyser = new SentimentAnalysisHandler();
                        sentimentAnalyser.AnalyseSimilarArticles(searchTaskId);
                        System.out.println("performed sentiment analysis successfully");
                    }
                    
                    // present results based on analysis   
                    if (context != null) {
                        context.dispose();
                        UIFoundResults resGui = new UIFoundResults();
                        resGui.calculateResults();
                    }
                } else {
                    throw new SQLException("Creating search task failed, no ID obtained.");
                }
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UINetReali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void truncate_search_tables() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            PreparedStatement preparedStmt;
            String query;
           
            query = "TRUNCATE search_tasks;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated search_tasks successfully");

            
            if (services.get(Services.SCRAPE) == true) {
                query = "TRUNCATE articles;";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                System.out.println("truncated articles successfully");
            }
           
            if (services.get(Services.TRANSLATE) == true) {
                query = "TRUNCATE translated_articles;";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                System.out.println("truncated translated_articles successfully");
            }
            
            if (services.get(Services.EXTRACT) == true) {
                query = "TRUNCATE extracted_meta;";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                System.out.println("truncated extracted_meta successfully");
            }
            
            if (services.get(Services.COMPARE) == true) {
                query = "TRUNCATE similar_articles;";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                System.out.println("truncated similar_articles successfully");
            }
            
            if (services.get(Services.ANALYZE) == true) {
                query = "TRUNCATE sentiment_analysis_score;";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                System.out.println("truncated sentiment_analysis_score successfully");
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UINetReali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {        
        String body = "טראמפ איים - ומקיים: 285 מיליון דולרים יקוצצו מתקציב האו\"ם האיום של נשיא ארה\"ב לאור תוצאות ההצבעה נגד ההכרה בירושלים הופך למעשי • השגרירה ניקי היילי: \"חוסר היעילות והבזבוז של האו\"ם מוכרים היטב. לא נרשה עוד שינצלו את נדיבות העם האמריקני\" ך ביום חמישי האחרון, בדיון באו\"ם שבסיומו אימצה העצרת הכללית החלטה נגד ההכרה האמריקנית בירושלים כבירת ישראל, איימה שגרירת ארה\"ב ניקי היילי כי להצבעה יהיו השלכות כלכליות. שלשום, בצעד שכנראה כבר תוכנן עוד קודם לכן, הוכיחה היילי כי האיום שהשמיעה היה רציני. השגרירה האמריקנית הודיעה ביום ראשון כי ארה\"ב נשאה ונתנה עם האו\"ם על קיצוץ של 285 מיליון דולר מתקציב הארגון, שאותו הגדירה כ\"נפוח\". לדבריה, \"חוסר היעילות והבזבוז של האו\"ם מוכרים היטב. אנחנו לא נרשה עוד שינצלו את הנדיבות של העם האמריקני\". השגרירה הוסיפה כי ה\"קיצוץ ההיסטורי\" הוא צעד בכיוון הנכון והבטיחה כי ארה\"ב תנקוט צעדים נוספים כדי לקדם ארגון יעיל ואחראי יותר. \"נוסף על החיסכון המשמעותי, הפחתנו במנגנוני הניהול והתמיכה המנופחים של האו\"ם, עיגנו את התמיכה בסדרי עדיפויות אמריקניים ברחבי העולם והשתתנו יותר משמעת ואחריות לאורכה ולרוחבה של המערכת\", נכתב בהודעה מטעם משלחת ארה\"ב לאו\"ם. הקיצוץ מתייחס לתקציב האו\"ם לשנת 2019-2018, והיילי הביעה תקווה כי תוכל לסייע ליישם קיצוצים נוספים גם בשנים הבאות. הצעד מגיע ימים ספורים אחרי הדיון באו\"ם, שעוד לפניו הבטיחה השגרירה האמריקנית כי ארה\"ב \"תרשום שמות\" במהלך ההצבעה - מסר שעליו חזרה גם בנאומה בעצרת. \"אנו נזכור את היום הזה שבו הותקפנו בעצרת האו\"ם על השימוש בריבונות שלנו\", הטיחה היילי מעל בימת האו\"ם, \"אנו נזכור זאת כשיבקשו מאיתנו לשלם. אנחנו נשים את השגרירות שלנו בירושלים - זה הדבר הנכון לעשות. ההחלטה היום לא תשנה זאת. ההחלטה הזו תשנה את האופן שבו האמריקנים תופסים את האו\"ם ואת המדינות שלא מכבדות אותנו באו\"ם. נזכור זאת כשיקראו לנו לתרום שוב לאו\"ם וכשמדינות יבקשו את הכספים והתמיכה שלנו\"";
        
        Map<Services, Boolean> services = new HashMap<>();
        services.put(Services.SCRAPE, false);
        services.put(Services.EXTRACT, false);
        services.put(Services.TRANSLATE, false);
        services.put(Services.COMPARE, true);
        services.put(Services.ANALYZE, true);
        
        SearchHandler sh = new SearchHandler(body, null, services);       
        sh.search();               
    }
}
