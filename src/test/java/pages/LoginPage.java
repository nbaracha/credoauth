package pages;

import components.LanguageSelectorComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriverWait wait;
    public LanguageSelectorComponent languageSelector;

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.xpath("//button[@arialabel='sign in']");

    private final By fieldError = By.xpath("//crd-error");
    private final By toastError = By.xpath("//div[contains(@class, 'cdk-overlay-pane')]//p[contains(@class, 'body-2')]");

    public LoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.languageSelector = new LanguageSelectorComponent(driver);
    }

    @Step("მომხმარებლის სახელის შეყვანა: {username}")
    public void enterUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        element.clear();
        if (username != null && !username.isEmpty()) {
            element.sendKeys(username);
        }
    }

    @Step("პაროლის შეყვანა: {password}")
    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        element.clear();
        if (password != null && !password.isEmpty()) {
            element.sendKeys(password);
        }
    }

    @Step("ავტორიზაციის ღილაკზე დაჭერა")
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("ცარიელი ველის შეცდომის ტექსტი")
    public String getFieldError() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(fieldError));
        wait.until(d -> !element.getText().trim().isEmpty());
        return element.getText().trim();
    }

    @Step("არასწორი მონაცემების ტოსტის ტექსტი")
    public String getToastErrorMessage() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(toastError));
        wait.until(d -> !element.getText().trim().isEmpty());
        return element.getText().trim();
    }
}