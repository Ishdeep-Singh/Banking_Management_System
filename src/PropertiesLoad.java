import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//Use of Singleton Class (Singleton design pattern)
public class PropertiesLoad {
	private PropertiesLoad() {}
	
	public static PropertiesLoad prop = null;
	public static Properties properties = null;
	
	public void propertiesInstance() {
		try (InputStream input = new FileInputStream("config.properties")) {
			
            properties = new Properties();
            //System.out.println("Properties var:"+properties);
            // load a properties file
            properties.load(input);
            //System.out.println(properties.getProperty("sqliteDbFileLocation"));
            // get the property value and print it out
//            System.out.println(prop.getProperty("db.url"));
//            System.out.println(prop.getProperty("db.user"));
//            System.out.println(prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	public static PropertiesLoad getPropertyFileInstance() {
		if(prop == null) {
			prop = new PropertiesLoad();
			prop.propertiesInstance();
			//System.out.println("prop class object:"+prop);
		}
		
		return prop;
	}
}
