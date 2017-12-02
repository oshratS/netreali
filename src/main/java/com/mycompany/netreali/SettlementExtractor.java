/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oshrat
 */
public class SettlementExtractor implements EntityExtractorInterface {

    private ArrayList<String> settlements;

    public SettlementExtractor() throws SQLException {
        Statement stmt = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            // the mysql insert statement
            String query = "select name from settlements";

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            settlements = new ArrayList<>();
            while (rs.next()) {
                settlements.add(rs.getString("name").toLowerCase().trim());
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MaarivScraper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    @Override
    public ArrayList<String> extract(String txt) {
        ArrayList<String> extracted = new ArrayList<>();
        String lowerTxt = txt.toLowerCase();

        Iterator<String> itr = settlements.iterator();
        while (itr.hasNext()) {
            String settlement = itr.next();
            if (lowerTxt.contains(settlement)) {
                extracted.add(settlement);
            }
        }

        return extracted;
    }

    public static void main(String args[]) {
        try {
            SettlementExtractor extractor = new SettlementExtractor();

            String txt = "i was going to ARI'EL when i found out mamki";

            ArrayList<String> extracted = extractor.extract(txt);

            System.out.println(extracted.toString());
        } catch (SQLException ex) {
            Logger.getLogger(SettlementExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
