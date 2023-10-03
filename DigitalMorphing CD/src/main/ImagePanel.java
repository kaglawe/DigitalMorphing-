/*
 * ImagePanel.java
 *
 * Created on August 15, 2007, 11:28 AM
 */

package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.media.jai.PlanarImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator 
 */
public class ImagePanel extends javax.swing.JLabel implements MouseListener{
    
    private String imageFilename="";
    private PlanarImage planarImage;
   
    /** Creates new form ImagePanel */
    public ImagePanel() {
        //initComponents();
        
    }
    public ImagePanel(PlanarImage planarImage)
    {
        this.planarImage=planarImage;
        
    }
   public void setImage(PlanarImage planarImage)
    {
        this.planarImage=planarImage;
        setIcon(new ImageIcon(planarImage.getAsBufferedImage()));
       
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
  /*  public void paint(Graphics graphics)
    {
        //Drawing Transparent Grid
        final int boxSize=10;
        Graphics2D graphics2D=(Graphics2D)graphics;
        Dimension dimension=getSize();
        boolean colorFlag=true;
        for(int y=0;y<dimension.height;y+=boxSize)
        {
           
            boolean flag;
            flag=colorFlag;
            for(int x=0;x<dimension.width;x+=boxSize)
            {
                if(flag)
                {
                graphics2D.setColor(Color.WHITE);
                }
                else
                {
                graphics2D.setColor(Color.LIGHT_GRAY);
                }
                graphics2D.fillRect(x,y,boxSize,boxSize);
                flag=!flag;
            }
            colorFlag=!colorFlag;
            
        }
        //Drawing Image
        if(planarImage!=null)
        {
        AffineTransform afx=new AffineTransform();
        Dimension panelSize=getSize();
        int imageWidth=planarImage.getWidth();
        int imageHeight=planarImage.getHeight();
        graphics2D.translate((panelSize.width-imageWidth)/2.0,(panelSize.height-imageHeight)/2.0);
        graphics2D.drawRenderedImage(planarImage,afx);
        }     
    }
*/
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}