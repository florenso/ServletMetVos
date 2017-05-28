

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FilenameFilter;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class CreateDomXml {
	public static void main(String[] args) {


		String p1 = "";
		String p2 = "";
		try {
		
		 File f = new File("C:/Users/matth/Desktop/ServletMetVos/Week4/Opdracht1/src");

    FilenameFilter textFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".txt");
        }
    };

    File[] files = f.listFiles(textFilter);
    for (File file : files) {
       
    
    	}
    		
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			Element root = doc.createElement("trekking");
			root.setAttribute("jaar","2011");
			// all it to the xml tree
			doc.appendChild(root);

			// create child element
			

			//Voeg verschillende kinderen toe
			for  (File file : files){
				 if (file.isDirectory()) {
            System.out.print("directory:");
        } else {
        	String s = file.getName();
        	String[] parts = s.split("_");
        	p1 = parts[0];
        	p2 = parts[1];
        	p2 = p2.substring(0, p2.lastIndexOf('.'));
        }

        	Element e = doc.createElement("lijstje");
			root.appendChild(e);



			Element child = doc.createElement("naam");
			Text tn = doc.createTextNode(""+p1);
			child.appendChild(tn);
			e.appendChild(child);

			 String line;
			try (
 	  			InputStream fis = new FileInputStream(file);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader br = new BufferedReader(isr);
		) {
 	    while ((line = br.readLine()) != null) {
 	    	child = doc.createElement("kado");
			
			tn = doc.createTextNode(line);
			child.appendChild(tn);
			e.appendChild(child);
  		  }
		}
			
}
			TransformerFactory tf = TransformerFactory.newInstance();

			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
					"3");

			DOMSource ds = new DOMSource(doc);
			Result dest1 = new StreamResult(System.out);
			Result dest = new StreamResult(new File("verlanglijstjes.xml"));
			t.transform(ds, dest);
			t.transform(ds, dest1);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}