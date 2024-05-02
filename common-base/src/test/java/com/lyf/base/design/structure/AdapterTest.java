package com.lyf.base.design.structure;

import com.lyf.base.design.structure.adapter.class_way.TargetRefClient;
import com.lyf.base.design.structure.adapter.obj_way.Target;
import com.lyf.base.design.structure.adapter.obj_way.TargetWrapper;
import com.sun.imageio.plugins.common.InputStreamAdapter;
import org.junit.Test;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @author liyunfei
 **/
public class AdapterTest {
    @Test
    public void test(){
        new TargetRefClient().run();
    }
    @Test
    public void test_2(){
        Target target = new TargetWrapper();
        target.targetMethod();
        target = new Target();
        target.targetMethod();
    }
    
    @Test
    public void test_Scenary() throws IOException {
        //Driver
        //DriverManager
    
        InputStreamAdapter inputStreamAdapter = new InputStreamAdapter(new FileImageInputStream(new File("")));
        //inputStreamAdapter.
        
        //#### Using a Custom Cache
        //
        //In addition to customizing the cache in these ways, you can also completely override the cache behavior by implementing
        // your own cache, or creating an adapter to other 3rd party caching solutions.
    }
}
