package steps.google;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.google.ResultsPage;

public class ResultsPageSteps {

    ResultsPage resultsPage;

    public ResultsPageSteps() {
        resultsPage = new ResultsPage();
    }

    @Then("amount of results should be sufficient")
    public void amountOfResultsShouldBeSufficient() {
        int actualNumberOfResults = resultsPage.getNumberOfResults();

        int testExpectedNumber = 10000;
        boolean condition = actualNumberOfResults > testExpectedNumber;
        Assert.assertTrue("amount of result is less than " + testExpectedNumber, condition);
    }

    @Then("amount of results is greater than {int}")
    public void amountOfResultsIsGreaterThan(Integer expectedNumber) {
        int actualNumberOfResults = resultsPage.getNumberOfResults();
        boolean condition = actualNumberOfResults > expectedNumber;
        Assert.assertTrue("amount of result is less than " + expectedNumber, condition);
    }
}
