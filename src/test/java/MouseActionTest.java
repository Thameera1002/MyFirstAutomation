import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseActionTest {

    public static void main(String[] args) throws InterruptedException {
        testDoubleClickAction();
        testMouseHover();
        testContextClickAction();
        testSliderAction();
        
    }

    public static void testDoubleClickAction() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://unixpapa.com/js/testmouse.html");
        WebElement clickHereToTest = driver.findElement(By.linkText("click here to test"));
        Actions actions = new Actions(driver);
        actions.doubleClick(clickHereToTest).build().perform();

        WebElement textarea = driver.findElement(By.tagName("textarea"));
        String value = textarea.getAttribute("value");
        System.out.println(value);
    }

    public static void testContextClickAction() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/context-menu");
        WebElement contextClickBox = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextClickBox).build().perform();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        //assertEquals(alertText, "You selected a context menu");
        alert.accept();
        Thread.sleep(2000);
    }


    public static void testSliderAction() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        WebElement slider = driver.findElement(By.cssSelector("input[type='range'][value='5']"));
        Thread.sleep(2000);
        Point point = slider.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
        System.out.println("x: " + xcord);
        System.out.println("y: " + ycord);

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(-145,0).release().build().perform();
        Thread.sleep(2000);
        String outputResult = driver.findElement(By.cssSelector("output#range")).getText();
        Thread.sleep(2000);
        System.out.println(outputResult);
        //assertEquals(outputResult, "20");

    }


    public static void testMouseHover() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
        WebElement myAccountLink = driver.findElement(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink).build().perform();
        Thread.sleep(4000);
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();
        Thread.sleep(2000);
        List<WebElement> pageHeaders = driver.findElements(By.tagName("h2"));
        String loginHeader = pageHeaders.get(1).getText();
        Thread.sleep(2000);
        System.out.println(loginHeader);
        //assertEquals(loginHeader, "Returning Customer");

    }

}
