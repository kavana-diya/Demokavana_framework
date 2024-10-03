package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
/**
 * This class consisting of method related to property file
 * @throws IOException 
 */
public String toReadDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\commonDataPropertiies");
	Properties prop=new Properties();
	prop.load(fis);
	String value=prop.getProperty(key);
	return value;
			}
}






