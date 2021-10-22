/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.MGui;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 *
 * @author Admin
 */
public class Controll {
 MGui m = new MGui();
 private final int RADIUS = 100; // bán kính 
    
    private final int x = 10; // toạ độ x
    private final int y = 10; //  toạ độ y
    
    private final Graphics2D g;
    
    public Controll() {
        m.setVisible(true);
        g = (Graphics2D) m.getPnB().getGraphics();
        m.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        m.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                initCounter();
            }
        });
        
        m.getBtnU().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             //  up
              // set location of ball
               int r1 = m.getPnB().getX();
               int r2 = m.getPnB().getY();
               int l = m.getPnM().getHeight(); //height of jpanel have button to move
               
               m.getPnB().setLocation(r1,r2-50); // move 50
              
               if (r2 <-1) {
                r2 = m.getHeight()-l; //  is height of jframe - height of jpanel have button to move
                m.getPnB().setLocation(r1,r2); // reset location
                
                ///
                
                
               }

            }
        });
        
        
        ///
         /// move down
        m.getBtnD().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // down
              int n1 = m.getPnB().getX();
              int n2 = m.getPnB().getY();
               int l = m.getPnM().getHeight();// //height of jpanel have button to move
              m.getPnB().setLocation(n1,n2+50);
              if (n2 > m.getHeight()-l) { // is height of jframe - height of jpanel have button to move
                n2 = 0;
                m.getPnB().setLocation(n1,n2);
               }
              
            }
        });
        
    ///
      //move right
        m.getBtnR().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //right
                int m1 = m.getPnB().getX();
                int m2 = m.getPnB().getY();
                m.getPnB().setLocation(m1+50,m2); 
               
                if (m1 > m.getWidth()) {
                m1 = 0; // 
                m.getPnB().setLocation(m1,m2);
               }
               
            }
        });

        /// move left
        m.getBtnL().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //left
                int t1 = m.getPnB().getX();
                int t2 = m.getPnB().getY();
                m.getPnB().setLocation(t1-50,t2);
                if (t1 <-1) {
                t1 = m.getWidth();
                m.getPnB().setLocation(t1,t2);
               }
                
            }
        });

    }
    public void initCounter(){
        g.setColor(Color.black); // border of oval
        g.setStroke(new BasicStroke(5)); // line
        g.drawOval(x, y, RADIUS, RADIUS); // vẽ hình tròn tại toạ độ x,yy với bán kính 
        g.setColor(Color.green); // back ground
        g.fillOval(x, y, RADIUS, RADIUS); // 
        
        m.getPnB().paintComponents(g);
    }
    }
    

