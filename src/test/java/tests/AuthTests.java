package tests;

import data.LoginDataProvider;
import enums.Language;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import steps.LoginSteps;

@Feature("MyCredo ავტორიზაციის ნეგატიური სცენარები")
public class AuthTests extends BaseTest {

    @Test(dataProvider = "invalidCredentialsData", dataProviderClass = LoginDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Story("არასწორი მონაცემების შეტანის ტესტები")
    public void testInvalidCredentialsMultiLanguage(Language language, String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(driver);
        LoginSteps loginSteps = new LoginSteps(driver);
        SoftAssert softAssert = new SoftAssert();

        // ენის შეცვლა
        loginPage.languageSelector.selectLanguage(language);

        // 1. შემოწმება: ვართ თუ არა ლოგინ გვერდზე (ლოგინის ღილაკის არსებობა)
        WebElement loginBtnElement = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.loginButton));
        softAssert.assertTrue(loginBtnElement.isDisplayed(), "ERROR: ლოგინის გვერდი არ ჩანს ან ლოგინის ღილაკი არ არის ეკრანზე!");

        // 2. შემოწმება: ჩანს თუ არა მომხმარებლის და პაროლის ველები
        WebElement userField = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.usernameInput));
        WebElement passField = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.passwordInput));
        softAssert.assertTrue(userField.isDisplayed(), "ERROR: იუზერის ველი არ ჩანს!");
        softAssert.assertTrue(passField.isDisplayed(), "ERROR: პაროლის ველი არ ჩანს!");

        // მონაცემების შეყვანა და დაკლიკება
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickLogin();

        // 3. შემოწმება: მოსალოდნელი ტოსტ შეცდომის ტექსტი
        String actualError = loginSteps.getToastErrorMessageText();
        softAssert.assertTrue(actualError.contains(expectedError),
                "ERROR: მოსალოდნელი ტექსტი ('" + expectedError + "') არ ემთხვევა რეალურს ('" + actualError + "')");

        // ყველა ასერტის ერთდროული შემოწმება
        softAssert.assertAll();
    }

    @Test(dataProvider = "emptyFieldsData", dataProviderClass = LoginDataProvider.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("ცარიელი ველების ვალიდაციის ტესტები")
    public void testEmptyFieldsMultiLanguage(Language language, String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(driver);
        LoginSteps loginSteps = new LoginSteps(driver);
        SoftAssert softAssert = new SoftAssert();

        // ენის შეცვლა
        loginPage.languageSelector.selectLanguage(language);

        // 1. შემოწმება: ვართ თუ არა ლოგინ გვერდზე
        WebElement loginBtnElement = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.loginButton));
        softAssert.assertTrue(loginBtnElement.isDisplayed(), "ERROR: ლოგინის გვერდი არ ჩანს!");

        // 2. შემოწმება: ველების გამოჩენა ეკრანზე
        WebElement userField = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.usernameInput));
        WebElement passField = loginPage.getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.passwordInput));
        softAssert.assertTrue(userField.isDisplayed(), "ERROR: იუზერის ველი არ ჩანს!");
        softAssert.assertTrue(passField.isDisplayed(), "ERROR: პაროლის ველი არ ჩანს!");

        // მონაცემების შეყვანა და დაკლიკება
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickLogin();

        // 3. შემოწმება: ველის შეცდომის ტექსტი
        String actualError = loginSteps.getFieldErrorText();
        softAssert.assertTrue(actualError.contains(expectedError),
                "ERROR: მოსალოდნელი ტექსტი ('" + expectedError + "') არ ემთხვევა რეალურს ('" + actualError + "')");

        // ყველა ასერტის ერთდროული შემოწმება
        softAssert.assertAll();
    }
}