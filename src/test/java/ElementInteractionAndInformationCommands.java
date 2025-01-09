import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementInteractionAndInformationCommands {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();
        String url = "https://www.ebay.com/";
        driver.get(url);

        System.out.println(driver.findElement(By.xpath("//input[@id='gh-ac']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//input[@id='gh-ac']")).isEnabled());
        driver.findElement(By.xpath("//input[@id='gh-ac']")).click();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Iphone");
        driver.findElement(By.cssSelector("#gh-btn")).click();
        Thread.sleep(2000);

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//div[text()='Shipping and pickup']/../following-sibling::div/ul/li/div"));
        for (WebElement checkBox : checkBoxList) {
            if(checkBox.getAttribute("class").contains("disabled")){
                System.out.println(checkBox.getAttribute("class"));
                break;
            }
        }

        List<WebElement> titles = driver.findElements(By.cssSelector("[class='s-item__title'] [role='heading']"));
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(titles.get(i).getText());
            if(titles.get(i).getText().equalsIgnoreCase("Apple iPhone 5s. 16gb")) {
                titles.get(i).click();
                break;
            }
        }
    }
}
