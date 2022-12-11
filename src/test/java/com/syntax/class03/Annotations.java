package com.syntax.class03;

import org.testng.annotations.*;

public class Annotations {
   /* @BeforeTest
    public void BeforeTest(){
        System.out.println("I am Before Test");
    }*/

    @BeforeClass
    public void BeforeClass(){
        System.out.println("I am Before Class");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("I am Before Method");
    }
    @Test
    public void AFirstTest(){
        System.out.println("I am A 1 Test");
    }
    @Test
    public void BSecondTest(){
        System.out.println("I am B 2 Test");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("I am After Method");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("I am After Class");
    }
  /*  @AfterTest
    public void AfterTest(){
        System.out.println("I am After Test");
    }*/

}
