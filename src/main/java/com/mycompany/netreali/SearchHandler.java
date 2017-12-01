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
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "zxasqw12");
            
            // the mysql insert statement
            String query = "INSERT INTO search_tasks (title, body, date)"
              + " VALUES (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, title);
            preparedStmt.setString (2, body);
            preparedStmt.setString(3, date);

            // execute the preparedstatement
            preparedStmt.execute();                        
            
            try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    searchTaskId = generatedKeys.getInt(1);
                    
                    // extract meta text for the body of the search task
                    // ExtractionHandler extractor = new ExtractionHandler();
                    // extractor.extractAndSave(body, CREATE AN ARTICLE FROM IT AND THEN PUT THAT ID HERE); 
                   
                    // start scraping new articles from different sources
                    ScrapingHandler scraper = new ScrapingHandler();
                    scraper.scrapeAndSave(searchTaskId);
                   
                   // find similar articles (by bag of words similarity)
                   
                   // perform sentiment analysis
                   
                   // present results based on analysis
                }
                else {
                    throw new SQLException("Creating search task failed, no ID obtained.");
                }
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(netRealiGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        String title = "בהלה בגוש דן";
        String body = "אזעקת השווא שגרמה לבהלה ביישובי גוש דן נבעה מטעות אנוש - כך עולה מתחקיר שנערך בראשות מפקד פיקוד העורף, אלוף תמיר ידעי. ב-2 בנובמבר התעוררו תושבים רבים באזור המרכז בשעה 2:48 בלילה לקול אזעקה. התושבים דיווחו על אזעקה עולה ויורדת שנשמעה בתל אביב, בגבעתיים, בת-ים, חולון ובאזורים נוספים בגוש דן. בתום התחקיר נמסר: \"פיקוד העורף הפיק לקחים מהאירוע, אותם יישם עד תום ופועל לצמצום מקרי אזעקות שווא במטרה לשמור על שגרת יומם של אזרחי ישראל\". האזעקה הופעלה על רקע מתיחות ביטחונית בשתי גזרות, מצפון ומדרום. שלושה ימים קודם לכן פוצצה המנהרה שחפר הג'יהאד האיסלאמי מרצועת עזה לתוך שטח ישראל. בפיצוץ נהרגו 12 מחבלים מהג'יאהד האיסלאמי ומהחמאס, בהם בכירים. התעורר חשש שלמרות התנגדות החמאס, בארגון הג'יהאד האיסלאמי יתקשו להבליג על המכה שספגו, וישגרו רקטות לעבר ישראל. מסיבה זו בוטל תרגיל של פיקוד העורף, שבמסגרתו היו אמורים לפעול צופרים ברחבי גוש דן. אזעקת השווא: על רקע חשש מתגובה של הג'יהאד על פיצוץ המנהרה(צילום: EPA) מצפון, הורגשה מתיחות לאחר שלפי דיווחים סוריים תקף חיל האוויר, שעות לפני שהופעלו הצופרים, מטרה באיזור העיר חומס. בתגובה, שיגרו הסורים טילי נ\"מ לעבר מטוסי חיל-האוויר. מצאתם טעות בכתבה? כתבו לנו";
        String date = "10.5.2017 12:34";
        SearchHandler sh = new SearchHandler(title, body, date);
        sh.search();
    }
}
