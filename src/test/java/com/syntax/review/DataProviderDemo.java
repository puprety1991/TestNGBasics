package com.syntax.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {
    @DataProvider
    public Object[][] loginData(){
        Object[][] login = new Object[4][2];
        login[0][0] = "admin";
        login[0][1] = "Hum@nhrm123";
        login[1][0] = "admin4";
        login[1][1] = "Hum@nhrm4123";
        login[2][0] = "admin3";
        login[2][1] = "Hum@nhrm1243";
        login[3][0] = "admin";
        login[3][1] = "Hum@nhrm123";
        return login;
    }

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginData")
    public void invalidCredentials(String username, String password) {
        //username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys(username);
//        password
        WebElement passWord = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        passWord.sendKeys(password);
//        login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

        WebElement welcomeMsg = driver.findElement(By.id("welcome"));
        Assert.assertTrue(welcomeMsg.isDisplayed());

    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}
