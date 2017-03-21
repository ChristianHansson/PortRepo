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

public class XmlCreaterNoErrors{

	/*public static void main(String [] args){
		XmlCreaterNoErrors xc = new XmlCreaterNoErrors();
		xc.createDocument();
		//System.out.println(xc.generateName());
	}*/
	public String generateName(){
		String tempName = "";
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
	    int n = alphabet.length();
	    Random rOne = new Random();

	    for (int i = 0; i < 18; i++) {
	    	tempName += alphabet.charAt(rOne.nextInt(n));
	    	if(i == 9){
	    		tempName += " ";
	    	}
	    }
		return tempName;
	}
	public String generateTele(){
		String tempTeleNummer = "";
		String nummer = "1234567890";
		int n = nummer.length();
		Random rTwo = new Random();
		
		for(int i = 0; i <10; i++){
			tempTeleNummer += nummer.charAt(rTwo.nextInt(n));
		}
		return tempTeleNummer;
	}
	public void createDocument(){
		String currentDir = System.getProperty("user.dir")+"/src/XmlCreators/";
		
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc2 = docBuilder.newDocument();
			
			Element leads = doc2.createElementNS("http://ws.wso2.org/dataservice","leads");
			doc2.appendChild(leads);
			
			for(int i = 0; i < 100; i++){
				String tempName = generateName();
				
				Element lead = doc2.createElement("lead");
						lead.setAttribute("id", Integer.toString(i));
							leads.appendChild(lead);
				
				Element name = doc2.createElement("name");
						name.appendChild(doc2.createTextNode(tempName));
							lead.appendChild(name);
				
				Element adress = doc2.createElement("address");
						adress.appendChild(doc2.createTextNode("Styrbordsgatan 987 b"));
							lead.appendChild(adress);
				
				Element zip = doc2.createElement("zip");
						zip.appendChild(doc2.createTextNode("54512"));
							lead.appendChild(zip);

				Element city = doc2.createElement("city");
						city.appendChild(doc2.createTextNode("London"));
							lead.appendChild(city);
				
				Element contact = doc2.createElement("contact");
						contact.appendChild(doc2.createTextNode(generateName()));
							lead.appendChild(contact);
				
				Element tele = doc2.createElement("tele");
						tele.appendChild(doc2.createTextNode(generateTele()));
							lead.appendChild(tele);
				
				Element size = doc2.createElement("size");
						size.appendChild(doc2.createTextNode("1"+i));
							lead.appendChild(size);
					
				Element currentProvider = doc2.createElement("current_provider");
						currentProvider.appendChild(doc2.createTextNode("Random firma"+i));
							lead.appendChild(currentProvider);
				
				Element mail = doc2.createElement("email");
						mail.appendChild(doc2.createTextNode(i+"forNamn"+"@"+"Domän.se"));
							lead.appendChild(mail);
			}
			
			//Skriver innehållet till en xml fil
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			//transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			//transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
			DOMSource source = new DOMSource(doc2);
			StreamResult result = new StreamResult(new File(currentDir+"FileNoError.xml"));
	 
			//Output för testing
			//StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("Xml without error created and saved! name: FileNoError.xml");
			
		}catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  	}
	}
}
