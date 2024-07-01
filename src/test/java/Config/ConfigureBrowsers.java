package Config;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Class to configure and manage WebDriver instances for different browsers.
 */
public class ConfigureBrowsers {

    public static WebDriver driver;

    /**
     * Starts the specified browser and returns the WebDriver instance.
     * @param browserName The name of the browser to start ("chrome", "firefox", "edge", "safari").
     * @return WebDriver instance for the started browser.
     * @throws IllegalArgumentException if an unsupported browser name is provided.
     */
    public static WebDriver startBrowser(String browserName) {
        WebDriverManager.chromedriver().setup();

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        return driver;
    }

    /**
     * Closes the WebDriver instance if it is not null.
     */
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
