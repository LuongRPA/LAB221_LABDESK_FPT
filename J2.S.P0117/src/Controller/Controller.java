/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.View;
import java.sql.Connection;
import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Controller {

    public Controller() {
    }
    
    private View view;
    
    public Controller(View view) {
        this.view = view;
        
        dataNDisplay(); // đổ dữ liệu vào bảng theo model
        actionBatch(); // add dữ liệu vào data sql
    }
    ////  window display frame with table add data to sql
    private void dataNDisplay() {
        DefaultTableModel dt = new DefaultTableModel() { 
            // create model of table
          
        };
        // set model
        view.getTable().setModel(dt);
        view.getTable().getTableHeader().setReorderingAllowed(false);
        //add column
        dt.addColumn("StockID");
        dt.addColumn("StockName");
        dt.addColumn("Address");
        dt.addColumn("DateAvailable");
        dt.addColumn("Note");
        /// add data to table
        dt.addRow(new Object[]{1, "Stock one", "No1-Washington street", "11/05/2010", ""});
        dt.addRow(new Object[]{2, "Stock two", "372 Cave Town-001 Banks", "09/07/2011", ""});
        dt.addRow(new Object[]{3, "Stock three", "Nary angle-890 Number one", "13/05/2010", "Store Dangerous"});
        dt.addRow(new Object[]{4, "Stock four", "Twin tower- 01 Main street", "04/07/2015", ""});
        dt.addRow(new Object[]{5, "Stock five", "Victory anniversary distric", "8/12/2014", ""});
        
    }
    /// check  use batch in java add list data to sql if false
    private void actionBatch() {
        view.getBtnInsert().addActionListener((ae) -> { 
            
            try {
                batchUpdate(); /// add to sql
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); 
// show masge nếu k kết nối dc sever
                JOptionPane.showMessageDialog(view, "Add error!! ");
            }
            
        });
    }
    //// use batch in java add list data to sql
    private void batchUpdate() throws SQLException, ParseException{
        Connection conn = new dal.Dataconnection().getConnection();
        
        try { // masage to sql
            String sql = " \n"
                    + "INSERT INTO [FU_DB].[dbo].[Stock117]( [StockID]\n"
                    + "      ,[StockName]\n"
                    + "      ,[Address]\n"
                    + "      ,[DateAvailable]\n"
                    + "      ,[Note])\n"
                    + "VALUES (?,?,?,?,?)\n"
                    ;
            
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            JTable table = view.getTable(); 
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // định dạng 
            sdf.setLenient(false); // k cho cộng date
            
            for (int i = 0; i < table.getRowCount(); i++) { // get seqence row value of table
                ps.setString(1, table.getValueAt(i, 0).toString());
                ps.setString(2, table.getValueAt(i, 1).toString());
                ps.setString(3, table.getValueAt(i, 2).toString());
                
                java.util.Date date = sdf.parse(table.getValueAt(i, 3).toString()); // chuyển sang date
                ps.setDate(4, new java.sql.Date(date.getTime()));
                
                
               // ps.setString(4, table.getValueAt(i, 3).toString());
                //ps.setDate("2017-02-21");
               // ps.setDate(4, Date.valueOf(table.getValueAt(i, 3).toString()));
              //ps.setDate(4, java.sql.Date.valueOf(table.getValueAt(i, 3).toString()));
                ps.setString(5, table.getValueAt(i, 4).toString());
                ps.addBatch(); // add to batch
                ps.executeBatch(); // executeBatch
                
            }
            
            conn.commit(); // fill message 
            JOptionPane.showMessageDialog(view, "Insert Success!!!");
            
            
        } catch (SQLException ex) {
            conn.rollback();        // rollback data if  catch exception 
            JOptionPane.showMessageDialog(view, ex.getMessage()); 
            
        }catch (Exception x) {
            conn.rollback();        // rollback data if  catch exception 
            JOptionPane.showMessageDialog(view, x.getMessage());
        }
        finally {
           // conn.close(); // close
        }
        
    }
    
}
