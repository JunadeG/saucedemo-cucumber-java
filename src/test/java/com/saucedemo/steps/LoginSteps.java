package com.saucedemo.steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the SauceDemo login page")
    public void navigateToLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }



    @When("the user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        // TODO: Find the username field (id="user-name") and type the 'username' variable
        WebElement user1 = driver.findElement(By.id("user-name"));
        user1.sendKeys(username);

        // TODO: Find the password field (id="password") and type the 'password' variable
        WebElement userpass = driver.findElement(By.id("password"));
        userpass.sendKeys(password);


    }

    @And("clicks the login button")
    public void clickLogin() {
        // TODO: Find the login button (id="login-button") and click it
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();
    }

    @Then("the user should be redirected to the inventory page")
    public void verifyLogin() {
        // This is a simple check: if login worked, the URL changes
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));
        driver.quit();

    }

    @Then("an error message containing {string} should be dispalyed")
    public void verifyErrorMessage(String expectedMessage){
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container h3"));
        String actualMessage = errorElement.getText();
        Assert.assertTrue("Error message did not match!" , actualMessage.contains(expectedMessage));
        driver.quit();
    }


    @And("clicks the {string} to the cart")
    public void clickItem(String productName){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    }

    @Then("the cart badge should show {string} item")
    public void verifyCartCount(String expectedCount){
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        String actualCount = badge.getText();
        Assert.assertEquals(expectedCount, actualCount);
        driver.quit();
    }
}