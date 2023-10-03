/*
 * JAIImageReader.java
 *
 * Created on August 16, 2007, 9:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Admin
 */
public class JAIImageReader {
    
    private String fileName;
    private PlanarImage planarImage;
    private BufferedImage bufferedImage;
    
    /** Creates a new instance of JAIImageReader */
    
    public JAIImageReader(String fileName) {
      
        this.setFileName(fileName);
        setPlanarImage(JAI.create("fileload",fileName));
      
    }
    public BufferedImage getBufferedImage() {
        bufferedImage=getPlanarImage().getAsBufferedImage();
        return bufferedImage;
    }
    public BufferedImage getBufferedImage(Rectangle rectangle) {
        setBufferedImage(getPlanarImage().getAsBufferedImage(rectangle,getPlanarImage().getColorModel()));
        return getBufferedImage();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public PlanarImage getPlanarImage() {
        return planarImage;
    }

    public void setPlanarImage(PlanarImage planarImage) {
        this.planarImage = planarImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
