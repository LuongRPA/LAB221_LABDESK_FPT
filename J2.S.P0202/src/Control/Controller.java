/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.Convert;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class Controller {
Convert c = new Convert();

///check
public boolean check() {

        String intput = c.getTxt1().getText().trim();
        String output = c.getTxt2().getText().trim();
       

//check format input
         if (!intput.matches("[0-9]+.+[0-9]")&&!intput.matches("[0-9]+")) {
            //only number 0-9 
            JOptionPane.showMessageDialog(c, "Please enter input a number again!");
            c.getTxt1().requestFocus();
            return false;
        }
          if(c.getTxt1().getText().equals(" ")) {
        JOptionPane.showMessageDialog(c, "Please enter input a number again!");
            c.getTxt1().requestFocus();
           
            c.getTxt2().setText(" ");
            return false;
    }
        

        return true;
    }

    public Controller() {
        c.setVisible(true);
        
        /// //mi =m * 0.00062137 ( dặm(mile) bằng meter(mét) x  0.00062137)
    
    // event convet 
    
    //1 dam = 1.609m
        
         c.getBtnCon().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check();
                ///met to mile
                if(c.getCb1().getSelectedItem() == "Meter" && c.getCb2().getSelectedItem() == "Mile"){
            double in = Double.parseDouble(c.getTxt1().getText());
            double out = in*0.621371192;
            c.getTxt2().setText(Double.toString(out));
            }
                /// mile to met
                if(c.getCb1().getSelectedItem() == "Mile" && c.getCb2().getSelectedItem() == "Meter"){
            double in = Double.parseDouble(c.getTxt1().getText());
            double out = in/0.621371192;
            c.getTxt2().setText(Double.toString(out));
            }
                ///met to met
                if(c.getCb1().getSelectedItem() == "Meter" && c.getCb2().getSelectedItem() == "Meter"){
            double in = Double.parseDouble(c.getTxt1().getText());
            double out = in*1;
            c.getTxt2().setText(Double.toString(out));
            }
                
             /// mile to mile
             if(c.getCb1().getSelectedItem() == "Mile" && c.getCb2().getSelectedItem() == "Mile"){
            double in = Double.parseDouble(c.getTxt1().getText());
            double out = in*1;
            c.getTxt2().setText(Double.toString(out));
            }
                
            }
            
        });
               
    }
  
    
}
