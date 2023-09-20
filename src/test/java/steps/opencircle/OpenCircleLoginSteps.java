package steps.opencircle;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.openCircle.OpenCircleLoginPage;
import steps.CommonSteps;

public class OpenCircleLoginSteps {

    OpenCircleLoginPage loginPage = new OpenCircleLoginPage();
    CommonSteps steps = new CommonSteps();

    @Given("user opens main page")
    public void userOpensMainPage() {
        loginPage.open();
        steps.wait.forLoading(10);
    }

    @When("fills out form with invalid credentials")
    public void fillsOutFormWithInvalidCredentials() {
        loginPage.fillOutExistingCredentials();
    }

    @When("fills out form with provided credentials")
    public void fillsOutFormWithProvidedCredentials() {
        loginPage.fillOutContextCredentials();
    }

    @Then("invalid password error is displayed")
    public void invalidPasswordErrorIsDisplayed() {
        loginPage.assertErrorMessageInvalidPassword();
    }

    @Then("error with {string} text is displayed")
    public void invalidPasswordErrorIsDisplayed(String errorText) {
        switch (errorText) {
            case "too_short_error_message":
                errorText = loginPage.getTooShortErrorText();
                break;
        }
        loginPage.assertErrorMessagePresent(errorText);
    }

    @Given("user credentials are {string} and {string}")
    public void userCredentialsAreAnd(String loginValue, String passwordValue) {
        steps.context.put("LOGIN", loginValue);
        steps.context.put("PASSWORD", passwordValue);
    }
}
