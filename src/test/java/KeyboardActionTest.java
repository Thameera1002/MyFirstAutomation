import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyboardActionTest {
    public static void main(String[] args) throws InterruptedException {
        copyPastAction();
    }

    public static void copyPastAction() throws InterruptedException {
        // Initialize ChromeDriver
        // Here we assume that the ChromeDriver path has been set in the System Global variables
        WebDriver driver = WebDriverManager.chromedriver().create();

        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");
        Thread.sleep(2000);
        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");
        Thread.sleep(2000);
        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");
        Thread.sleep(2000);
        // Copy the Current Address
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL,"c"));

        //Press the TAB Key to Switch Focus to Permanent Address
//       currentAddress.sendKeys(Keys.TAB);
        driver.findElement(By.id("permanentAddress")).click();
        //Paste the Address in the Permanent Address field
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(Keys.chord(Keys.CONTROL,"v"));
        Thread.sleep(2000);
        //Compare Text of current Address and Permanent Address
        //assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));

        driver.close();

    }
}