import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;


public class Test2 {
	public static void main(String[] args) throws Exception {
		String str = "<report   xmlns='http://www.eclipse.org/birt/2005/design' version='3.2.15' id='1'><list-property name='cssStyleSheets'><structure><property name='fileName'>D: eport.css</property></structure></list-property></report>";
		
		
//		Namespace   senv   =   Namespace.get(   "SOAP-ENV ",   "http://schemas.xmlsoap.org/soap/envelope/ "); 
//		Namespace   trns   =   Namespace.get( "http://10.1.2.122/misc/dsmp.xsd ");
		
        Document document = DocumentHelper.parseText(str);
        Element e = document.getRootElement();
        e.addNamespace("design","http://www.eclipse.org/birt/2005/design");
        List tmp = document.selectNodes("//design:list-property");
        System.out.println(tmp.size());
	}
}
