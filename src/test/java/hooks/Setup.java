package hooks;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() {
        setSystemPaths();
        initBrowser();
    }

    private void initBrowser() {
        String browser = System.getProperty("browser");
        if (browser == null) browser = "chrome";

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }

    private void setSystemPaths() {
        String os = System.getProperty("os.name");

        if (os.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/macos/m1/chromedriver98");
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/macos/m1/geckodriverAarch64");
        }

        if (os.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/win/geckodriver.exe");
        }

    }
}
