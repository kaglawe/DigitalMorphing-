/*
 * ScaleImage.java
 *
 * Created on August 24, 2007, 12:40 AM
 */

package main;

import java.awt.Color;
import javax.media.jai.PlanarImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Adminstrator
 *
 */
public class ScaleImage extends javax.swing.JFrame {
    private ChildWindow currentChildWindow;
    private PlanarImage planarImage;
    private int originalHeight;
    private int originalWidth;
    private double newWidth;
    private double newHeight;
    private ImageControl originalImageLabel;
    /** Creates new form ScaleImage */
    public ScaleImage() {
        initComponents();
        getContentPane().setBackground(new Color(221,224,225));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jDialog1 = new javax.swing.JDialog();
        jOptionPane1 = new javax.swing.JOptionPane();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        orgImageWidth = new javax.swing.JTextField();
        orgImageHeight = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        scaleX = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        newImageWidth = new javax.swing.JTextField();
        newImageheight = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        applyBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        scaleY = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Scale");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel2.setText("Width :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 50, 60, 14);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel3.setText("Height :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 80, 60, 14);

        orgImageWidth.setEditable(false);
        getContentPane().add(orgImageWidth);
        orgImageWidth.setBounds(90, 50, 110, 20);

        orgImageHeight.setEditable(false);
        getContentPane().add(orgImageHeight);
        orgImageHeight.setBounds(90, 80, 110, 20);

        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(30, 110, 190, 10);

        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(30, 40, 190, 10);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel1.setText("Original Image");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(83, 20, 97, 20);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel4.setText("Scale ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 130, 50, 15);

        scaleX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleXActionPerformed(evt);
            }
        });

        getContentPane().add(scaleX);
        scaleX.setBounds(90, 160, 70, 20);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel5.setText("New Image");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 240, 100, 15);

        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 260, 190, 2);

        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(30, 330, 190, 2);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel6.setText("Width :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 270, 50, 14);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel7.setText("Height :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 300, 50, 14);

        newImageWidth.setEditable(false);
        getContentPane().add(newImageWidth);
        newImageWidth.setBounds(90, 270, 110, 20);

        newImageheight.setEditable(false);
        getContentPane().add(newImageheight);
        newImageheight.setBounds(90, 300, 110, 20);

        okBtn.setFont(new java.awt.Font("Verdana", 1, 11));
        okBtn.setText("Ok");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        getContentPane().add(okBtn);
        okBtn.setBounds(60, 370, 70, 23);

        cancelBtn.setFont(new java.awt.Font("Verdana", 1, 11));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        getContentPane().add(cancelBtn);
        cancelBtn.setBounds(140, 370, 80, 23);

        applyBtn.setFont(new java.awt.Font("Verdana", 1, 11));
        applyBtn.setText("Apply");
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        getContentPane().add(applyBtn);
        applyBtn.setBounds(230, 370, 80, 23);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel8.setText("0.1 To 50");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(162, 160, 60, 20);

        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(30, 150, 190, 2);

        scaleY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleYActionPerformed(evt);
            }
        });

        getContentPane().add(scaleY);
        scaleY.setBounds(90, 190, 70, 20);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel9.setText("0.1 To 50");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(162, 190, 60, 20);

        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(30, 220, 190, 2);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel10.setText("ScaleX :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 162, 50, 14);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel11.setText("ScaleY :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 192, 50, 14);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-387)/2, (screenSize.height-448)/2, 387, 448);
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
// TODO add your handling code here:
      dispose();
    }//GEN-LAST:event_okBtnActionPerformed
    
    private void scaleYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleYActionPerformed
        scaleXActionPerformed(evt);
    }//GEN-LAST:event_scaleYActionPerformed
    
    private void scaleXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleXActionPerformed
        double scaleXValue=getScaleX();
        double scaleYValue=getScaleY();
        
        if(scaleXValue>=0.1 && scaleXValue<=50 && scaleYValue>=0.1 && scaleYValue<=50) {
            newWidth=originalWidth*scaleXValue;
            newHeight=originalHeight*scaleYValue;
            newImageWidth.setText(""+newWidth);
            newImageheight.setText(""+newHeight);
        } else
            JOptionPane.showConfirmDialog(this,"Enter value Between 0.1 To 50");
    }//GEN-LAST:event_scaleXActionPerformed
    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        
        dispose();
        
        
    }//GEN-LAST:event_cancelBtnActionPerformed
    
    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        
        //JOptionPane.showConfirmDialog(this,getScaleX());
        float scaleX=(float)getScaleX();
        float scaleY=(float)getScaleY();
        ImageProcessor imageProcessor=new ImageProcessor(planarImage);
        PlanarImage newPlanarImage=imageProcessor.scale(scaleX,scaleY);
        currentChildWindow.setCurrentPlanarImage(newPlanarImage);
        
        
    }//GEN-LAST:event_applyBtnActionPerformed
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
// TODO add your handling code here:
        
        
    }//GEN-LAST:event_formWindowGainedFocus
    
    public String getOrgImageWidth() {
        return orgImageWidth.getText();
    }
    
    public String getOrgImageHeight() {
        return orgImageHeight.getText();
    }
    
    public double getScaleX() {
        
        Double scaleValue= Double.parseDouble(scaleX.getText().trim());
        return scaleValue;
        
    }
    
    public double getScaleY() {
        
        Double scaleValue= Double.parseDouble(scaleY.getText().trim());
        return scaleValue;
        
    }
    
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
// TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setDefaultLookAndFeelDecorated(true);
                new ScaleImage().setVisible(true);
            }
        });
    }
    public void setChildWindow(ChildWindow currentChildWindow) {
        this.currentChildWindow=currentChildWindow;
        planarImage=currentChildWindow.getOriginalPlanarImage();
        originalWidth=planarImage.getWidth();
        originalHeight=planarImage.getHeight();
        orgImageWidth.setText(""+originalWidth);
        orgImageHeight.setText(""+originalHeight);
        scaleX.setText("1");
        scaleY.setText("1");
        
        //Set original Image
        originalImageLabel=new ImageControl();
        originalImageLabel.setPlanarImage(planarImage);
        originalImageLabel.setBounds(230,22,120,100);
        getContentPane().add(originalImageLabel);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField newImageWidth;
    private javax.swing.JTextField newImageheight;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextField orgImageHeight;
    private javax.swing.JTextField orgImageWidth;
    private javax.swing.JTextField scaleX;
    private javax.swing.JTextField scaleY;
    // End of variables declaration//GEN-END:variables
    
    
    
}