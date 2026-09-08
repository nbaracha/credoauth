package tests;

import data.LoginDataProvider;
import enums.Language;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

@Feature("MyCredo ავტორიზაციის ნეგატიური სცენარები")
public class AuthTests extends BaseTest {
    @Test(dataProvider = "invalidCredentialsData", dataProviderClass = LoginDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Story("არასწორი მონაცემების შეტანის ტესტები")
    public void testInvalidCredentialsMultiLanguage(Language language, String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.languageSelector.selectLanguage(language);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualError = loginPage.getToastErrorMessage();
        softAssert.assertTrue(actualError.contains(expectedError),
                "ERROR: მოსალოდნელი ტექსტი ('" + expectedError + "') არ ემთხვევა რეალურს ('" + actualError + "')");

        softAssert.assertAll();
    }

    @Test(dataProvider = "emptyFieldsData", dataProviderClass = LoginDataProvider.class)
    @Severity(SeverityLevel.NORMAL)
    @Story("ცარიელი ველების ვალიდაციის ტესტები")
    public void testEmptyFieldsMultiLanguage(Language language, String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.languageSelector.selectLanguage(language);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualError = loginPage.getFieldError();
        softAssert.assertTrue(actualError.contains(expectedError),
                "ERROR: მოსალოდნელი ტექსტი ('" + expectedError + "') არ ემთხვევა რეალურს ('" + actualError + "')");

        softAssert.assertAll();
    }
}