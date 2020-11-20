package com.scrumlaunch.project.framework;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static com.scrumlaunch.project.framework.BasePage.driver;

public class BaseTest {
    private static Settings settings = new Settings();
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() {
        driver = settings.getDriver();
        BasePage.settings = settings;
        driver.get(settings.getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        BasePage.closeBrowser();
    }

}

