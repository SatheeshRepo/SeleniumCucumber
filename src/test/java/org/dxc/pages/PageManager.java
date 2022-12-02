package org.dxc.pages;

public class PageManager {

    private HomePage homePage;
    private ContactUsPage contactUsPage;
    private CareerPortalPage careerPortalPage;
    private AwardRecognitionPage awardRecognitionPage;

    public HomePage getHomePage() {
        return (homePage==null)?homePage=new HomePage():homePage;
    }

    public ContactUsPage getContactUsPage() {
        return (contactUsPage==null)?contactUsPage=new ContactUsPage():contactUsPage;
    }

    public CareerPortalPage getCareerPortalPage() {
        return (careerPortalPage==null)?careerPortalPage=new CareerPortalPage():careerPortalPage;
    }

    public AwardRecognitionPage getAwardRecognitionPage() {
        return (awardRecognitionPage==null)?awardRecognitionPage=new AwardRecognitionPage():awardRecognitionPage;
    }
}
