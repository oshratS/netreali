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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oshrat
 */
public class ynetScraper {

    public static void main(String[] args) {

        try {
            // fetch the document over HTTP
            String domain = "http://www.ynet.co.il";
            Document doc = Jsoup.connect(domain + "/home/0,7340,L-344,00.html").get();

            // get the page title
            String title = doc.title();
            System.out.println("title: " + title);

            // get all links in page
            Elements links = doc.select("div.art_headlines_item > a");
            links.forEach(link -> {
                String href = link.attr("href");
                try {
                    // Getting the article
                    Document articleDoc = Jsoup.connect(domain + href).get();

                    // get the title
                    String articleTitle = articleDoc.title();
                    System.out.println(articleTitle);

                    // get the timestamp
                    Element timestampElm = articleDoc.getElementsByClass("art_header_footer_author").last();
                    String articleTimestamp = timestampElm.text();
                    articleTimestamp = articleTimestamp.replace("פורסם:", " ").replace("עדכון אחרון:", " ").trim();

                    System.out.println(articleTimestamp);

                    // get the body
                    Element bodyElm = articleDoc.getElementsByClass("art_body").first();
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
                        Logger.getLogger(ynetScraper.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ynetScraper.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
