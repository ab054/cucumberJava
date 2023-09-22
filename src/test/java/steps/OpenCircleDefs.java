package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.open_circle.OpenCircleJoinPage;

import static hooks.Setup.driver;
public class OpenCircleDefs {

    OpenCircleJoinPage joinPage = new OpenCircleJoinPage();
    @Given("open Join Circle page")
    public void open_join_circle_page() {
        driver.get("http://opencircle.us/join");
    }


    @Then("verify that {string} appears")
    public void verifyThatAppears(String error_text) {
        switch (error_text) {
            case "email_exist":
                error_text = OpenCircleJoinPage.EMAIL_EXIST_ERROR;
                break;
            case "too_short_pw":
                error_text = OpenCircleJoinPage.TOO_SHORT_PW_ERROR;
                break;
            case "invalid_circle_name":
                error_text = OpenCircleJoinPage.INVALID_CIRCLE_NAME_ERROR;
                break;
            case "invalid_passcode":
                error_text = OpenCircleJoinPage.INVALID_PASSCODE_ERROR;
                break;
            case "empty_fname_field":
                error_text = OpenCircleJoinPage.EMPTY_NAME_FIELD_ERROR;
                break;
            case "empty_lname_field":
                error_text = OpenCircleJoinPage.EMPTY_NAME_FIELD_ERROR;
                break;
        }
        joinPage.assertErrorMessage(error_text);
    }


}
