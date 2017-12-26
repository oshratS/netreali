package com.mycompany.netreali;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HaaretzScraper {

    public void scrapeAndSave(int searchTaskId) {
        Map<String, String> scraped = new HashMap<>();

        try {
            String domain = "https://www.haaretz.co.il";
            Document doc = Jsoup.connect(domain + "/news/world").get();

            // get all links in page
            Elements links = doc.select(".l-main article > a");
            links.forEach(link -> {
                String href = link.attr("href");
                scraped.put("url", domain + href);

                try {
                    // Getting the article
                    Document articleDoc = Jsoup.connect(domain + href).get();

                    // get the title
                    String articleTitle = articleDoc.title();
                    scraped.put("title", articleTitle);
                    // System.out.println(articleTitle);

                    // get the timestamp
                    Element timestampElm = articleDoc.select(".art__info time").first();
                    String articleTimestamp = timestampElm.text();
                    articleTimestamp = articleTimestamp.trim();
                    scraped.put("date", articleTimestamp);
                    // System.out.println(articleTimestamp);

                    // get the body
                    Element bodyElm = articleDoc.select(".l-article__entry .t-body-text").first();
                    String articleBody = bodyElm.text();
                    scraped.put("body", articleBody);

                    save(scraped, searchTaskId);
                } catch (IOException ex) {
                    Logger.getLogger(HaaretzScraper.class.getName()).log(Level.SEVERE, "Exception on url: " + domain + href);
                    Logger.getLogger(HaaretzScraper.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(HaaretzScraper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(Map<String, String> scraped, int searchTaskId) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            // the mysql insert statement
            String query = "INSERT INTO articles (search_task_id, title, body, date, url, source)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, searchTaskId);
            preparedStmt.setString(2, scraped.get("title"));
            preparedStmt.setString(3, scraped.get("body"));
            preparedStmt.setString(4, scraped.get("date"));
            preparedStmt.setString(5, scraped.get("url"));
            preparedStmt.setString(6, "haaretz");

            // execute the preparedstatement
            preparedStmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(YNETScraper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
