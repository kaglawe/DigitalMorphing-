/*
 * WindowList.java
 *
 * Created on August 19, 2007, 6:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package main;

import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class WindowList {
    
    /** Creates a new instance of WindowList */
    private Vector windowList;
  
    public WindowList() {
        windowList=new Vector();
       
    }
    public void addWindow(JFrame childFrame)
    {
       if(windowList!=null)
       {
            windowList.addElement(childFrame);
           
       }
    }
    public JFrame getCurrentFrame()
    {
        if(windowList!=null)
        {
            for(int i=0;i<windowList.size();i++)
            {
                ChildWindow childWindow=(ChildWindow)windowList.elementAt(i);
            
                if(childWindow.isActive())
                    return childWindow;
            }
        }
        return null;
    }
  
    public Vector getFileList()
    {
        Vector vector=new Vector();
          if(windowList!=null)
        {
            for(int i=0;i<windowList.size();i++)
            {
                ChildWindow childWindow=(ChildWindow)windowList.elementAt(i);
            
               vector.addElement(childWindow.getSourceFilePath());
            }
        }
        return vector;
    }
    
    public void disposeWindow(JFrame frame)
    {
        if(windowList!=null)
        {
            for(int i=0;i<windowList.size();i++)
            {
                JFrame childWindow=(ChildWindow)windowList.elementAt(i);
                if(childWindow==frame)
                {
                    childWindow.dispose();
                    windowList.remove(childWindow);
                    break;
                }
            }
        }
    }
    
}
