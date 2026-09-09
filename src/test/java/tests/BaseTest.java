package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        // Chrome Options კონფიგურაცია
        ChromeOptions options = new ChromeOptions();

        // 1. ფანჯრის ზომის ფიქსაცია (მაქსიმიზაციის ნაცვლად ან პარალელურად ზუსტი რეზოლუციისთვის)
        options.addArguments("--window-size=1920,1080");

        // 2. ბრაუზერის ნოტიფიკაციების და ფოპ-აპების გამორთვა
        options.addArguments("--disable-notifications");

        // 3. ავტომატიზაციის აღმჩნევის დროტმაკერის (Chrome is being controlled by automated test software) დამალვა
        options.addArguments("--disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // 4. სტაბილურობისთვის დამატებითი ფლაგები (განსაკუთრებით CI/CD სვერვერებისთვის ან სრული ეკრანის პრობლემების ასაცილებლად)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        // ვუერთებთ ოფციებს დრაივერს
        driver = new ChromeDriver(options);

        // ფანჯრის ეკრანზე გაშლა
        driver.manage().window().maximize();

        driver.get("https://mycredo.ge/landing/main/auth");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}