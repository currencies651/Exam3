package com.hand.Program3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadXmlAndJson {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("http://www.hq.sinajs.cn/list=sz300170"));
			Element root = document.getDocumentElement();
			NodeList stock = root.getElementsByTagName("stock");
		    for(int i=0;i<stock.getLength();i++){
		    	Element lan = (Element) stock;
		}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	try {
		
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(new FileReader("test.json"));
		System.out.println("cat=" + object.get("cat").getAsString());
		System.out.println("pop=" + object.get("pop").getAsBoolean());
		
		JsonArray array = object.get("languages").getAsJsonArray();
		for (int i = 0; i < array.size(); i++) {
			JsonObject subObject = array.get(i).getAsJsonObject();
			System.out.println("name="+subObject.get("name").getAsString());
			System.out.println("open="+subObject.get("open").getAsString());
			System.out.println("current="+subObject.get("current").getAsString());
			System.out.println("high"+subObject.get("high").getAsString());
			System.out.println("low"+subObject.get("low").getAsString());
		}
		
		
	} catch (JsonIOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonSyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
