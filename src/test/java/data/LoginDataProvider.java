package data;

import enums.Language;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "invalidCredentialsData")
    public static Object[][] getInvalidCredentialsData() {
        return new Object[][] {
                {Language.GE, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "მონაცემები არასწორია"},
                {Language.EN, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "Please make sure the entered details are correct"},
                {Language.RU, RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(10), "Пожалуйста, убедитесь, что введенные данные верны."}
        };
    }

    @DataProvider(name = "emptyFieldsData")
    public static Object[][] getEmptyFieldsData() {
        return new Object[][] {
                // ქართული (GE)
                {Language.GE, "", RandomStringUtils.randomAlphanumeric(8), "სავალდებულო ველი"},
                {Language.GE, RandomStringUtils.randomAlphabetic(8), "", "სავალდებულო ველი"},

                // ინგლისური (EN)
                {Language.EN, "", RandomStringUtils.randomAlphanumeric(8), "Required field"},
                {Language.EN, RandomStringUtils.randomAlphabetic(8), "", "Required field"},

                // რუსული (RU)
                {Language.RU, "", RandomStringUtils.randomAlphanumeric(8), "Обязательное поле"},
                {Language.RU, RandomStringUtils.randomAlphabetic(8), "", "Обязательное поле"}
        };
    }
}