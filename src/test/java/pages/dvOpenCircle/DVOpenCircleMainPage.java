package pages.dvOpenCircle;


import org.openqa.selenium.By;
import pages.BasePage;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class DVOpenCircleMainPage extends BasePage {
    private static final String CIRCLE_NAME = "May2023";
    private static final String CIRCLE_NAME_XPATH = "xpath=//div[@class='header_organization__lkTO2']";
    private static final String PROFILE_LOGO_XPATH = "xpath=//span[@class='ant-avatar-string']";
    private static final String CHANGE_PASSWORD_BUTON = "xpath=//div[@class='ant-collapse-header' and @role='button']";
    private static final String OLS_PASSWORD = "Qwer1234";
    private static final String OLD_PASSWORD_FIELD = "xpath=//input[@id='oldPassword']";
    private static final String NEW_PASSWORD = "Qwer1";
    private static final String NEW_PASSWORD_FIELD = "xpath=//input[@id='newPassword']";
    private static final String ERR_MSG = "Password should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20";
    private static final String ERR_MSG_XPATH = "xpath=//div[@class='ant-form-item-explain-error']";
    private static final String ALBUMS_BUTTON_XPATH = "xpath=//div[@class='button-navigation_button__rgNMH ']";
    private static final String ALBUM_LOGO_XPATH = "xpath=//div[@class='albums_container__WP77J']/div[2]";
    private static final String ADD_TOPIC_BUTTON = "xpath=//div[@class='sidebar_crateChannelBtn__U_vp5']";
    private static final String CREATE_TOPIC_DIALOG_TITLE = "Create a new Topic";
    private static final String CREATE_TOPIC_DIALOG_TITLE_XPATH = "xpath=//div[@class='ant-modal-title']";
    private static final String NEW_TOPIC_NAME = "seleniumTest";
    private static final String TOPIC_NAME_FIELD = "xpath=//input[@id='form_in_modal_name']";
    private static final String CREATE_TOPIC_BUTTON = "xpath=//button[@class='ant-btn css-o2xhy3 ant-btn-primary']";
    private static final String SUCCESS_MSG = "Success";
    private static final String SUCCESS_MSG_XPATH = "xpath=//div[contains(text(),'Success')]";
    private static final String TOPIC_TO_DELETE_XPATH = "xpath=//span[contains(.,'seleniumTest')]";
    private static final String TOPIC_INFO_BUTTON = "xpath=//div[contains(text(),'seleniumTest')]/span";
    private static final String DELETE_TOPIC_BUTTON = "xpath=//span[contains(text(),'Delete Channel')]";
    private static final String CONFIRM_MSG_TEXT = "Delete the Topic";
    private static final String CONFIRM_MSG_TEXT_XPATH = "xpath=//div[@class='ant-popconfirm-message-title ant-popconfirm-message-title-only' and contains(text(),'Delete the Topic')]";
    private static final String DELETE_YES_BUTTON = "xpath=//button[@class='ant-btn css-o2xhy3 ant-btn-primary ant-btn-sm']";
    private static final String FIRST_NAME_FIELD_XPATH = "xpath=//input[@id='firstName' and @value='Dm']";
    private static final String LAST_NAME_FIELD_XPATH = "xpath=//input[@id='lastName' and @value='Vl']";
    private static final String LOGOUT_BUTTON = "xpath=//div[@class='profile_logout__egRJU']";

    public void assertCircleName() {
        steps.assertTextPresentedIn(CIRCLE_NAME, CIRCLE_NAME_XPATH);
    }

    public void openUserProfile() {
        steps.clickTo(PROFILE_LOGO_XPATH);
    }

    public void changePassword() {
        steps.clickTo(CHANGE_PASSWORD_BUTON);
        steps.typeIn(OLS_PASSWORD, OLD_PASSWORD_FIELD);
        steps.typeIn(NEW_PASSWORD, NEW_PASSWORD_FIELD);
    }

    public void changePswErrorMessageDispayed() {
        steps.assertTextPresentedIn(ERR_MSG, ERR_MSG_XPATH);
    }

    public void openAlbums() {
        steps.clickTo(ALBUMS_BUTTON_XPATH);
        steps.waitForIsVisible(ALBUM_LOGO_XPATH);
    }

    public void albumIsPresent() {
        steps.assertElementStringPresent(ALBUM_LOGO_XPATH);
    }

    public void createNewTopic() {
        steps.clickTo(ADD_TOPIC_BUTTON);
        steps.assertTextPresentedIn(CREATE_TOPIC_DIALOG_TITLE, CREATE_TOPIC_DIALOG_TITLE_XPATH);
        steps.typeIn(NEW_TOPIC_NAME, TOPIC_NAME_FIELD);
        steps.clickTo(CREATE_TOPIC_BUTTON);
    }

    public void createTopicMessageDisplayed() {
        steps.assertTextPresentedIn(SUCCESS_MSG, SUCCESS_MSG_XPATH);
    }

    public void deleteTpic() {
        steps.clickTo(TOPIC_TO_DELETE_XPATH);
        steps.clickTo(TOPIC_INFO_BUTTON);
        steps.clickTo(DELETE_TOPIC_BUTTON);
    }

    public void confirmationMsgDisplayed() {
        steps.assertTextPresentedIn(CONFIRM_MSG_TEXT, CONFIRM_MSG_TEXT_XPATH);
        steps.clickTo(DELETE_YES_BUTTON);
    }

    public void firstLastNamesConfirmation() {
        steps.assertElementStringPresent(FIRST_NAME_FIELD_XPATH);
        steps.assertElementStringPresent(LAST_NAME_FIELD_XPATH);
    }

    public void userLogsOut() {
        steps.clickTo(LOGOUT_BUTTON);
    }
}
