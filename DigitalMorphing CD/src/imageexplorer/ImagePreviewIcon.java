

package imageexplorer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

/**
 * Class to handle the Preview thumbnail image icon in the table.
 * 
 * @version 10 Jan 2007
 * @author Administrator 
 */

public class ImagePreviewIcon implements Icon
{
    /** Class variables*/
    private BufferedImage bufferedImage;
    private int width;
    private int height;

    /**
     * Constructor. initializes the buffered image
     * @param theColor color of icon.
     */
    public ImagePreviewIcon (BufferedImage bufferedImage)
    {
	this.setBufferedImage(bufferedImage);
        width=height=64;
    }

    /**
     * Method to paint the icon.
     */
    public void paintIcon (Component c, Graphics g, int x, int y)
    {
	g.drawImage (getBufferedImage(), 0, 0, width, height, 0, 0, getBufferedImage()
	    .getWidth (), getBufferedImage().getHeight (), null);
    }

    public int getIconHeight ()
    {
	// need not to be implement
	return height;
    }

    public int getIconWidth ()
    {
	// need not to be implement
	return width;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public void setIconWidth(int width) {
        this.width = width;
    }


    public void setIconHeight(int height) {
        this.height = height;
    }
}
