/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fjr.test;

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class Eg20 extends Applet {

    public void paint(Graphics g) {
        int xBase = 10;
        int top = 10;
        int yScale = 100;
        int xAxis = 360;

        int yBase = top + yScale;
        int x, y;

        // first draw the axis
        g.drawLine(xBase, top, xBase, top + 2 * yScale);
        g.drawLine(xBase, yBase, xBase + xAxis, yBase);

        // now plot the graph
        g.setColor(Color.red);

        for (int i = 0; i < xAxis; i++) {
            x = xBase + i;
            y = (int) (yBase - Math.sin(Math.toRadians(i)) * yScale);
            // there's no drawPoint in java so draw a VERY short line
            g.drawLine(x, y, x, y);
        }
    }
}