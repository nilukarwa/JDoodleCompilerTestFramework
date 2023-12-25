package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import BasePage.BasePage;
import java.util.Properties;

public class HomePage extends BasePage {
	@FindBy(id = "execute")
    private WebElement runButton;

    @FindBy(id = "language")
    private WebElement languageDropdown;

    @FindBy(id = "textarea-code")
    private WebElement codeEditor;

    @FindBy(id = "share-button")
    private WebElement shareButton;

    @FindBy(id = "shared-link")
    private WebElement sharedLink;

    @FindBy(id = "output")
    private WebElement output;

    public HomePage(WebDriver driver, Properties properties) {
        super(driver, properties);
    }
    
    public void enterCodeAndRun(String code) {
        setCodeInEditor(code);
        clickRunButton();
        waitForOutput();
    }

    public void selectLanguage(String language) {
        openLanguageDropdown();
        selectLanguageOption(language);
    }

    public void clickShareButton() {
        shareButton.click();
    }

    public String getSharedLink() {
        return sharedLink.getText();
    }

    public boolean verifySyntaxHighlighting() {
        WebElement codeEditorElement = codeEditor;
        String classAttribute = codeEditorElement.getAttribute("class");
        return classAttribute.contains("syntax-highlighted");
    }

    private void setCodeInEditor(String code) {
        WebElement codeEditorElement = codeEditor;
        codeEditorElement.clear();
        codeEditorElement.sendKeys(code);
    }

    private void clickRunButton() {
        runButton.click();
    }

    private void waitForOutput() {
        wait.until(ExpectedConditions.visibilityOf(output));
    }

    private void openLanguageDropdown() {
        WebElement languageDropdownElement = languageDropdown;
        languageDropdownElement.click();
    }

    private void selectLanguageOption(String language) {
        WebElement languageOptionElement = findBy("languageOption");
        languageOptionElement.click();
    }
}