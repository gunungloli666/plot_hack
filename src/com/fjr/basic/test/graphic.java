/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fjr.basic.test;

import java.applet.Applet;

/**
 *
 * @author mamat
 */
import java.awt.*;
import java.applet.*;

public class graphic extends Applet {

    Button button1;

    public void init() {
    }

    public void paint(Graphics g) {
        Button button1 = new Button("Plot");
        add(button1);
        g.setColor(Color.blue);
        g.drawLine(600, 0, 600, 1000); // x-axis
        g.drawLine(0, 350, 1400, 350);// y-axis

        for (int i = 0; i <= 1000; i++) {
            g.drawLine(i, (int) Math.sin(i), i, (int) Math.sin(i));//Suppose to give me a graph 
//even tho at random location 
        }
    }
}