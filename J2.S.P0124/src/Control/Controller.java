/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.SimplePaint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
/**
 *
 * @author Admin
 */
public class Controller {
    SimplePaint sp = new SimplePaint();
    Graphics g;
    Color c = Color.BLACK;
    int x1 = 0; //khởi tạo biến toạ độ theo trục tung và hoành
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    public Controller() {
        sp.setVisible(true);
        g = sp.getDisplay().getGraphics();
        g.setColor(c);
        sp.setResizable(false);
        sp.getDisplay().setVisible(true);
        g = (Graphics2D) sp.getDisplay().getGraphics();
        ///black 
         sp.getBtnblack().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               g.setColor(sp.getBtnblack().getBackground());
                sp.getBtnblack().setBorder(BorderFactory.createLineBorder(Color.RED));
                sp.getBtnred().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnblue().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtngre().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnyelow().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnvio().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnleon().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
         
         //red
          sp.getBtnred().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               g.setColor(sp.getBtnred().getBackground());
               sp.getBtnblack().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnred().setBorder(BorderFactory.createLineBorder(Color.YELLOW));
                sp.getBtnblue().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtngre().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnyelow().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnvio().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnleon().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
          //
          //green
           sp.getBtngre().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               g.setColor(sp.getBtngre().getBackground());
               sp.getBtnblack().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnred().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnblue().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtngre().setBorder(BorderFactory.createLineBorder(Color.RED));
                sp.getBtnyelow().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnvio().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnleon().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
           
           ///blue
            sp.getBtnblue().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               g.setColor(sp.getBtnblue().getBackground());
               sp.getBtnblack().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnred().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnblue().setBorder(BorderFactory.createLineBorder(Color.RED));
                sp.getBtngre().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnyelow().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnvio().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnleon().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
            ///leon
             sp.getBtnleon().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               g.setColor(sp.getBtnleon().getBackground());
               sp.getBtnblack().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnred().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnblue().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtngre().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnyelow().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnvio().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnleon().setBorder(BorderFactory.createLineBorder(Color.RED));
            }
        });
             //voilet
              sp.getBtnvio().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               g.setColor(sp.getBtnvio().getBackground());
               sp.getBtnblack().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnred().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnblue().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtngre().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnyelow().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnvio().setBorder(BorderFactory.createLineBorder(Color.RED));
                sp.getBtnleon().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
              //yelow
               sp.getBtnyelow().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               g.setColor(sp.getBtnyelow().getBackground());
               sp.getBtnblack().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnred().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnblue().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtngre().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnyelow().setBorder(BorderFactory.createLineBorder(Color.RED));
                sp.getBtnvio().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                sp.getBtnleon().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
               
               ///clear 
               sp.getBtnclear().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sp.getDisplay().repaint();
            }
        });
               
               
               //////////////////////////
               
                sp.getDisplay().addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Point p = evt.getLocationOnScreen(); //lấy điểm p đặt chuột ở trên màn hình
        SwingUtilities.convertPointFromScreen(p,sp.getDisplay());//lấy toạ độ điểm p theo màn hình display
        x2 = p.x; // x2, y2 : toa do diem tiep theo
        y2 = p.y;

        g.drawLine(x1, y1, x2, y2);// ve 1 duong thang 

        x1 = x2;
        y1 = y2;
            }
        });
             /////////////////////////
                
                sp.getDisplay().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                 g.drawOval(x1, y1, 1, 1);//diem cham  
            }
            /////////////////////////////////
            public void mousePressed(java.awt.event.MouseEvent evt) {
                 Point p = evt.getLocationOnScreen();
      SwingUtilities.convertPointFromScreen(p, sp.getDisplay());//lấy toạ độ điểm p theo màn hình display
        x1 = p.x;
        y1 = p.y;
        
            }
        });
        ///
        
               
    }
   
     
}
