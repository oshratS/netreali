
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


public class haaretzScraper {       
        
    public static void main(String args[]){
        try {
            String domain = "https://www.haaretz.co.il";
            Document doc = Jsoup.connect(domain + "/news").get();
            
             // get all links in page
            Elements links = doc.select("article > a");
            links.forEach(link -> {
                String href = link.attr("href");
                try {
                    // Getting the article
                    Document articleDoc = Jsoup.connect(domain + href).get();

                    // get the title
                    String articleTitle = articleDoc.title();
                    System.out.println(articleTitle);

                    // get the timestamp
                    Element timestampElm = articleDoc.select(".art__info time").first();
                    String articleTimestamp = timestampElm.text();
                    articleTimestamp = articleTimestamp.trim();

                    System.out.println(articleTimestamp);

                    // get the body
                    Element bodyElm = articleDoc.getElementsByClass("t-body-text").first();
                    String articleBody = articleDoc.html();

                    try {
                        // TODO: adding to db

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali", "root", "zxasqw12");
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
            Logger.getLogger(haaretzScraper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
