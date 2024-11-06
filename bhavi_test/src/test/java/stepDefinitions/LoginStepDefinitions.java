package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
    }

    @When("User enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
    }

    @When("User does not enter any credentials")
    public void user_does_not_enter_any_credentials() {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        driver.findElement(By.id("signInBtn")).click();
    }

    @Then("User should be navigated to the next page")
    public void user_should_be_navigated_to_the_next_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("angularpractice/shop"));
        Assert.assertTrue(driver.getCurrentUrl().contains("angularpractice/shop"), "User was not navigated to the next page.");
        driver.quit();
    }


    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.cssSelector("div.alert-danger"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed as expected.");
        Assert.assertEquals(errorMessage.getText().trim(), expectedMessage);
        driver.quit();
    }
}
