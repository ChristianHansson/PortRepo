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

public class XmlCreaterCorruptPhone {
	/*public static void main(String [] args){
		XmlCreaterCorruptPhoneError xc = new XmlCreaterCorruptPhoneError();
		xc.createDocument();
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
	
	public String generateTeleNoError(){
		String tempTeleNummer = "";
		String nummer = "1234567890";
		int n = nummer.length();
		Random rTwo = new Random();
		
		for(int i = 0; i <21; i++){
			if(i == 0){
				tempTeleNummer += "+(46)";
			}
			else{
				if(i == 3){
					tempTeleNummer += "-";
				}else{
					if(i == 7){
						tempTeleNummer += " ";
					}else{						
						tempTeleNummer += nummer.charAt(rTwo.nextInt(n));
					}
				}
			}
		}
		return tempTeleNummer;
	}
	public String generateTeleWithLetters(){
		String tempTeleNummer = "";
		String nummer = "1234567890ABCDEFGHIJKLMNOPQRSTUVXYZÅÄÖ";
		int n = nummer.length();
		Random rTwo = new Random();
		
		for(int i = 0; i <21; i++){
			if(i == 0){
				tempTeleNummer += "+(46)";
			}
			else{			
				if(i == 3){
					tempTeleNummer += "-";
				}else{
					if(i == 7){
						tempTeleNummer += " ";
					}else{					
						tempTeleNummer += nummer.charAt(rTwo.nextInt(n));
					}
				}
			}
		}
		return tempTeleNummer;
	}
	public String generateTeleWithIlleagalSymbols(){
		String tempTeleNummer = "";
		String nummer = "1234567890<|>!\"#¤%&/()=?`´*¨^~";
		int n = nummer.length();
		Random rTwo = new Random();
		
		for(int i = 0; i <21; i++){
			if(i == 0){
				tempTeleNummer += "+(46)";
			}
			else{			
				if(i == 3){
					tempTeleNummer += "-";
				}else{
					if(i == 7){
						tempTeleNummer += " ";
					}else{					
						tempTeleNummer += nummer.charAt(rTwo.nextInt(n));
					}
				}
			}
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
				
							Random r = new Random();
							int randomTal = r.nextInt(3);
							int talToCompare1 = 1, talToCompare2 = 2 ;
				Element tele = doc2.createElement("tele");
					if(talToCompare1 == randomTal){
						tele.appendChild(doc2.createTextNode(generateTeleWithLetters()));
					}else{
						if(talToCompare2 == randomTal){
							tele.appendChild(doc2.createTextNode(generateTeleWithIlleagalSymbols()));
						}else{							
							tele.appendChild(doc2.createTextNode(generateTeleNoError()));	
						}
					}
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
			StreamResult result = new StreamResult(new File(currentDir+"FileCorruptPhone.xml"));
	 
			//Output för testing
			//StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("Xml corrupt with only phone error created and saved! name: FileCorruptPhone.xml");			
		}catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  	}
	}
}
/*
 * 			System.out.println("Xml corrupt with only phone error created and saved! name: FileCorruptPhoneError.xml");

 * 
 * 
 * */
