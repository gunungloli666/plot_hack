  /**
   * Copyright 2012, Moh. Fajar
   * 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
    */

package tuningpid;

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
    
    public PlotPanel() {
        this.setBackground(Color.gray);
        for (int i = 50; i < horplot; i += 70) {
            list.add(i);
            list1.add(i);
        }
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.drawRect(mainX, mainY, hor, ver);
        g.setColor(Color.BLUE);
        this.drawVerticalLine(g);
        this.drawAxisValue(g);
    }
    
//    public void drawSineWave(Graphics g){
//        
//    }
    
    public void drawAxisValue(Graphics g){
       g.setColor(Color.BLACK);
       for(int i=0; i<list.size() ;i++){
           g.drawString(list1.get(i).toString(),list.get(i).intValue()-10 , ver+mainY+15);
       }
    }

    public void drawVerticalLine(Graphics g) {
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).intValue();
            g.drawLine(a, ver + mainY, a, mainY);
        }
    }

    public void movePanel() {
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).intValue();
            a--;
            list.remove(i);
            list.add(i, a);
        }
        int b = list.get(list.size() - 1).intValue();
        int bb = list1.get(list1.size() - 1).intValue();
        int cc = list.get(0).intValue();
        if(cc <mainX){
           list.remove(0);
           list1.remove(0);
        }
        if ((horplot - b) > 70) {
            list.add(b+70);
            list1.add(bb+70);
        }
    }

    @Override
    public void run() {
        while (true) {
            this.movePanel();
            this.repaint();
            try {
                Thread.sleep(15);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }

    public static void main(String[] args) {
        PlotPanel plotpanel = new PlotPanel();
        AppFrame frame = new AppFrame(plotpanel, "sinusiodal");
    }
}
