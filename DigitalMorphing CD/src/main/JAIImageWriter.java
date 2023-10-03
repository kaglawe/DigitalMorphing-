/*
 * JAIImageWriter.java
 *
 * Created on August 24, 2007, 6:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package main;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Administrator
 */
public class JAIImageWriter {
    
    
    public static PlanarImage saveAs(PlanarImage sourceImage,String targetFileName,String extension) {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(sourceImage);
        pb.add(targetFileName+"."+extension);
        pb.add(extension);
        pb.add(null);
        pb.add(true);
        return JAI.create("filestore", pb, null);

    }
    
    
    
}
