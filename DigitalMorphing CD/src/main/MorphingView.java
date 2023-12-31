/*
 * MorphingView.java
 *
 * Created on October 6, 2007, 7:50 PM
 */

package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Vector;
import javax.media.jai.PlanarImage;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Adminstrator
 */
public class MorphingView extends javax.swing.JFrame implements Runnable {
    
    private String sourceFilePath;
    private ImagePanel imagePanel;
    private ImageProcessor imageProcessor;
    private PlanarImage originalPlanarImage,currentPlanarImage;
    private JPanel imageContainer;
    private Thread thread;
    private int checkRedio;
    private Vector filePath;
    private int playStatus=1;
    private int j=0;
    private FileCopy fileCopy;
    private ImageControl secondImageControl;
    private ImageControl firstImageControl;
    /** Creates new form MorphingView */
    public MorphingView() {
        initComponents();
        delayRadioBtn.setSelected(true);
        disableEnable();
        //Set Image Control
        firstImageControl=new ImageControl();
        firstImageControl.setBounds(80, 20, 400,400);
        getContentPane().add(firstImageControl);
        imageProcessor=new ImageProcessor();

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        stopBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();
        pauseBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        totalRadioBtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        delayTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        delayRadioBtn = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Morphing Viewer");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                window_Closed(evt);
            }
        });
        getContentPane().setLayout(null);

        stopBtn.setFont(new java.awt.Font("Verdana", 1, 10));
        stopBtn.setText("Stop");
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });
        getContentPane().add(stopBtn);
        stopBtn.setBounds(180, 510, 80, 23);

        playBtn.setFont(new java.awt.Font("Verdana", 1, 10));
        playBtn.setText("Play");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });
        getContentPane().add(playBtn);
        playBtn.setBounds(270, 510, 80, 23);

        pauseBtn.setFont(new java.awt.Font("Verdana", 1, 10));
        pauseBtn.setText("Pause");
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });
        getContentPane().add(pauseBtn);
        pauseBtn.setBounds(370, 510, 80, 23);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel1.setText("Total Time :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 460, 90, 15);
        getContentPane().add(totalTxt);
        totalTxt.setBounds(370, 460, 120, 20);

        buttonGroup1.add(totalRadioBtn);
        totalRadioBtn.setFont(new java.awt.Font("Verdana", 1, 11));
        totalRadioBtn.setText("Total Time ");
        totalRadioBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        totalRadioBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        totalRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalRadioBtnActionPerformed(evt);
            }
        });
        getContentPane().add(totalRadioBtn);
        totalRadioBtn.setBounds(360, 440, 110, 15);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel3.setText("ms");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 460, 19, 15);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel2.setText("Delay :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 460, 50, 20);
        getContentPane().add(delayTxt);
        delayTxt.setBounds(90, 460, 120, 20);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel4.setText("ms");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 460, 19, 15);

        buttonGroup1.add(delayRadioBtn);
        delayRadioBtn.setFont(new java.awt.Font("Verdana", 1, 11));
        delayRadioBtn.setText("Delay ");
        delayRadioBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        delayRadioBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        delayRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delayRadioBtnActionPerformed(evt);
            }
        });
        getContentPane().add(delayRadioBtn);
        delayRadioBtn.setBounds(110, 440, 70, 15);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(30, 430, 220, 10);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(30, 430, 2, 60);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(30, 490, 220, 10);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(250, 430, 10, 60);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(280, 430, 2, 60);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(280, 430, 240, 10);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(280, 490, 240, 10);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(520, 430, 2, 60);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-569)/2, (screenSize.height-618)/2, 569, 618);
    }// </editor-fold>//GEN-END:initComponents
    
    private void totalRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalRadioBtnActionPerformed
        totalTxt.setEditable(true);
        delayTxt.setEditable(false);
        delayTxt.setText("");
        checkRedio=2;
    }//GEN-LAST:event_totalRadioBtnActionPerformed
    
    private void delayRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delayRadioBtnActionPerformed
        disableEnable();
    }//GEN-LAST:event_delayRadioBtnActionPerformed
        
    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        try {
            thread=new Thread(this);
            thread.start();
            
        } catch (Exception ex) {
            System.out.println("error"+ex);
        }
        
        
        
    }//GEN-LAST:event_playBtnActionPerformed
    
    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed
        thread.stop();
        playStatus=2;
    }//GEN-LAST:event_pauseBtnActionPerformed
    
    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        thread.stop();
        playStatus=1;
    }//GEN-LAST:event_stopBtnActionPerformed
    
    private void window_Closed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_window_Closed
        this.filePath.removeAllElements();
        new FileCopy().deleteFiles("e:\\temp1");
        
        
    }//GEN-LAST:event_window_Closed
    
    public void showMorphingView(String filePath) {
   
        JAIImageReader reader=new JAIImageReader(filePath);
        PlanarImage planarImage=reader.getPlanarImage();
        firstImageControl.setPlanarImage(planarImage);
        firstImageControl.refresh();
    
    }
    
    
    private void disableEnable() {
        totalTxt.setEditable(false);
        totalTxt.setText("");
        delayTxt.setEditable(true);
        checkRedio=1;
    }
    
    private int checkDelay_TotalTime() {
        
        if(checkRedio==1) {
            return Integer.parseInt(delayTxt.getText());
        }
        if(checkRedio==2) {
            int time= Integer.parseInt(totalTxt.getText());
            time=time/filePath.size();
            return time;
        }
        return 0;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MorphingView().setVisible(true);
                JFrame.setDefaultLookAndFeelDecorated(true);
            }
            
            
           
        });
    }
    
    public void run() {
        
        if(playStatus==1) {
            for(int i=1;i<filePath.size();i++) {
                showMorphingView((String) filePath.elementAt(i));
                j=i;
                try {
                    Thread.sleep(checkDelay_TotalTime());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
        }
        
        if(playStatus==2) {
            for(int i=j;i<filePath.size();i++) {
                showMorphingView((String) filePath.elementAt(i));
                j=i;
                try {
                    Thread.sleep(checkDelay_TotalTime());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void setFilePath(Vector filePath) {
        this.filePath = filePath;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton delayRadioBtn;
    private javax.swing.JTextField delayTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JButton playBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JRadioButton totalRadioBtn;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables
    
}
