package steps.lifetwig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.lifetwig.LTFeedPage;
import pages.lifetwig.LTLoginPage;
import steps.CommonSteps;

public class LTSecuritySettingsSteps {

    LTLoginPage loginPage = new LTLoginPage();
    LTSecuritySettingsPage securitySettings = new LTSecuritySettingsPage();
    CommonSteps steps = new CommonSteps();
    private LTFeedPage feedPage = new LTFeedPage();

    @And("user navigates to security settings page")
    public void userNavigatesToSecuritySettingsPage() {
        securitySettings.openViaURL();
        securitySettings.selectSecurityTab();
    }

    @And("correctly fills out change form")
    public void correctlyEntersAsANewPassword() {
        String oldPassword = (String) steps.context.get("PASSWORD_VALUE");
        String newPassword = (String) steps.context.get("NEW_PASSWORD_VALUE");

        securitySettings.correctlyEntersANewPassword(oldPassword, newPassword, newPassword);
        securitySettings.clickOnChangeButton();
    }

    @Then("password change notification is displayed")
    public void passwordChangeNotificationIsDisplayed() {
        securitySettings.passwordChangeNotificationIsDisplayed();
    }

    @Given("existing user logs in and lands on security page")
    public void existingUserLogsInAndLandsOnSecurityPage() {
        loginPage.open();
        loginPage.loginAsExistingUser((String) steps.context.get("LOGIN_VALUE"), (String) steps.context.get("PASSWORD_VALUE"));
        feedPage.assertThatOpened();
        securitySettings.openViaURL();
        securitySettings.selectSecurityTab();
    }

    @Given("existing user credentials are {string} and {string}")
    public void existingUserCredentialsAreAnd(String login, String password) {
        steps.context.put("LOGIN_VALUE", login);
        steps.context.put("PASSWORD_VALUE", password);
    }

    @And("new password is {string}")
    public void newPasswordIsAndOld(String newPassword) {
        steps.context.put("NEW_PASSWORD_VALUE", newPassword);
    }

}
