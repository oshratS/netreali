/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JTextArea;
import org.jdesktop.swingx.JXHyperlink;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author oshrat
 */
public class UIFoundResults extends javax.swing.JFrame {
     /**
     * Creates new form FoundResultsGui
     */
    public UIFoundResults() {
        initComponents();                
    }
    
    public void calculateResults() {        
        Class<?> c = this.getClass();
        Field f;

        // fetch the data of similar articles
        // body, date, source, similarity_score
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/netreali?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "zxasqw12")) {
            String query = "SELECT art.id, source, MIN(ABS(score)) as score, title, body, date, url "
                    + "FROM sentiment_analysis_score AS sas "
                    + "LEFT JOIN articles AS art ON sas.article_id = art.id "
                    + "GROUP BY source "
                    + "ORDER BY ABS(score) ASC";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            int iterationCount = 0;
            String[] scoreTexts = new String[3];
            scoreTexts[0] = "MOST OBJECTIVE";
            scoreTexts[1] = "MID OBJECTIVE";
            scoreTexts[2] = "LEAST OBJECTIVE";                    
            ResultSet rs = preparedStmt.executeQuery();                                                 
            while (rs.next()) {                        
                String source = rs.getString("source");

                // Handle title                        
                f = c.getDeclaredField(source + "Title");
                f.setAccessible(true);                                                
                JLabel title = (JLabel)f.get(this);
                title.setText(rs.getString("title"));     
                title.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                f.set(this, title);

                // Handle date                        
                f = c.getDeclaredField(source + "Date");
                f.setAccessible(true);                                                
                JLabel date = (JLabel)f.get(this);
                date.setText(rs.getString("date"));                        
                f.set(this, date);

                // Handle score                                                
                f = c.getDeclaredField(source + "Score");
                f.setAccessible(true);
                JLabel score = (JLabel)f.get(this);
                // score.setText(new DecimalFormat("##.##").format(rs.getDouble("score")));                        
                this.setScoreTextAndColor(scoreTexts[iterationCount], score);
                f.set(this, score);

                // Handle link  
                URI uri = new URI(rs.getString("url"));                        
                f = c.getDeclaredField(source + "Link");
                f.setAccessible(true);
                JXHyperlink link = (JXHyperlink)f.get(this);
                link.setURI(uri);
                link.setText("open article");
                f.set(this, link);

                // Handle body                      
                String[] words = rs.getString("body").split("\\s");
                String htmlBody = "";
                int spaceCount = 0;
                for(String word : words) {
                    spaceCount++;

                    if (spaceCount % 14 == 0) {
                        htmlBody += "\n" + word;
                    } else {
                        htmlBody += " " + word;
                    }
                }

                f = c.getDeclaredField(source + "Body");
                f.setAccessible(true);
                JTextArea body = (JTextArea)f.get(this);
                body.setText(htmlBody);
                body.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                body.setCaretPosition(0);
                f.set(this, body);

                iterationCount++;
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(UIFoundResults.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

     public void setScoreTextAndColor(String text, JLabel label) {
        label.setText(text); 
        switch(text) {
            case "MOST OBJECTIVE":
                label.setForeground(new Color(0, 128, 0));
                break;
            case "LEAST OBJECTIVE":
                label.setForeground(new Color(204, 0, 0));
                break;
            default:
                label.setForeground(new Color(255, 69, 0));
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        ynetPanel = new javax.swing.JPanel();
        ynetTitle = new javax.swing.JLabel();
        ynetDate = new javax.swing.JLabel();
        ynetScore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ynetBody = new javax.swing.JTextArea();
        ynetLink = new org.jdesktop.swingx.JXHyperlink();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        maarivPanel = new javax.swing.JPanel();
        maarivTitle = new javax.swing.JLabel();
        maarivDate = new javax.swing.JLabel();
        maarivScore = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        maarivBody = new javax.swing.JTextArea();
        maarivLink = new org.jdesktop.swingx.JXHyperlink();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        haaretzPanel = new javax.swing.JPanel();
        haaretzTitle = new javax.swing.JLabel();
        haaretzDate = new javax.swing.JLabel();
        haaretzScore = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        haaretzBody = new javax.swing.JTextArea();
        haaretzLink = new org.jdesktop.swingx.JXHyperlink();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NetReali");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setName("NetReali"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(400, 600));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        title.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        title.setText("Analysis Results");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(title, gridBagConstraints);

        description.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        description.setText("<html><center>The analysis finished successfully<br />We've found some similar articles and calculated their objectivity</center></html>");
        description.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(description, gridBagConstraints);

        ynetPanel.setMinimumSize(new java.awt.Dimension(342, 200));
        java.awt.GridBagLayout ynetPanelLayout = new java.awt.GridBagLayout();
        ynetPanelLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        ynetPanelLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        ynetPanel.setLayout(ynetPanelLayout);

        ynetTitle.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        ynetTitle.setText("title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        ynetPanel.add(ynetTitle, gridBagConstraints);

        ynetDate.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        ynetDate.setText("date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        ynetPanel.add(ynetDate, gridBagConstraints);

        ynetScore.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        ynetScore.setText("score");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 9;
        ynetPanel.add(ynetScore, gridBagConstraints);

        ynetBody.setEditable(false);
        ynetBody.setColumns(40);
        ynetBody.setRows(5);
        jScrollPane1.setViewportView(ynetBody);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        ynetPanel.add(jScrollPane1, gridBagConstraints);

        ynetLink.setText("open article");
        ynetLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ynetLinkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        ynetPanel.add(ynetLink, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        ynetPanel.add(jSeparator1, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ynet_logo_90.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        ynetPanel.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 24, 0);
        getContentPane().add(ynetPanel, gridBagConstraints);

        maarivPanel.setMinimumSize(new java.awt.Dimension(342, 200));
        java.awt.GridBagLayout maarivPanelLayout = new java.awt.GridBagLayout();
        maarivPanelLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        maarivPanelLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        maarivPanel.setLayout(maarivPanelLayout);

        maarivTitle.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        maarivTitle.setText("title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        maarivPanel.add(maarivTitle, gridBagConstraints);

        maarivDate.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        maarivDate.setText("date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        maarivPanel.add(maarivDate, gridBagConstraints);

        maarivScore.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        maarivScore.setText("score");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 9;
        maarivPanel.add(maarivScore, gridBagConstraints);

        maarivBody.setEditable(false);
        maarivBody.setColumns(40);
        maarivBody.setRows(5);
        jScrollPane2.setViewportView(maarivBody);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        maarivPanel.add(jScrollPane2, gridBagConstraints);

        maarivLink.setText("open article");
        maarivLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maarivLinkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        maarivPanel.add(maarivLink, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        maarivPanel.add(jSeparator2, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maariv_logo_90.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        maarivPanel.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 24, 0);
        getContentPane().add(maarivPanel, gridBagConstraints);

        haaretzPanel.setMinimumSize(new java.awt.Dimension(342, 200));
        haaretzPanel.setLayout(new java.awt.GridBagLayout());

        haaretzTitle.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        haaretzTitle.setText("title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        haaretzPanel.add(haaretzTitle, gridBagConstraints);

        haaretzDate.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        haaretzDate.setText("date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        haaretzPanel.add(haaretzDate, gridBagConstraints);

        haaretzScore.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        haaretzScore.setText("score");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 9;
        haaretzPanel.add(haaretzScore, gridBagConstraints);

        haaretzBody.setEditable(false);
        haaretzBody.setColumns(40);
        haaretzBody.setRows(5);
        haaretzBody.setText("no similar article found from this source");
        jScrollPane3.setViewportView(haaretzBody);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        haaretzPanel.add(jScrollPane3, gridBagConstraints);

        haaretzLink.setText("open article");
        haaretzLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haaretzLinkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        haaretzPanel.add(haaretzLink, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        haaretzPanel.add(jSeparator3, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/haaretz_logo_90.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        haaretzPanel.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 24, 0);
        getContentPane().add(haaretzPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ynetLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ynetLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ynetLinkActionPerformed

    private void maarivLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maarivLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maarivLinkActionPerformed

    private void haaretzLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haaretzLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_haaretzLinkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        //</editor-fold>
        //</editor-fold>    
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIFoundResults gui = new UIFoundResults();                
                gui.calculateResults();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel description;
    private javax.swing.JTextArea haaretzBody;
    private javax.swing.JLabel haaretzDate;
    private org.jdesktop.swingx.JXHyperlink haaretzLink;
    private javax.swing.JPanel haaretzPanel;
    private javax.swing.JLabel haaretzScore;
    private javax.swing.JLabel haaretzTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea maarivBody;
    private javax.swing.JLabel maarivDate;
    private org.jdesktop.swingx.JXHyperlink maarivLink;
    private javax.swing.JPanel maarivPanel;
    private javax.swing.JLabel maarivScore;
    private javax.swing.JLabel maarivTitle;
    private javax.swing.JLabel title;
    private javax.swing.JTextArea ynetBody;
    private javax.swing.JLabel ynetDate;
    private org.jdesktop.swingx.JXHyperlink ynetLink;
    private javax.swing.JPanel ynetPanel;
    private javax.swing.JLabel ynetScore;
    private javax.swing.JLabel ynetTitle;
    // End of variables declaration//GEN-END:variables
}
