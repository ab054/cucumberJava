package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.CommonTools;

public class ResultsPage extends BasePage {

    By resultsById = By.id("result-stats");

    public void waitForElement(By elementToWait) {
        wait.forElementToBeDisplayed(10, elementToWait,  "resultsById");
    }

    public int getNumberOfResults() {
        waitForElement(resultsById);

        WebElement statsElement = driver.findElement(resultsById);
        return CommonTools.parseResults(statsElement);
    }
}
