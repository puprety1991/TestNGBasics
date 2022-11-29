package com.syntax.class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssertions {
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebSite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test(groups = "regression")
    public void invalidCredentials(){
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm12322");
        WebElement logIn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        logIn.click();
        WebElement errorMsg = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String actualErrorMsg = errorMsg.getText();
        String expectedErrorMsg="Invalid credential";
    // if we want to use soft Assertion we call it from the class SoftAssert by declaring an instance
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualErrorMsg,expectedErrorMsg);
    // check if the webElement error message isDisplayed
        boolean displayed = errorMsg.isDisplayed();
    //Assertion
        soft.assertTrue(displayed);
        System.out.println(displayed);

        // assert all the assertions that have been made
        soft.assertAll();
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
