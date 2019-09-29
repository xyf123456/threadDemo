package com.bdqn.utils.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: {@link XmlParseDemo}
 * Description: TODO xml解析的案例
 * Author: xyf
 * Date 2019/9/29 9:22
 */
public class XmlParseDemo {

    /**
     * Description: TODO 解析XML文档
     * param: [uri]
     * return: org.w3c.dom.Document
     * Date: 2019/9/29 10:27
     */
    public Document parse(String uri) throws ParserConfigurationException, IOException, SAXException {
        //得到DOM解析器的工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //从DOM工厂获得DOM解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
//        解析XML文档，得到Document对象，即DOM树
//        document = db.parse("resources/phone.xml");
        Document document = db.parse(uri);
        System.out.println(document);
        System.out.println(document.getDoctype());
        System.out.println(document.getDocumentURI());
        System.out.println(document.getDocumentElement());
        return document;
    }


    /**
     * Description: TODO 展示XML的信息
     * param: [document]
     * return: void
     * Date: 2019/9/29 10:42
     */
    public void showXmlInfo(Document document,String tagName1,String tagName2) {
        //        得到所有的brand节点列表信息
       /* Element brandEle = document.getElementById("brand1");
        System.out.println(brandEle.getTagName());*/
//        NodeList brandList = document.getElementsByTagName("brand");
        NodeList brandList = document.getElementsByTagName(tagName1);
//        System.out.println(brandList.getLength());
//        遍历得到brand节点的信息
        for (int i = 0; i < brandList.getLength(); i++) {
            //            得到brand子节点的集合
            Node brand = brandList.item(i);
         /*   System.out.println(brand.getNodeName());
            System.out.println(brand.getNodeType());
            System.out.println(brand.getNodeValue());*/
            Element element = (Element) brand;
//            String attribute = element.getAttribute("name");
            String attribute = element.getAttribute(tagName2);
//            System.out.println(attribute);
//            得到type子节点的集合
            NodeList typeList = element.getChildNodes();
            for (int j = 0; j < typeList.getLength(); j++) {
                Node type = typeList.item(j);
                /*if (type instanceof Element) {
                    Element typeEle = (Element) type;
//                    String typeArr = typeEle.getAttribute("name");
                    String typeArr = typeEle.getAttribute(tagName2);
                    System.out.println("手机:" + attribute + typeArr);
                }*/
                if (type.getNodeType()==Node.ELEMENT_NODE){
                    Element typeEle = (Element) type;
//                    String typeArr = typeEle.getAttribute("name");
                    String typeArr = typeEle.getAttribute(tagName2);
                    System.out.println("手机:" + attribute + typeArr);
                }
            }
        }
    }

    public void addInfo(Document document){
        //添加操作
//        创建brand节点
        Element brandEle = document.createElement("brand");
        brandEle.setAttribute("name","MI");
//        创建brand子节点type
        Element typeEle=document.createElement("type");
        typeEle.setAttribute("name","MI10");
        typeEle.setAttribute("name","MI20");
        typeEle.setAttribute("name","MI30");
//        设置父子节点关系
        brandEle.appendChild(typeEle);//设置type元素节点为brand元素节点的子节点
//        得到文档的根元素phoneInfo节点
        //设置brand元素节点为phoneInfo元素节点的子节点
        Element phoneInfoEle= (Element) document.getElementsByTagName("phoneInfo").item(0);
//        Element phoneInfoEle=document.getDocumentElement();
        phoneInfoEle.appendChild(brandEle);
    }

    /**
     * Description: TODO 对修改完成的Document文档进行保存
     * param: [document, uri]
     * return: void
     * Date: 2019/9/29 11:36
     */
    public void save(Document document,String uri) throws TransformerException, FileNotFoundException {
//        保存XML文档
//        得到TransformerFactory对象
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
//        创建DOMSource对象
        DOMSource domSource = new DOMSource(document);
//        设置编码格式
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
//        StreamResult result = new StreamResult(new FileOutputStream("resources/phone.xml"));
        StreamResult result = new StreamResult(new FileOutputStream(uri));
//        把DOM树转换为XML文件
        transformer.transform(domSource,result);
    }

    /**
     * Description: TODO 更新某个属性
     * param: [document, tagName, attrName, attrValue]
     * return: void
     * Date: 2019/9/29 11:58
     */
    public void update(Document document,String tagName,String attrName,String attrValue1,String attrValue2,String uri) throws TransformerException, FileNotFoundException {
        NodeList brandList=document.getElementsByTagName(tagName);
        for (int i = 0; i <brandList.getLength() ; i++) {
             Node brand=brandList.item(i);
             if (brand.getNodeType()==Node.ELEMENT_NODE){
                 Element brandElement= (Element) brand;
                 String brandName=brandElement.getAttribute(attrName);
                 if (brandName.equals(attrValue1)){
                     brandElement.setAttribute(attrName,attrValue2);
                 }
             }
        }
        System.out.println("更新完成！");
        //保存操作
        this.save(document,uri);
    }

    /**
     * Description: TODO 删除某个节点
     * param: [document, tagName, attrName, attrValue1, uri]
     * return: void
     * Date: 2019/9/29 12:18
     */
    public void delete(Document document,String tagName,String attrName,String attrValue1,String uri) throws TransformerException, FileNotFoundException {
        NodeList brandList=document.getElementsByTagName(tagName);//brand
        for (int i = 0; i <brandList.getLength() ; i++) {
            Node brand=brandList.item(i);
            if (brand.getNodeType()==Node.ELEMENT_NODE){
                Element brandElement= (Element) brand;
                String brandName=brandElement.getAttribute(attrName);//属性
                if (brandName.equals(attrValue1)){
                   brandElement.getParentNode().removeChild(brandElement);//去掉brand节点
                }
            }
        }
        System.out.println("删除完成！");
        //保存操作
        this.save(document,uri);
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        XmlParseDemo xmlParseDemo = new XmlParseDemo();
        Document document = xmlParseDemo.parse("resources/phone.xml");
//        Document document1 = xmlParseDemo.parse("resources/phone1.xml");
        xmlParseDemo.showXmlInfo(document,"brand","name");
//        xmlParseDemo.showXmlInfo(document1,"brand","name");

//        xmlParseDemo.addInfo(document);

//     xmlParseDemo.save(document,"resources/phone.xml");

//       xmlParseDemo.update(document,"brand","name","MI","mi","resources/phone.xml");
        xmlParseDemo.delete(document,"brand","name","mi","resources/phone.xml");
    }
}
