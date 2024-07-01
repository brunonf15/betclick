package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object class for interacting with elements on the Betclic homepage.
 */
public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     * @param driver The WebDriver instance to use for interactions.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clicks on the "Accept cookies" button after it becomes clickable.
     */
    public void acceptCookies() {
        WebElement acceptCookiesButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.id("popin_tc_privacy_button_2")));
        acceptCookiesButton.click();
    }

    /**
     * Clicks on the football tab specified by the sport name.
     * @param sport The name of the sport tab to click.
     */
    public void clickFootball(String sport) {
        WebElement footballElement = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='list_itemTitle'][normalize-space()='" + sport + "']")));
        footballElement.click();
    }

    /**
     * Checks if the current URL contains "brasil-serie-a".
     * @return True if the URL contains "brasil-serie-a", false otherwise.
     */
    public boolean isOnBrasilSerieAUrl() {
        wait.until(ExpectedConditions.urlContains("brasil-serie-a"));
        return driver.getCurrentUrl().contains("brasil-serie-a");
    }

    /**
     * Checks if the specified element containing text is visible.
     * @param element The text of the element to check visibility for.
     * @return True if the element is visible, false otherwise.
     */
    public boolean isTodaAOfertaVisible(String element) {
        WebElement todaAOfertaElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + element + "')]")));
        return todaAOfertaElement.isDisplayed();
    }

    /**
     * Clicks on the "Desafios" (Challenges) tab.
     */
    public void clickDesafios() {
        WebElement desafiosTab = driver.findElement(By.xpath("//span[@class='tab_label' and text()='Desafios']"));
        desafiosTab.click();
    }

    /**
     * Checks if the current URL contains "missions".
     * @return True if the URL contains "missions", false otherwise.
     */
    public boolean isOnMissionsUrl() {
        return driver.getCurrentUrl().contains("missions");
    }

    /**
     * Clicks on the "Aceder" (Access) button after it becomes clickable.
     */
    public void clickAceder() {
        WebElement accessButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-qa='empty-view-btn-label']")));
        accessButton.click();
    }

    /**
     * Checks if the current URL contains "login".
     * @return True if the URL contains "login", false otherwise.
     */
    public boolean isOnLoginUrl() {
        wait.until(ExpectedConditions.urlContains("login"));
        return driver.getCurrentUrl().contains("login");
    }
}
