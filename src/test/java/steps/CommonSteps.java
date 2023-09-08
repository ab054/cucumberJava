package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class CommonSteps {

    private final Duration DEFAULT_WAIT_TIMEOUT = Duration.ofSeconds(25);
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

    @When("type {string} in {string} for {int} times")
    public void typeInForTimes(String value, String target, int times) {
        WebElement foundElement = driver.findElement(getByObject(target));

        for (int i = 0; i < times; i++) {
            foundElement.sendKeys(value);
        }
    }

    private By getByObject(String target) {
        if (target.startsWith("name")) {
            String locatorValue = target.split("=")[1];
            return By.name(locatorValue);
        } else if (target.startsWith("id")) {
            String locatorValue = target.split("=")[1];
            return By.id(locatorValue);
        } else if (target.startsWith("linkText")) {
            String locatorValue = target.split("=")[1];
            return By.linkText(locatorValue);
        } else if (target.startsWith("xpath")) {
            String locatorValue = target.substring(6);
            return By.xpath(locatorValue);
        } else if (target.startsWith("css")) {
            String locatorValue = target.split("=")[1];
            return By.cssSelector(locatorValue);
        }

        return null;
    }

    @And("send key {string} to {string}")
    public void sendKeyTo(String keyParam, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.sendKeys(Keys.valueOf(keyParam));
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("click to {string}")
    public void clickTo(String target) {
        sleep(500);
        WebElement foundElement = driver.findElement(getByObject(target));
        foundElement.click();
    }

    @And("rightClick to {string}")
    public void rightClickTo(String target) {
        Actions action = new Actions(driver);
        WebElement foundElement = driver.findElement(getByObject(target));
        action.contextClick(foundElement).perform();
    }


    @And("click to {string} {int} times")
    public void clickToTimes(String locator, int times) {
        WebElement element = driver.findElement(getByObject(locator));

        for (int i = 0; i < times; i++) {
            element.click();
        }
    }

    @And("wait for {string} is visible")
    public void waitForIsVisible(String target) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
        wait.until(ExpectedConditions.elementToBeClickable(getByObject(target)));
    }

    @When("wait for {string} is visible for {int} millis")
    public void wait_for_is_visible_for_sec(String target, Integer amountOfMillis) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofMillis(amountOfMillis));
        localWait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
        localWait.until(ExpectedConditions.elementToBeClickable(getByObject(target)));
    }

    @Then("assert text {string} presented in {string}")
    public void assertTextPresentedIn(String text, String target) {
        WebElement foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject(target)));
        String elementText = foundElement.getText();
        String message = "Text \"" + text + "\" \nin " + target + " is not presented. \nActual text is \"" + elementText + "\"";
        assertTrue(message, elementText.contains(text));
    }

    @Then("assert element {string} present")
    public void assertElementStringPresent(String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        assertTrue(foundElement.isDisplayed());
    }

    @Then("assert that {string} checked")
    public void assert_that_checked(String locator) {
        WebElement checkbox = driver.findElement(getByObject(locator));
        String isChecked = checkbox.getAttribute("checked");
        assertNotNull(isChecked);
    }

    @And("assert that {string} not checked")
    public void assertThatNotChecked(String locator) {
        WebElement checkbox = driver.findElement(getByObject(locator));
        String isChecked = checkbox.getAttribute("checked");
        assertNull(isChecked);
    }



    @And("checkbox {string} should be selected {string}")
    public void checkboxShouldBeSelected(String locator, String booleanParam) {
        WebElement element = driver.findElement(getByObject(locator));

        if (booleanParam.equalsIgnoreCase("true")) {
            Assert.assertTrue("element was not selected", element.isSelected());
        } else {
            Assert.assertFalse("element was selected", element.isSelected());
        }

    }

    @And("select text {string} in {string} dropdown")
    public void selectTextInDropdown(String visibleText, String locator) {
        WebElement element = driver.findElement(getByObject(locator));
        Select select = new Select(element);

        select.selectByVisibleText(visibleText);
    }

    @Then("option {string} is selected in {string} dropdown")
    public void optionIsSelectedInDropdown(String visibleText, String locator) {
        WebElement element = driver.findElement(getByObject(locator));
        Select select = new Select(element);
        WebElement selected = select.getFirstSelectedOption();
        String selectedText = selected.getText();
        assertEquals(selectedText, visibleText);
    }

    @When("set value of {string} to {string}")
    public void setValueOfTo(String locator, String value) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "document.getElementById('" + locator + "').setAttribute('value', '" + value + "')";
        jse.executeScript(script);
    }

    @When("submit {string} input")
    public void submitInput(String locator) {
        WebElement element = driver.findElement(getByObject(locator));
        element.submit();
    }

    @Then("sleep for {int} seconds")
    public void sleepForSecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
