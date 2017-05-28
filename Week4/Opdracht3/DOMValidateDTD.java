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
	private String port = "81";
	public static void main(String args[]) {
	
	try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("server.xml"));
        NodeList nodeList = document.getElementsByTagName("Connector");
        for(int x=0,size= nodeList.getLength(); x<size; x++) {
            System.out.println(nodeList.item(x).getAttributes().getNamedItem("port").getNodeValue());

           	System.out.println("Changing port to "+port+" and printing nodevalue again");
			nodeList.item(x).getAttributes().getNamedItem("port").setNodeValue(port);
           	System.out.println(nodeList.item(x).getAttributes().getNamedItem("port").getNodeValue());
        }
}catch(Exception e){
	System.out.println("doet het niet");
}
		

	}
}