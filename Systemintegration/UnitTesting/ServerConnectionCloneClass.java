package UnitTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class ServerConnectionCloneClass {
	
	/*
	 * The reason for this class is to send dummydata, similar to the response that
	 * we get from the server, into our application for testing purpose.
	 * */
	////////////////////////////////// DUMMYDATAFILES CREATED //////////////////////////////////////
	/**
	 * No error
	 * */
	public Document getXmlWithoutError(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyDataWithoutError())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyDataWithoutError() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileNoError.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Fetch xml with error
	 * */
	public Document getXmlWithError(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyDataWithError())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyDataWithError() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileWithError.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}	
//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Get the corrupt file. gives random corrupt values.
	 * */
	public Document getXmlCorrupt(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyCorrupt())));
		return doc;
		}catch(Exception e){
			
		}
		return null;

	}
	public String getDummyCorrupt() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileCorrupt.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Corrupt Email error
	 * */
	public Document getXmlCorruptEmail(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyDataCorruptEmail())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyDataCorruptEmail() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileCorruptEmailError.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Corrupt name error
	 * */
	public Document getXmlCorruptName(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyDataCorruptName())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyDataCorruptName() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileCorruptName.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Corrupt phone error
	 * */
	public Document getXmlCorruptPhone(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyDataCorruptPhone())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyDataCorruptPhone() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileCorruptPhone.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Corrupt zip error
	 * */
	public Document getXmlCorruptZip(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyDataCorruptZip())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyDataCorruptZip() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileCorruptZipError.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 10 000 leads
	 * */
	public Document getXmlTenThousand(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyDataTenThousand())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyDataTenThousand() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileNoErrorTenThousand.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Email has three duplicates in this file.
	 * */
	public Document getXmlWithDuplicates(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyWithDuplicates())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyWithDuplicates() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileWithDuplicates.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Some elements has sql statements and som have javascript in them.
	 * */
	public Document getXmlWithSqlAndJs(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDummyWithSqlAndJs())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDummyWithSqlAndJs() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/FileCorruptWithSqlAndJs.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 35 unique posts
	 * */
	public Document getXmlDEMOfileOne(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDEMOdummyFileOne())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDEMOdummyFileOne() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/DemoFileOne.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 35 posts. 10 with email error
	 * */
	public Document getXmlDEMOfileTwo(){
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader( getDEMOdummyFileTwo())));
		return doc;
		}catch(Exception e){
			
		}
		return null;
	}
 
	public String getDEMOdummyFileTwo() throws Exception{
		File f = new File(System.getProperty("user.dir")+"/src/XmlCreators/DemoFileTwo.xml");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////////
}

