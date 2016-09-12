package com.jeannot.fordcombechurch.tests;

import com.jeannot.fordcombechurch.webpages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HomePageTest {
    WebDriver driver;

    @Before
    public void setup(){
        //Select which browser driver:
        //driver = new FirefoxDriver(); //use FF Driver

        //Chrome driver: TODO path to chromedriver should be externalized
        System.setProperty("webdriver.chrome.driver","C:\\Users\\milnerpl\\AppData\\Local\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver(); //use Chrome Driver

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void home_page_works() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        assertTrue(driver.getCurrentUrl().equals(HomePage.PAGE_URL));
        assertTrue(home.welcomeLink.isDisplayed());
    }

    @After
    public void close(){
        driver.close();
    }
}