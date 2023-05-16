package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class MainPage extends BasePage {

    By searchInput = By.name("q");

    public void open() {
        driver.get("https://google.com/");
    }

    public void typeQueryAndSubmit(String queryText) {
        wait.forPresenceOfElements(10, searchInput, "search input");
        WebElement textInput = driver.findElement(searchInput);
        textInput.sendKeys(queryText);

        textInput.submit();
    }

}
