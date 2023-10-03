

package imageexplorer;

import java.awt.Component;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * Class implementing the renderrers for the cells in JTable.
 * @version 1.00  7 Feb 07
 * @author Administrator 
 *
 */
public class ImageCellRenderer implements TableCellRenderer
{
    /**Instance variables*/
    DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer ();

    private void configureRenderer (JLabel renderer, BufferedImage bufferedImage)
    {
	if ((bufferedImage != null))
	{
	    renderer.setIcon (new ImagePreviewIcon (bufferedImage));
            
	}
	else
	{
	    renderer.setIcon (null);
	}
    }

    /**
     * Returns the component used for drawing the cell.
     * @see javax.swing.TableCellRenderer
     */

    public Component getTableCellRendererComponent (JTable table, Object value,
	boolean isSelected, boolean hasFocus, int row, int column)
    {
	tableRenderer =
		(DefaultTableCellRenderer) tableRenderer
		    .getTableCellRendererComponent (table, null, isSelected,
			hasFocus, row, column);
	configureRenderer (tableRenderer, (BufferedImage) value);
	return tableRenderer;
    }
}

