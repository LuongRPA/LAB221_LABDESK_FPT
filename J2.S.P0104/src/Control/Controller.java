/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import View.Gui;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class Controller {
    Vector vth = new Vector();
    Vector vtn = new Vector();
    Gui g = new Gui();
    public Controller() {
        
        //Gui g = new Gui();
        g.setVisible(true);
        
        ////
        vth.add("StockID");
        vth.add("StockName");
        vth.add("Address");
        vth.add("DateAvailable");
        vth.add("NOte");
        // tb.setModel(new DefaultTableModel(vtn, vth));
        ///dong1
        Vector vtr1 = new Vector();
        vtr1.add("1");
        vtr1.add("StockOne");
        vtr1.add("Washington");
        vtr1.add("11/05/2020");
        vtr1.add("   ");
        vtn.add(vtr1);
       // tb.setModel(new DefaultTableModel(vtn, vth));
        ///dong2
        Vector vtr2 = new Vector();
        vtr2.add("2");
        vtr2.add("StockTwo");
        vtr2.add("Chicago");
        vtr2.add("1/12/2020");
        vtr2.add("   ");
        vtn.add(vtr2);
        // tb.setModel(new DefaultTableModel(vtn, vth));
        ///dong3
        Vector vtr3 = new Vector();
        vtr3.add("3");
        vtr3.add("StockThree");
        vtr3.add("Nevada");
        vtr3.add("09/04/2020");
        vtr3.add("   ");
        vtn.add(vtr3);
        // tb.setModel(new DefaultTableModel(vtn, vth));
        ///dong4
        Vector vtr4 = new Vector();
        vtr4.add("4");
        vtr4.add("StockFour");
        vtr4.add("Newtork");
        vtr4.add("10/07/2020");
        vtr4.add("   ");
        vtn.add(vtr4);
        // tb.setModel(new DefaultTableModel(vtn, vth));
        ///dong5
        Vector vtr5 = new Vector();
        vtr5.add("5");
        vtr5.add("StockFive");
        vtr5.add("Florida");
        vtr5.add("12/08/2020");
        vtr5.add("   ");
        vtn.add(vtr5);
        g.getTb().setModel(new DefaultTableModel(vtn, vth));
        //
        int n = g.getTb().getRowCount();
        //check date in table
        if(n == 0){
           JOptionPane.showMessageDialog(g.getTb(), "Data in table is null. Please enter date!!"); 
        }
        else{
        //auto choose first line
        g.getTb().setRowSelectionInterval(0, 0);
        //check choose
        //choose first
        g.getBtnf().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 g.getTb().setRowSelectionInterval(0, 0);
                 Check();
            }
        });
        
         //choose last
        g.getBtnl().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 g.getTb().setRowSelectionInterval(g.getTb().getRowCount() - 1, g.getTb().getRowCount() - 1);
             Check();
            }
        });
        
        
        ///choose next
         g.getBtnn().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int index = g.getTb().getSelectedRow();
       
        if (g.getTb().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(g.getTb(), "Please choose a row");
            return;
        } else if (g.getTb().getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(g.getTb(), "Please choose a row");
            return;
        } else if (g.getTb().getSelectedRow() == g.getTb().getRowCount() - 1) {
             g.getTb().setRowSelectionInterval(0, 0);
        } else {
           g.getTb().setRowSelectionInterval(index + 1, index + 1);
        }
           Check();      
        }
        });
        
        
        //chose previous
        g.getBtnp().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int index = g.getTb().getSelectedRow();
        
        if (g.getTb().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(g.getTb(), "Please choose a row");
            return;
        }
        else if (g.getTb().getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(g.getTb(), "Please choose a row");
            return;
        }
        else if (g.getTb().getSelectedRow() == 0) {
            g.getTb().setRowSelectionInterval(g.getTb().getRowCount() - 1, g.getTb().getRowCount() - 1);

        } else {
            g.getTb().setRowSelectionInterval(index - 1, index - 1);
        }
         Check();
        }
        });
        
      
    }
    }
    
    void Check(){
       // Gui g = new Gui();
        int row = g.getTb().getSelectedRow();
        if(row < 0){
            g.getBtnf().setVisible(true);
            g.getBtnl().setVisible(true);
            g.getBtnn().setVisible(true);
            g.getBtnp().setVisible(false);
           
        } else if(row ==0 ){
            g.getBtnf().setVisible(false);
            g.getBtnl().setVisible(true);
            g.getBtnn().setVisible(true);
            g.getBtnp().setVisible(false);
        } else if(row == g.getTb().getRowCount() - 1){
            g.getBtnf().setVisible(true);
            g.getBtnl().setVisible(false);
            g.getBtnn().setVisible(false);
            g.getBtnp().setVisible(true);
    } else {
            g.getBtnf().setVisible(true);
            g.getBtnl().setVisible(true);
            g.getBtnn().setVisible(true);
            g.getBtnp().setVisible(true);
        }
        
        
    }   
    
   
    
}
