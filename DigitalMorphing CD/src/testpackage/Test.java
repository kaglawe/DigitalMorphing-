/*
 * Test.java
 *
 * Created on January 26, 2008, 7:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package testpackage;

import java.io.File;

/**
 *
 * @author kamlesh paunikar
 */
public class Test {
    
    /** Creates a new instance of Test */
    public Test() {
    }
    public static void main(String arg[]) {
        String path1="c:\\smita";
        long size1=new Test().directorySize(new File(path1));
        System.out.println("Size1="+size1);
         String path2="c:\\smita1";
        long size2=new Test().directorySize(new File(path2));
        System.out.println("Size1="+size2);
        
    }
    public long directorySize(File dir) {
        
        long totalSize=0;
        if(dir.isFile()) {
            return dir.length();
        } else {
            if(dir.isDirectory()) {
                File files[]=dir.listFiles();
                
                for(int index=0;index<files.length;index++) {
                   totalSize+=directorySize(files[index]);
                }
            }
        }
        return totalSize;
    }
}
