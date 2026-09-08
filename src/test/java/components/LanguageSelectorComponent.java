package components;

import enums.Language;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSelectorComponent {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By languageButton = By.xpath("//button[.//app-icon[@svgicon='language']]");

    public LanguageSelectorComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectLanguage(Language language) {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(languageButton));
        btn.click();

        By langOption = By.xpath("//li[.//p[normalize-space(text())='" + language.getLabel() + "']]");

        wait.until(ExpectedConditions.elementToBeClickable(langOption)).click();
    }
}