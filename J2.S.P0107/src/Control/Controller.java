/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.PGB;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class Controller {
PGB p = new PGB();
    public Controller() {
        p.setVisible(true);
        progress();// call run progress
        
        //exit program
         p.getBtnExit().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0); // exit
            }
        });
        
    }
    // run progress
    public void progress(){
        int i = 0;
        
        while(i < 100){ // 100%
            i++;
            p.getPrb().setValue(i);
            String s =  "Monitorning Progress Operation is  " +String.valueOf(i) +" % Complate"; 
            
            p.getLblnum().setText(s);
            try {
                Thread.sleep(100); // delay 100ms
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
