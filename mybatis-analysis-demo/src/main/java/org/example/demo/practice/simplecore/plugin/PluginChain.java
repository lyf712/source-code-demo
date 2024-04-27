package org.example.demo.practice.simplecore.plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class PluginChain {
    
    private final List<Plugin> pluginList = new ArrayList<>();
    
    public Object proxyPlugin(Object target){
//        pluginList.forEach(plugin -> {
//            target = plugin.wrap(target);
//        });
        for(Plugin plugin:pluginList){
            target = plugin.wrap(target);
        }
        return target;
    }
    
    public void addPlugin(Plugin plugin){
        pluginList.add(plugin);
    }
    
}
