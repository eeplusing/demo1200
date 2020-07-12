package com.eplusing.mvnbook.account.persist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.util.List;
public class AccounPersistServiceImpl implements AccounPersistService {

	private String file;
	private SAXReader reader = new SAXReader();
	
	
	public Account createAccount(Account account) throws AccountPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	public Account readAccount(String id) throws AccountPersistException {
		Document doc = readDocument();
		Element accountsEle = doc.getRootElement().element("accounts");
		for(Element accountEle :(List<Element>)accountsEle.elements()){
			if(accountEle.elementText("id").equals(id)){
				return buildAccount(accountEle);
			}
		}
		return null;
	}

	private Account buildAccount(Element accountEle) {
		Account account = new Account();
		account.setId(accountEle.elementText("id"));
		account.setName(accountEle.elementText("name"));
		account.setEmail(accountEle.elementText("email"));
		account.setPassword(accountEle.elementText("password"));
		account.setActivated("true".equals(accountEle.elementText("activated")) ? true:false);
		
		return account;
	}

	public Account updateAccount(Account account) throws AccountPersistException {
		return null;
	}

	public void deleteAccount(String id) throws AccountPersistException {
		// TODO Auto-generated method stub
		
	}

	private Document readDocument() throws AccountPersistException{
		File dataFile = new File(file);
		if(!dataFile.exists()){
			dataFile.getParentFile().mkdirs();
			Document doc = DocumentFactory.getInstance().createDocument();
			Element rootEle = doc.addElement("account-persist");
			rootEle.addElement("accounts");
			writeDocument(doc);
		}
		
		try {
			return reader.read(new File(file));
		} catch (DocumentException e) {
			throw new AccountPersistException("Unable to read persist data.xml", e);
		}
		
	}
	
	
	private void writeDocument(Document doc) {
		Writer out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
			XMLWriter writer = new XMLWriter(out, OutputFormat.createPrettyPrint());
			writer.write(doc);
		} catch (IOException e) {
			try {
				throw new AccountPersistException("Unable to write persist data.xml", e);
			} catch (AccountPersistException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
			
			try {
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					throw new AccountPersistException("Unable to close persist data.xml", e);
				} catch (AccountPersistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

	
	
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public SAXReader getReader() {
		return reader;
	}

	public void setReader(SAXReader reader) {
		this.reader = reader;
	}
	
	
}
