
/*
 * ImageTableModel.java
 *
 * Created on 5 october 2007
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package imageexplorer;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrator 
 */
public class ImageTableModel implements TableModel{
    
   private final String columns[]={"File Name","Image Icon","Image Resolution (Pixels)","File Size (Kb)"};
    
    private ArrayList <ImageTableRow>rowList=new ArrayList<ImageTableRow>();
    /** Creates a new instance of MyTableModel */
    public ImageTableModel() {
    }

    public int getRowCount() {
        return rowList.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
     
        if(columnIndex==0)
        return String.class;
        if(columnIndex==1)
        return BufferedImage.class;
        if(columnIndex==2)
        return String.class;
         if(columnIndex==3)
        return String.class;
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        
        ImageTableRow tableRow=rowList.get(rowIndex);
        if(columnIndex==0)
            return tableRow.getFilename();
        if(columnIndex==1)
            return tableRow.getBufferedImage();
        if(columnIndex==2)
            return tableRow.getImageSize();
        if(columnIndex==3)
            return tableRow.getFileSize();
        return null;
        
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         ImageTableRow tableRow=rowList.get(rowIndex);
         if(columnIndex==0)
         tableRow.setFilename((String) aValue);
         if(columnIndex==1)
         tableRow.setBufferedImage((BufferedImage) aValue);
         if(columnIndex==2)
         tableRow.setImageSize((String) aValue);
         if(columnIndex==3)
         tableRow.setFileSize((String) aValue);
    }
    public void addRow(ImageTableRow row)
    {
        rowList.add(row);
    }
    public void addTableModelListener(TableModelListener l) {
    }

    public void removeTableModelListener(TableModelListener l) {
    }
    
}
