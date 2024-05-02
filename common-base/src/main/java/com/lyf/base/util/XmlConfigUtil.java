package com.lyf.base.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author liyunfei
 **/
public class XmlConfigUtil {
    
    //private final static DocumentBuilderFactory FACTORY = DocumentBuilderFactory.newInstance();
    
    private static Document DOCUMENT;
//
//    static {
//        try {
//            DocumentBuilder documentBuilder = FACTORY.newDocumentBuilder();
//            DOCUMENT = documentBuilder.parse("config.xml");
//        } catch (ParserConfigurationException | IOException | SAXException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
    public static String getTvBrandName() {
        NodeList brandName = DOCUMENT.getElementsByTagName("brandName");
        Node firstChild = brandName.item(0).getFirstChild();
        return firstChild.getNodeValue().trim();
    }
    
    public static Object getBean(String className) {
      
        try {
            DocumentBuilderFactory FACTORY = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = FACTORY.newDocumentBuilder();
            DOCUMENT = documentBuilder.parse("config.xml");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        NodeList factory = DOCUMENT.getElementsByTagName("factory");
        Node firstChild = factory.item(0);//.getFirstChild();
        
        return firstChild.getNodeValue().trim();
    }
    
    
}
