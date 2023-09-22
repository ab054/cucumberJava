package pages.open_circle;

import pages.BasePage;


public class OpenCircleJoinPage extends BasePage {
    public static final String EMAIL_EXIST_ERROR = "A user with such an email exists.";
    public static final String TOO_SHORT_PW_ERROR = "Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20";
    public static final String INVALID_CIRCLE_NAME_ERROR = "Incorrect Circle Name. Please try again";

    public static final String INVALID_PASSCODE_ERROR = "Incorrect Passcode. Please try again";

    public static final String EMPTY_NAME_FIELD_ERROR = "This input is required.";

    public void assertErrorMessage(String message) {
        steps.assertElementPresent("xpath=//*[contains(.,'" + message + "')]");
    }
}

