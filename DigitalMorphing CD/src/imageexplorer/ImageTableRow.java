/*
 * ImageTableRow.java
 *
 * Created on 5 October 2007
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package imageexplorer;

import java.awt.image.BufferedImage;

/**
 *
 * @author Administrator
 */
public class ImageTableRow {
    
    private String fileName;
    
    private BufferedImage bufferedImage;
    
    private String imageSize;
    
    private String fileSize;
    
    /** Creates a new instance of MyTableRow */
    public ImageTableRow(String fileName,BufferedImage bufferedImage,String imageSize,String fileSize) {
        this.fileName=fileName;
        this.bufferedImage=bufferedImage;
        this.setImageSize(imageSize);
        this.setFileSize(fileSize);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String size) {
        this.imageSize = size;
    }

    public String getFileSize() {
        return fileSize;
    }
    public void setFileSize(String fileSize) {
        this.fileSize=fileSize;
    }

    public void setFilename(String fileName) {
        this.fileName=fileName;
    }
     public String getFilename() {
       return this.fileName;
    }
}

