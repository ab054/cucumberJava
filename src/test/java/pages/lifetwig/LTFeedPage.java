package pages.lifetwig;

import pages.BasePage;

public class LTFeedPage extends BasePage {
    private static final String USER_PROFILE = "xpath=//a[contains(@href, '/user-profile')]";

    public void assertThatOpened() {
        steps.assertElementPresent(USER_PROFILE);
    }
}
