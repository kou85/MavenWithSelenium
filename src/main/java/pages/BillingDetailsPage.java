package pages;

import com.scrumlaunch.project.framework.BasePage;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.Assertions.assertThat;


public class BillingDetailsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @Description("Title")
    @FindBy(xpath = "//h1[contains(text(), 'Billing')]")
    private WebElement title;

    @Description("Close window")
    @FindBy(xpath = "//a[@class='pull-right modal-close']")
    private WebElement close;

    @Description("Street")
    @FindBy(xpath = "//*[@id='address1']")
    private WebElement street;

    @Description("Postal code")
    @FindBy(xpath = "//*[@id='postalcode']")
    private WebElement postalCode;

    @Description("Card number")
    @FindBy(xpath = "//*[@id='accountnumber']")
    private WebElement cardNumber;

    @Description("First name")
    @FindBy(xpath = "//*[@id='firstname']")
    private WebElement firstName;

    @Description("Last name")
    @FindBy(xpath = "//*[@id='lastname']")
    private WebElement lastname;

    @Description("Donate button")
    @FindBy(xpath = "//*[@id='paymentinformation']//button")
    private WebElement donateButton;

    @Description("Фрейм")
    @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
    private WebElement frame;

    public void assertHeader() {
        logger.info("Verifying header of the Billing page");
        getWebDriverWait(2000);
        assertThat(getTitle().getText()).isEqualTo("Billing Details");
        close.click();
    }

    public WebElement getTitle() {
        driver.switchTo().frame(frame);
        return title;
    }
}
