package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
public class Test_Base {
    WebDriver driver;



    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }



        driver.manage().window().maximize();
        driver.navigate().to("https://sm.wonderfulpebble-47b0ec53.westus2.azurecontainerapps.io/html/index.html");
    }
  /*  public void open_chrome() {
        driver = new ChromeDriver();                         // Launch Chrome browser
        driver.manage().window().maximize();                 // Maximize browser window
        driver.navigate().to("https://automationexercise.com"); // Open target URL
    }*/

    @AfterMethod
    public void close_chrome() throws InterruptedException {
        Thread.sleep(5000);                                  // Wait for 5 seconds
        driver.quit();                                       // Close the browser
    }
}
