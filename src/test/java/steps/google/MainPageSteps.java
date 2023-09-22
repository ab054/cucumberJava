package steps.google;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.google.MainPage;

import static hooks.Setup.driver;

public class MainPageSteps {

    MainPage mainPage;

    public MainPageSteps() {
        mainPage = new MainPage();
    }

    @When("type {string} and submit")
    public void typeAndSubmitQuery(String query) {
        mainPage.typeQueryAndSubmit(query);
    }

    @Given("a user navigates to Google's main page")
    public void aUserNavigatesToGoogleSMainPage() {
        mainPage.open();
    }

    @Then("wait for {int} sec")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }

    @Given("a user navigates to Open circle main page")
    public void aUserNavigatesToOpenCircleMainPage() {
        driver.get("http://opencircle.us/login");
    }
}
