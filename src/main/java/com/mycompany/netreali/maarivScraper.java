package com.mycompany.netreali;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class maarivScraper {

    public static void main(String[] args) {
        try {
            // fetch the document over HTTP
            String domain = "http://www.maariv.co.il";
            Document doc = Jsoup.connect(domain + "/news/israel").get();

            // get all links in page
            Elements links = doc.select("ul.list-category-articles li > a");
            links.forEach(link -> {
                String href = link.attr("href");
                try {
                    // Getting the article
                    Document articleDoc = Jsoup.connect(href).get();

                    // get the title
                    String articleTitle = articleDoc.title();
                    System.out.println(articleTitle);

                    // get the timestamp
                    Element timestampElm = articleDoc.getElementsByClass("article-he-date").first();
                    String articleTimestamp = timestampElm.text();
                    articleTimestamp = articleTimestamp.replace(" עודכן בתאריך: ", " ").trim();

                    System.out.println(articleTimestamp);

                    // get the body
                    Element bodyElm = articleDoc.getElementsByClass("article-text").first();
                    String articleBody = bodyElm.text();

                    try {
                        // TODO: adding to db

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "zxasqw12");
                        // the mysql insert statement
                        String query = "INSERT INTO articles (title, body, date)"
                                + " VALUES (?, ?, ?)";

                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString(1, articleTitle);
                        preparedStmt.setString(2, articleBody);
                        preparedStmt.setString(3, articleTimestamp);

                        // execute the preparedstatement
                        preparedStmt.execute();

                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(maarivScraper.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(maarivScraper.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(maarivScraper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
