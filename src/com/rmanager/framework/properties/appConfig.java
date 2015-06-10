package com.rmanager.framework.properties;  

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class appConfig {

	Properties properties = new Properties();
	InputStream propertyFile = null;
	
	public appConfig(){
		properties = new Properties();		
			try {		 
				propertyFile = new FileInputStream("rmanager.properties");
				properties.load(propertyFile);		 
				} 
			catch (IOException ex) {
				ex.printStackTrace();
			} 
			finally {
				if (propertyFile != null) {
					try {
						propertyFile.close();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
		    }
	}
}
	
	public String getBaseURL(){
		return properties.getProperty("urlRMApp");
	}
	public String getUsername(){
		return properties.getProperty("user");	
	}
	public String getPasseword(){
		return properties.getProperty("password");	
	}
}

