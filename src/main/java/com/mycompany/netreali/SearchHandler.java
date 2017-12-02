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
    private int articleId;

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
                                        
                    // the mysql insert statement
                    String articlesQuery = "INSERT INTO articles (search_task_id, title, body, date, url)"
                            + " VALUES (?, ?, ?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement articlesPreparedStmt = conn.prepareStatement(articlesQuery, Statement.RETURN_GENERATED_KEYS);
                    articlesPreparedStmt.setInt(1, searchTaskId);
                    articlesPreparedStmt.setString(2, title);
                    articlesPreparedStmt.setString(3, body);
                    articlesPreparedStmt.setString(4, date);
                    articlesPreparedStmt.setString(5, "SEARCH_TASK");

                    // execute the preparedstatement
                    articlesPreparedStmt.execute();       
                    
                    try (ResultSet generatedArticleKeys = articlesPreparedStmt.getGeneratedKeys()) {
                        if (generatedArticleKeys.next()) {
                            System.out.println("created article for search task successfully");
                            articleId = generatedArticleKeys.getInt(1);

                            // start scraping new articles from different sources
                            System.out.println("    scraping articles...");
                            ScrapingHandler scraper = new ScrapingHandler();
                            // scraper.scrapeAndSave(searchTaskId);
                            System.out.println("scraped articles successfully");

                            // extract meta text for the articles
                            System.out.println("    extracting meta text...");
                            ExtractionHandler extractor = new ExtractionHandler();
                            // extractor.extractAndSave();
                            System.out.println("extracted meta text successfully");

                            // extract meta text for the body of the search task                    
                            Map<String, ArrayList<String>> searchTaskExtractedMeta = extractor.extract(body, articleId);

                            // find similar articles (by term similarity)
                            System.out.println("    comparing articles...");
                            ArticleCompareHandler articleComparer = new ArticleCompareHandler();
                            articleComparer.compareArticles(searchTaskExtractedMeta, articleId);
                            System.out.println("compared articles successfully");

                            // perform sentiment analysis
                            // present results based on analysis
                        } else {
                            throw new SQLException("Creating search task failed, no ID obtained.");
                        }
                    }
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
        String title = "פיגוע דקירה בערד: חייל נדקר למוות";
        String body = "פיגוע על רקע לאומני בערד: חייל כבן 20, שהמתין להסעה, נדקר למוות אמש (יום ה') סמוך לקניון בעיר. צוותי מד\"א ביצעו בו פעולות החייאה, אך בסופו של דבר נאלצו לקבוע את מותו. במשטרה אמרו כי ככל הנראה מדובר ברצח על רקע לאומני. סריקות מתנהלות אחר החשודים במעשה ומחסומים נפרסו באזור. בין היתר נבדק אם נגנב נשק מהחייל. כוחות צה\"ל ואנשי שב\"כ מסייעים לשוטרים כדי לנסות לתפוס את הרוצח או הרוצחים.  בשעה 21:26 נמסר למוקד מד\"א על חייל שנדקר בתחנת אוטובוס ברחוב הקנאים סמוך לקניון בערד. פאראמדיק מד\"א זיו שפירא סיפר: \"כשהגענו למקום ראינו צעיר כבן 20 שוכב מחוסר הכרה ללא דופק וללא נשימה עם פצעי דקירה בפלג גופו העליון, הענקנו לו טיפול רפואי מציל חיים וביצענו פעולות החייאה מתקדמות שבסופן נאלצנו לקבוע את מותו\". עדי ראייה סיפרו כי לאחר שהחייל נדקר הוא ניסה להזעיק עזרה ונפל על רכב שנסע במקום. הנהג, חסיד גור שסבר שמדובר באדם שנפגע בתאונה, הזעיק את כוחות מד\"א. הוא סיפר: \"נסעתי בכיכר, פתאום רץ אליי צעיר כבן 20 מהספסלים, חוסם לי את האוטו באמצע הכיכר. לא הבנתי מה זה. נעצרתי והזעקנו עזרה. הוא היה בהכרה, ניסה להגיד משהו ולא הצליח. באנו לעזור לו והוא נפל לקרקע. התקשרנו למד\"א וניסינו לעצור את הדימום. שמנו עליו מגבת\".  עד ראייה נוסף סיפר: \"בא אליו מישהו מאחור ודקר אותו. ראיתי אותו כשהוא שוכב. חבר שלי קרא לי כשהאירוע קרה. חבר שלי יצא וניסה לעצור את הדימום. לקח מגבת. הוא ניסה לחסום את פצע הדקירה. חברו אליו אנשי מד\"א ופינו אותו למנחת\". מפקד מרחב נגב במשטרה, תת-ניצב נתן בוזנה, אמר כי \"אנחנו עדיין לא יודעים לקבוע שמדובר באירוע טרור. הצפנו את השטח בכוחות ואנו מבצעים סריקות. בשלב הזה הוקפצו כל הכוחות המיוחדים - מסוק, כלבים, כוחות שיטור - כדי לנסות ליירט את מי שפגע בחייל. בכל היישובים במרחב עיבינו את כוחות הביטחון השוטף. אנחנו מבקשים לשמור על שגרה. על כל חשוד ורכב חשוד ניענה לקריאה באופן מיידי. אני מבקש מהציבור לגלות עירנות ועל כל דבר חשוד לקרוא לנו\". כוחות גדולים של משטרה פתחו בחקירה ועורכים סריקות. מחסומים הוצבו בכביש 31 ובכניסה לעיר. מסוק הועלה לאוויר כדי לסייע בחיפושים אחר המחבלים. במשטרה אמרו כי הם פועלים יחד עם גורמי ביטחון נוספים.  ראש העיר ערד, ניסן בן חמו, אמר כי \"הנחת העבודה היא כי מדובר בפיגוע. אין עדיין קביעה חד משמעית. אם זה אכן פיגוע, זהו הפיגוע הראשון בעיר\". למרות שככל הנראה מדובר בפיגוע לא ניתנו הנחיות מיוחדות לתושבי העיר. הערכת מצב נוספת תתבצע בשעות הלילה.  ";
        String date = "01.12.17 00:04";
        SearchHandler sh = new SearchHandler(title, body, date);
        // sh.truncate_search_tables();
        sh.search();
    }
}
