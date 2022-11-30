package com.syntax.class03;

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

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class dataProvider {
    //    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credential"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be emptiee"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be emptiess"
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebSite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @DataProvider(name = "credentials")
    public Object[][] data(){
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credential"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be emptyiee"},
                {"", "Hum@nhrm123", "Username cannot be emptiess"}
        };
        return loginData;
    }
    @Test(dataProvider = "credentials")
    public void LoginWithInvalidCredentials(String userName, String Password, String ExpectedErrorMsg){
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys(userName);
        WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passWord.sendKeys(Password);
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualError = errorMsg.getText();
        Assert.assertEquals(actualError,ExpectedErrorMsg);

    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}


