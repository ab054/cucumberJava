package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MainPage;
import pages.ResultsPage;

public class SearchSteps {

    @Given("user navigates to Google search page")
    public void userNavigatesToGoogleSearchPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigate();
    }

    @When("type and submit query {string}")
    public void typeAndSubmitQuery(String query) {
        MainPage mainPage = new MainPage();
        mainPage.typeQueryAndSubmit(query);
    }

    @Then("amount of results should be sufficient")
    public void amountOfResultsShouldBeSufficient() {
        ResultsPage resultsPage = new ResultsPage();
        int actualNumberOfResults = resultsPage.getNumberOfResults();

        int testExpectedNumber = 10000;
        Assert.assertTrue("amount of result is less than " + testExpectedNumber, actualNumberOfResults > testExpectedNumber);
    }

    @Then("amount of results is greater than {string}")
    public void amountOfResultsIsGreaterThan(String number) {
        ResultsPage resultsPage = new ResultsPage();
        int actualNumberOfResults = resultsPage.getNumberOfResults();

        int testExpectedNumber = Integer.parseInt(number);
        Assert.assertTrue("amount of result is less than " + testExpectedNumber, actualNumberOfResults > testExpectedNumber);
    }
}
