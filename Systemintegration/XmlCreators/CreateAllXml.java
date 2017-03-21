package XmlCreators;

public class CreateAllXml {
	public static void main(String [] args){
		XmlCreaterCorrupt corrupt = new XmlCreaterCorrupt();
		corrupt.createDocument();
		
		XmlCreaterCorruptEmail email = new XmlCreaterCorruptEmail();
		email.createDocument();
		
		XmlCreaterCorruptName name = new XmlCreaterCorruptName();
		name.createDocument();
		
		XmlCreaterCorruptPhone phone = new XmlCreaterCorruptPhone();
		phone.createDocument();
		
		XmlCreaterCorruptZip zip = new XmlCreaterCorruptZip();
		zip.createDocument();
		
		XmlCreaterWithError error = new XmlCreaterWithError();
		error.createDocument();
		
		XmlCreaterNoErrors noerror = new XmlCreaterNoErrors();
		noerror.createDocument();
		
		XmlCreateTenThousandLeads tenthousand = new XmlCreateTenThousandLeads();
		tenthousand.createDocument();
		
		XmlCreaterCorruptSqlAndJs sqlAndJs = new XmlCreaterCorruptSqlAndJs();
		sqlAndJs.createDocument();
	}
}
