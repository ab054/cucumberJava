package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MainPage;

public class MainPageSteps {

    MainPage mainPage;

    public MainPageSteps() {
        mainPage = new MainPage();
    }

    @Given("user navigates to Google search page")
    public void userNavigatesToGoogleSearchPage() {
        mainPage.open();
    }

    @When("type and submit query {string}")
    public void typeAndSubmitQuery(String query) {
        mainPage.typeQueryAndSubmit(query);
    }

}
