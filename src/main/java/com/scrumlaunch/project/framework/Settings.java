package com.scrumlaunch.project.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.*;
import java.util.Properties;

public class Settings {

    private static final String BASE_URL = "baseUrl";
    private static final String BROWSER = "browser";
    private static final String PROPERTIES = "data.properties";

    private String baseUrl;
    private BrowserType browser;
    private Properties properties = new Properties();

    public Settings() {
        loadSettings();
    }

    private void loadSettings() {
        properties = loadPropertiesFile();
        baseUrl = getPropertyOrThrowException(BASE_URL);
        browser = BrowserType.Browser(getPropertyOrThrowException(BROWSER));
    }


    private Properties loadPropertiesFile() {
        try {
            String filename = getPropertyOrNull(PROPERTIES);
            if (filename == null) {
                filename = PROPERTIES;
            }

            InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);
            if (stream == null) {
                stream = new FileInputStream(new File(filename));
            }
            Properties result = new Properties();
            result.load(stream);
            return result;
        } catch (IOException e) {
            throw new UnknownPropertyException("Property file is not found");
        }
    }

    public String getPropertyOrNull(String name) {
        return getProperty(name, false);
    }

    public String getPropertyOrThrowException(String name) {
        return getProperty(name, true);
    }

    private String getProperty(String name, boolean forceExceptionIfNotDefined) {
        String result;
        if ((result = System.getProperty(name, null)) != null && result.length() > 0) {
            return result;
        } else if ((result = getPropertyFromPropertiesFile(name)) != null && result.length() > 0) {
            return result;
        } else if (forceExceptionIfNotDefined) {
            throw new UnknownPropertyException("Unknown property: [" + name + "]");
        }
        return result;
    }

    private String getPropertyFromPropertiesFile(String name) {
        Object result = properties.get(name);
        if (result == null) {
            return null;
        } else {
            return result.toString();
        }
    }

    public WebDriver getDriver() {
        return getDriver(browser);
    }

    private WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case GC:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            default:
                throw new UnknownBrowserException("Cannot create driver for unknown browser type");
        }
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public BrowserType getBrowser() {
        return browser;
    }
}