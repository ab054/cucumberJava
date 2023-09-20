package pages.openCircle;

import pages.BasePage;

public class OpenCircleLoginPage extends BasePage {
    private static final String LOGIN_PAGE = "http://opencircle.us/login";
    private static final String UNAUTHORIZED_LOGIN = "ab@gmail.com";
    private static final String LOGIN_INPUT = "id=email";
    private static final String UNAUTHORIZED_PASSWORD = "1234567Qw!";
    private static final String PASSWORD_INPUT = "id=password";
    private static final String SUBMIT_BUTTON = "xpath=//button[@type='submit']";
    private static final String INVALID_PASSWORD_MESSAGE = "xpath=//span[contains(.,'Invalid email or password.')]";
    private static final String PASSWORD_IS_TOO_SHORT_ERROR = "Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20";

    public void open() {
        driver.get(LOGIN_PAGE);
    }

    public void fillOutExistingCredentials() {
        steps.typeIn(UNAUTHORIZED_LOGIN, LOGIN_INPUT);
        steps.typeIn(UNAUTHORIZED_PASSWORD, PASSWORD_INPUT);
        steps.clickTo(SUBMIT_BUTTON);
    }

    public void fillOutContextCredentials() {
        String login = (String) steps.context.get("LOGIN");
        String password = (String) steps.context.get("PASSWORD");
        steps.typeIn(login, LOGIN_INPUT);
        steps.typeIn(password, PASSWORD_INPUT);
        steps.clickTo(SUBMIT_BUTTON);
    }

    public void assertErrorMessageInvalidPassword() {
        steps.assertElementPresent(INVALID_PASSWORD_MESSAGE);
    }

    public void assertErrorMessagePresent(String errorMessageText) {
        steps.assertElementPresent("xpath=//*[contains(.,'" + errorMessageText + "')]");
    }

    public String getTooShortErrorText() {
        return PASSWORD_IS_TOO_SHORT_ERROR;
    }
}
