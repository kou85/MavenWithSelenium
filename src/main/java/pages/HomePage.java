package pages;

import com.scrumlaunch.project.framework.BasePage;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @Description("All links program")
    @FindBy(xpath = "//*[@id='skip-to-content']//a[contains(@href, 'eventID')]")
    private List<WebElement> listProgram;

    @Description("Search")
    @FindBy(xpath = ".//*[@id='searchterm']")
    private WebElement search;

    @Description("Go to Home page")
    @FindBy (xpath = "//*[@id='logo']")
    private WebElement homeLogoPageButton;

    public HomePage goToHomePage() {
        logger.info("Go to Home page");
        homeLogoPageButton.click();
        return initPage(HomePage.class);
    }

    public SearchPage searchFundraiser(String value) {
        search.sendKeys(value);
        search.sendKeys(Keys.ENTER);
        return initPage(SearchPage.class);
    }
}
