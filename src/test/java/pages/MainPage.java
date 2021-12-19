package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    By searchInput = By.name("q");

    public void navigate() {
        driver.get("https://google.com/");
    }

    public void typeQueryAndSubmit(String queryText) {
        WebElement textInput = driver.findElement(searchInput);
        textInput.sendKeys(queryText);
        textInput.submit();
    }

}
