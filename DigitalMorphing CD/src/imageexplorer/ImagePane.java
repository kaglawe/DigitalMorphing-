package imageexplorer;

import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class ImagePane extends JScrollPane {
    private JTable table;
    private ImageTableModel imageTableModel;
    
    public ImagePane() {
        table=new JTable();
        imageTableModel=new ImageTableModel();
        table.setModel(imageTableModel);
        
        TableColumn column = table.getColumnModel ().getColumn (1);
       	ImageCellRenderer renderer = new ImageCellRenderer ();
	column.setCellRenderer (renderer);  
        setViewportView(table);
        
    }
    
    private BufferedImage getBufferedImage(File file)throws Exception {
        BufferedImage bufferedImage=null;
        try {
            bufferedImage = null;
            ParameterBlock pb = new ParameterBlock();
            pb.add(file.getPath());
            PlanarImage tempPlanarImage = JAI.create("fileload", pb);
            bufferedImage=tempPlanarImage.getAsBufferedImage();
        } catch(Exception e)
        {
            throw e;
        }
        return bufferedImage;
    }
    public void loadDirectory(String dirPath) {
        try {
            File dir=new File(dirPath);
            File fileList[]=dir.listFiles();
            for(int count=0;count<fileList.length;count++) {
                try {
                    BufferedImage bufferedImage=getBufferedImage(fileList[count]);
                    String imageSize=bufferedImage.getWidth()+" x "+bufferedImage.getHeight();
                    ImageTableRow  tableRow=new ImageTableRow(fileList[count].getName(),bufferedImage,imageSize,""+fileList[count].length()/1024.0);
                    imageTableModel.addRow(tableRow);
                } catch (Exception ex) {
                   
                }
                
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        setViewportView(table);
        
    }

    public void setRowHeight(int height) {
        table.setRowHeight(height);
    }
}
