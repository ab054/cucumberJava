package pages.dvOpenCircle;

import org.junit.internal.builders.SuiteMethodBuilder;
import pages.BasePage;

public class DVOpenCircleLoginPage extends BasePage {


    private static final String LOGIN_PAGE_URL = "http://opencircle.us/login";
    private static final String VALID_EMAIL = "test123@gmail.com";
    private static final String EMAIL_FIELD_XPATH = "xpath=//input[@id='email']";
    private static final String VALID_PASSWORD = "Qwer1234";
    private static final String PASSWORD_FIELD_XPATH = "xpath=//input[@id='password']";
    private static final String SUBMIT_BTN_XPATH = "xpath=//button[@type='submit']";
    private static final String SIGNIN_BUTTON_XPATH = "xpath=//h1[contains(text(),'Sign in')]";
    private static final String SUBMIT_BTN_TEXT = "Sign in";

    public void open() {
        driver.get(LOGIN_PAGE_URL);
        steps.waitForIsVisible(SIGNIN_BUTTON_XPATH);
        steps.assertElementStringPresent(SIGNIN_BUTTON_XPATH);
    }


    public void typeCredentials() {
        steps.typeIn(VALID_EMAIL, EMAIL_FIELD_XPATH);
        steps.typeIn(VALID_PASSWORD, PASSWORD_FIELD_XPATH);
        steps.clickTo(SUBMIT_BTN_XPATH);
    }

    public void loginPageDisplayed() {
        steps.waitForIsVisible(SUBMIT_BTN_XPATH);
        steps.assertTextPresentedIn(SUBMIT_BTN_TEXT, SUBMIT_BTN_XPATH);
    }
}
