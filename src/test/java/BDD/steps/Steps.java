package BDD.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Config.ConfigureBrowsers;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for BDD scenarios related to navigating the Betclic website.
 */
public class Steps {

    WebDriver driver;
    HomePage homePage;

    /**
     * Step to initialize Selenium WebDriver based on the specified browser.
     * @param browser The name of the browser to use for testing.
     */
    @Given("I am using Selenium on {string}")
    public void i_am_using_selenium_on(String browser) {
        driver = ConfigureBrowsers.startBrowser(browser);
        homePage = new HomePage(driver);
    }

    /**
     * Step to navigate to the Betclic homepage and accept cookies.
     */
    @And("I am on the Betclic homepage")
    public void i_am_at_lgc_login_page() {
        driver.get("https://www.betclic.pt");
        homePage.acceptCookies();
    }

    /**
     * Step to click on a specific sport tab.
     * @param Sport The name of the sport tab to click.
     */
    @When("I click on the {string} tab")
    public void i_click_on_the_tab(String Sport) {
        homePage.clickFootball(Sport);
    }

    /**
     * Step to verify that a specific element (tab) has loaded without errors.
     * @param Element The name of the element (tab) to verify.
     */
    @Then("the {string} tab should load without errors")
    public void the_the_tab_should_load_without_errors(String Element) {
        Assert.assertTrue(homePage.isTodaAOfertaVisible(Element));
    }

    /**
     * Hook to close the browser after each scenario.
     */
    @After
    public void fecharBrowser() {
        ConfigureBrowsers.closeBrowser();
    }

    /**
     * Step to select a specific league after clicking on a sport tab.
     * @param Element The name of the league to select.
     */
    @And("I select the {string} league")
    public void i_select_the(String Element) {
        homePage.clickFootball(Element);
    }

    /**
     * Step to verify that the browser is on the correct URL for a specific league.
     * @param string Placeholder for the league name in the URL assertion.
     */
    @Then("I should be on the {string} URL")
    public void i_will_be_on_url(String string) {
        boolean isOnBrasilSerieA = homePage.isOnBrasilSerieAUrl();
        Assert.assertTrue("URL does not contain 'brasil-serie-a'", isOnBrasilSerieA);
    }

    /**
     * Step to click on the "Challenges" tab.
     * @param string Placeholder for the "Challenges" tab in the step.
     */
    @And("I click on {string}")
    public void i_click_on(String string) {
        homePage.clickDesafios();
    }

    /**
     * Step to click on the "Aceder" button.
     * @param string Placeholder for the "Aceder" button in the step.
     */
    @And("I click on the {string} button")
    public void i_click_on_button(String string) {
        homePage.clickAceder();
    }

    /**
     * Step to verify that the browser has been redirected to the login page.
     */
    @Then("I should be redirected to the login page")
    public void i_should_be_on_login_page() {
        boolean isOnLoginUrl = homePage.isOnLoginUrl();
        Assert.assertTrue("URL does not contain 'login'", isOnLoginUrl);
    }

}
