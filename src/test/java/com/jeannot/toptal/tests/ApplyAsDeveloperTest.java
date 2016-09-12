package com.jeannot.toptal.tests;

import com.jeannot.toptal.webpages.DeveloperApplyPage;
import com.jeannot.toptal.webpages.DeveloperPortalPage;
import com.jeannot.toptal.webpages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * These don't work, the site under test must've changed...
 * Taken as example from http://blog.testproject.io/2016/09/06/test-automation-selenium-page-object-model-page-factory/
 */
public class ApplyAsDeveloperTest {
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
    public void applyAsDeveloper() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnDeveloperApplyButton();

        //Create object of DeveloperPortalPage
        DeveloperPortalPage devportal= new DeveloperPortalPage(driver);

        //Check if page is opened
        Assert.assertTrue(devportal.isPageOpened());

        //Click on Join Toptal
        devportal.clikOnJoin();

        //Create object of DeveloperApplyPage
        DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);

        //Check if page is opened
        Assert.assertTrue(applyPage.isPageOpened());

        //Fill up data
        applyPage.setDeveloper_email("dejan@toptal.com");
        applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
        applyPage.setDeveloper_password("password123");
        applyPage.setDeveloper_password_confirmation("password123");
        applyPage.setDeveloper_skype("automated_test_skype");

        //Click on join
        //applyPage.clickOnJoin();
    }

    @After
    public void close(){
        driver.close();
    }
}