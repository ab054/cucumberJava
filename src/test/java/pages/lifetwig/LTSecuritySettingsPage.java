package pages.lifetwig;

import pages.BasePage;

public class LTSecuritySettingsPage extends BasePage {
    private static final String SECURITY_SETTINGS_URL = "https://www.lifetwig.com/settings/security";
    private static final String SECURITY_TAB = "xpath=//a[@href='/settings/security']";
    private static final String CURRENT_PASSWORD_INPUT = "xpath=//input[@placeholder='Enter current password']";
    private static final String NEW_PASSWORD_INPUT = "xpath=//input[@placeholder='Enter new password']";
    private static final String CONFIRM_PASSWORD_INPUT = "xpath=//input[@placeholder='Enter new password again']";
    private static final String CHANGE_BUTTON = "xpath=//span[text()='Change']";
    private static final String PASSWORD_CHANGED_NOTIFICATION = "xpath=//span[contains(@text, 'changed successfully')]";

    public void openViaURL() {
        driver.get(SECURITY_SETTINGS_URL);
    }

    public void selectSecurityTab() {
        steps.clickTo(SECURITY_TAB);
    }

    public void correctlyEntersANewPassword(String current, String newPassword, String newPasswordAgain) {
        steps.typeIn(current, CURRENT_PASSWORD_INPUT);
        steps.typeIn(newPassword, NEW_PASSWORD_INPUT);
        steps.typeIn(newPasswordAgain, CONFIRM_PASSWORD_INPUT);
    }

    public void clickOnChangeButton() {
        steps.clickTo(CHANGE_BUTTON);
    }

    public void passwordChangeNotificationIsDisplayed() {
        steps.assertElementPresent(PASSWORD_CHANGED_NOTIFICATION);
    }
}
