/*
 * ImageProcessor.java
 *
 * Created on August 18, 2007, 9:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package main;

import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.util.Vector;
import javax.media.jai.InterpolationBilinear;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.WritableRenderedImageAdapter;
import javax.media.jai.operator.ShearDescriptor;

/**
 *
 * @author Administrator
 */
public class ImageProcessor implements  Runnable {
    public Thread thread;
    private PlanarImage planarImage;
    private JAIImageReader sourceReader;
    private  JAIImageReader targetReader;
    private ProgressBar progressBar;
    private int steps;
    private String targetFolder;
    public Vector filePath;
    private File file;
    /** Creates a new instance of ImageProcessor */
    public ImageProcessor() {
        filePath=new Vector();
    }
    public ImageProcessor(PlanarImage planarImage) {
        this.planarImage=planarImage;
    }
    public void setImage(PlanarImage planarImage) {
        this.planarImage=planarImage;
        
    }
    public void threadActive() {
        thread.start();
    }
    
    public PlanarImage greenEffect(int value) {
        BufferedImage bufferedImage=planarImage.getAsBufferedImage();
        int width=bufferedImage.getWidth();
        int height=bufferedImage.getHeight();
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                int rgb=bufferedImage.getRGB(x,y);
                int green= rgb&0x0000ff00;
                green=green>>8;
                green=(int)(green*value/100.0);
                green=green<<8;
                int newrgb=(0xff000000)|green;
                bufferedImage.setRGB(x,y,newrgb);
            }
        }
        // Convert the BufferedImage to a PlanarImage.
        WritableRenderedImageAdapter adapter =
                new WritableRenderedImageAdapter(bufferedImage);
        
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(adapter);
        pb.add(bufferedImage.getSampleModel().getDataType());
        
        return JAI.create( "format", pb );
    }
    public PlanarImage redEffect(int value) {
        BufferedImage bufferedImage=planarImage.getAsBufferedImage();
        int width=bufferedImage.getWidth();
        int height=bufferedImage.getHeight();
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                int rgb=bufferedImage.getRGB(x,y);
                int red=rgb&0x00ff0000;
                red=red>>16;
                red=(int)(red*value/100.0);
                red=red<<16;
                int newrgb=(0xff000000)|red;
                bufferedImage.setRGB(x,y,newrgb);
            }
        }
        // Convert the BufferedImage to a PlanarImage.
        WritableRenderedImageAdapter adapter =
                new WritableRenderedImageAdapter(bufferedImage);
        
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(adapter);
        pb.add(bufferedImage.getSampleModel().getDataType());
        
        return JAI.create( "format", pb );
    }
    public PlanarImage grayEffect() {
        BufferedImage bufferedImage=planarImage.getAsBufferedImage();
        int width=bufferedImage.getWidth();
        int height=bufferedImage.getHeight();
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                int rgb=bufferedImage.getRGB(x,y);
                int red=(rgb>>16)&0xff;
                
                int green=(rgb>>8)&0xff;
                
                int blue=(rgb&0xff);
                
                int grayValue=(int)(red*0.10+green*0.3+blue*0.6);
                
                int newrgb=0xff000000|(grayValue<<16)|(grayValue<<8)|(grayValue);
                
                bufferedImage.setRGB(x,y,newrgb);
                
            }
        }
        // Convert the BufferedImage to a PlanarImage.
        WritableRenderedImageAdapter adapter =
                new WritableRenderedImageAdapter(bufferedImage);
        
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(adapter);
        pb.add(bufferedImage.getSampleModel().getDataType());
        
        return JAI.create( "format", pb );
    }
    
    public PlanarImage blueEffect(int value) {
        BufferedImage bufferedImage=planarImage.getAsBufferedImage();
        int width=bufferedImage.getWidth();
        int height=bufferedImage.getHeight();
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                int rgb=bufferedImage.getRGB(x,y);
                int blue=rgb&0x000000ff;
                blue=(int)(blue*value/100.0);
                int newrgb=0xff000000|blue;
                bufferedImage.setRGB(x,y,newrgb);
            }
        }
        // Convert the BufferedImage to a PlanarImage.
        WritableRenderedImageAdapter adapter =
                new WritableRenderedImageAdapter(bufferedImage);
        
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(adapter);
        pb.add(bufferedImage.getSampleModel().getDataType());
        
        return JAI.create( "format", pb );
    }
    PlanarImage scale(float scaleX,float scaleY) {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add(scaleX);
        pb.add(scaleY);
        
        return JAI.create( "scale", pb );
    }
    private int changeMorphPixel(int value1,int value2,int nStep,int steps) {
        int result=0;
        
        int red1=(value1&0x00ff0000)>>16;
        int red2=(value2&0x00ff0000)>>16;
        int red3=changeMorphValue(red1,red2,nStep,steps);
        
        int green1=(value1&0x0000ff00)>>8;
        int green2=(value2&0x0000ff00)>>8;
        int green3=changeMorphValue(green1,green2,nStep,steps);
        
        int blue1=(value1&0x000000ff);
        int blue2=(value2&0x000000ff);
        int blue3=changeMorphValue(blue1,blue2,nStep,steps);
        
        result=(0xff000000)|(red3<<16)|(green3<<8)|(blue3);
        return result;
    }
    private int changeMorphValue(int band1,int band2,int nStep,int steps) {
        int result=-1;
        double diff=(band2-band1)/(steps*1.0);
        diff=(diff*nStep);
        result=(int)(band1+diff);
        result=result%256;
        return result;
    }
    private PlanarImage createMorphImage(PlanarImage source,PlanarImage target,int nStep,int steps) {
        BufferedImage sourceBuffer=source.getAsBufferedImage();
        BufferedImage targetBuffer=target.getAsBufferedImage();
        BufferedImage resultBuffer=new  BufferedImage(sourceBuffer.getWidth(),sourceBuffer.getHeight(),sourceBuffer.getType());
        int width=sourceBuffer.getWidth();
        int height=sourceBuffer.getHeight();
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                int pixel1=sourceBuffer.getRGB(x,y);
                int pixel2=targetBuffer.getRGB(x,y);
                int pixel3=changeMorphPixel(pixel1,pixel2,nStep,steps);
                resultBuffer.setRGB(x,y,pixel3);
            }
        }
        
        // Convert the BufferedImage to a PlanarImage.
        WritableRenderedImageAdapter adapter =
                new WritableRenderedImageAdapter(resultBuffer);
        
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(adapter);
        pb.add(resultBuffer.getSampleModel().getDataType());
        
        return JAI.create( "format", pb );
    }
    
    
    public void createMorphFiles(String sourceImage,String targetImage,String targetFolder,int steps,ProgressBar progressBar) {
        this.sourceReader=new JAIImageReader(sourceImage);
        this.targetReader=new JAIImageReader(targetImage);
        this.targetFolder=targetFolder;
        this.steps=steps;
        this.progressBar=progressBar;
        file=new File(this.targetFolder);
        System.out.println(file.mkdir());
        thread=new Thread(this);
        thread.start();
        
    }
    
    
    public void run() {
        
        PlanarImage sourcePlanar=sourceReader.getPlanarImage();
        PlanarImage targetPlanar=targetReader.getPlanarImage();
        PlanarImage resultPlanar=sourcePlanar;
        int i;
        int ProgressBarStatus=0;
        for( i=1;i<=steps-1;i++) {
            JAIImageWriter writer=new JAIImageWriter();
            writer.saveAs(resultPlanar,file.getPath()+"\\temp"+i,"jpeg");
            filePath.addElement(file.getPath()+"\\temp"+i+".jpeg");
            ProgressBarStatus=(int)(100*(i+1))/steps;
            progressBar.setImageProgressBar(ProgressBarStatus);
            progressBar.setProgressBarStatus(ProgressBarStatus);
            resultPlanar=createMorphImage(sourcePlanar,targetPlanar,i,steps);
            try {
                thread.yield();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        JAIImageWriter writer=new JAIImageWriter();
        writer.saveAs(targetPlanar,file.getPath()+"\\temp"+i,"jpeg");
        filePath.addElement(file.getPath()+"\\temp"+i+".jpeg");
        progressBar.setVisible(false);
        if(ProgressBarStatus==100) {
            MorphingView morphingView=new MorphingView();
            morphingView.showMorphingView(""+filePath.elementAt(0));
            morphingView.setFilePath(filePath);
            morphingView.setVisible(true);
        }
    }
    
    public Vector getFilePath() {
        return filePath;
    }
    public void setFilePath(){
        this.filePath.removeAllElements();
    }
    
    public PlanarImage getPlanarImage() {
        return planarImage;
    }
    
    public PlanarImage smoothEffect(int smoothValue) {
        //set kernel size
        int kernelSize = smoothValue;
        // Create an array with enough positions for the kernel.
        float[] kernelMatrix = new float[kernelSize*kernelSize];
        // Fill the array with the data for the kernel. The sum of all array
        // positions will be 1.0.
        for(int k=0;k<kernelMatrix.length;k++)
            kernelMatrix[k] = 1.0f/(kernelSize*kernelSize);
        
        // Create the kernel using the array.
        KernelJAI kernel = new KernelJAI(kernelSize,kernelSize,kernelMatrix);
        // Run the convolve operator, creating the output image.
        PlanarImage output = JAI.create("convolve", planarImage, kernel);
        return output;
        
    }
    public PlanarImage rotate(float angle) {
        // Rotates the original image.
        angle=(float)(Math.toRadians((float)angle));
        float centerX=(float)(planarImage.getWidth()/2.0);
        float centerY=(float)(planarImage.getHeight()/2.0);
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add(centerX);
        pb.add(centerY);
        pb.add((float)angle);
        pb.add(new InterpolationBilinear());
        // Creates a new, rotated image and uses it on the DisplayJAI component
        PlanarImage rotatedImage = JAI.create("rotate", pb);
        return rotatedImage;
    }
    public PlanarImage shear(int direction,float shearing) {
        shearing=(float)Math.tan((Math.toRadians(shearing)));
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add((float)shearing);
        if (direction == 0) {
            pb.add(ShearDescriptor.SHEAR_HORIZONTAL);
        } else {
            pb.add(ShearDescriptor.SHEAR_VERTICAL);
        }
        pb.add(0.0F);
        pb.add(0.0F);
        pb.add(new InterpolationNearest());
        // Creates a new, sheared image and uses it on the DisplayJAI component
        PlanarImage shearedImage = JAI.create("shear", pb);
        return shearedImage;
    }
    
}
