package util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Settings {
    private static final String CONFIG_FILE = "src/test/resources/settings.xml";
    private static Settings instance;
    private final Document document;

    private String baseUrl;
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;


    private Settings() {
        try {
            File file = new File(CONFIG_FILE);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(file);
            loadConfig();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static synchronized Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    private void loadConfig() {
        baseUrl = getElementText("baseUrl");

        Element credentials = (Element) document.getElementsByTagName("credentials").item(0);
        Element valid = (Element) credentials.getElementsByTagName("valid").item(0);
        Element invalid = (Element) credentials.getElementsByTagName("invalid").item(0);

        validUsername = getElementText(valid, "username");
        validPassword = getElementText(valid, "password");
        invalidUsername = getElementText(invalid, "username");
        invalidPassword = getElementText(invalid, "password");
    }

    private String getElementText(String tagName) {
        return document.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private String getElementText(Element parent, String tagName) {
        return parent.getElementsByTagName(tagName).item(0).getTextContent();
    }

    public String getBaseUrl() { return baseUrl; }
    public String getValidUsername() { return validUsername; }
    public String getValidPassword() { return validPassword; }
    public String getInvalidUsername() { return invalidUsername; }
    public String getInvalidPassword() { return invalidPassword; }
}