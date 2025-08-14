
package ecommerceSeleniumProject;


// Import necessary Selenium and TestNG libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.io.File;

public class BaseTest2 {

    // Declare a WebDriver instance that will be used by all test classes
    public WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        
        String driverPath = "/Users/namita.sharma.leeds.uk/Downloads/chromedriver-mac-arm64/chromedriver"; 
        File driverFile = new File(driverPath);

        System.out.println("step1: Using chromedriver at: " + driverPath);
        if (!driverFile.exists() || !driverFile.canExecute()) {
            throw new IllegalStateException("The chromedriver executable does not exist or is not executable at path: " + driverPath);
        }
        
        System.setProperty("webdriver.chrome.driver", driverPath);
        System.out.println("step2: ChromeDriver system property set successfully.");
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        // Initialize the Chrome browser and maximize the window
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the specified application URL
        driver.get("http://localhost:80/ATE_PEP2_Testing_Using_TestNG/");

        // Delete all cookies to ensure a clean session for each test
        driver.manage().deleteAllCookies();

        // Set a timeout for page loads to prevent tests from running indefinitely
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    // This method will run after each test method
    @AfterMethod
    public void closeBrowser() {
        // Check if the driver instance is not null before quitting the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

