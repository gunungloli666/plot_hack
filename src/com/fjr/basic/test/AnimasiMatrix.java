/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fjr.basic.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author mamat
 */
public class AnimasiMatrix extends JPanel implements  Runnable{
    
    class MapFontLokasi{
        
        int x; 
        StringBuilder str ;
        
        Random rand = new Random();

        MapFontLokasi() {
            for(int i=0; i< testString.length; i++){
                if(rand.nextInt(2) !=0){
                    str.append(testString[i]).append("\t");
                }
            }
        }
        
        public String getString(){
            return str.toString();
        }
        
        public MapFontLokasi createStringWithLocation(){
            return new MapFontLokasi();
        }
    }
    
    ArrayList<ArrayList> list = new ArrayList<ArrayList>();
    String [] testString ="abcdefghijklmnopqrstuvwxyz".split("");
    Random rand = new Random();
    
    public AnimasiMatrix(){
       setBackground(Color.BLACK);
       new Thread(this).start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.drawRect(20, 20, 600, 400);
        this.drawStringAnimasi(g);
        
    }
    
    public void drawStringAnimasi(Graphics g){
        for(int i =30; i< 300;i+=12){
            g.drawString("makan", 34, i);
        }
    }
    
    public void createStringAnimasi(){
        for(int i=0; i< 300; i++){
            
        }
    }
    
    public static void main(String[] args){
      // AppFrame frame = new AppFrame(new AnimasiMatrix(), "Matriks Reloaded");
    }

    @Override
    public void run() {
     //   throw new UnsupportedOperationException("Not supported yet.");
         while(true){
            this.repaint();
        }
    }
}
