package steps.dv_open_circle;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.dvOpenCircle.DVOpenCircleMainPage;

public class DVOpenCircleMainPageSteps {

    DVOpenCircleMainPage dvOpenCircleMainPage = new DVOpenCircleMainPage();

    @Then("circle name is displayed")
    public void circleNameIsDisplayed() {
        dvOpenCircleMainPage.assertCircleName();
    }

    @Then("open user profile")
    public void openUserProfile() {
        dvOpenCircleMainPage.openUserProfile();
    }

    @Then("change password with {int} char")
    public void changePasswordWithChar(int arg0) {
        dvOpenCircleMainPage.changePassword();
    }


    @Then("change psw error message displayed")
    public void changePswErrorMessageDisplayed() {
        dvOpenCircleMainPage.changePswErrorMessageDispayed();
    }

    @When("user opens albums")
    public void userOpensAlbums() {
        dvOpenCircleMainPage.openAlbums();
    }

    @Then("album is present in list")
    public void albumIsPresentInList() {
        dvOpenCircleMainPage.albumIsPresent();
    }

    @And("user creates topic")
    public void userCreatesTopic() {
        dvOpenCircleMainPage.createNewTopic();
    }


    @Then("create topic success message displayed")
    public void createTopicSuccessMessageDisplayed() {
        dvOpenCircleMainPage.createTopicMessageDisplayed();
    }

    @And("user deletes topic")
    public void userDeletesTopic() {
        dvOpenCircleMainPage.deleteTpic();
    }

    @Then("confirmation message is displayed")
    public void confirmationMessageIsDisplayed() {
        dvOpenCircleMainPage.confirmationMsgDisplayed();
    }

    @Then("first and last names are verified")
    public void firstAndLastNamesAreVerified() {
        dvOpenCircleMainPage.firstLastNamesConfirmation();
    }

    @Then("user logs out")
    public void userLogsOut() {
        dvOpenCircleMainPage.userLogsOut();
    }
}
