package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGParellelTest {
    long startTime;

    @BeforeClass
    public void beforeClass() {
        startTime = System.currentTimeMillis();
    }

    @AfterClass
    public void afterClass() {
        long endTime = System.currentTimeMillis()-startTime;
        System.out.println("Execution time: "+endTime);
    }

    @Test
    public void method1() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            System.out.println("Method 01 : "+i);
        }
    }

    @Test
    public void method2() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Method 02 : "+i);
        }
    }

    @Test
    public void method3() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1500);
            System.out.println("Method 03 : "+i);
        }
    }

    @Test
    public void method4() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2500);
            System.out.println("Method 04 : "+i);
        }
    }

    @Test
    public void method5() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            System.out.println("Method 05 : "+i);
        }
    }
}
