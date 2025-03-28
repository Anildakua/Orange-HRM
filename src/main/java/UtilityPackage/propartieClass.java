package UtilityPackage;

import java.io.FileInputStream;
import java.util.Properties;

public class propartieClass {

	public static String proparties(String key) throws Exception {
	
		FileInputStream file=new FileInputStream("./src/test/resources/resources/login.proparties");
		Properties pro=new Properties();
		pro.load(file);
		String data=pro.getProperty(key);
		return data;
		
	}
}
