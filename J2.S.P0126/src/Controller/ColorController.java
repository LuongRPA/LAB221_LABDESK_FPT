/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import GUI.ChooseColor;
import static java.awt.Color.*;
/**
 *
 * @author Admin
 */
public class ColorController {

    public ColorController() {
        ChooseColor cl = new ChooseColor();
        cl.setVisible(true);
        //choose color red
        cl.getRbred().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cl.getColorText().setBackground(RED);
                 cl.getColorText().setText("Red is selected");
                 cl.getColorText().setForeground(WHITE);
            }
        });
        
        
        //choose color blue
        cl.getRbblue().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cl.getColorText().setBackground(BLUE);
                  cl.getColorText().setText("Blue is selected");
                 cl.getColorText().setForeground(WHITE);
                
            }
        });
        
        
         //choose color green
        cl.getRbgreen().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cl.getColorText().setBackground(GREEN);
                  cl.getColorText().setText("Green is selected");
                cl.getColorText().setForeground(WHITE);
            }
        });
        
         //choose color black
        cl.getRbblack().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cl.getColorText().setBackground(BLACK);
                  cl.getColorText().setText("Black is selected");
                cl.getColorText().setForeground(WHITE);
            }
        });
    }
    
}
