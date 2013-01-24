/**
 * Copyright 2012, Moh. Fajar
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>
 */
package com.fjr.basic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PlotPanel extends JPanel implements Runnable {

    int hor = 500;
    int ver = 350;
    private int mainX = 20, mainY = 10;
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    int horplot = hor + mainX;
    int verplot = mainY + ver;
    int a, b;
    double buffer[] = new double[10];
    int[] bufferValue = new int[hor];
    private ControlPanel controlPanel;
    Thread mainThread;
    private boolean pauseThread = false;
    int midleVer = (int) (mainY + ver / 2); //pertengahan bidang plot
    int frekuensi;
    int amplitudo;

    public PlotPanel() 
    {
        for (int i = 50; i < horplot; i += 70) {
            list.add(i);
            list1.add(i);
        }
        a = 0;
        frekuensi = 1;
        amplitudo = 1;
        mainThread = new Thread(this);
        mainThread.start();
    }

    public void pauseThread()
    {
        pauseThread = true;
    }

    public void resumeThread() 
    {
        pauseThread = false;
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paintComponent(g);
        g.drawRect(mainX, mainY, hor, ver);
        g.setColor(Color.BLUE);
        this.drawVerticalLine(g);
        this.drawAxisValue(g);
        this.drawSineWave(g);
        this.drawHorizontalAxis(g);
    }

    public void drawHorizontalAxis(Graphics g)
    {
        g.setColor(Color.red);
        g.drawLine(mainX, midleVer, horplot, midleVer);
    }

    public void drawSineWave(Graphics g) 
    {
        b = a + hor;
        int m;
        int tempx = 0;
        for (int i = a; i < b; i++) {
            m = (int) (midleVer - amplitudo * Math.sin(Math.toRadians(i) * frekuensi) * (ver / 2));
            g.fillOval(mainX + tempx, m, 4, 3);
            tempx++;
        }
    }

    public void setAmplitudo(int a)
    {
        this.amplitudo = a;
    }

    public void setFrekuensi(int a) 
    {
        this.frekuensi = a;
    }

    public void drawAxisValue(Graphics g) 
    {
        g.setColor(Color.BLACK);
        for (int i = 0; i < list.size(); i++) {
            g.drawString(list1.get(i).toString(), list.get(i).intValue() - 10, ver + mainY + 15);
        }
    }

    public void drawVerticalLine(Graphics g) 
    {
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).intValue();
            g.drawLine(a, ver + mainY, a, mainY);
        }
    }

    public void movePanel()
    {
        this.a++;

        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).intValue();
            a--;
            list.remove(i);
            list.add(i, a);
        }
        int b = list.get(list.size() - 1).intValue();
        int bb = list1.get(list1.size() - 1).intValue();
        int cc = list.get(0).intValue();
        if (cc < mainX) {
            list.remove(0);
            list1.remove(0);
        }
        if ((horplot - b) > 70) {
            list.add(b + 70);
            list1.add(bb + 70);
        }
    }

    @Override
    public void run()
    {
        while (true) {
            if (!pauseThread) {
                this.movePanel();
                this.repaint();
            }
            try {
                Thread.sleep(15);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
