package models;

import org.openqa.selenium.support.ui.Select;

public class Donator {

    private String firstName;
    private String lastName;
    private String displayName;
    private String email;
    private String donationPrivacy;

    public Donator(String firstName, String lastName, String displayName, String email, String donationPrivacy) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
        this.donationPrivacy = donationPrivacy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getDonationPrivacy() {
        return donationPrivacy;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDonationPrivacy(String donationPrivacy) {
        this.donationPrivacy = donationPrivacy;
    }

    @Override
    public String toString() {
        return "Donator{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", donationPrivacy='" + donationPrivacy + '\'' +
                '}';
    }


}





