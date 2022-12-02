package org.dxc.pages;

import org.dxc.base.TestBase;
import org.dxc.common.Generic;
import org.dxc.constants.GlobalConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CareerPortalPage extends TestBase{


    GlobalConstants globalConstants;
    Generic generic;
    public HomePage homePage;
    public CareerPortalObjects careerPortalObjects;

    /**
     * Constructor
     * @param
     */
    public CareerPortalPage()
    {
        globalConstants = new GlobalConstants();
        generic = new Generic(TestBase.driver);
        homePage = new HomePage();
        careerPortalObjects = new CareerPortalObjects();
        PageFactory.initElements(getDriver(),careerPortalObjects);
    }


    public void getCareerPortalLink() throws InterruptedException {

        careerPortalObjects.careerLink.click();
        generic.waitForLongTimeOut();
    }

    public Boolean checkSearchButton(){

        return careerPortalObjects.searchButton.isDisplayed();
    }

    public void searchKeyword(String keyword) throws Exception {
        careerPortalObjects.searchTextBox.sendKeys(keyword);
        careerPortalObjects.searchButton.click();


        generic.waitForLongTimeOut();

        //validate saved jobs link is displayed
        Assert.assertTrue(careerPortalObjects.savedJobsLink.isDisplayed(),"Saved Jobs link is displayed");
        //validate keyword in filtered result
        Assert.assertTrue(careerPortalObjects.resultContentText.getText().contains(keyword),
                "Filtered Result contains keyword "+keyword);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1400)");
        generic.waitForMediumTimeOut();
//        validate Job Alert button is displayed
        Assert.assertTrue(careerPortalObjects.jobAlertButton.isDisplayed(),
                "Job Alert Button is displayed");

    }



    /*
       ###################################################################################
       ######################                                      #######################
       ######################    Career Portal -  WebElements         #######################
       ######################                                      #######################
       ###################################################################################
   */
    static class CareerPortalObjects {

        @FindBy(xpath ="//a[@href='https://careers.dxc.com'][normalize-space()='Careers']")
        @CacheLookup
        private WebElement careerLink;


        @FindBy(xpath = "//span[@phae-bind-literal='globalsearchButtonText']")
        @CacheLookup
        private WebElement searchButton;

        @FindBy(xpath = "//input[@id='typehead']")
        @CacheLookup
        private WebElement searchTextBox;

        @FindBy(xpath = "//div[@class='phs-jobs-list-header au-target']")
        @CacheLookup
        private WebElement resultContentText;

        @FindBy(xpath = "//span[@class='linkText']")
        @CacheLookup
        private WebElement savedJobsLink;

        @FindBy(xpath = "//button[normalize-space()='Create Job Alert']")
        @CacheLookup
        private WebElement jobAlertButton;
    }

}
