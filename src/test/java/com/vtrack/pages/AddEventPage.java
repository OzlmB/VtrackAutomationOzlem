package com.vtrack.pages;

import com.vtrack.utilities.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEventPage {
    public void AddEventPage() {
        PageFactory.initElements(Driver.get(), this);
    }

        @FindBy(xpath = "(//ul[@class='unstyled options']//li)[1]")
        public WebElement anyVehicle;

        @FindBy(xpath = "//a[@title='Add an event to this record']")
        public WebElement addEventButton;

        @FindBy(xpath = "(//span[@class='color'])[1]")
    public WebElement anyColor;


    @FindBy(xpath = "//input[@name='oro_calendar_event_form[allDay]']")
    public WebElement allDayEventButton;

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeatCheckbox;
    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatDropdown;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement endButton;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement neverEndButton;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement afterEndButton;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement byEndButton;

    @FindBy(xpath = "//div[@class='list-item']")
    public List<WebElement> addedEventList;


    }


