package com.scrumlaunch.project;

import com.scrumlaunch.project.framework.BaseTest;
import com.scrumlaunch.project.framework.BasePage;
import com.sun.org.glassfish.gmbal.Description;
import models.DataBuilder;
import models.Donator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static com.scrumlaunch.project.framework.BasePage.generateRandomString;
import static com.scrumlaunch.project.framework.BasePage.initPage;

public class DonationFormTest extends BaseTest {

    private HomePage homePage;
    private SearchPage searchPage;
    private FundraiserDetailPage fundraiserDetailPage;
    private Donator donator;
    private DonationPage donationPage;
    private BillingDetailsPage billingDetailsPage;




    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        homePage = initPage(HomePage.class);
        searchPage = initPage(SearchPage.class);
        fundraiserDetailPage = initPage(FundraiserDetailPage.class);
        donationPage = initPage(DonationPage.class);
        billingDetailsPage = initPage(BillingDetailsPage.class);


    }
    @AfterMethod(alwaysRun = true)
    public void goToHomePage() {
        homePage.goToHomePage();
    }


    @Test
    public void donationFillFormTest() {
        donator = DataBuilder.donator("ALL");
        homePage.searchFundraiser("The");
        searchPage.navigateToFundraiserDetailPage();
        fundraiserDetailPage.navigateToDonationPage();
        donationPage.fillDonatorsForm(donator, "5", false);
        billingDetailsPage.assertHeader();

    }

    @Test
    @Description("Negative test")
    public void invalidDonationAmountValidation() {
        donator = DataBuilder.donator("TARGET");
        homePage.searchFundraiser("The");
        searchPage.navigateToFundraiserDetailPage();
        fundraiserDetailPage.navigateToDonationPage();
        donationPage.fillDonationAmount("AA");
        donationPage.assertAmount();
    }

    @Test
    @Description("Negative test")
    public void invalidDonationNameValidation() {
        donator = DataBuilder.donator("TARGET");
        homePage.searchFundraiser("Paul");
        searchPage.navigateToFundraiserDetailPage();
        fundraiserDetailPage.navigateToDonationPage();
        donationPage.fillDonatorsForm(donator, "11", true);
        donationPage.assertName();
    }

}
