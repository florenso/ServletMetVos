import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DOMValidateDTD {
	
	public static void main(String args[]) {
	
	try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("tomcat-users.xml"));
        NodeList nodeList = document.getElementsByTagName("tomcat-users");
        for(int x=0,size= nodeList.getLength(); x<size; x++) {
        	Element newuser = document.createElement("new-user");
        	newuser.setAttribute("password","test");
        	newuser.setAttribute("roles","manager-gui,admin-gui");
        	newuser.setAttribute("username","test");
            nodeList.item(x).appendChild(newuser);
        }
        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("tomcat-users.xml");
        transformer.transform(source, result);
}catch(Exception e){
	 System.out.println(e.getMessage());
}
		

	}
}