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
package com.fjr.tuningpid;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class AppFrame extends JFrame {
    
     private PlotPanel plotPanel;
     private ControlPanel controlPanel;
    
    public AppFrame( String title){
        super(title);
        this.setPreferredSize(new Dimension(700, 500));
        this.init();
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    private void init(){
        this.setLayout(new BorderLayout());
        plotPanel = new PlotPanel();
        controlPanel = new ControlPanel(plotPanel);
        this.add(plotPanel,BorderLayout.CENTER);
        this.add(controlPanel,BorderLayout.EAST);
    }
    
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
     
                AppFrame frame = new AppFrame("y=A*sin(a*x)");
            }
        });
    }
}
