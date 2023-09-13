package pages;

import hooks.Setup;
import hooks.Wait;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public CommonSteps steps;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
        this.steps = new CommonSteps();
    }

}
