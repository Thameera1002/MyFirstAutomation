import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ChainedActionWithCallback {

    public static void main(String[] args) throws InterruptedException {
        chainedActionWithCallback();
    }

    public static void chainedActionWithCallback() throws InterruptedException {
        // Initialize ChromeDriver using WebDriverManager
        WebDriver driver = WebDriverManager.chromedriver().create();

        // Navigate to demo site
        driver.get("https://demoqa.com/menu");
        driver.manage().window().maximize();

        // Locate the main menu item
        WebElement mainMenu = driver.findElement(By.xpath("//a[text()='Main Item 2']"));

        // Locate the submenu item
        WebElement subMenu = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));

        // Locate the sub-submenu item
        WebElement subSubMenuItem = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));

        // Create an Actions instance
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        // Chaining the actions with a callback-style approach using a custom method
        performActionWithCallback(actions, mainMenu, subMenu, subSubMenuItem);
        Thread.sleep(2000);
        // Close the browser
        driver.quit();
    }

    private static void performActionWithCallback(Actions actions, WebElement mainMenu, WebElement subMenu, WebElement subSubMenuItem) {
        actions.moveToElement(mainMenu) // Hover over "Main Item 2"
                .moveToElement(subMenu)  // Move to "SUB SUB LIST"
                .moveToElement(subSubMenuItem) // Move to "Sub Sub Item 1"
                .click() // Click "Sub Sub Item 1"
                .perform(); // Perform the action

        // Callback-style execution after the action is performed
        // In a typical scenario, this could be verifying the action or interacting with another element.
        onActionPerformed();
    }

    private static void onActionPerformed() {
        System.out.println("Chained action performed successfully!");
        // You could also add any additional verification or interaction here
    }
}