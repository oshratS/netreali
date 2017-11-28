/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

/**
 *
 * @author oshrat
 */
public class FoundResultsGui extends javax.swing.JFrame {

    /**
     * Creates new form FoundResultsGui
     */
    public FoundResultsGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        ResultsLabel = new javax.swing.JLabel();
        jTextArea3 = new javax.swing.JTextArea();
        HaretzPanel = new javax.swing.JPanel();
        HArticleT = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        HLabel5 = new javax.swing.JLabel();
        HLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        YnetPanel = new javax.swing.JPanel();
        ynetPanel1 = new javax.swing.JPanel();
        MArticleT1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        YLabel7 = new javax.swing.JLabel();
        YLabel8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        ynetPanel2 = new javax.swing.JPanel();
        MArticleT2 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        YLabel9 = new javax.swing.JLabel();
        YLabel10 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NetReali");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(900, 900));
        setName("NetReali"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 800));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainPanel.setForeground(new java.awt.Color(255, 255, 255));
        MainPanel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        ResultsLabel.setBackground(new java.awt.Color(255, 255, 255));
        ResultsLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        ResultsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ResultsLabel.setText("        Results");
        ResultsLabel.setAlignmentY(0.0F);
        ResultsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ResultsLabel.setPreferredSize(new java.awt.Dimension(211, 96));

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("                               The process finished successfully.  \n                               We`ve founf the next similar articles:");
        jTextArea3.setAutoscrolls(false);
        jTextArea3.setBorder(null);
        jTextArea3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(ResultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextArea3)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea3)
                .addContainerGap())
        );

        ResultsLabel.getAccessibleContext().setAccessibleName("ResultsLabel");

        HArticleT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HArticleT.setText("Article Title");

        jTextPane3.setEditable(false);
        jTextPane3.setBackground(new java.awt.Color(255, 0, 0));
        jTextPane3.setBorder(null);
        jTextPane3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextPane3.setText("42% objectivity");
        jScrollPane6.setViewportView(jTextPane3);

        HLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        HLabel5.setText("23/11/2017 18:55");

        HLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        HLabel6.setText("Haaretz");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setFocusable(false);
        jScrollPane4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane4.setRequestFocusEnabled(false);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("Lorem Ipsum is simply dummy text of the printing and \ntypesetting industry.  Lorem Ipsum has been the \nindustry's standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and \nscrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into");
        jTextArea4.setAutoscrolls(false);
        jTextArea4.setFocusable(false);
        jScrollPane4.setViewportView(jTextArea4);

        javax.swing.GroupLayout HaretzPanelLayout = new javax.swing.GroupLayout(HaretzPanel);
        HaretzPanel.setLayout(HaretzPanelLayout);
        HaretzPanelLayout.setHorizontalGroup(
            HaretzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HaretzPanelLayout.createSequentialGroup()
                .addGroup(HaretzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HArticleT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HaretzPanelLayout.createSequentialGroup()
                        .addComponent(HLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(HLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(438, Short.MAX_VALUE))
            .addGroup(HaretzPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HaretzPanelLayout.setVerticalGroup(
            HaretzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HaretzPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HArticleT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HaretzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HaretzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HLabel5)
                    .addComponent(HLabel6))
                .addContainerGap())
        );

        MArticleT1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MArticleT1.setText("Article Title");

        jTextPane4.setEditable(false);
        jTextPane4.setBackground(new java.awt.Color(255, 255, 0));
        jTextPane4.setBorder(null);
        jTextPane4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextPane4.setText("55% objectivity");
        jScrollPane8.setViewportView(jTextPane4);

        YLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        YLabel7.setText("23/11/2017 18:58");

        YLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        YLabel8.setText("Ynet");

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane9.setFocusable(false);
        jScrollPane9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane9.setRequestFocusEnabled(false);

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextArea6.setRows(5);
        jTextArea6.setText("Lorem Ipsum is simply dummy text of the printing and \ntypesetting industry.  Lorem Ipsum has been the \nindustry's standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and \nscrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into");
        jTextArea6.setAutoscrolls(false);
        jTextArea6.setFocusable(false);
        jScrollPane9.setViewportView(jTextArea6);

        javax.swing.GroupLayout ynetPanel1Layout = new javax.swing.GroupLayout(ynetPanel1);
        ynetPanel1.setLayout(ynetPanel1Layout);
        ynetPanel1Layout.setHorizontalGroup(
            ynetPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ynetPanel1Layout.createSequentialGroup()
                .addComponent(MArticleT1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(509, Short.MAX_VALUE))
            .addGroup(ynetPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ynetPanel1Layout.createSequentialGroup()
                .addComponent(YLabel7)
                .addGap(18, 18, 18)
                .addComponent(YLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 438, Short.MAX_VALUE))
        );
        ynetPanel1Layout.setVerticalGroup(
            ynetPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ynetPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MArticleT1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ynetPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ynetPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YLabel7)
                    .addComponent(YLabel8))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout YnetPanelLayout = new javax.swing.GroupLayout(YnetPanel);
        YnetPanel.setLayout(YnetPanelLayout);
        YnetPanelLayout.setHorizontalGroup(
            YnetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
            .addGroup(YnetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(YnetPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ynetPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        YnetPanelLayout.setVerticalGroup(
            YnetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
            .addGroup(YnetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(YnetPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ynetPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        MArticleT2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MArticleT2.setText("Article Title");

        jTextPane5.setEditable(false);
        jTextPane5.setBackground(new java.awt.Color(102, 255, 51));
        jTextPane5.setBorder(null);
        jTextPane5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextPane5.setText("87% objectivity");
        jScrollPane10.setViewportView(jTextPane5);

        YLabel9.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        YLabel9.setText("23/11/2017 18:41");

        YLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        YLabel10.setText("Maariv");

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane11.setFocusable(false);
        jScrollPane11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane11.setRequestFocusEnabled(false);

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextArea7.setRows(5);
        jTextArea7.setText("Lorem Ipsum is simply dummy text of the printing and \ntypesetting industry.  Lorem Ipsum has been the \nindustry's standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and \nscrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into");
        jTextArea7.setAutoscrolls(false);
        jTextArea7.setFocusable(false);
        jScrollPane11.setViewportView(jTextArea7);

        javax.swing.GroupLayout ynetPanel2Layout = new javax.swing.GroupLayout(ynetPanel2);
        ynetPanel2.setLayout(ynetPanel2Layout);
        ynetPanel2Layout.setHorizontalGroup(
            ynetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ynetPanel2Layout.createSequentialGroup()
                .addGroup(ynetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MArticleT2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ynetPanel2Layout.createSequentialGroup()
                        .addComponent(YLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(YLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ynetPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ynetPanel2Layout.setVerticalGroup(
            ynetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ynetPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MArticleT2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ynetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10)
                    .addComponent(jScrollPane11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ynetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YLabel9)
                    .addComponent(YLabel10))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(YnetPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HaretzPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ynetPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ynetPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(YnetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HaretzPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FoundResultsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoundResultsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoundResultsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoundResultsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FoundResultsGui gui = new FoundResultsGui();
                gui.setVisible(true);      
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HArticleT;
    private javax.swing.JLabel HLabel5;
    private javax.swing.JLabel HLabel6;
    private javax.swing.JPanel HaretzPanel;
    private javax.swing.JLabel MArticleT1;
    private javax.swing.JLabel MArticleT2;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel ResultsLabel;
    private javax.swing.JLabel YLabel10;
    private javax.swing.JLabel YLabel7;
    private javax.swing.JLabel YLabel8;
    private javax.swing.JLabel YLabel9;
    private javax.swing.JPanel YnetPanel;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JPanel ynetPanel1;
    private javax.swing.JPanel ynetPanel2;
    // End of variables declaration//GEN-END:variables
}

