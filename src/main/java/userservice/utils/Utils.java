package userservice.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import userservice.interfaces.Resource;

public class Utils {

	public static final String CLASSPATH_URL_PREFIX = "classpath:";

	public static final String FILE_URL_PREFIX = "file:";
	
	public static final String XML_FILENAME_PREFIX = ".xml";

	public static final String JSON_FILENAME_PREFIX = ".json";
	
	public static String fileRead(Resource resource) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}

	public static void fileWriter(String content, String fileName) {
		FileOutputStream fop = null;
		File file;
		try {
			file = new File(fileName);
			fop = new FileOutputStream(new File(fileName));
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Document readBySAX(Resource resource) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(resource.getInputStream()) ;
			
			return doc ;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	
	public static void writeXML(Document doc,String fileName) {
		try{
			OutputFormat format = OutputFormat.createPrettyPrint();  
			format.setEncoding("UTF-8");  
			XMLWriter writer = new XMLWriter(  
			new OutputStreamWriter(new FileOutputStream(fileName)), format);  
			writer.write(doc);  
			writer.close();    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
