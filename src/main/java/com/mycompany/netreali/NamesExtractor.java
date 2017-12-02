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
public class NamesExtractor implements EntityExtractorInterface {

    private ArrayList<String> names;

    public NamesExtractor() throws SQLException {
        Statement stmt = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            // the mysql insert statement
            String query = "select name from first_names";

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            names = new ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString("name").toLowerCase());
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

        Iterator<String> itr = names.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            if (lowerTxt.contains(name)) {
                extracted.add(name);
            }
        }

        return extracted;
    }

    public static void main(String args[]) {
        try {
            NamesExtractor extractor = new NamesExtractor();

            String txt = "i was going to ARI'EL when i found out mamki";

            ArrayList<String> extracted = extractor.extract(txt);

            System.out.println(extracted.toString());
        } catch (SQLException ex) {
            Logger.getLogger(NamesExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
