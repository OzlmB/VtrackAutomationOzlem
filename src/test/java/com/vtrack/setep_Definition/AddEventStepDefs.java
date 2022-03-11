package com.vtrack.setep_Definition;

import com.vtrack.pages.AddEventPage;
import com.vtrack.pages.BasePage;
import com.vtrack.pages.DashboardPage;
import com.vtrack.pages.LoginPage;
import com.vtrack.utilities.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddEventStepDefs {

    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    AddEventPage addEventPage=new AddEventPage();

    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String storemanager) {
        loginPage.loginAsSalesManager();
        BrowserUtils.waitFor(2);

    }
    @Given("go to from {string} to {string} module")
    public void go_to_from_to_module(String Fleet, String Vehicle) {
        dashboardPage.navigateToModule("Fleet","Vehicles");
        BrowserUtils.waitFor(2);

    }
    @When("clicking on any vehicle")
    public void clicking_on_any_vehicle() {
        addEventPage.anyVehicle.click();
        BrowserUtils.waitFor(2);

    }
    @When("clicking on {string} button")
    public void clicking_on_button(String AddEvent) {
        // Write code here that turns the phrase above into concrete actions
        addEventPage.addEventButton.click();
        BrowserUtils.waitFor(5);
    }
    @When("the user can mark the event with any color")
    public void the_user_can_mark_the_event_with_any_color() {
        addEventPage.anyColor.click();
    }

    @And("the user can mark {string} button")
    public void theUserCanMarkButton(String AllDaybutton) {
        addEventPage.allDayEventButton.click();
        BrowserUtils.waitFor(2);

    }


    @Then("Repeat option should includes the options below")
    public void repeatOptionShouldIncludesTheOptionsBelow(List<String> dataTable) {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(addEventPage.repeatCheckbox,4);
        addEventPage.repeatCheckbox.click();

        Select dropdown = new Select(addEventPage.repeatDropdown);

        List<WebElement> options = dropdown.getOptions();
        for (int i = 0; i <options.size(); i++) {

            String expectedTitle = dataTable.get(i);
            String actualTitle = options.get(i).getText();
            Assert.assertEquals(expectedTitle,actualTitle);

        }


        }

    @And("Ends options should be clickable")
    public void endsOptionsShouldBeClickable() {
        addEventPage.endButton.isSelected();


    }

    @Then("Ends option should be as below")
    public void endsOptionShouldBeAsBelow() {
        String expected="Never";
        String actual=addEventPage.neverEndButton.getText();
        Assert.assertEquals(expected,actual);

        String expectedd="After";
        String actuall=addEventPage.afterEndButton.getText();
        Assert.assertEquals(expectedd,actuall);

        String expectedTitle="By";
        String actualTitle=addEventPage.byEndButton.getText();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("All Users can see all events in the General information page")
    public void allUsersCanSeeAllEventsInTheGeneralInformationPage() {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        List<String> list=BrowserUtils.getElementsText(addEventPage.addedEventList);
        String option = list.get(0).toString();
        System.out.println(option);
        String actual = "Calendar event added by John Doe\n" + "...\n" + "competition\n" + "Yesterday";
        Assert.assertEquals(option,actual);
        
    }
}


