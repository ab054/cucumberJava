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

    public void open() {
        driver.get(LOGIN_PAGE);
    }

    public void fillOutCredentials() {
        steps.typeIn(UNAUTHORIZED_LOGIN, LOGIN_INPUT);
        steps.typeIn(UNAUTHORIZED_PASSWORD, PASSWORD_INPUT);
        steps.clickTo(SUBMIT_BUTTON);
    }

    public void assertErrorMessageInvalidPassword() {
        steps.assertElementStringPresent(INVALID_PASSWORD_MESSAGE);
    }
}
