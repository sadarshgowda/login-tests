package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.base.BaseTestCase;
import util.base.ConfigReader;
import util.base.Constants;

import java.util.concurrent.TimeUnit;

public class LoginWebPage extends BaseTestCase {
    private String baseUrl = ConfigReader.getProperty(Constants.BASE_URL);
    private String loginPageUrl = ConfigReader.getProperty(Constants.LOGIN_PAGE_URL);
    private String webDriver = ConfigReader.getProperty(Constants.WEB_DRIVER);
    private String validUsername = ConfigReader.getProperty(Constants.VALID_USERNAME);
    private String validPassword = ConfigReader.getProperty(Constants.VALID_PASSWORD);
    private String inValidUsername = ConfigReader.getProperty(Constants.INVALID_USERNAME);
    private String inValidPassword = ConfigReader.getProperty(Constants.INVALID_PASSWORD);
    private String loginSuccessPageUrl = ConfigReader.getProperty(Constants.LOGIN_SUCCESS_PAGE_URL);


    @Test(priority = 0, description = "checking login functionality with valid username and password")
    public void loginWithValidCredentials() throws InterruptedException {

        //Initializing the web driver configurations
        System.setProperty("webdriver.chrome.driver", webDriver);

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(baseUrl);

        //Finding the login page

        WebElement click = driver.findElement(By.name("Practo login"));
        click.click();

        TimeUnit.SECONDS.sleep(1);

        //Asserting the resultant signin page with expected page

        Assert.assertEquals(loginPageUrl,driver.getCurrentUrl());
        driver.get(loginPageUrl);

        //Finding the username  web element and sending username

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(validUsername);

        //Finding the password web element and sending username

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(validPassword);

        //Finding the submit button and clicking on it

        WebElement submit = driver.findElement(By.id("login"));
        submit.click();

        TimeUnit.SECONDS.sleep(2);

        //Asserting the resultant login page with expected page

        Assert.assertEquals(loginSuccessPageUrl, driver.getCurrentUrl());

        driver.quit();
    }


    @Test(priority = 1, description = "checking login functionality with invalid username and valid password")
    public void loginWithInValidUsername() throws InterruptedException {

        //Initializing the web driver configurations
        System.setProperty("webdriver.chrome.driver", webDriver);

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(baseUrl);

        //Finding the login page

        WebElement click = driver.findElement(By.name("Practo login"));
        click.click();

        TimeUnit.SECONDS.sleep(1);

        //Asserting the resultant signin page with expected page

        Assert.assertEquals(loginPageUrl,driver.getCurrentUrl());
        driver.get(loginPageUrl);

        //Finding the username  web element and sending username

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(inValidUsername);

        //Finding the password web element and sending username

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(validPassword);

        //Finding the submit button and clicking on it

        WebElement submit = driver.findElement(By.id("login"));
        submit.click();

        TimeUnit.SECONDS.sleep(2);

        //Asserting the resultant login page with expected page

        Assert.assertNotEquals(loginSuccessPageUrl, driver.getCurrentUrl());

        driver.quit();

    }



    @Test(priority = 2, description = "checking login functionality with valid username and invalid password")
    public void loginWithInValidPassword() throws InterruptedException {

        //Initializing the web driver configurations
        System.setProperty("webdriver.chrome.driver", webDriver);

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(baseUrl);

        //Finding the login page

        WebElement click = driver.findElement(By.name("Practo login"));
        click.click();

        TimeUnit.SECONDS.sleep(1);

        //Asserting the resultant signin page with expected page

        Assert.assertEquals(loginPageUrl,driver.getCurrentUrl());
        driver.get(loginPageUrl);

        //Finding the username  web element and sending username

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(validUsername);

        //Finding the password web element and sending username

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(inValidPassword);

        //Finding the submit button and clicking on it

        WebElement submit = driver.findElement(By.id("login"));
        submit.click();

        TimeUnit.SECONDS.sleep(2);

        //Asserting the resultant login page with expected page

        Assert.assertNotEquals(loginSuccessPageUrl, driver.getCurrentUrl());

        driver.quit();

    }

}
