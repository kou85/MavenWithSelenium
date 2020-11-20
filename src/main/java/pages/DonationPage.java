package pages;

import com.scrumlaunch.project.framework.BasePage;
import com.sun.org.glassfish.gmbal.Description;
import models.Donator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.fest.assertions.Assertions.assertThat;

public class DonationPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @Description("Donation Amount field")
    @FindBy(xpath = ".//*[@id='donation-amount-input' and @name = 'donationAmountInput']")
    private WebElement donationAmount;

    @Description("Encouraging message  field")
    @FindBy(xpath = ".//*[@id='donation-message']")
    private WebElement message;

    @Description("First name field")
    @FindBy(xpath = ".//*[@id='first-name']")
    private WebElement firstName;

    @Description("Last name field")
    @FindBy(xpath = ".//*[@id='last-name']")
    private WebElement lastName;

    @Description("Donation Privacy")
    @FindBy(xpath = ".//*[@id='donor-name-visibility']")
    private WebElement donationPrivacy;

    @Description("Display name field")
    @FindBy(xpath = ".//*[@id='displayname']")
    private WebElement displayName;

    @Description("Email field")
    @FindBy(xpath = ".//*[@id='email']")
    private WebElement email;

    @Description("Credit card")
    @FindBy(xpath = "//*[@class='icon-credit-card']/..")
    private WebElement creditCardButton;

    @Description("amount Input Error")
    @FindBy(xpath = "//*[@id='donation-amount-input-error']")
    private WebElement amountInputError;

    @Description("name Input Error")
    @FindBy(xpath = "//*[@id='first-name-error']")
    private WebElement nameInputError;


    public BillingDetailsPage fillDonatorsForm (Donator donator, String amount, boolean withError) {
        logger.info("Fill donators form " + donator);
        getWebDriverWait(2000);
        while(!isElementPresent(donationAmount)) {
            getWebDriverWait(1000);
        }
        donationAmount.sendKeys(amount);
        if (!withError) {
            firstName.sendKeys(donator.getFirstName());
        }
        lastName.sendKeys(donator.getLastName());
        displayName.sendKeys(donator.getDisplayName());
        email.sendKeys(donator.getEmail());
        selectDropdown(donationPrivacy, donator.getDonationPrivacy());
        creditCardButton.click();
        return initPage(BillingDetailsPage.class);
    }

    public BillingDetailsPage fillDonationAmount (String amount) {
        logger.info("Fill donation Amount");
        getWebDriverWait(2000);
        donationAmount.sendKeys(amount);
        message.click();
        return initPage(BillingDetailsPage.class);
    }

    public void assertAmount() {
        logger.info("Verifying amount field");
            getWebDriverWait(4000);
            assertThat(amountInputError.getText()).isEqualTo("Please enter a valid donation amount with only numbers and a decimal point.");
        }
    public void assertName() {
        logger.info("Verifying name field");
            getWebDriverWait(4000);
            assertThat(nameInputError.getText()).isEqualTo("Please enter a first name.");
        }

}
