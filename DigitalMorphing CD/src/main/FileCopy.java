/*

This program is used to copy one file to another file.
 */
package main;
import java.io.*;
import java.io.File;

class FileCopy {
    public final static int SUCCESS=0;
    public final static int SOURCEERROR=1;
    public final static int TARGETERROR=2;
    public final static int PERMISSIONDENIED=3;
    private String source,target;
    
    
        /*
        Default constructor to initialize
        member variables.
         */
    public FileCopy() {
        source="";
        target="";
    }
    
        /*
        Parameterized constructor to initialize
        source and target variables
         */
    public FileCopy(String s,String t) {
        source=s;
        target=t;
    }
    
        /*
        method to copy one file into another
         */
    public int fileCopy(String source,String target) {
        File sourceFile=new File(source);
        if(!sourceFile.exists())
            return SOURCEERROR;
        File targetFile=new File(target);
        if(!targetFile.exists())
            return TARGETERROR;
        
        try {
            long size;
            final int b=4096;
            
            InputStream input=new FileInputStream(source);
            size=new File(source).length();
            
            long n=size;
            
            long a;
            a=n/b;
            int n1=(int)(n%b);
            OutputStream output=new FileOutputStream(target);
            for(long i=0;i<a;i++) {
                
                byte buf[]=new byte[b];
                input.read(buf);
                output.write(buf);
                
            }
            byte buff[]=new byte[n1];
            input.read(buff);
            output.write(buff);
        } catch(Exception e) {
            System.out.println(e);
        }
        return SUCCESS;
    }
    
    /*
     *Generalize method to copy file or folder.
     *
     */
    public int copy() {
        //Check whether the source is of Filepath or Directorypath
        File checkSource=new File(source);
        if(checkSource.isFile()) {
            return fileCopy(source,target);
        }
        
        
        if(checkSource.isDirectory()) {
            File temp=new File(source);
            
            
            new File(target+"\\"+temp.getName()).mkdir();
            
            
            return copyList(source,target+"\\"+temp.getName());
        }
        
        
        return 0;
    }
    
    public int copyList(String sourcePath,String targetPath) { 
        
        File file=new File(sourcePath);
        
        String list[]=file.list();
        for(int i=0;i<list.length;i++) {
            String filepath=sourcePath+"\\"+list[i];
            File temp=new File(filepath);
            if(temp.isFile())
                
            {
                
                fileCopy(filepath,targetPath+"\\"+list[i]);
            }
            if(temp.isDirectory())
                
            {
                new File(targetPath+"\\"+list[i]).mkdir();
                copyList(filepath,targetPath+"\\"+list[i]);
            }
            
        }
        return 0;
    }                       

    public  void deleteFiles(String sourcePath) {
        try {
            File file=new File(sourcePath);
            String list[]=file.list();
            int i=1;
           while(true) {
                File sourceFile=new File(sourcePath+"\\"+list[i]);
                if(sourceFile.exists())
                    sourceFile.delete();
                else
                    break;
                i++;
            }
        } catch(Exception ex) {
        }
      }
 
    }
