package steps.lifetwig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.lifetwig.LTFeedPage;
import pages.lifetwig.LTLoginPage;

public class LTLoginPageSteps {

    LTLoginPage loginPage = new LTLoginPage();
    LTFeedPage feedPage = new LTFeedPage();

    @Given("user navigates to the LifeTwig login page")
    public void userNavigatesToTheMainLifeTwigPage() {
        loginPage.open();
    }

    @And("logs in as an existing user")
    public void logsInAsAnExistingUser() {
        loginPage.loginAsExistingUser();
        feedPage.assertThatOpened();
    }
}
