package com.lyf.base.design.create.simple;

/**
 * @author liyunfei
 **/
public class TvFactory {
    
    public static Tv createTv(String type){
        if("Haier".equalsIgnoreCase(type)){
            return new HaierTv();
        }else if("Huawei".equalsIgnoreCase(type)){
            HuaweiTv huaweiTv = new HuaweiTv();
            // 检查对象等工作。。。
            
            return huaweiTv;
        }else {
            throw new IllegalArgumentException("");
        //    return null;
        }
    }
}
