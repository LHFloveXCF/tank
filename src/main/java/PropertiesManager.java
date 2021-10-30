import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * tank
 */
public class PropertiesManager {
    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertiesManager.class.getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getObject(String key) {
        return properties.getProperty(key);
    }

    public static Integer getIntValue(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}
