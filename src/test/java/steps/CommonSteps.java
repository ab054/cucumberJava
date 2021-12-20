package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CommonSteps {

    private final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(5);
    WebDriverWait wait;
    WebDriver driver;

    public CommonSteps() {
        driver = Setup.driver;
        wait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT);
    }

    @Given("open {string}")
    public void open(String address) {
        driver.get(address);
    }

    @Then("type {string} in {string}")
    public void typeIn(String value, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.sendKeys(value);
    }

    private By getByObject(String target) {
        if (target.startsWith("name")) {
            String locatorValue = target.split("=")[1];
            return By.name(locatorValue);
        } else if (target.startsWith("id")) {
            String locatorValue = target.split("=")[1];
            return By.id(locatorValue);
        }

        return null;
    }

    @And("send key {string} to {string}")
    public void sendKeyTo(String keyParam, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.sendKeys(Keys.valueOf(keyParam));
    }

    @Then("assert element {string} present")
    public void assertElementPresent(String locator) {
        WebElement foundElement = driver.findElement(getByObject(locator));
        assert (foundElement.isDisplayed());
    }

    @And("wait for {string} is visible")
    public void waitForIsVisible(String target) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
    }

    @Then("assert text {string} presented in {string}")
    public void assertTextPresentedIn(String text, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        String elementText = foundElement.getText();

        String message = "Text \"" + text + "\" \nin " + target + " is not presented. \nActual text is \"" + elementText + "\"";
        assertTrue(message, elementText.contains(text));
    }

}
