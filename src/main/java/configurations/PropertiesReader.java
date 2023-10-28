package configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static constants.Constants.*;

public class PropertiesReader {
    private static final Properties properties = new Properties();

    private PropertiesReader() {
    }

    public static String readProperties(String key) {
        String value = null;
        try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(input);
            value = properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Exception, file is missing");
        }
        return value;
    }
}
