/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import GUI.Note;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
/**
 *
 * @author Admin
 */
public class Controller {
 Note n = new Note();
 String title = "Untitled - My Text Editor", pathFile = "", curDir = System.getProperty("user.home"); 
//curDir để lưu trữ thư mục mở lần cuối
    Vector v = new Vector();
    //tạo vector font
    boolean isSave = true;
    //biến cờ để báo khi nào có thể save
    UndoManager um = new UndoManager();
    
    public Controller() {
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        n.setTitle(title); // untitiled 
        um.setLimit(-1);
        initListener();
        n.getmCut().setEnabled(false);
        n.getmCoppy().setEnabled(false);
        n.getmUndo().setEnabled(false);
        n.getmRedo().setEnabled(false);
        n.getmFind().setEnabled(false);
        
        initFindDialog();
        initReplaceDialog();
        initChangeFontDialog();
        
        ////
        n.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        n.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                initExit();
            }
        });
        /// new
         n.getmNew().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (isSave) { // check saved 
            newFile();
        } else { // if un saved
            int opt = JOptionPane.showConfirmDialog(n, "Do you want to save changes to " + title.split(" - ")[0] + "?", "My Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opt == JOptionPane.YES_OPTION) { // show massage dialog
                if (saveFile(n.getTxtContent().getText())) {// save file
                    newFile();  //  then create new file
                }
            } else if (opt == JOptionPane.NO_OPTION) {
                newFile(); // close and create new file
            }
        }
            }
        });
         ////open
          n.getmOpen().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (isSave) { // open file in local
            openFile();
        } else { // nếu trên content đang có file chưa lưu thì show dialog thông báo tuỳ chọn
            int opt = JOptionPane.showConfirmDialog(n, "Do you want to save changes to " + title.split(" - ")[0] + "?", "My Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                if (saveFile(n.getTxtContent().getText())) {
                    openFile();
                }
            } else if (opt == JOptionPane.NO_OPTION) {
                openFile();
            }
        }
            }
        });
          ///save 
           n.getmSave().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 saveFile(n.getTxtContent().getText());
            }
        });
           ////save as
           n.getmSaveAs().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAs(n.getTxtContent().getText());
            }
        });
           ///exit
            n.getmExit().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initExit();
            }
        });
            ////undo
            n.getmUndo().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                um.undo(); // undomanager in java
            }
        });
            ///redo
            n.getmRedo().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 um.redo(); // undomanager in java
            }
        });
            ///cut
            n.getmCut().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n.getTxtContent().cut(); // cut in java
            }
        });
            ///coppy
             n.getmCoppy().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 n.getTxtContent().copy(); // copy in java
            }
        });
             ////pate
             n.getmPate().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n.getTxtContent().paste(); // paste in java
            }
        });
             ///select all
             n.getmSelectAll().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n.getTxtContent().selectAll(); // choose all in java
                
            }
        });
             ///find
               n.getmFind().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                n.getFindDialog().setVisible(true);
                n.getTxtFind().setText("");
                if (n.getTxtContent().getSelectedText() != null) {
                n.getTxtFind().setText(n.getTxtContent().getSelectedText());
        }
            }
        });
              //replace
            n.getmRePlace().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            n.getReplaceDialog().setVisible(true);
            if (n.getTxtContent().getSelectedText() != null) {
            n.getTxtReFind().setText(n.getTxtContent().getSelectedText());
        }
            }
        });
               ///change font
               n.getmChangeFont().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n.getChangeFontDialog().setVisible(true);
                loadFonts();
            }
        });
               ///find dialog
                n.getBtnFind().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findStr();
            }
        });
                ///cancel find
                n.getBtnCancelFind().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               n.getFindDialog().dispose();
            }
        });
                ///find
                n.getBtnFind().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               findStr();
            }
        });
                //find next
            n.getBtnFindNext().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repFindStr();
            }
        });
                /// replace
            n.getBtnReplace().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (n.getTxtContent().getSelectedText() == null) {
               repFindStr();
        } else {
            n.getTxtContent().replaceSelection(n.getTxtRePlace().getText());
               repFindStr();
        }
            }
        });
            ////repalce all
            n.getBtnRePlaceAl().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            String rep = n.getTxtReFind().getText(); // text find
            String replace = n.getTxtRePlace().getText();// text want to replace
            boolean existed = n.getTxtContent().getText().contains(rep); 
            if (!existed) { 
            n.getReplaceDialog().setAlwaysOnTop(false); // show dialog message 
            JOptionPane.showMessageDialog(n, "Can't find \"" + rep + "\"", "Can't Find", JOptionPane.OK_OPTION);
            n.getReplaceDialog().setAlwaysOnTop(true); 
             } else {////replaces all occurrences of "rep" to "replace"  
            n.getTxtContent().setText(n.getTxtContent().getText().replaceAll(rep, replace)); // replaceall in java
        }
            }
        });
             ///cancel
                n.getBtnCancel().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                n.getReplaceDialog().dispose();
            }
        });
              ///apply
               n.getBtnApply().addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
               Font font = n.getTxtFontText().getFont();
               n.getTxtFontText().setFont(font);
               n.getChangeFontDialog().dispose();
            }
        });
               ///cancel font
               n.getBtnFontCancel().addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
               n.getChangeFontDialog().dispose();
            }
        });
                
             
    }
    
    /// tạo file mới 
    private void newFile() {
        title = "Untitled - My Text Editor";
        n.setTitle(title);
        //khi file mới chưa có title
        n.getTxtContent().setText("");
        pathFile = "";
        isSave = true;
        um.discardAllEdits();
        //discard để không undo được nữa, xóa hết các edit stack được lưu
        disableMenuItems();
    }

    //// save file in context thành file mới 
     private boolean saveAs(String conttent) {
        try {
            JFileChooser jf = new JFileChooser(curDir);
            jf.setFileFilter(new FileNameExtensionFilter("Text Document", "TXT"));
            int opt = jf.showSaveDialog(n);
            curDir = jf.getCurrentDirectory().getAbsolutePath();
            if (opt == JFileChooser.APPROVE_OPTION) {
                File f = jf.getSelectedFile();
                if (!f.getName().toLowerCase().endsWith(".txt")) {
                    f = new File(f.getPath() + ".txt");
                }
                pathFile = f.getPath(); // lấy path của file
                if (f.exists()) {
                    int choice = JOptionPane.showConfirmDialog(n, f.getName() + " already exists. \nDo you want to replace it?", "Confirm Save As", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        Files.write(f.toPath(), conttent.getBytes());
                        isSave = true; //file đã lưu nên set = true
                        title = f.getName().replaceAll("\\.txt$", "") + " - My Text Editor";
                        n.setTitle(title);
                    } else {
                        if (!saveAs(conttent)) {
                            return false;                        }
                    }
                } else {
                    Files.write(f.toPath(), conttent.getBytes());
                    isSave = true;
                    title = f.getName().replaceAll("\\.txt$", "") + " - My text editor";
                    n.setTitle(title);
                }
            } else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
            return false; //neu co exception thi return la chua save as
        }
        return true;
        //nếu lưu thành công thì return true
    }
     //// save file in content to local
     private boolean saveFile(String content) {
        if (pathFile.isEmpty()) {
            //nếu file chưa từng đc lưu
            if (saveAs(content)) {
                return true;
                //lưu file
            }
        } else {
            try {
                Files.write(new File(pathFile).toPath(), content.getBytes());
                //lưu file đã có tên
                isSave = true;
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }
     //// open file in local
     private void openFile() {
        try {
            JFileChooser jf = new JFileChooser(curDir);
            jf.setFileFilter(new FileNameExtensionFilter("Text Document", "TXT"));
            int opt = jf.showOpenDialog(n);
            curDir = jf.getSelectedFile().getAbsolutePath();
            if (opt == JFileChooser.APPROVE_OPTION) {
                File f = jf.getSelectedFile();
                pathFile = f.getPath(); // file dc chọn 
                try {
                    n.getTxtContent().read(Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8), null);
                } catch (Exception e) {
                    n.getTxtContent().read(Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_16), null);
                }
                initListener();
                disableMenuItems();
            }
        } catch (Exception e) {
        }
    }
//// show menu item
     public void disableMenuItems() {
        if (um.canUndo()) {
            n.getmUndo().setEnabled(true);
        } else {
            n.getmUndo().setEnabled(false);
        }
        if (um.canRedo()) {
            n.getmRedo().setEnabled(true);
        } else {
            n.getmRedo().setEnabled(false);
        }
        if (n.getTxtContent().getText().isEmpty()) {
            n.getmFind().setEnabled(false);
        } else {
            n.getmFind().setEnabled(true);
        }
        if (um.canUndo()) {
            isSave = false;
        } else {
            isSave = true;
        }
    }
     ///
     private void loadFonts() { // load font in local
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment(); // các font có trên máy thực hiện
        String[] fontName = env.getAvailableFontFamilyNames(); // to string to add jlist 
        JList listFontName = new JList(fontName); // list font name
        n.getListFontName().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String font = n.getListFontName().getSelectedValue(); // choose font
                Font fontText = new Font(font, Font.PLAIN, 15); // 
                n.getTxtFontText().setFont(fontText); // change font in txtcontent
            }
        });
        n.getScrollName().getViewport().add(listFontName);

        n.getListFontStyle().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int style = n.getListFontStyle().getSelectedIndex();
                    Font fontStyle = n.getTxtFontText().getFont().deriveFont(style);
                    n.getTxtFontText().setFont(fontStyle);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        });

        n.getListFontSize().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Float size = Float.parseFloat(n.getListFontSize().getSelectedValue());
                    Font fontSize = n.getListFontSize().getFont().deriveFont(size);
                    n.getListFontSize().setFont(fontSize);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
     //// show find dialog
     private void initFindDialog() {
        n.getFindDialog().setAlwaysOnTop(true);
        n.getFindDialog().setTitle("Find");
        n.getFindDialog().setSize(450, 200);
        n.getFindDialog().setLocationRelativeTo(n);
    }
////
    private void initReplaceDialog() { // show replace dialog
        n.getReplaceDialog().setAlwaysOnTop(true);
        n.getReplaceDialog().setTitle("Replace");
        n.getReplaceDialog().setSize(500, 250);
        n.getReplaceDialog().setLocationRelativeTo(n);
    }
////
    private void initChangeFontDialog() { // show dialog change font
        n.getChangeFontDialog().setAlwaysOnTop(true);
        n.getChangeFontDialog().setTitle("Change Font");
        n.getChangeFontDialog().setSize(460, 338);
        n.getChangeFontDialog().setLocationRelativeTo(n);
    }
//// 
    private void initListener() {
        n.getTxtContent().getDocument().addUndoableEditListener((UndoableEditEvent e) -> {
            um.addEdit(e.getEdit());
            //khi có sự kiện có thể undo thì thêm edit vào stack undo
            disableMenuItems();
        });

        n.getTxtContent().getDocument().addDocumentListener(new DocumentListener() {
            //nếu textarea phát sinh sự kiện thì phát sinh
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableMenuItems(); // thêm insert
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                disableMenuItems(); // thêm remove
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                disableMenuItems(); // thêm change
            }
        });
    }
///// find string 
    private void findStr() {
        String find = n.getTxtFind().getText();
        int index = n.getTxtContent().getText().indexOf(find, n.getTxtContent().getCaretPosition());
        if (index < 0) { // cand find show mesage
            n.getFindDialog().setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(n, "Cannot find \"" + find + "\"", "My Text Editor", JOptionPane.INFORMATION_MESSAGE);
            n.getFindDialog().setAlwaysOnTop(true);
        } else {
            n.getTxtContent().select(index, index + find.length());
        }
    }
////
    private void repFindStr() {
        String find = n.getTxtReFind().getText();
        int index = n.getTxtContent().getText().indexOf(find, n.getTxtContent().getCaretPosition());
        if (index < 0) { // can find show dialog
            n.getReplaceDialog().setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(n, "Can't find\"" + find + "\"", "My Text Editor", JOptionPane.INFORMATION_MESSAGE);
            n.getReplaceDialog().setAlwaysOnTop(true);
        } else {
            n.getTxtContent().select(index, index + find.length());
        }
    }
///// exit program
    private void initExit() {
        if (isSave) {
            System.exit(0); 
        } else { // if dont save show dialog 
            int opt = JOptionPane.showConfirmDialog(n, "Do you want to save changes to " + title.split(" - ")[0] + "?", "My Text Editor", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                if (saveFile(n.getTxtContent().getText())) {
                    System.exit(0);
                }
            } else if (opt == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }
}
