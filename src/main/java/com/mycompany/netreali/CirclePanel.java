/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author oshrat
 */
public class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        //Adding  super.paintComponent....  
        super.paintComponent(g);

        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
}
