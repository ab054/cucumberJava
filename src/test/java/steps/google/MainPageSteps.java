package steps.google;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.google.MainPage;

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
}
