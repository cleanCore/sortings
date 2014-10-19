package project1;
import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//get ideal from a blog which did not show author's name. I made it generic to support any data
//version 0.01. designed by maohua only support 2 level xml file currently
//maohua version 0.01. designing is my blood. But my stupid English pulls me back,
//otherwise I could do something in jdk or some great framework for Java people.
//I also know how .net foundation works together with C#

public class XmlParse<T> {//T must extends from IXmlDataSets
//XmlParse<DataSetsForXml>(DataSetsForXml.class);
	ArrayList<T> myTObjs; 
	Document dom;
	String xmlTag;
	private Class<T> xmlDataClass;

	public XmlParse(Class<T> clazz,String tag){ // I hate this constructor. modify it later
		//create a list to hold the datasets files objects
		xmlDataClass=clazz;
		myTObjs = new ArrayList<T>();
		xmlTag=tag;
	}

	public ArrayList<T> runXmlParse(String xmlName) {
		
		parseXmlFile(xmlName);
		
		parseDocument();
		
		return myTObjs;
		
	}
		
	private void parseXmlFile(String xmlFile){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//parse using builder to get DOM representation of the XML file
			dom = db.parse(xmlFile);
			
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	private void parseDocument(){
		//get the root elememt
		Element docEle = dom.getDocumentElement();
		
		//get a nodelist of <T> elements
		NodeList nl = docEle.getElementsByTagName(xmlTag);
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				
				//get the T element
				Element el = (Element)nl.item(i);
				
				//get the T object
				T xmlObj = getXmlObject(el);
				
				//add it to list
				myTObjs.add(xmlObj);
			}
		}
	}


	private T getXmlObject(Element empEl){
		
		T xmlObject;
		try {
			xmlObject = xmlDataClass.newInstance();
			if(xmlObject instanceof IXmlData)
			{
				IXmlData obj=(IXmlData)xmlObject;
				String [] requestStr=obj.sendRequest();
				String [] result=new String[requestStr.length];
				for(int i=0; i<requestStr.length;i++)
				{
					String objElementStr=getTextValue(empEl,requestStr[i]);
					if(objElementStr==null)
						result[i]=" ";
					else result[i]=objElementStr;
				}
				obj.save(result);
				return xmlObject;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}


	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}

/*
	private int getIntValue(Element ele, String tagName) {
		
		return Integer.parseInt(getTextValue(ele,tagName));
	}
*/	

}
