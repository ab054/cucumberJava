package steps.playstation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.playstation.PSMainPage;

public class PSMainPageSteps {

    PSMainPage psMainPage;

    public PSMainPageSteps() {
        this.psMainPage = new PSMainPage();
    }

    @Given("user navigates to the main PlayStation page")
    public void userNavigatesToTheMainPlayStationPage() {
        psMainPage.open();
    }

    @And("expands Services menu from top navigation bar")
    public void expandsServicesMenuFromTopNavigationBar() {
        psMainPage.expandServiceMenu();
    }

    @When("selects PS Plus option")
    public void selectsPSPlusOption() {
        psMainPage.selectPSPlus();
    }

    @And("submits Join PlayStation Plus button")
    public void submitsButton() throws InterruptedException {
        psMainPage.clickJoinPSPlus();
    }

    @Then("user selects 12-months plan")
    public void userIsAbleToSelectMonthsPlan() {
        psMainPage.select12monthPlan();
    }

    @And("verify that {int}-months option is indeed selected")
    public void verifyThatMonthsOptionIsIndeedSelected(int monthValue) {
        psMainPage.verifyPlanOptionSelected(monthValue);
    }

    @And("add it to the cart")
    public void addItToTheCart() {
        psMainPage.addToCart();
    }
}
