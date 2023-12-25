package BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    public BasePage(WebDriver driver, Properties properties) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10));
        this.properties = properties;
        initializeElements();
    }

    private void initializeElements() {
        PageFactory.initElements(driver, this);
    }

    protected WebElement findBy(String locatorKey) {
        String locatorValue = properties.getProperty(locatorKey);
        return driver.findElement(getSelector(locatorValue));
    }

    private By getSelector(String locator) {
        if (locator.startsWith("//")) {
            return By.xpath(locator);
        } else if (locator.startsWith("css=")) {
            return By.cssSelector(locator.substring(4));
        } else {
            return By.id(locator);
        }
    }
}