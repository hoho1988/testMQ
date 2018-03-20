import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.xml.sax.InputSource;


public class Test {
	public static void main(String[] args) throws Exception {
		String str = "<?xml version='1.0' encoding='UTF-8'?><note><to>Tove</to><from id='asd'>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body><names><name key='a'>aaa</name><name key='b'>bbb</name><name key='c'>ccc</name></names><haha>"
				+ "<![CDATA[<?xml version='1.0' encoding='UTF-8'?><s:yy><s:xx>hhhhhhh</s:xx></s:yy>]]></haha></note>";
		/*StringReader sr = new StringReader(str);   
		  
		InputSource is = new InputSource(sr);   
		  
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		  
		DocumentBuilder builder=factory.newDocumentBuilder();    
		  
		Document doc = builder.parse(is);*/
		
				  
		Document document = DocumentHelper.parseText(str); 
		Element root = document.getRootElement();
		Element element = root.element("names");
		
		List<Element> nodes = element.elements("name");  
        for (Element e : nodes) {
//        	if("a".equals(e.attributeValue("key")))
//			System.out.println(e.getText());
		}
        Element haha = root.element("haha");
        
        String hahastr = haha.getText().toString();
        System.out.println(hahastr+"==========================hahastr");
        Document documenthaha = DocumentHelper.parseText(hahastr);
        Element roothaha = documenthaha.getRootElement();
        Element elementhaha = roothaha.element("s:xx");
        
        System.out.println(elementhaha.getText());
        
		
	}
}
