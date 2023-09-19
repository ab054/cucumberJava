package pages.lifetwig;

import pages.BasePage;

public class LTLoginPage extends BasePage {
    private static final String LT_MAIN_PAGE_URL = "https://www.lifetwig.com/login";
    private static final String USER_EMAIL = "moonraytest@gmail.com";
    private static final String INPUT_LOGIN = "id=login_email";
    private static final String USER_PASSWORD = "L1fetw1g@22!";
    private static final String INPUT_PASSWORD = "id=login_password";


    public void open() {
        driver.get(LT_MAIN_PAGE_URL);
    }

    public void loginAsExistingUser() {
        steps.typeIn(USER_EMAIL, INPUT_LOGIN);
        steps.typeIn(USER_PASSWORD, INPUT_PASSWORD);
        steps.clickTo("xpath=//button[@type='submit']");
    }

    public void loginAsExistingUser(String login, String password) {
        steps.typeIn(USER_EMAIL, INPUT_LOGIN);
        steps.typeIn(password, INPUT_PASSWORD);
        steps.clickTo("xpath=//button[@type='submit']");
    }
}
