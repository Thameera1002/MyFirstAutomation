import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayDemo {
    public static void main(String[] args) throws InterruptedException {
        //WebDriver driver = WebDriverManager.chromedriver().create();
        WebDriver driver = WebDriverManager.chromedriver().create();
//        Thread.sleep(2000);
        driver.manage().window().maximize();
        String url = "https://www.ebay.com/";

//       Opens the specified URL in the browser
        driver.get(url);

//        Retrieves the current URL
        String currentUrl = driver.getCurrentUrl();

//        Gets the page title
        String currentTitle = driver.getTitle();

        //verification
        if (currentUrl.contains(url) && currentTitle.contains("eBay") ) {
            System.out.println(currentUrl +" : "+currentTitle);
        }




        driver.findElement(By.xpath("//input[@id='gh-ac']")).click();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Iphone");

        Select selectCategory = new Select(driver.findElement(By.id("gh-cat")));
        selectCategory.selectByVisibleText("Cell Phones & Accessories");

        driver.findElement(By.cssSelector("#gh-btn")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Apple iPhone 11']")).click();
        Thread.sleep(3000);


    }
}
