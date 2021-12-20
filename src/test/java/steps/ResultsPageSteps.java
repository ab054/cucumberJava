package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ResultsPage;

public class ResultsPageSteps {

    ResultsPage resultsPage;

    public ResultsPageSteps() {
        resultsPage = new ResultsPage();
    }

    @Then("amount of results should be sufficient")
    public void amountOfResultsShouldBeSufficient() {
        int actualNumberOfResults = resultsPage.getNumberOfResults();

        int testExpectedNumber = 10000;
        Assert.assertTrue("amount of result is less than " + testExpectedNumber, actualNumberOfResults > testExpectedNumber);
    }

    @Then("amount of results is greater than {string}")
    public void amountOfResultsIsGreaterThan(String number) {
        int actualNumberOfResults = resultsPage.getNumberOfResults();

        int testExpectedNumber = Integer.parseInt(number);
        Assert.assertTrue("amount of result is less than " + testExpectedNumber, actualNumberOfResults > testExpectedNumber);
    }
}
