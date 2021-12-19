package tools;

import org.openqa.selenium.WebElement;

public class CommonTools {

    public static int extractInteger(String stringValue) {
        String[] array = stringValue.split(" ");
        String numberOfResults = array[1];
        String replacedComma = numberOfResults.replace(",", "");
        int parsedInteger = Integer.parseInt(replacedComma);

        return parsedInteger;
    }

    public static int parseResults(WebElement element) {
        String elementText = element.getText();
        return extractInteger(elementText);
    }
}
