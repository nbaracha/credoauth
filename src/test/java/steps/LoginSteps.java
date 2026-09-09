package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(org.openqa.selenium.WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    @Step("მომხმარებლის სახელის შეყვანა: {username}")
    public void enterUsername(String username) {
        WebElement element = loginPage.getWait().until(ExpectedConditions.elementToBeClickable(loginPage.usernameInput));
        element.clear();
        if (username != null && !username.isEmpty()) {
            element.sendKeys(username);
        }
    }

    @Step("პაროლის შეყვანა: {password}")
    public void enterPassword(String password) {
        WebElement element = loginPage.getWait().until(ExpectedConditions.elementToBeClickable(loginPage.passwordInput));
        element.clear();
        if (password != null && !password.isEmpty()) {
            element.sendKeys(password);
        }
    }

    @Step("ავტორიზაციის ღილაკზე დაჭერა")
    public void clickLogin() {
        loginPage.getWait().until(ExpectedConditions.elementToBeClickable(loginPage.loginButton)).click();
    }

    @Step("ცარიელი ველის შეცდომის ტექსტის მიღება")
    public String getFieldErrorText() {
        WebElement element = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.fieldError));
        loginPage.getWait().until(d -> !element.getText().trim().isEmpty());
        return element.getText().trim();
    }

    @Step("არასწორი მონაცემების ტოსტის ტექსტის მიღება")
    public String getToastErrorMessageText() {
        WebElement element = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.toastError));
        loginPage.getWait().until(d -> !element.getText().trim().isEmpty());
        return element.getText().trim();
    }
}