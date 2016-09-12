package com.jeannot.fordcombechurch.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    //Page URL
    public static String PAGE_URL="http://fordcombechurch.org/";

    //Locators
    @FindBy(how=How.LINK_TEXT, using="Welcome")
    public WebElement welcomeLink;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

}