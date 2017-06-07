package com.local.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by white on 17/6/7.
 */
public class XMLUtil {
    public static void run(){
        ClassLoader cl = XMLUtil.class.getClassLoader();
        URL resource = cl.getResource("book.xml");
        String path = resource.getPath();
        File xml = new File(path);//在resources目录下的文件被放入classpath
        System.out.println(xml.getAbsolutePath());
        SAXReader sax = new SAXReader();
        try {
            Document doc = sax.read(xml);
            Element root = doc.getRootElement();
            listNode(root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void listNode(Element node){
        System.out.println("node name: " + node.getName());
        List<Attribute> list = node.attributes();
        for(Attribute attr: list){
            System.out.println("node attr: " + attr.getName() + ":" + attr.getValue());
        }
        if (!(node.getTextTrim().equals(""))) {
            System.out.println("node text: " + node.getText());
        }
        Iterator<Element> it = node.elementIterator();
        while(it.hasNext()){
            Element e = it.next();
            listNode(e);
        }
    }

}
