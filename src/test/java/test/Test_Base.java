package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

public class Test_Base {
    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");                       // Use headless mode
            options.addArguments("--no-sandbox");                         // Needed for CI
            options.addArguments("--disable-dev-shm-usage");              // Fix for memory issue
            options.addArguments("--disable-gpu");                        // Optional but safe
            options.addArguments("--remote-allow-origins=*");            // Required for Chrome v111+
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-headless");                            // Use headless mode
            driver = new FirefoxDriver(options);
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://sm.wonderfulpebble-47b0ec53.westus2.azurecontainerapps.io/html/index.html");
    }

    @AfterMethod
    public void close_chrome() throws InterruptedException {
        Thread.sleep(5000);  // Optional delay for debugging
        driver.quit();
    }
}
