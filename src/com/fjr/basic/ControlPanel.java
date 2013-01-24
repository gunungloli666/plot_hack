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

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mamat
 */
public class ControlPanel extends  JPanel{
    
    PlotPanel plotPanel;
    JButton button1;
    JButton button2;
    
    public ControlPanel(PlotPanel panel)
    {
        button1 = new JButton("Pause");
        button2 = new JButton("Resume");
        this.plotPanel  = panel;
        this.setLayout(new BorderLayout());
        JPanel panelAsembli = new JPanel(new GridLayout());
        panelAsembli.add(button1);
        panelAsembli.add(button2);
        
//         
//        Hashtable<Integer,JLabel> mymap = new Hashtable<Integer, JLabel> ();
//        mymap.put(5, new JLabel("5"));
//        mymap.put(4, new JLabel("4"));
//        mymap.put(3, new JLabel("3"));
//        mymap.put(2, new JLabel("2"));
//        mymap.put(1, new JLabel("1"));
////        
        
//        Hashtable<Integer, JLabel> mymap1 = new Hashtable<Integer, JLabel>();
//        mymap1.put(5, new JLabel("5"));
//        mymap1.put(4, new JLabel("4"));
//        mymap1.put(3, new JLabel("3"));
//        mymap1.put(2, new JLabel("2"));
//        mymap1.put(1, new JLabel("1"));

         final JSlider slider1 = new JSlider(SwingConstants.VERTICAL);
  
         slider1.setPaintLabels(true);
         slider1.setMajorTickSpacing(2);
         slider1.setMinorTickSpacing(1);
         slider1.setPaintTicks(true);
     //    slider1.setLabelTable(mymap);
         slider1.setMaximum(5);
         slider1.setMinimum(1);
          slider1.setValue(slider1.getMinimum());
        // slider1.setLabelTable(mymap);
         
         
         final JSlider slider2 = new JSlider(SwingConstants.VERTICAL);
         slider2.setMajorTickSpacing(1);
         slider2.setMinorTickSpacing(1);
         slider2.setMaximum(5);
         slider2.setMinimum(1);
         slider2.setPaintLabels(true);
         slider2.setPaintTicks(true);
         slider2.setValue(slider2.getMinimum());
     //    slider2.setLabelTable(mymap1);
         
       
         slider1.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                // int a = slider1.getValue();
               //  System.out.println(a);
                plotPanel.setAmplitudo(slider1.getValue());
            }
        });   
         
         slider2.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                plotPanel.setFrekuensi(slider2.getValue());
            }
        });
         
         JPanel panelAssembli1 = new JPanel(new FlowLayout());
         panelAssembli1.add(slider1);
         panelAssembli1.add(slider2);
         
         JPanel panelTemp = new JPanel(new BorderLayout());
         panelTemp.add(panelAssembli1, BorderLayout.WEST);
        
         
        this.add(panelAsembli, BorderLayout.NORTH);
        this.add(panelTemp, BorderLayout.CENTER);
        
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                plotPanel.pauseThread();
            }
        });

        
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               plotPanel.resumeThread();
            }
        });
    }
     
}
