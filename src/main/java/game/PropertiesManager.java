package game;

import java.io.IOException;
import java.util.Properties;

/**
 * tank
 */
public class PropertiesManager {
    private static volatile PropertiesManager instance;
    private Properties properties;

    /**
     * 将构造器设置为私有，外部不允许调用
     */
    private PropertiesManager() {
        properties = new Properties();
        try {
            properties.load(PropertiesManager.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesManager getInstance() {
        if (null == instance) {
            synchronized (PropertiesManager.class) {
                if (null == instance) {
                    instance = new PropertiesManager();
                }
            }
        }
        return instance;
    }

    // static Properties properties = new Properties();

    // static {
    //     try {
    //         properties.load(game.PropertiesManager.class.getResourceAsStream("config.properties"));
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    public Object getObject(String key) {
        return properties.getProperty(key);
    }

    public Integer getIntValue(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}
