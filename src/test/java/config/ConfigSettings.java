package config;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Class that encapsulates the user settings specified in the
 * properties file of the framework
 *
 * @author Chindhu
 */
public class ConfigSettings {

    private static Properties properties= loadFromPropertiesFile();
    public ConfigSettings() {
        // To prevent external instantiation of this class
       // properties = loadFromPropertiesFile();
    }
    public static Properties getInstance() {
        return properties;
    }


    private static Properties loadFromPropertiesFile() {

        Properties properties = new Properties();

        try {
            String configPropertiesPath = /*configParameters.getRelativePath()+*/
                    PropertiesPath();
            properties.load(new FileInputStream(configPropertiesPath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new FrameworkException("Exception while loading the configProperties file");
        }

        return properties;
    }
    public static String PropertiesPath(){
       return System.getProperty("user.dir")+
               "//src//test//resources//config//frameworkProperties.properties";
    }
    public static void saveProperty(Properties p) {
        try {
            p.save(new FileOutputStream(PropertiesPath()), "");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
