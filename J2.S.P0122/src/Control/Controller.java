/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.RCB;
import java.awt.Color;
/**
 *
 * @author Admin
 */
public class Controller {
    RCB a = new RCB();
    int r,g,b;
    
    public Controller() {
        a.setVisible(true);
         r = 0;
         g = 0;
         b = 0;
         
         a.getLblRed().setText("R="+r);
         a.getLblGre().setText("G="+g);
         a.getLblBlue().setText("B="+b);
         a.getPnColor().setBackground(new Color(r,g,b));
        /// sld red
        a.getSlRed().addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                r = a.getSlRed().getValue();
                a.getLblRed().setText("R="+r);
                a.getPnColor().setBackground(new Color(r,g,b));
            }
        });
        
        
         /// sld green
        a.getSlGre().addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                g = a.getSlGre().getValue();
                a.getLblGre().setText("G="+g);
                a.getPnColor().setBackground(new Color(r,g,b));
            }
        });
        
        
         /// sld blue
        a.getSlBlue().addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                b = a.getSlBlue().getValue();
                a.getLblBlue().setText("B="+b);
                a.getPnColor().setBackground(new Color(r,g,b));
            }
        });
    }
    
}
