/*
 * testFrame.java
 *
 * Created on September 5, 2007, 9:35 PM
 */

package testpackage;

import imageexplorer.ImagePane;

/**
 *
 * @author Administrator
 */
public class testFrame extends javax.swing.JFrame {
    
    /** Creates new form testFrame */
    private ImagePane imagePane;
    
    public testFrame() {
        initComponents();
        imagePane=new ImagePane();
        imagePane.setRowHeight(65);
        imagePane.loadDirectory("E:\\Projects\\Java\\DigitalMorphing\\samples");
        getContentPane().add(imagePane);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
