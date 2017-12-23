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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oshrat
 */
public class SearchHandler {    
    final private String body; 
    final private UINetReali context;
    private int searchTaskId;  

    public SearchHandler(String body, UINetReali context) {        
        this.body = body;        
        this.context = context;
    }

    public void search() {
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
                    System.out.println("    scraping articles...");
                    ScrapingHandler scraper = new ScrapingHandler();
                    // scraper.scrapeAndSave(searchTaskId);
                    System.out.println("scraped articles successfully");

                    // extract meta text for the articles
                    // System.out.println("    extracting meta text...");
                    // ExtractionHandler extractor = new ExtractionHandler();
                    // extractor.extractAndSave();
                    // System.out.println("extracted meta text successfully");
                    
                    // Translate text of all articles
                    System.out.println("    translating text...");
                    TxtTranslator translator = new TxtTranslator();
                    // translator.translateAndSave();
                    System.out.println("translated text successfully");

                    // translate the text for the body of the search task                    
                    String transBody = TxtTranslator.translate(body);
                    System.out.println("translated search task body: " + transBody);
                    
                    // extract meta text for the body of the search task                    
                    // Map<String, ArrayList<String>> searchTaskExtractedMeta = ExtractionHandler.extract(transBody);

                    // find similar articles (by term similarity)
                    System.out.println("    comparing articles...");
                    ArticleCompareHandler articleComparer = new ArticleCompareHandler();
                    articleComparer.compareArticles(transBody, searchTaskId);
                    System.out.println("compared articles successfully");

                    // perform sentiment analysis
                    System.out.println("    performing sentiment analysis on similar articles...");
                    SentimentAnalysisHandler sentimentAnalyser = new SentimentAnalysisHandler();
                    sentimentAnalyser.AnalyseSimilarArticles(searchTaskId);
                    System.out.println("performed sentiment analysis successfully");
                    
                    // present results based on analysis   
                    context.dispose();
                    UIFoundResults resGui = new UIFoundResults();
                    resGui.calculateResults();
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
            
             query = "TRUNCATE articles;";
             preparedStmt = conn.prepareStatement(query);
             preparedStmt.execute();
             System.out.println("truncated articles successfully");

            query = "TRUNCATE search_tasks;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated search_tasks successfully");

            query = "TRUNCATE translated_articles;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated translated_articles successfully");
            
            query = "TRUNCATE extracted_meta;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated extracted_meta successfully");
            
            query = "TRUNCATE similar_articles;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated similar_articles successfully");
            
            query = "TRUNCATE sentiment_analysis_score;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("truncated sentiment_analysis_score successfully");
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UINetReali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {        
        String body = "תקרית חמורה בדרום: הפלסטינים ירו היום (חמישי) פצצות מרגמה לעבר כוח צה\"ל שביצע עבודות הנדסיות על גבול הרצועה. לא היו נפגעים. צה\"ל השיב אש לעבר עמדות של ארגון חמאס. בעקבות הירי הופסקה תנועת הרכבות בין אשקלון לשדרות. הרכבות מדרום יגיעו עד נתיבות ואילו הרכבות מצפון ייעצרו באשדוד. אוטובוסים יפעלו מתי התחנות לרווחת הנוסעים. מוקדם יותר נשמעה באזור עוטף עזה אזעקת צבע אדום, אבל היא הוגדרה כהתרעת שווא. דובר צה\"ל מסר כי \"לפני זמן קצר תקף צה\"ל באמצעות ירי טנקים וכלי טיס של חיל האוויר ארבע מטרות טרור ברצועת עזה. התקיפה בוצעה בתגובה לירי תלול המסלול שבוצע לעבר מוצב צבאי בצפון רצועת עזה. צה\"ל רואה בארגון הטרור חמאס האחראי למתרחש ברצועת עזה\". כזכור, לפני כחודשיים פוצץ צה\"ל מנהרה של ארגון הג'יהאד האסלאמי שחדרה לתוך שטח ישראל. בתקרית נהרגו 12 אנשי הארגון, כשגופות של חמישה מהם נמצאות בידי ישראל. לאחר התקרית איים הג'יהאד האסלאמי לנקום בישראל, ובעקבות זאת נפרסו ברחבי הארץ סוללות כיפת ברזל. לפני כשבועיים הורה צה\"ל לסגור אתרי מטיילים בסמוך לרצועת עזה בעקבות חשש מפיגועי צלפים וירי נ\"ט של ארגון הטרור הסוני. בשבוע שעבר פורסם כי הוגש כתב אישום נגד פעיל חמאס שחצה את הגבול מעזה לישראל. איש, אחמד עביד, בן 23 משכונת סג'עייה, שבעזה, התגייס לארגון הטרור ב-2013. במסגרת פעילותו בחמאס עבר הכשרה צבאית ונטל חלק באימונים צבאיים בתחומי הנ\"ט, ההנדסה והצליפה. עוד עלה כי לקח חלק בחפירת מנהרות בגזרת מגוריו וכן שימש כפעיל כוח הריסון (אבטחת הגבולות) מטעם חמאס. משב\"כ והמשטרה נמסר כי בחקירתו של עביד התקבל מידע רב אודות פעילות מערך המנהרות של חמאס ברצועת עזה - הן מנהרות המיועדות לפעילות התקפית נגד ישראל, והן מנהרות המיועדות ללחימה מול כוחות צה\"ל בתוך שטח הרצועה. חקירתו של עביד חשפה פעם נוספת את פעילות הטרור של חמאס בתחום המנהרות לקידום פעילות טרור כנגד מדינת ישראל. ב-23 באוקטובר הוגש לבית המשפט המחוזי בבאר שבע כתב אישום חמור המייחס לעביד עבירות ביטחון חמורות. יום קודם לכן פורסם כי רשות המעברים במשרד הביטחון סיכלה הברחה של כמה טונות חומר נפץ שהיו בדרכן לגורמי הטרור בעזה. לאחרונה, בשלב ההרצה של המעבדה, הגיעה למעבר כרם שלום משאית, שהובילה מטען של שמנים לרכב, שעוררה את חשד הבודקים הביטחוניים. דגימות מהשמנים הועברו לבדיקת המעבדה, אשר זיהתה שלא מדובר בשמן מנוע תמים, אלא בחומר מסוכן, המיועד לייצור חומרי נפץ בכמות גדולה מאוד.";                        
        SearchHandler sh = new SearchHandler(body, null);
        sh.truncate_search_tables();
        // sh.search();               
    }
}
