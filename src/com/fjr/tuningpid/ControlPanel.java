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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mamat
 */
public class ControlPanel extends  JPanel{
    
    PlotPanel plotPanel;
    JButton button1;
    JButton button2;
    
    public ControlPanel(PlotPanel panel) {
        button1 = new JButton("Pause");
        button2 = new JButton("Resume");
        this.plotPanel  = panel;
        
        this.setLayout(new BorderLayout());
        
        
        JPanel panelAsembli = new JPanel(new GridLayout());
        panelAsembli.add(button1);
        panelAsembli.add(button2);
        
        this.add(panelAsembli, BorderLayout.NORTH);
        
        
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
