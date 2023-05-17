package hooks;

import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() {
        initBrowser();
    }

    private void initBrowser() {
        String browser = System.getProperty("browser");
        if (browser == null) browser = "firefox";

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-network-throttling");
                options.addArguments("--blink-settings=imagesEnabled=false");
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-debugging-port=9222");
                options.addArguments("--disable-features=NetworkService");
                options.addArguments("--dns-prefetch-disable");
                options.addArguments("--disable-extensions");
                //options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
}
