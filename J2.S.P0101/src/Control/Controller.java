/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.Jprogressbar;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import sun.util.locale.StringTokenIterator;
/**
 *
 * @author Admin
 */
public class Controller {
Jprogressbar j = new Jprogressbar();
DefaultMutableTreeNode root;  
String fileName = "nodeData2.txt";  
DefaultMutableTreeNode currentFatherNode;
DefaultMutableTreeNode currentSonNode;
boolean isFater = false;
boolean isSon = false;
boolean isRoot = false;
    ////
    
    ////
    
    /////
    public Controller() {
    j.setVisible(true);
    root = new DefaultMutableTreeNode("RootNode");
    // dispkay data of tree
        loadData();
       
   
    /// click button add action evev 
         j.getTxtAdd().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // addNewNode();
                j.getTxtAdd().setText(" "); // click mouse text box set text null
            }
        });
         
         ///
         j.getTxtAdd().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewNode(); /// add new node tree
            }
        });
         
         ///
         j.getTxtAdd().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                // addNewNode();
            }
        });
//////

// click to a node in tree 
        j.getTreeData().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeClick(); // tree click
            }
        });
    ///// click to btn delete node
 j.getBtnRrmove().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeNode(); /// remove node clicked
            }
        });    
    }
  ///// check string in text box
    public boolean validateString(String x){
        if(j.getTreeData().getSelectionPath() != null){
           TreePath path = j.getTreeData().getSelectionPath();
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            for(int i = 0; i< selectedNode.getChildCount();i++){
                if(selectedNode.getChildAt(i).toString().equals(x)){ // k được giống text cũ
                    JOptionPane.showMessageDialog(j, "Don't add the same item");
                    return false;
                }
            }            
        }
        
        //// khi text trống  null show dialog

        if(x.isEmpty()){
            JOptionPane.showMessageDialog(j, "Please write something");
            return false;
        }
        /// 
        if(x.trim().length() == 0){
            JOptionPane.showMessageDialog(j, "Don't add blank");
            return false;
        }
        ///
        if(x.charAt(x.length() -1) == ':'){
            JOptionPane.showMessageDialog(j, "Don't put : at the end");
            return false;
        }
        return true;
    }
    
    ////// revmoe node
    public void removeNode(){
        if(j.getTreeData().getSelectionPath() != null){ // k chọn sẵn 
        TreePath path = j.getTreeData().getSelectionPath(); // chọn vị trí trên cây
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();//
        int numberOfChild = selectedNode.getChildCount(); // check số node
        if(numberOfChild == 0){
            if(selectedNode != root){
                if(isSon){// confrm xoá node
                    if(JOptionPane.showConfirmDialog(j,"Are you sure","Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        currentFatherNode.remove(this.currentSonNode);
                    }                    
                }else{
                    root.remove(this.currentSonNode);
                }
            }else{
                DefaultTreeModel model = (DefaultTreeModel) j.getTreeData().getModel();
                root = (DefaultMutableTreeNode) model.getRoot();
                root.removeAllChildren();
                root = null;
                model.reload();
                model.setRoot(null);        
            }
        }else{
            JOptionPane.showMessageDialog(j, "There is still item in here");
        }
        

        j.getTreeData().updateUI();
        }else{
            JOptionPane.showMessageDialog(j, "Please choose a node");
        }
    }
    
    //// thêm vào cây
    public void addNewNode(){
        String x = j.getTxtAdd().getText(); // chon tên con 
        if(j.getTreeData().getSelectionPath() == null && root != null){ //  chưa chọn vị trí thêm
            JOptionPane.showMessageDialog(j, "You have not choosen any node");
            return;
        }         
        if(root == null){
            root = new DefaultMutableTreeNode(x);
            DefaultTreeModel model = (DefaultTreeModel) j.getTreeData().getModel();
            model.setRoot(root);
        }else{
            if(validateString(x) == false){
                return;
            }
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(x);
        
            if(isRoot){
                root.add(newNode);
            }else if(isFater){
                currentFatherNode.add(newNode);
                
            }else if(isSon){
                currentSonNode.add(newNode);           
            }
        } 
       

        j.getTxtAdd().setText("");
        j.getTreeData().updateUI(); // update data
        
    }
    ///// chọn vị trí trên cây
    public void treeClick(){
        j.getTreeData().setEditable(false);        
        TreePath path = j.getTreeData().getSelectionPath();

        if(path == null){
            return;
        }
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)path.getLastPathComponent();
        int numberOfChild = selectedNode.getChildCount();
        if(root != null){
        if(selectedNode == root){
            currentFatherNode = currentSonNode= root;
            
            isRoot = true;
            isFater = false;
            isSon = false;
        }else{
            if(numberOfChild > 0){
                currentFatherNode = selectedNode;
                currentSonNode = null;
                isFater = true;
                isSon = false;
                isRoot = false;
            }else{
                currentFatherNode = (DefaultMutableTreeNode) selectedNode.getParent();
                currentSonNode = selectedNode;
                isSon = true;
                isFater = false;
                isRoot = false;
            }
        }             
        }
        
    }
    /////
    
    public void testPrint(){
        JOptionPane.showMessageDialog(j, currentFatherNode+" "+currentSonNode);
    }
    ////
    //hiển thị dữ liệu của cây
    public void loadData(){
        String line = "";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                boolean isFather = line.charAt(line.length() - 1) == ':';
                StringTokenIterator token = new StringTokenIterator(line, ":"); 
                if(isFather){
                                       
                    currentFatherNode = new DefaultMutableTreeNode(token.first());
                    root.add(currentFatherNode);
                }else{
                    currentSonNode = new DefaultMutableTreeNode(line);
                    currentFatherNode.add(currentSonNode);
                }
            }
            
        } catch (IOException e) {
        }
    }
    
}
