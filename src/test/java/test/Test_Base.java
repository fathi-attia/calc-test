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
    @BeforeClass
    public void setup(@Optional("chrome") String browserName) {
        // ✅ قراءة القيمة المرسلة من GitHub Actions أو الجهاز
        String envProfile = System.getProperty("envProfile", "local");
        System.out.println(" Running with envProfile = " + envProfile);

        // ✅ التحقق لو بيئة CI، شغّل المتصفح في headless mode
        boolean isHeadless = envProfile.equalsIgnoreCase("ci");

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("-headless");
            }
            driver = new FirefoxDriver(options);
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://sm.wonderfulpebble-47b0ec53.westus2.azurecontainerapps.io/html/index.html");
    }

    @AfterClass
    public void close_chrome() throws InterruptedException {
        Thread.sleep(5000);  // Optional delay for debugging
        driver.quit();
    }
}
