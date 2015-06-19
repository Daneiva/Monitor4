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
				propertyFile = new FileInputStream("config/rmanager.properties");
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
	
	public String getUrlAdmin(){
		return properties.getProperty("adminUrl");
	}
	public String getUrlTablet(){
		return properties.getProperty("tabletURl");
	}
	public String getUsername(){
		return properties.getProperty("user");	
	}
	public String getPasseword(){
		return properties.getProperty("password");	
	}
	public String getPathChromeNavigator(){
		System.out.println(properties.getProperty("crhomepathnavigator"));
		return properties.getProperty("crhomepathnavigator");
	}
}

