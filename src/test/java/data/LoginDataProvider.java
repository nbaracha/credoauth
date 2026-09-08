package data;

import enums.Language;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "negativeAuthData")
    public static Object[][] getNegativeAuthData() {
        return new Object[][] {
                {Language.GE, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "მონაცემები არასწორია"},
                {Language.GE, "", RandomStringUtils.randomAlphanumeric(8), "სავალდებულო ველი"},
                {Language.GE, RandomStringUtils.randomAlphabetic(8), "", "სავალდებულო ველი"},

                {Language.EN, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "Please make sure the entered details are correct"},
                {Language.EN, "", RandomStringUtils.randomAlphanumeric(8), "Required field"},
                {Language.EN, RandomStringUtils.randomAlphabetic(8), "", "Required field"},

                {Language.RU, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "Пожалуйста, убедитесь, что введенные данные верны."},
                {Language.RU, "", RandomStringUtils.randomAlphanumeric(8), "Обязательное поле"},
                {Language.RU, RandomStringUtils.randomAlphabetic(8), "", "Обязательное поле"}
        };
    }
}