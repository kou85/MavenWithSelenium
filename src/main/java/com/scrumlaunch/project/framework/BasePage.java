package com.scrumlaunch.project.framework;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public static Settings settings;

    public static <T extends BasePage> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public void selectDropdown(WebElement element, String value) {
        logger.info("Select value in the dropdown: ");
        getWebDriverWait(200);
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public WebDriverWait getWebDriverWait(int timeout) {
        return new WebDriverWait(driver, timeout, 2);
    }

    public void getWait() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean isElementPresent(WebElement element) {
        logger.info("Is element present: ");
        boolean present = true;
        try {
            element.isDisplayed();

        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;

    }


    public boolean isElementsExist(List<WebElement> listWebElements) {
        logger.info("Is elements exist: ");
        boolean result = false;
        if (listWebElements != null && listWebElements.size() > 0) {
            result = true;
        }
        return result;
    }


    public static String getDateInMilliseconds() {
        return String.valueOf(new Date().toInstant().toEpochMilli());
    }


    public static String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static void closeBrowser() {
        logger.info("Close browser");
        driver.quit();
    }

}

