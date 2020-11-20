package models;

import com.scrumlaunch.project.framework.BasePage;

import static com.scrumlaunch.project.framework.BasePage.generateRandomString;

public class DataBuilder extends BasePage {

    public static Donator donator(String donationPrivacy) {
        return new Donator("User" + getDateInMilliseconds(), "Test", "User" + generateRandomString(), "Test" + getDateInMilliseconds() + "@gmail.com", donationPrivacy);


    }
}
