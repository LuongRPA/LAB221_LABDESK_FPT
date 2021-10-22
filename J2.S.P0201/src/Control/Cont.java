/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.Move;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.Timer;
/**
 *
 * @author Admin
 */
public class Cont {
Move m = new Move();

    
    public Cont() {
        m.setVisible(true);
   // g = (Graphics2D) m.getPnB().getGraphics();
    m.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        m.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
              //  initCounter();
             
            }
        });
        
        m.getBtnU().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             //  up
              // set location of ball
               int r1 = m.getLblB().getX();
               int r2 = m.getLblB().getY();
               int l = m.getPnM().getHeight(); //height of jpanel have button to move
               
               m.getLblB().setLocation(r1,r2-50); // move 50
              
               if (r2 <-1) {
                r2 = m.getHeight()-l; //  is height of jframe - height of jpanel have button to move
                m.getLblB().setLocation(r1,r2); // reset location
                
                ///
                
                
               }

            }
        });
        
        
        ///
         /// move down
        m.getBtnD().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // down
              int n1 = m.getLblB().getX();
              int n2 = m.getLblB().getY();
               int l = m.getPnM().getHeight();// //height of jpanel have button to move
              m.getLblB().setLocation(n1,n2+50);
              if (n2 > m.getHeight()-l) { // is height of jframe - height of jpanel have button to move
                n2 = 0;
                m.getLblB().setLocation(n1,n2);
               }
              
            }
        });
        
    ///
      //move right
        m.getBtnR().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //right
                int m1 = m.getLblB().getX();
                int m2 = m.getLblB().getY();
                m.getLblB().setLocation(m1+50,m2); 
               
                if (m1 > m.getWidth()) {
                m1 = 0; // 
                m.getLblB().setLocation(m1,m2);
               }
               
            }
        });

        /// move left
        m.getBtnL().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //left
                int t1 = m.getLblB().getX();
                int t2 = m.getLblB().getY();
                m.getLblB().setLocation(t1-50,t2);
                if (t1 <-1) {
                t1 = m.getWidth();
                m.getLblB().setLocation(t1,t2);
               }
                
            }
        });

    }
//   
}
