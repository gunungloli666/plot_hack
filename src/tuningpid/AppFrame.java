/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tuningpid;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author mamat
 */
public class AppFrame extends JFrame {
    
    public AppFrame(Component c, String title){
        super(title);
        this.setPreferredSize(new Dimension(700, 500));
        this.setLayout(new BorderLayout());
        this.add(c);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
}
