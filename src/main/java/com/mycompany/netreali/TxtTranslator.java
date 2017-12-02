/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

// Imports the Google Cloud client library
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oshrat
 */
public class TxtTranslator {

    public static String translate(String txt) {
        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        String translatedText = "";
        try {
            // Translates some text into English
            translatedText = translate.translate(
                txt,
                TranslateOption.sourceLanguage("iw"),
                TranslateOption.targetLanguage("en"))
                .getTranslatedText();                                
        } catch (Exception ex){
            Logger.getLogger(TxtTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if ("".equals(translatedText)) {
            System.out.println("ERROROROROROR!!!!!, EMPTY TEXT FOR " + txt);
        }
        
        return translatedText;
    }

    public static String translateAndSave(String txt, int articleId) { 
        String translatedTxt = "";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "SELECT id, body from translated_articles WHERE article_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, articleId);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                // skipping this translate operation if this article was already translated
                String foundText = rs.getString("body");
                conn.close();
                return foundText;
            }
            
            // translating the text
            translatedTxt = translate(txt);
            
            if (!"".equals(translatedTxt)) {
                // the mysql insert statement
                String insert = "INSERT INTO translated_articles (article_id, body) VALUES (?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement insertPreparedStmt = conn.prepareStatement(insert);
                insertPreparedStmt.setInt(1, articleId);
                insertPreparedStmt.setString(2, translatedTxt);           

                // execute the preparedstatement
                insertPreparedStmt.execute();                        
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TxtTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return translatedTxt;
    }
    
    public static void main(String... args) throws Exception {
        // The text to translate
        String text = "אזעקת השווא שגרמה לבהלה ביישובי גוש דן נבעה מטעות אנוש - כך עולה מתחקיר שנערך בראשות מפקד פיקוד העורף, אלוף תמיר ידעי. ב-2 בנובמבר התעוררו תושבים רבים באזור המרכז בשעה 2:48 בלילה לקול אזעקה. התושבים דיווחו על אזעקה עולה ויורדת שנשמעה בתל אביב, בגבעתיים, בת-ים, חולון ובאזורים נוספים בגוש דן. בתום התחקיר נמסר: \"פיקוד העורף הפיק לקחים מהאירוע, אותם יישם עד תום ופועל לצמצום מקרי אזעקות שווא במטרה לשמור על שגרת יומם של אזרחי ישראל\". האזעקה הופעלה על רקע מתיחות ביטחונית בשתי גזרות, מצפון ומדרום. שלושה ימים קודם לכן פוצצה המנהרה שחפר הג'יהאד האיסלאמי מרצועת עזה לתוך שטח ישראל. בפיצוץ נהרגו 12 מחבלים מהג'יאהד האיסלאמי ומהחמאס, בהם בכירים. התעורר חשש שלמרות התנגדות החמאס, בארגון הג'יהאד האיסלאמי יתקשו להבליג על המכה שספגו, וישגרו רקטות לעבר ישראל. מסיבה זו בוטל תרגיל של פיקוד העורף, שבמסגרתו היו אמורים לפעול צופרים ברחבי גוש דן. אזעקת השווא: על רקע חשש מתגובה של הג'יהאד על פיצוץ המנהרה(צילום: EPA) מצפון, הורגשה מתיחות לאחר שלפי דיווחים סוריים תקף חיל האוויר, שעות לפני שהופעלו הצופרים, מטרה באיזור העיר חומס. בתגובה, שיגרו הסורים טילי נ\"מ לעבר מטוסי חיל-האוויר. מצאתם טעות בכתבה? כתבו לנו";
        System.out.printf("Text: %s%n", text);

        String transText = TxtTranslator.translate(text);
        System.out.printf("Translation: %s%n", transText);
    }
}
