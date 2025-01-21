package testng;

import org.testng.annotations.*;

public class TestNGAnnotationTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I'm BeforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I'm BeforeTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I'm BeforeClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I'm BeforeMethod");
    }
    @Test(priority = 2)
    public void test1(){
        System.out.println("I'm Test Method 1");
    }
    @Test(priority = 1)
    public void test2(){
        System.out.println("I'm Test Method 2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I'm AfterMethod");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I'm AfterClass");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I'm AfterTest");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I'm AfterSuite");
    }

}
