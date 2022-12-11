package com.syntax.review;

import org.testng.annotations.DataProvider;

import java.util.Objects;

public class AnotherDataProviderDemo {
    @DataProvider(name = "loginData")
    public Object[][] data(){
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credential"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be emptyiee"},
                {"", "Hum@nhrm123", "Username cannot be emptiess"}
        };
        return loginData;
    }
    
}
