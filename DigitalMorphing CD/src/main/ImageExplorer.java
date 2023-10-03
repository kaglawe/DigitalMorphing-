package main;
import imageexplorer.ImagePane;
import java.awt.Container;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
/*
 * ImageExplorer.java
 *
 * Created on September 7, 2007, 9:44 PM
 */

/**
 *
 * @author Administrator
 */
public class ImageExplorer extends javax.swing.JFrame {
      private ImagePane imagePane;
    
    /**
     * Creates new form ImageExplorer
     */
    public ImageExplorer() {
        initComponents();
        setSize(600,550);
        int width=getWidth();
        int height=getHeight();
        
        folderLbl.setBounds(20,20,70,20);
        folderPathTxt.setBounds(100,20,430,20);
        openDialogButton.setBounds(540,20,40,20);
        
        imagePane=new ImagePane();
        imagePane.setRowHeight(65);
        imagePane.setBounds(0,60,width-5,height-60);
        getContentPane().add(imagePane);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        folderLbl = new javax.swing.JLabel();
        openDialogButton = new javax.swing.JButton();
        folderPathTxt = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        folderLbl.setText("Folder Path");
        getContentPane().add(folderLbl);
        folderLbl.setBounds(20, 30, 70, 14);

        openDialogButton.setText("...");
        openDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDialogButtonActionPerformed(evt);
            }
        });

        getContentPane().add(openDialogButton);
        openDialogButton.setBounds(330, 30, 45, 23);

        folderPathTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderPathTxtActionPerformed(evt);
            }
        });

        getContentPane().add(folderPathTxt);
        folderPathTxt.setBounds(90, 30, 230, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-409)/2, (screenSize.height-300)/2, 409, 300);
    }// </editor-fold>//GEN-END:initComponents
    
    private void folderPathTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderPathTxtActionPerformed
        
    }//GEN-LAST:event_folderPathTxtActionPerformed
    
    private void openDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDialogButtonActionPerformed
        
        JDialog.setDefaultLookAndFeelDecorated(true);
        JFileChooser filechooser=new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if(filechooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File selectedFile=filechooser.getSelectedFile();
            folderPathTxt.setText( selectedFile.getPath());
            imagePane.loadDirectory(selectedFile.getPath());
            
            getContentPane().add(imagePane);
        }
        
        
    }//GEN-LAST:event_openDialogButtonActionPerformed
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageExplorer().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel folderLbl;
    private javax.swing.JTextField folderPathTxt;
    private javax.swing.JButton openDialogButton;
    // End of variables declaration//GEN-END:variables
    
  
}

