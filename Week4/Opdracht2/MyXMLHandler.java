import java.io.IOException;
import java.io.PrintWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.Writer;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class MyXMLHandler extends DefaultHandler {
	private PrintWriter writer;
	private Writer output;
	private String name = "";
	private boolean newlist = false;
	private boolean isName = false;
	private boolean isPresent = false;
	private int nspaties = 0;

	private void writeSpaces(int n) {
		for (int i = 0; i < n; i++)
			System.out.print(' ');
	}

	private void parseDocument(String bestand) {

		// Maak een parser factory (standaard)
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			// Maak een nieuwe parser
			SAXParser sp = spf.newSAXParser();
			// parse het bestand
			sp.parse(bestand, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Bij event: een startelement gevonden:
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("lijstje")) {
			newlist = true;
		}
		if (qName.equals("naam")) {
			isName = true;
		}
		if (qName.equals("kado")) {
			isPresent = true;
		}
		writeSpaces(nspaties);
		System.out.println("start: " + qName);
		if (attributes.getLength() > 0) {
			for (int i = 0; i < attributes.getLength(); i++) {
				writeSpaces(nspaties);
				System.out.println("   attr. " + attributes.getQName(i) + ": " + attributes.getValue(i));
			}
		}
		nspaties += 3;
	}

	// Bij event: character data gevonden
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch, start, length);
		if (!s.trim().equals("")) {

			writeSpaces(nspaties);
			if (isName == true) {
				name = s.trim();
				try {
					FileWriter file = new FileWriter(name + ".txt");
				} catch (Exception e) {
				}
				;
			}
			if (isPresent == true) {
				BufferedWriter out = null;

				try {
					FileWriter fstream = new FileWriter(name + ".txt", true); // true
																				// tells
																				// to
																				// append
																				// data.
					out = new BufferedWriter(fstream);
					out.write("\n" + s.trim());
					out.newLine();

				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				} finally {
					if (out != null)
						try {
							out.close();
						} catch (IOException ignore) {
						}
				}
				// System.out.println("chars: " + s.trim());
			}

		}
	}

	// Bij event: een sluitelement gevonden:
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("lijstje")) {
			newlist = false;
		}
		if (qName.equals("naam")) {
			isName = false;

		}
		if (qName.equals("kado")) {
			isPresent = false;
		}
		nspaties -= 3;
		writeSpaces(nspaties);
		System.out.println("end: " + qName);
	}

	public static void main(String[] args) {
		MyXMLHandler spe = new MyXMLHandler();
		// spe.runParsing("verlanglijstjes.xml");
		spe.parseDocument("verlanglijstjes.xml");
	}
}
