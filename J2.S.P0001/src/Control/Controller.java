/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.Img;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Controller {   
    Img i = new Img();
   ///    
    private void setImageforLabel(JLabel jl, ImageIcon ic) {
        Image im = ic.getImage().getScaledInstance(jl.getWidth(), jl.getHeight(), Image.SCALE_SMOOTH);
        ic = new ImageIcon(im);
        jl.setIcon(ic);
    }
    ///
    
    
    
    public Controller() {
        i.setVisible(true);
////

        ///img1
        i.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setImageforLabel(i.getjLabel1(), i.getIcon1());
                 i.getjButton1().setBorder(BorderFactory.createLineBorder(Color.RED));
                 i.getjButton2().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton3().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton4().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton5().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
        ///img2
        i.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setImageforLabel(i.getjLabel1(), i.getIcon2());
                 i.getjButton2().setBorder(BorderFactory.createLineBorder(Color.RED));
                 i.getjButton1().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton3().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton4().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton5().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
        //img3
        i.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setImageforLabel(i.getjLabel1(), i.getIcon3());
                 i.getjButton3().setBorder(BorderFactory.createLineBorder(Color.RED));
                 i.getjButton2().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton1().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton4().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton5().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
        //img4
        i.getjButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setImageforLabel(i.getjLabel1(), i.getIcon4());
                 i.getjButton4().setBorder(BorderFactory.createLineBorder(Color.RED));
                 i.getjButton2().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton3().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton1().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton5().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
        //img5
        i.getjButton5().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setImageforLabel(i.getjLabel1(), i.getIcon5());
                 i.getjButton5().setBorder(BorderFactory.createLineBorder(Color.RED));
                 i.getjButton2().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton3().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton4().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                 i.getjButton1().setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });
        
        
    }
     
}
