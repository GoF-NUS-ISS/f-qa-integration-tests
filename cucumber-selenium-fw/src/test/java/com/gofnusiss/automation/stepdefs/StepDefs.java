package com.gofnusiss.automation.stepdefs;

import com.gofnusiss.automation.pageobjects.CmnPageObjects;
import com.gofnusiss.automation.core.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class StepDefs {

    private static final Logger logger = LogManager.getLogger(StepDefs.class);
    WebDriver driver;
    String base_url = System.getProperty("base_url");
    int implicit_wait_timeout_in_sec = 60;
    Scenario scn;
    CmnPageObjects cmnPageObjects;

    @Before
    public void setUp(Scenario scn) throws Exception {
        this.scn = scn;
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        logger.info("Browser invoked.");
        cmnPageObjects = new CmnPageObjects(driver);
    }

    @After(order=1)
    public void cleanUp(){
        WebDriverFactory.quitDriver();
        scn.log("Browser Closed");
    }

    @After(order=2)
    public void takeScreenShot(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }

    @Given("User navigated to the home application url")
    public void user_navigated_to_the_home_application_url() {
        WebDriverFactory.navigateToTheUrl(base_url);
        scn.log("Browser navigated to URL: " + base_url);

        String expected = "TravelPlannerProject";
        cmnPageObjects.validatePageTitleMatch(expected);
    }

    @When("User enter username")
    public void user_enter_username() {
        cmnPageObjects.enterTextInEmailTextBox(System.getProperty("username"));
    }

    @When("User enter password")
    public void user_enter_password() {
        cmnPageObjects.enterTextInPasswordTextBox(System.getProperty("password"));
    }

    @When("User click on Sign Button")
    public void user_click_on_sign_button() {
        cmnPageObjects.clickSignInButton();
    }

    @Then("User is able to login in to the Application")
    public void user_is_able_to_login_in_to_the_application() {
        cmnPageObjects.validatePublishButtonIsDisplayed();
    }

    @When("User enter wrong username")
    public void user_enter_wrong_username() {
        cmnPageObjects.enterTextInEmailTextBox("wrongusername");
    }

    @When("User enter wrong password")
    public void user_enter_wrong_password() {
        cmnPageObjects.enterTextInPasswordTextBox("wrongpassword");
    }

    @Then("User is not logged in and application displayes error message as {string}")
    public void user_is_not_logged_in_and_application_displayes_error_message_as(String string) {
        cmnPageObjects.validateTextUserDoesNotExistIsDisplayed();
    }

    @When("User click on {string} Link")
    public void user_click_on_link(String string) {
        WebDriverWait wait  = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create a Plan")));
        element.click();
        scn.log("Clicked on Create new Plan Link.");
    }

    @When("User fill the form with below details")
    public void user_fill_the_form_with_below_details(Map<String,String> data) {
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
//        driver.findElement(By.id("titleId")).sendKeys(data.get("TITLE"));
    }

    @Then("User plan is created")
    public void user_plan_is_created() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("User Plan is displayed under {string} Plan Page")
    public void user_plan_is_displayed_under_plan_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }


}
