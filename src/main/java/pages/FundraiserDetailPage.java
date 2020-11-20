package pages;

import com.scrumlaunch.project.framework.BasePage;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundraiserDetailPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @Description("Donate Button")
    @FindBy(xpath = ".//*[@id='btn-support-participant-top']")
    private WebElement donateButton;


    public DonationPage navigateToDonationPage() {
        logger.info("Go to Donation page");
        getWebDriverWait(500);
        if (isElementPresent(donateButton)) {
            donateButton.click();
        }
        //getWebDriverWait(200);
        return initPage(DonationPage.class);
    }

}
