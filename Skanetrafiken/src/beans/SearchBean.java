package beans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class SearchBean {
	private String from, to;
	private ArrayList<String> fromLoc, toLoc;

	public ArrayList<String> getFromLoc() {
		if (fromLoc == null) {
			getTrip();
		}
		return fromLoc;
	}

	public ArrayList<String> getToLoc() {
		if (toLoc == null) {
			getTrip();
		}
		return toLoc;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	// Gets and sets the search results
	private void getTrip() {
		String URLtoSend = "http://www.labs.skanetrafiken.se/v2.2/querypage.asp?inpPointFr=" + from + "from&inpPointTo="
				+ to;
		try {
			URL line_api_url = new URL(URLtoSend);
			HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();

			linec.setDoInput(true);
			linec.setDoOutput(true);
			linec.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));
			String inputLine;
			String ApiResponse = "";
			while ((inputLine = in.readLine()) != null) {
				ApiResponse += inputLine;
			}
			in.close();

			Document doc = convertStringToXMLDocument(ApiResponse);
			doc.getDocumentElement().normalize();

			NodeList nListFrom = searchThrough(doc).item(2).getChildNodes();
			NodeList nListTo = searchThrough(doc).item(3).getChildNodes();

			this.fromLoc = generateArray(nListFrom);
			this.toLoc = generateArray(nListTo);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Returns a list of the results
	private ArrayList<String> generateArray(NodeList nodeList) {
		ArrayList<String> ArrayList = new ArrayList<String>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			NodeList nList = nodeList.item(i).getChildNodes();
			Node node = nList.item(1);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				ArrayList.add(eElement.getFirstChild().getNodeValue());
			}
		}
		return ArrayList;
	}

	// Converts strings to XML documents
	private Document convertStringToXMLDocument(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// Function to clean up the main code
	private NodeList searchThrough(Document doc) {
		return doc.getDocumentElement().getFirstChild().getFirstChild().getFirstChild().getChildNodes();
	}
}