package com.vtrack.setep_Definition;

import com.vtrack.pages.LoginPage;
import com.vtrack.utilities.utilities.ConfigurationReader;
import com.vtrack.utilities.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class loginStepDefs {

    LoginPage loginPage=new LoginPage();

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @Then("the user enter user1 and UserUser123")
    public void the_user_enter_user1_and_user_user123() {
    loginPage.loginAsDriver();

    }

    @Then("the user enter storemanager85 and UserUser123")
    public void the_user_enter_storemanager85_and_user_user123() {
        loginPage.loginAsStoreManager();
    }


    @Then("the user enter salesmanager and UserUser123")
    public void the_user_enter_salesmanager_and_user_user123() {
        loginPage.loginAsSalesManager();
    }

    @Then("{string} should land on {string} page after successful login")
    public void should_land_on_page_after_successful_login(String string, String string2) {
        loginPage.loginAsDriver();
       String expectedTitle="Quick Launchpad";
       String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Then("{string} or {string} should on {string} page after successful login")
    public void or_should_on_page_after_successful_login(String string, String string2, String string3) {
        loginPage.loginAsStoreManager();
        String expectedTitle="Dashboard";
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        loginPage.loginAsSalesManager();
        String expectedtitle="Dashboard";
        String actualtitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Then("the user enters invalid credentials {string} and {string} and the user can see {string} message")
    public void the_user_enters_invalid_credentials_and_and_the_user_can_see_message(String string, String string2, String string3) {


       loginPage.usernameBox.sendKeys("user123");
        loginPage.passwordBox.sendKeys("UserUser123");
        loginPage.submitButton.click();
        String expectedtitle="Invalid username or password.";
        String actualtitle= loginPage.invalidMessage.getText();
        Assert.assertEquals(expectedtitle,actualtitle);

        loginPage.usernameBox.sendKeys("store");
        loginPage.passwordBox.sendKeys("Userbghu");
        loginPage.submitButton.click();
        String expectedttitle="Invalid username or password.";
        String actualttitle= loginPage.invalidMessage.getText();
        Assert.assertEquals(expectedttitle,actualttitle);

        loginPage.usernameBox.sendKeys("salesmanager101");
        loginPage.passwordBox.sendKeys("abghyt657");
        loginPage.submitButton.click();
        String expectedttitlee="Invalid username or password.";
        String actualttitlee= loginPage.invalidMessage.getText();
        Assert.assertEquals(expectedttitlee,actualttitlee);
    }

    @Then("the user enters blank credentials {string} and {string} and the user can see {string} message")
    public void the_user_enters_blank_credentials_and_and_the_user_can_see_message(String string, String string2, String string3) {
        loginPage.usernameBox.sendKeys(" ");
        loginPage.passwordBox.sendKeys(" ");
        loginPage.submitButton.click();

        String expextedtitle="Please fill in this field.";
        String actualtitle = loginPage.blankMessage.getText();
        Assert.assertEquals(expextedtitle,actualtitle);
    }

}
