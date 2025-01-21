import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouseActionTest {
    public static void main(String[] args) throws InterruptedException {
        keyboardMouseCombinedAction();
    }

    public static void keyboardMouseCombinedAction() throws InterruptedException {
        // Initialize ChromeDriver using WebDriverManager
        WebDriver driver = WebDriverManager.chromedriver().create();

        // Navigate to a drag-and-drop demo site
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        // Locate the source element (item to be dragged)
        WebElement sourceElement = driver.findElement(By.id("draggable"));

        // Locate the target element (drop zone)
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Create an Actions instance
        Actions actions = new Actions(driver);

        // Perform the action: Hold Shift, drag the source element, and drop it onto the target
        actions.keyDown(Keys.SHIFT) // Hold the Shift key
                .clickAndHold(sourceElement) // Click and hold the source element
                .moveToElement(targetElement) // Move to the target element
                .release() // Release the source element
                .keyUp(Keys.SHIFT) // Release the Shift key
                .perform(); // Perform the action
        Thread.sleep(2000);
        // Verify the success message after dropping
        String dropText = targetElement.getText();
        assert dropText.contains("Dropped!") : "Drag and drop failed!";

        // Close the browser
        driver.quit();
    }
}