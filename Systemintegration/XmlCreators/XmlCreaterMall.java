package XmlCreators;

import java.io.File;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 


import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlCreaterMall {

	/*public static void main(String [] args){
		XmlCreaterMall xc = new XmlCreaterMall();
		xc.createDocument();
	}*/
	public void createDocument(){
		String currentDir = System.getProperty("user.dir")+"/src/XmlCreators/";
		
		try{
			Random r = new Random();
			int randomTal,randomTalToCompare;
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			
			Element leads = doc.createElementNS("http://ws.wso2.org/dataservice","leads");
			doc.appendChild(leads);
			
			for(int i = 0; i < 100; i++){
				randomTal = r.nextInt(5);
				randomTalToCompare = 1;
				
				Element lead = doc.createElement("lead");
				lead.setAttribute("id", Integer.toString(i));
				leads.appendChild(lead);
				
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode("James Bond"));
				lead.appendChild(name);
				
				Element adress = doc.createElement("address");
				adress.appendChild(doc.createTextNode("Styrbordsgatan 987 b"));
				lead.appendChild(adress);
				
				Element zip = doc.createElement("zip");
				zip.appendChild(doc.createTextNode("54512"));
				lead.appendChild(zip);

				Element city = doc.createElement("city");
				city.appendChild(doc.createTextNode("London"));
				lead.appendChild(city);
				
				Element contact = doc.createElement("contact");
				contact.appendChild(doc.createTextNode("James Bond"));	
				lead.appendChild(contact);
				
				Element tele = doc.createElement("tele");
				tele.appendChild(doc.createTextNode("010001100"));
				lead.appendChild(tele);
				
				Element size = doc.createElement("size");
				size.appendChild(doc.createTextNode("250"));
				lead.appendChild(size);
				
				Element currentProvider = doc.createElement("current_provider");
				currentProvider.appendChild(doc.createTextNode("nån skitfirma"));
				lead.appendChild(currentProvider);
				
				Element mail = doc.createElement("email");
				mail.appendChild(doc.createTextNode(i+"forNamn"+"@"+"Domän.se"));
				lead.appendChild(mail);
			}
			
			//Skriver innehållet till en xml fil
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			//transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			//transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(currentDir+"FileMall.xml"));
	 
			// Output för testing
			//StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
			
		}catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  	}
	}
}
