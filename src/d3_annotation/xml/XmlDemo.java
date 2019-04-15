package d3_annotation.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XmlDemo {
    public static void main(String[] args) throws DocumentException {
        //创建SAXReader对象 将xml文件内容加载到内存中
        SAXReader saxReader = new SAXReader();
        //将数据读取到dom对象
        Document document = saxReader.read("src/d3_annotation/xml/books.xml");
        //获取跟标签，返回Element接口实现类对象
        Element element = document.getRootElement();
        //获取book标签对象
        List<Element> elements = element.elements();
        //遍历book标签数组
        for (Element book : elements) {
            //获取属性内容
            String author = book.attributeValue("author");
            //根据元素名称获取子元素的Element对象
            Element name = book.element("name");
            Element price = book.element("price");
            System.out.println(author + "---" + name .getText()+ "---" + price.getText());
        }

    }
}
