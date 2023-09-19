package steps.dv_open_circle;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.dvOpenCircle.DVOpenCircleLoginPage;
import pages.dvOpenCircle.DVOpenCircleMainPage;

public class DVOpenCircleLoginSteps {

    DVOpenCircleLoginPage dvOpenCircleLoginPage = new DVOpenCircleLoginPage();

    @Given("open login page")
    public void openLoginPage() {
        dvOpenCircleLoginPage.open();
    }


    @When("type valid credentials")
    public void typeValidCredentials() {
        dvOpenCircleLoginPage.typeCredentials();
    }


    @Then("login page is displayed")
    public void loginPageIsDisplayed() {
        dvOpenCircleLoginPage.loginPageDisplayed();
    }
}
