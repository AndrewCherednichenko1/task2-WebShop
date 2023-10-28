package configurations;

public class PropertiesManager {
    private PropertiesManager() {
    }

    public static String getBaseUrl() {
        return PropertiesReader.readProperties("base_url");
    }

    public static String getChromeDriver() {
        return PropertiesReader.readProperties("chrome_driver");
    }

    public static String getChromeDriverPath() {
        return PropertiesReader.readProperties("chrome_driver_path");
    }

    public static String getFirefoxDriver() {
        return PropertiesReader.readProperties("firefox_driver");
    }

    public static String getFirefoxDriverPath() {
        return PropertiesReader.readProperties("firefox_driver_path");
    }

    public static Integer getWaitTime() {
        return Integer.parseInt(PropertiesReader.readProperties("driver_wait_time"));
    }
}
