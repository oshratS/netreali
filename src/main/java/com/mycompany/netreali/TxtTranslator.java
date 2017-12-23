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
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.text.similarity.CosineDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.apache.commons.text.similarity.HammingDistance;
import org.apache.commons.text.similarity.JaccardDistance;

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
        
        String unescapedTranslatedText = StringEscapeUtils.unescapeHtml(translatedText);
        
        return unescapedTranslatedText;
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
    
    public void translateAndSave() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {            
            String query = "SELECT id, body FROM articles";                        

            PreparedStatement preparedStmt = conn.prepareStatement(query);            
            ResultSet rs = preparedStmt.executeQuery();                        

            while (rs.next()) {                
               TxtTranslator.translateAndSave(rs.getString("body"), rs.getInt("id"));          
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TxtTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String... args) throws Exception {
        // The text to translate
//        String text = "אזעקת השווא שגרמה לבהלה ביישובי גוש דן נבעה מטעות אנוש - כך עולה מתחקיר שנערך בראשות מפקד פיקוד העורף, אלוף תמיר ידעי. ב-2 בנובמבר התעוררו תושבים רבים באזור המרכז בשעה 2:48 בלילה לקול אזעקה. התושבים דיווחו על אזעקה עולה ויורדת שנשמעה בתל אביב, בגבעתיים, בת-ים, חולון ובאזורים נוספים בגוש דן. בתום התחקיר נמסר: \"פיקוד העורף הפיק לקחים מהאירוע, אותם יישם עד תום ופועל לצמצום מקרי אזעקות שווא במטרה לשמור על שגרת יומם של אזרחי ישראל\". האזעקה הופעלה על רקע מתיחות ביטחונית בשתי גזרות, מצפון ומדרום. שלושה ימים קודם לכן פוצצה המנהרה שחפר הג'יהאד האיסלאמי מרצועת עזה לתוך שטח ישראל. בפיצוץ נהרגו 12 מחבלים מהג'יאהד האיסלאמי ומהחמאס, בהם בכירים. התעורר חשש שלמרות התנגדות החמאס, בארגון הג'יהאד האיסלאמי יתקשו להבליג על המכה שספגו, וישגרו רקטות לעבר ישראל. מסיבה זו בוטל תרגיל של פיקוד העורף, שבמסגרתו היו אמורים לפעול צופרים ברחבי גוש דן. אזעקת השווא: על רקע חשש מתגובה של הג'יהאד על פיצוץ המנהרה(צילום: EPA) מצפון, הורגשה מתיחות לאחר שלפי דיווחים סוריים תקף חיל האוויר, שעות לפני שהופעלו הצופרים, מטרה באיזור העיר חומס. בתגובה, שיגרו הסורים טילי נ\"מ לעבר מטוסי חיל-האוויר. מצאתם טעות בכתבה? כתבו לנו";
//        System.out.printf("Text: %s%n", text);
//
//        String transText = TxtTranslator.translate(text);
//        System.out.printf("Translation: %s%n", transText);

        String title = "פצמ\"רים נורו לעבר כוח צה\"ל שעבד על גבול רצועת עזה";
        String body = "תקרית חמורה בדרום: הפלסטינים ירו היום (חמישי) פצצות מרגמה לעבר כוח צה\"ל שביצע עבודות הנדסיות על גבול הרצועה. לא היו נפגעים. צה\"ל השיב אש לעבר עמדות של ארגון חמאס. בעקבות הירי הופסקה תנועת הרכבות בין אשקלון לשדרות. הרכבות מדרום יגיעו עד נתיבות ואילו הרכבות מצפון ייעצרו באשדוד. אוטובוסים יפעלו מתי התחנות לרווחת הנוסעים. מוקדם יותר נשמעה באזור עוטף עזה אזעקת צבע אדום, אבל היא הוגדרה כהתרעת שווא. דובר צה\"ל מסר כי \"לפני זמן קצר תקף צה\"ל באמצעות ירי טנקים וכלי טיס של חיל האוויר ארבע מטרות טרור ברצועת עזה. התקיפה בוצעה בתגובה לירי תלול המסלול שבוצע לעבר מוצב צבאי בצפון רצועת עזה. צה\"ל רואה בארגון הטרור חמאס האחראי למתרחש ברצועת עזה\". כזכור, לפני כחודשיים פוצץ צה\"ל מנהרה של ארגון הג'יהאד האסלאמי שחדרה לתוך שטח ישראל. בתקרית נהרגו 12 אנשי הארגון, כשגופות של חמישה מהם נמצאות בידי ישראל. לאחר התקרית איים הג'יהאד האסלאמי לנקום בישראל, ובעקבות זאת נפרסו ברחבי הארץ סוללות כיפת ברזל. לפני כשבועיים הורה צה\"ל לסגור אתרי מטיילים בסמוך לרצועת עזה בעקבות חשש מפיגועי צלפים וירי נ\"ט של ארגון הטרור הסוני. בשבוע שעבר פורסם כי הוגש כתב אישום נגד פעיל חמאס שחצה את הגבול מעזה לישראל. איש, אחמד עביד, בן 23 משכונת סג'עייה, שבעזה, התגייס לארגון הטרור ב-2013. במסגרת פעילותו בחמאס עבר הכשרה צבאית ונטל חלק באימונים צבאיים בתחומי הנ\"ט, ההנדסה והצליפה. עוד עלה כי לקח חלק בחפירת מנהרות בגזרת מגוריו וכן שימש כפעיל כוח הריסון (אבטחת הגבולות) מטעם חמאס. משב\"כ והמשטרה נמסר כי בחקירתו של עביד התקבל מידע רב אודות פעילות מערך המנהרות של חמאס ברצועת עזה - הן מנהרות המיועדות לפעילות התקפית נגד ישראל, והן מנהרות המיועדות ללחימה מול כוחות צה\"ל בתוך שטח הרצועה. חקירתו של עביד חשפה פעם נוספת את פעילות הטרור של חמאס בתחום המנהרות לקידום פעילות טרור כנגד מדינת ישראל. ב-23 באוקטובר הוגש לבית המשפט המחוזי בבאר שבע כתב אישום חמור המייחס לעביד עבירות ביטחון חמורות. יום קודם לכן פורסם כי רשות המעברים במשרד הביטחון סיכלה הברחה של כמה טונות חומר נפץ שהיו בדרכן לגורמי הטרור בעזה. לאחרונה, בשלב ההרצה של המעבדה, הגיעה למעבר כרם שלום משאית, שהובילה מטען של שמנים לרכב, שעוררה את חשד הבודקים הביטחוניים. דגימות מהשמנים הועברו לבדיקת המעבדה, אשר זיהתה שלא מדובר בשמן מנוע תמים, אלא בחומר מסוכן, המיועד לייצור חומרי נפץ בכמות גדולה מאוד.";        
        CharSequence bodyTrans1 = TxtTranslator.translate(body);        
        
        String title2 = " פצמ\"רים נורו לעבר מוצב של צה\"ל בעוטף עזה, צה\"ל השיב באש לעמדות חמאס - חדשות";
        String body2 = "התחממות בגזרת עוטף עזה. מטח חריג במיוחד של פצצות מרגמה נורה בצהריים (יום ה') לעבר מוצב של צה\"ל בצפון הרצועה, באזור קיבוץ ארז. לא היו נפגעים. בתגובה תקפו מטוסי חיל האוויר וטנקים ארבע עמדות השייכות לזרועות הצבאיות של חמאס והג'יהאד האיסלאמי. בסך הכול נורו כ-10 פצמ\"רים שנפלו בשטח פתוח, סמוך למוצב. לפי הערכה של גורמים בצה\"ל, הירי כוון לעבר עבודות הנדסיות שבוצעו סמוך לגדר המערכת. גבול הרצועה, בצהריים(צילום: רועי עידן) (צילום: רועי עידן) האזור שבו נפלו הפצמ\"רים מדובר צה\"ל נמסר: \"לפני זמן קצר תקף צה\"ל באמצעות ירי טנקים וכלי טיס של חיל האוויר ארבע מטרות טרור ברצועת עזה. התקיפה בוצעה בתגובה לירי תלול המסלול שבוצע לעבר מוצב צבאי בצפון רצועת עזה. צה\"ל רואה בארגון הטרור חמאס האחראי למתרחש ברצועת עזה\". במקביל, ועל פי הנחיית גורמי ביטחון, הופסקה תנועת הרכבות בין אשקלון לשדרות לכשעה וחצי. כמו כן, חקלאים הונחו להתפנות מהשדות באזור העוטף והעבודות על המכשול נגד המנהרות שנבנה בעוטף הופסקו. בנוסף, בבית הספר היסודי \"חופים\" בקיבוץ יד מרדכי עוכבה יציאת התלמידים לבתיהם. זמן קצר קודם לכן נשמעה אזעקת צבע אדום במועצה האזורית שער הנגב. הערכת מצב של מח\"ט צפונית ומפקד מרחב לכיש של המשטרה סמוך למוצב(צילום: מתן צורי) X עומס בתחנת האוטובוס סמוך לרכבת בשדרות (צילום: בראל אפרים) סגור שליחה לחבר כתובת דוא''ל של החבר שמך כתובת הדוא''ל שלך נושא הקלידו את הקוד המוצג תמונה חדשה הסרטון נשלח לחברך סגור הטמעת הסרטון באתר שלך קוד להטמעה: ליד מקום מוגן בעוטף עזה(צילום: בראל אפרים) אמנון זרקא, המתגורר באזור התקרית, סיפר במשדר המיוחד של אולפן ynet: \"הייתי באתר הנטיעות של האבוקדו שלנו. את הצבע אדום שמעתי מרחוק, אבל לפני זה שמעתי נפילה ראשונה, נפילה שנייה ואחרי זה מטח של נפילות. אני חושב שלפחות עשר. זה היה מטח, היה ירי אחד לכינון, השני אולי גם, ואחרי זה מטח\". אחד החקלאים שהיה באזור סיפר ל-ynet: \"היינו חמישה עובדים במטע סמוך לגבול. פתאום החלה שורה של פיצוצים, אחד אחרי השני. נשכבנו על האדמה והנחנו ידיים על הראש. חשבנו שיורים עלינו. הפיצוצים נמשכו בערך 5 דקות ואיך שהם הסתיימו נכנסנו לכלים ועזבו את המקום במהירות. זו הייתה חוויה מטלטלת\". פרשננו לענייני צבא וביטחון רון בן ישי מעריך שהאחראי לירי הוא הג'יהאד האיסלאמי, ושלא יהיה לכך המשך בקרוב. לדבריו, הארגון ספג לחצים מאנשיו בשטח שרצו נקמה על אובדן המנהרה לפני כמה שבועות ועל ההרוגים שנספו בה. מצד שני חמאס ומצרים לחצו על הארגון להתאפק. גם האוכלוסייה ברצועה מתנגדת כעת לספוג עוד מצוקה שיביא סבב לחימה נוסף. הוא הוסיף כי נראה שהארגון התכוון שלא לפגוע בחיילי צה\"ל. גם צה\"ל לא גרם לאבדות בצד השני, מפני ששני הצדדים אינם רוצים בהסלמה.התגובה כוונה גם לעבר עמדות של חמאס מכיוון שהם הריבון בשטח והם אלו שאחראים לכל מה שיוצא מהרצועה, בין אם רצו בכך ובין אם לא. לאורך השבועות האחרונים, מאז השמיד צה\"ל מנהרת טרור של הג'יהאד האיסלאמי, הורגשה מתיחות בגבול הדרום מחשש לירי תגובה של הארגונים בעזה, וסוללות \"כיפת ברזל\" נפרסו גם באזור המרכז. בכמה מקרים הופעלו אזעקות צבע אדום באזורים שונים בעוטף עזה, אולם הן התבררו כהתרעות שווא. מצאתם טעות בכתבה? כתבו לנו";
        CharSequence bodyTrans2 = TxtTranslator.translate(body2);
        
        String body3 = "כוחות הביטחון הרסו הבוקר (רביעי) נגרייה בלתי חוקית ביישוב נתיב האבות שבאזור יהודה ושומרון (איו\"ש), זאת בהתאם להוראת הממשלה, ולאחר שעשרות מפגינים צעירים התבצרו בה, כאשר בנוסף מאות אחרים מחו מחוץ למבנה. מדובר צה\"ל נמסר הבוקר כי \"בהתאם להנחיית הדרג המדיני החלו כוחות הביטחון בהריסת המבנה הבלתי חוקי בנתיב האבות. בפעילות משתתפים כוחות הביטחון במספר מעגלי אחריות ופועלים לפינוי המבנה תוך שמירה על הביטחון החוק והסדר\". לתושבים הרבים שהגיעו למקום, על מנת למנוע את הריסת המבנה, נמסר ברמקולים \"לא להרים יד על שוטרים או חיילים\", זאת לאחר שעשרות חדרו מוקדם יותר למבנה, כדי למנוע מכוחות מג\"ב, שהגיעו למקום, להרוס את המבנה. מדובר בנגרייה הראשונה מתוך שישה, אשר נמצאת, על פי קביעת בג\"ץ, על קרקע פלסטינית, כאשר השאר יפונו עוד כארבעה חודשים. היועץ המשפטי לממשלה אביחי מנדלבליט גיבש מתווה לפיו הבתים יקבלו היתרי בנייה זמניים, כך שהתושבים ינסרו רק חלק מהבית, 40 ס\"מ בלבד, משום שהוא עומד על קרקע פלסטינית. ראש המועצה האזורית גוש עציון, שלמה נאמן, אמר בעקבות ההתרחשויות כי \"עצוב מאוד שהגענו לרגע המחפיר הזה של אובדן שליטה ושלטון. אומרים לנו שזהו שלטון החוק ואנו אומרים שזהו אובדן השלטון והרס החוק. לא רק מבנה תמים ייהרס הבוקר בנתיב האבות, גם חוק העם הריבון בארצו ייפגע תחת די בניין ההרס. לפני 70 שנה בדיוק הכירו אומות העולם בזכותנו להקים מדינת ישראל ובו ביום גוש עציון נכנס לקרב האחרון שלו - הקרב על ירושלים. הגיעה תורה של ממשלת ישראל להכיר בעובדת שלטון ישראל בכל חבלי הארץ ואין מתאים מגוש עציון שהולך בנתיב אבותיו להתחיל את הצד ההיסטורי הזה של החלת הריבונות\". מהאיחוד הלאומי נמסר: \"מפלגת האיחוד הלאומי מביעה זעזוע לנוכח אי הצדק והעוול המתרחש לנגד עינינו היום בנתיב האבות. יש כאן פינוי מיותר וסתמי פרי יוזמתם של אויבינו ולא פחות גרוע מכך פרי פסיקותיו השערורייתיות של בג\"ץ. אנו נפעל בכל הכוח למנוע מקרים דומים בעתיד ולהסדיר את יתר בתי השכונה במהרה שלא נצטרך לחזות שוב במראות כאלה\".";        
        CharSequence bodyTrans3 = TxtTranslator.translate(body3);
                       
        // Measures the Cosine similarity of two vectors of an inner product space and compares the angle between them.
        CosineDistance cd = new CosineDistance(); 
        double cdScore = cd.apply(bodyTrans1, bodyTrans2);      
        
        // This is the number of changes needed to change one sequence into another, where each change is a single character modification (deletion, insertion or substitution).
        LevenshteinDistance ld = new LevenshteinDistance();
        double ldScore = ld.apply(bodyTrans1, bodyTrans2);    
        
        // The hamming distance between two strings of equal length is the number of positions at which the corresponding symbols are different.
        // Strings must have the same length
        // HammingDistance hd = new HammingDistance();
        // double hdScore = hd.apply(bodyTrans1, bodyTrans2);       
        
        // Measures the Jaccard similarity (aka Jaccard index) of two sets of character sequence. Jaccard similarity is the size of the intersection divided by the size of the union of the two sets.
        JaccardDistance jd = new JaccardDistance();
        double jdScore = jd.apply(bodyTrans1, bodyTrans2);                
        
        // body1 vs body2 => cd 0.0972, ld 2274.0
        // body1 vs body3 => cd 0.1739, ld 1902.0
        // body2 vs body3 => cd 0.1661, ld 2284.0
        
        System.out.println("CosineDistance score = " + cdScore);        
        System.out.println("LevenshteinDistance score = " + ldScore);        
        // System.out.println("HammingDistance score = " + hdScore);        
        System.out.println("JaccardDistance score = " + jdScore);        
    }
}
