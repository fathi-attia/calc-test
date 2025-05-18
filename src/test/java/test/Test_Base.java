package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_Base {
    WebDriver driver;
    static ExtentReports extent;
    static ExtentTest testLogger;

    @BeforeSuite
    @Parameters("browser")
    public void setupextentReport(@Optional("chrome") String browsername) {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", browsername);
        extent.setSystemInfo("Version", "1.0");
        extent.setSystemInfo("Author", "Your Name");
    }

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browserName) throws MalformedURLException {
        String envProfile = System.getProperty("envProfile", "local");
        System.out.println("Running with envProfile = " + envProfile);
        boolean isHeadless = envProfile.equalsIgnoreCase("ci");

        if (envProfile.equalsIgnoreCase("docker")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);
            } else {
                throw new IllegalArgumentException("Unsupported browser for Docker: " + browserName);
            }
        } else {
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
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
            }
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://sm.wonderfulpebble-47b0ec53.westus2.azurecontainerapps.io/html/index.html");
    }

    @AfterClass
    public void close_chrome() throws InterruptedException {
        Thread.sleep(5000);  // Optional delay for debugging
        driver.quit();
    }

    @AfterSuite
    public void flushExtentReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
