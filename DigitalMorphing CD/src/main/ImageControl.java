/*
 * ImageControl.java
 *
 * Created on August 28, 2007, 7:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.media.jai.PlanarImage;
import javax.swing.JPanel;

public class ImageControl extends JPanel{
    
    private PlanarImage planarImage;
    /** Creates a new instance of ImageControl */
    public ImageControl()
    {
        
    }
    public void setPlanarImage(PlanarImage planarImage) {
        this.planarImage=planarImage;
    }
    public void refresh()
    {
        repaint();
    }
    public void paint(Graphics graphics)
    {
        Graphics2D graphics2D=(Graphics2D)graphics;
        Dimension dimension=getSize();
        if(planarImage!=null)
        {
        graphics2D.drawImage(planarImage.getAsBufferedImage(),0,0,dimension.width,dimension.height,null);
        }
    }
}
