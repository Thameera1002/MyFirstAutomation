import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {
        singleFrameTest();
    }

    public static void singleFrameTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
        Thread.sleep(2000);
        WebElement singleFrame = driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(singleFrame);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input")).sendKeys("Test");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
}
