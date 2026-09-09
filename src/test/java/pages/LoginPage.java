package pages;

import components.LanguageSelectorComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriverWait wait;
    public LanguageSelectorComponent languageSelector;


    public final By usernameInput = By.id("username");
    public final By passwordInput = By.id("password");
    public final By loginButton = By.xpath("//button[@arialabel='sign in']");
    public final By fieldError = By.xpath("//crd-error");
    public final By toastError = By.xpath("//div[contains(@class, 'cdk-overlay-pane')]//p[contains(@class, 'body-2')]");

    public LoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.languageSelector = new LanguageSelectorComponent(driver);
    }

    public WebDriverWait getWait() {
        return wait;
    }
}