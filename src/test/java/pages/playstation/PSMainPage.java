package pages.playstation;

import pages.BasePage;
import steps.CommonSteps;

import static java.lang.Thread.sleep;

public class PSMainPage extends BasePage {

    private String menuButton = "xpath=//*[@id='menu-button-primary--msg-services']";
    private String psPlusButton = "css=.shared-nav__secondary-item:nth-child(1) > #link-secondary--msg-ps-plus";
    private String joingPSPlusButton = "xpath=//span[@class='tertiary-cta__label']";
    private String planSelector = "css=.tier-selector__content:nth-child(2) .psw-radio:nth-child(3)";
    private String addToCartButton = "css=.tier-selector__content:nth-child(2) .psw-fill-x:nth-child(2) > .psw-fill-x";


    public void open() {
        driver.get("https://www.playstation.com/en-us/");
    }

    public void expandServiceMenu() {
        new CommonSteps().clickTo(menuButton);
    }

    public void selectPSPlus() {
        new CommonSteps().clickTo(psPlusButton);
    }

    public void clickJoinPSPlus() throws InterruptedException {
        new CommonSteps().clickTo(joingPSPlusButton);
        sleep(1000);
    }

    public void select12monthPlan() {
        new CommonSteps().clickTo(planSelector);
    }

    public void verifyPlanOptionSelected(int monthValue) {
        String locator = "xpath=//input[@type='radio'][@value='" + monthValue + "-Month Plan']";
        new CommonSteps().assert_that_checked(locator);
    }

    public void addToCart() {
        new CommonSteps().clickTo(addToCartButton);
    }
}
