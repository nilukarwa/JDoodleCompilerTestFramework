package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import Pages.HomePage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.function.Supplier;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Properties properties;

    private static final Map<String, Supplier<WebDriver>> DRIVER_SUPPLIERS = Map.of(
            "chrome", ChromeDriver::new,
            "firefox", FirefoxDriver::new,
            "ie", InternetExplorerDriver::new,
            "edge", EdgeDriver::new,
            "safari", SafariDriver::new
    );

    @BeforeClass
    public void setUp() throws IOException {
        properties = new Properties();
        String path = properties.getProperty("path");
        FileInputStream input = new FileInputStream(path);
        properties.load(input);

        // Get the browser type from the properties file
        String browserType = properties.getProperty("browser");
        boolean headlessMode = Boolean.parseBoolean(properties.getProperty("headlessMode", "false"));

        // Use WebDriverManager to manage browser drivers
        driver = DRIVER_SUPPLIERS.get(browserType.toLowerCase())
                .get();

        applyCommonOptions(headlessMode);

        homePage = new HomePage(driver, properties);
    }

    private void applyCommonOptions(boolean headlessMode) {
        if (driver instanceof ChromeDriver) {
        	ChromeOptions chromeOptions = new ChromeOptions();
            if (headlessMode)
                chromeOptions.addArguments("--headless");
            driver=new ChromeDriver(chromeOptions);
        } else if (driver instanceof FirefoxDriver) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (headlessMode) {
                firefoxOptions.addArguments("--headless");
            }
            driver=new FirefoxDriver(firefoxOptions);
        }
        else if (driver instanceof EdgeDriver) {
            EdgeOptions edgeOptions = new EdgeOptions();
            if (headlessMode) {
                edgeOptions.addArguments("--headless");
            }
            driver = new EdgeDriver(edgeOptions);
        }
        else if (driver instanceof InternetExplorerDriver) {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            driver = new InternetExplorerDriver(ieOptions);
        }
        else if (driver instanceof SafariDriver) {
            SafariOptions safariOptions = new SafariOptions();
            driver = new SafariDriver(safariOptions);
        }
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}