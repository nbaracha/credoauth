package data;

import enums.Language;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "negativeAuthData")
    public static Object[][] getNegativeAuthData() {
        return new Object[][] {
                // GE
                {Language.GE, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "მონაცემები არასწორია"},
                {Language.GE, "", RandomStringUtils.randomAlphanumeric(8), "შეიყვანეთ მომხმარებლის სახელი"},
                {Language.GE, RandomStringUtils.randomAlphabetic(8), "", "შეიყვანეთ პაროლი"},

                // EN
                {Language.EN, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "Incorrect credentials"},
                {Language.EN, "", RandomStringUtils.randomAlphanumeric(8), "Enter username"},
                {Language.EN, RandomStringUtils.randomAlphabetic(8), "", "Enter password"},

                // RU
                {Language.RU, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "Неверные данные"},
                {Language.RU, "", RandomStringUtils.randomAlphanumeric(8), "Введите имя пользователя"},
                {Language.RU, RandomStringUtils.randomAlphabetic(8), "", "Введите пароль"}
        };
    }
}