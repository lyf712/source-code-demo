package com.lyf.base.design.create.factory;

import com.lyf.base.design.create.simple.HaierTv;
import com.lyf.base.design.create.simple.Tv;

/**
 * @author liyunfei
 **/
public class HaierTvFactory extends AbstractTvFactory{
    
    @Override
    public Tv create() {
        return new HaierTv();
    }
}
