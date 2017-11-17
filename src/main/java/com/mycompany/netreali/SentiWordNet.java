package com.mycompany.netreali;

/**
 *
 * @author oshrat
*/

import java.io.IOException;

public class SentiWordNet {
    private final String text;
    private final SWN3 sentiwordnet;

    public SentiWordNet(String pathToSWN) throws IOException {
        //Import transalates text from TxtTranslator and alter it to CSV file
        String heText = "אזעקת השווא שגרמה לבהלה ביישובי גוש דן נבעה מטעות אנוש - כך עולה מתחקיר שנערך בראשות מפקד פיקוד העורף, אלוף תמיר ידעי. ב-2 בנובמבר התעוררו תושבים רבים באזור המרכז בשעה 2:48 בלילה לקול אזעקה. התושבים דיווחו על אזעקה עולה ויורדת שנשמעה בתל אביב, בגבעתיים, בת-ים, חולון ובאזורים נוספים בגוש דן. בתום התחקיר נמסר: \"פיקוד העורף הפיק לקחים מהאירוע, אותם יישם עד תום ופועל לצמצום מקרי אזעקות שווא במטרה לשמור על שגרת יומם של אזרחי ישראל\". האזעקה הופעלה על רקע מתיחות ביטחונית בשתי גזרות, מצפון ומדרום. שלושה ימים קודם לכן פוצצה המנהרה שחפר הג'יהאד האיסלאמי מרצועת עזה לתוך שטח ישראל. בפיצוץ נהרגו 12 מחבלים מהג'יאהד האיסלאמי ומהחמאס, בהם בכירים. התעורר חשש שלמרות התנגדות החמאס, בארגון הג'יהאד האיסלאמי יתקשו להבליג על המכה שספגו, וישגרו רקטות לעבר ישראל. מסיבה זו בוטל תרגיל של פיקוד העורף, שבמסגרתו היו אמורים לפעול צופרים ברחבי גוש דן. אזעקת השווא: על רקע חשש מתגובה של הג'יהאד על פיצוץ המנהרה(צילום: EPA) מצפון, הורגשה מתיחות לאחר שלפי דיווחים סוריים תקף חיל האוויר, שעות לפני שהופעלו הצופרים, מטרה באיזור העיר חומס. בתגובה, שיגרו הסורים טילי נ\"מ לעבר מטוסי חיל-האוויר. מצאתם טעות בכתבה? כתבו לנו";
        
        TxtTranslator translate = new TxtTranslator(heText);
        
        sentiwordnet = new SWN3(pathToSWN);
        text = translate.getTranslatedText();
    }

    /**
     * This method performs the classification of the text. Algorithm: Use all
     * POS, say "yes" in case of 0.
     *
     * @return An string with "no" (negative) or "yes" (positive).
     */
    public String classifyAllPOSY() {

        int count = 0;
        try {
            String delimiters = "\\W";
            String[] tokens = text.split(delimiters);
                        
            String feeling = "";
            for (int i = 0; i < tokens.length; ++i) {              
                // Add weights -- positive => +1, strong_positive => +2, negative => -1, strong_negative => -2
                if (!tokens[i].equals("")) {
                    // Search as adjetive
                    feeling = sentiwordnet.extract(tokens[i], "a");                    
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                    // Search as noun
                    feeling = sentiwordnet.extract(tokens[i], "n");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                    // Search as adverb
                    feeling = sentiwordnet.extract(tokens[i], "r");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                    // Search as verb
                    feeling = sentiwordnet.extract(tokens[i], "v");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("Problem found when classifying the text");
        }
        // Returns "yes" in case of 0
        if (count >= 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    /**
     * This method performs the classification of the text. Algorithm: Use all
     * POS, say "no" in case of 0.
     *
     * @return An string with "no" (negative) or "yes" (positive).
     */
    public String classifyAllPOSN() {

        int count = 0;
        try {
            String delimiters = "\\W";
            String[] tokens = text.split(delimiters);
            String feeling = "";
            for (int i = 0; i < tokens.length; ++i) {
                // Add weights -- positive => +1, strong_positive => +2, negative => -1, strong_negative => -2
                if (!tokens[i].equals("")) {
                    // Search as adjetive
                    feeling = sentiwordnet.extract(tokens[i], "a");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                    // Search as noun
                    feeling = sentiwordnet.extract(tokens[i], "n");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                    // Search as adverb
                    feeling = sentiwordnet.extract(tokens[i], "r");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                    // Search as verb
                    feeling = sentiwordnet.extract(tokens[i], "v");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("Problem found when classifying the text");
        }
        // Returns "no" in case of 0
        if (count > 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    /**
     * This method performs the classification of the text. Algorithm: Use only
     * ADJ, say "yes" in case of 0.
     *
     * @return An string with "no" (negative) or "yes" (positive).
     */
    public String classifyADJY() {

        int count = 0;
        try {
            String delimiters = "\\W";
            String[] tokens = text.split(delimiters);
            String feeling = "";
            for (int i = 0; i < tokens.length; ++i) {
                // Add weights -- positive => +1, strong_positive => +2, negative => -1, strong_negative => -2
                if (!tokens[i].equals("")) {
                    // Search as adjetive
                    feeling = sentiwordnet.extract(tokens[i], "a");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("Problem found when classifying the text");
        }
        // Returns "yes" in case of 0
        if (count >= 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    /**
     * This method performs the classification of the text. Algorithm: Use only
     * ADJ, say "no" in case of 0.
     *
     * @return An string with "no" (negative) or "yes" (positive).
     */
    public String classifyADJN() {

        int count = 0;
        try {
            String delimiters = "\\W";
            String[] tokens = text.split(delimiters);
            String feeling = "";
            for (int i = 0; i < tokens.length; ++i) {
                // Add weights -- positive => +1, strong_positive => +2, negative => -1, strong_negative => -2
                if (!tokens[i].equals("")) {
                    // Search as adjetive
                    feeling = sentiwordnet.extract(tokens[i], "a");
                    if ((feeling != null) && (!feeling.equals(""))) {
                        switch (feeling) {
                            case "strong_positive":
                                count += 2;
                                break;
                            case "positive":
                                count += 1;
                                break;
                            case "negative":
                                count -= 1;
                                break;
                            case "strong_negative":
                                count -= 2;
                                break;
                        }
                        System.out.println(tokens[i]+"#"+feeling+"#"+count);
                    }
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("Problem found when classifying the text");
        }
        // Returns "no" in case of 0
        if (count > 0) {
            return "yes";
        } else {
            return "no";
        }
    }
    
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\oshrat\\Documents\\NetBeansProjects\\netreali\\src\\main\\java\\com\\mycompany\\netreali\\SentiWordNet_3.0.0_20130122.txt";
        SentiWordNet classifier = new SentiWordNet(path);
                	
        // Comment the approaches you do not want to check
        System.out.println(classifier.classifyAllPOSY());
        // System.out.println(classifier.classifyAllPOSN());
        // System.out.println(classifier.classifyADJY());
        // System.out.println(classifier.classifyADJN());	
    }
}
