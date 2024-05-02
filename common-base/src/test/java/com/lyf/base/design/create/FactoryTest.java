package com.lyf.base.design.create;

import com.lyf.base.design.create.factory.AbstractTvFactory;
import com.lyf.base.design.create.factory.HaierTvFactory;
import com.lyf.base.design.create.simple.Tv;
import com.lyf.base.design.create.simple.TvFactory;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.DocumentBuilderFactory;
import java.security.NoSuchAlgorithmException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 * @author liyunfei
 **/
public class FactoryTest {
    
    @Test
    public void testSimple(){
        Tv haier = TvFactory.createTv("Haier");
        haier.play();
        TvFactory.createTv("huawei").play();
    }
    
    @Test
    public void testJdk(){
        /**
         * 静态工厂 + 适配器
         *     private static DateFormat get(LocaleProviderAdapter adapter, int timeStyle, int dateStyle, Locale loc) {
         *         DateFormatProvider provider = adapter.getDateFormatProvider();
         *         DateFormat dateFormat;
         *         if (timeStyle == -1) {
         *             dateFormat = provider.getDateInstance(dateStyle, loc);
         *         } else {
         *             if (dateStyle == -1) {
         *                 dateFormat = provider.getTimeInstance(timeStyle, loc);
         *             } else {
         *                 dateFormat = provider.getDateTimeInstance(dateStyle, timeStyle, loc);
         *             }
         *         }
         *         return dateFormat;
         *     }
         */
        
        // 父类中采用静态方法 --，DocumentBuilderFactory 对比
        DateFormat dateInstance = DateFormat.getDateInstance();
        String format = dateInstance.format(new Date());
        System.out.println(format);
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DESede");
            Cipher cipher = Cipher.getInstance("DESede");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    
    }
    
    @Test
    public void testFactory(){
        AbstractTvFactory factory = new HaierTvFactory();
        factory.create().play();
    }
    
    @Test
    public void testJDKFactory(){
        //   Iterator<T> iterator(); 工厂方法
        Collection collection = new HashSet();
        collection.iterator();
        
        // JDBC的executeQuery 返回结果集
        //Statement
        // TransactionFactory
    }
    
}
