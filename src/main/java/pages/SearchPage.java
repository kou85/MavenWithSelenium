package pages;

import com.scrumlaunch.project.framework.BasePage;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SearchPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @Description("Search result")
    @FindBy(xpath = "//*[@class='js-displayname']/a")
    private List<WebElement> searchResult;




    public FundraiserDetailPage navigateToFundraiserDetailPage() {
        logger.info("Go to Fundraiser detail page");
        getWebDriverWait(5000);
        if (!isElementsExist(searchResult)) {
            getWait();
        }
        searchResult.get(0).click();
        return initPage(FundraiserDetailPage.class);
    }

    public HomePage navigateToHomePage() {
        return new HomePage().goToHomePage();
    }
}
