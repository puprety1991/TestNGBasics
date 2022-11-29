package com.syntax.class01;

import org.testng.annotations.*;

public class testNGAnnotations {
    // first test case
    @Test
    public void AFirstTestCase(){
        System.out.println("I am first test case");
    }
    @Test
    public void BSecondTestCase(){
        System.out.println("I am second test case");
    }
    @Test
    public void ThirdTestCase(){
        System.out.println("I am third test case");
    }
    @Test
    public void FourthTestCase(){
        System.out.println("I am fourth test case");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }


}

