package com.vtrack.pages;

import com.vtrack.utilities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy(id = "_submit")
    public WebElement submitButton;

    @FindBy(xpath = "//div[*='Invalid user name or password.']//div")
    public WebElement invalidMessage;

    @FindBy(xpath = "//input[@class='span2']")
    public WebElement blankMessage;



    public void login() {
        usernameBox.sendKeys("username");
        passwordBox.sendKeys("password");
        submitButton.click();
    }

    public void loginAsDriver() {
        usernameBox.sendKeys("driver10");
        passwordBox.sendKeys("UserUser123");
        submitButton.click();
    }

    public void loginAsStoreManager() {
        usernameBox.sendKeys("driver85");
        passwordBox.sendKeys("UserUser123");
        submitButton.click();

    }

    public void loginAsSalesManager() {
        usernameBox.sendKeys("driver101");
        passwordBox.sendKeys("UserUser123");
        submitButton.click();

    }
}