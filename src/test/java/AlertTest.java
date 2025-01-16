import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        //alertWithOK();
        alertWithOKAndCancel();

    }

    public static void alertWithOK() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='active']/a[contains(text(),'Alert with OK ')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='btn btn-danger']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.quit();
    }

    public static void alertWithOKAndCancel() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("demo")).getText());
        driver.quit();
    }

    public static void alertWithTextBox() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        Thread.sleep(2000);
        //you need to change this locator
        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        Thread.sleep(2000);
        //you need to change this locator
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        Thread.sleep(2000);

        System.out.println(driver.switchTo().alert().getText());
        //you need to send the value here
        driver.switchTo().alert().sendKeys("");
        System.out.println(driver.findElement(By.id("demo1")).getText());
        driver.quit();
    }


}
