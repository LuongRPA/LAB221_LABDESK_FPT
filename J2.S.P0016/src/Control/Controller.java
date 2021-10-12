/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.Counter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.Timer;
/**
 *
 * @author Admin
 */
public class Controller {
Counter cr = new Counter();
 private final Graphics2D g;
    private final int RADIUS = 100; // bán kính 
    private final int TIME_LIMIT = 60; // 1 munite
    private final int x = 100; // toạ độ x
    private final int y = 100; //  toạ độ y
    private final Timer t;
    private int currentNumber = 0;

 
    public Controller() {
        cr.setVisible(true);
        
        t = new Timer(1000, (e) -> { // sleep 1s
            currentNumber ++;
            setCountdownNumber(currentNumber);
            drawTimer(currentNumber);
             
        });
        g = (Graphics2D) cr.getPnClock().getGraphics();
        
        
        
        ///start click
     cr.getBtnStart().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t.start();
                cr.getBtnStart().setEnabled(false);
                cr.getBtnStop().setEnabled(true);
            }
        });
     
     ///stop selected
     cr.getBtnStop().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t.stop();
                cr.getBtnStart().setEnabled(true);
                cr.getBtnStop().setEnabled(false);
            }
        });
 /// run panel draw 
 cr.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        cr.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                 initCounter(); //
            }
        });
     
     
    }
    
    public void initCounter(){
        g.setColor(Color.black); // border of oval
        g.setStroke(new BasicStroke(5)); // line
        g.drawOval(x, y, RADIUS, RADIUS); // vẽ hình tròn tại toạ độ x,yy với bán kính 
        g.setColor(Color.white); // back ground
        g.fillOval(x, y, RADIUS, RADIUS); // 
        setCountdownNumber(currentNumber);
        cr.getPnClock().paintComponents(g);
    }
    ///number of time
    public void setCountdownNumber(int number){
        cr.getLblTime().setText(number+"");
    }
    //draw 
    public void drawTimer(int number){
        if(number % TIME_LIMIT == 0){ // set start = 0 
            g.setColor(Color.white); // back ground write
            g.fillOval(x, y, RADIUS, RADIUS); // draw 
            currentNumber = 0;
        }else{
            g.setColor(Color.red); // choose red color
            int arcAngle = -(number%TIME_LIMIT)*(360/TIME_LIMIT);// tinh  góc
           // g.drawLine(x,y, RADIUS, RADIUS);
            g.fillArc(x, y, RADIUS, RADIUS, 90, arcAngle);
        }
    }

}
