package com.lyf.base.design.structure;

import com.lyf.base.design.structure.composite.File;
import com.lyf.base.design.structure.composite.Folder;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class CompositeTest {
    
    @Test
    public void test_1(){
        Folder parentFolder = new Folder("parent-folder");
        Folder folder1 = new Folder("folder-1");
        Folder folder2 = new Folder("folder-2");
    
        File file1 = new File("file-1");
        File file2 = new File("file-2");
        File file3 = new File("file-3");
        
        folder1.add(file1);
        folder1.add(file2);
        
        // ----xx.xx----
        
        folder2.add(file3);
        
        parentFolder.add(folder1);
        parentFolder.add(folder2);
        
        parentFolder.display();
    }
}
