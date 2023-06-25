import PageObject.Account;
import PageObject.MainPage;
import PageObject.Registration;
import SystemSettings.SelectBrowser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.restassured.RestAssured.given;

public class TestRegistration {
    private WebDriver driver;
    private MainPage mainPage;
    private Account accountPage;
    private Registration registrationPage;

    private String name = "Клиент12345678111";
    private String email = "newclient12345678111@mmm.ru";
    private String password = "123456";

    private String token;


    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        if (SelectBrowser.BROWSER.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (SelectBrowser.BROWSER.equals("Yandex")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/yandexdriver.exe");
            driver = new ChromeDriver(options);
        }
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickButtonPersonalAccount();
        accountPage = new Account(driver);
        accountPage.waitForLoadAccountPage();
        accountPage.clickButtonRegistration();
        registrationPage = new Registration(driver);
        registrationPage.waitForLoadRegistrationPage();
    }

    @Test
    @DisplayName("Успешная регистрация (6 символов в пароле)")
    public void checkRegistrationWith6SymbolsSuccess() {
        registrationPage.inputName(name);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.clickButtonRegistration();
        Assert.assertTrue(accountPage.waitForLoadAccountPage());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля (5 символов в пароле)")
    public void checkRegistrationWith5SymbolsPassError() {
        registrationPage.inputName(name);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("12345");
        registrationPage.clickButtonRegistration();
        Assert.assertEquals("Некорректный пароль", registrationPage.getWrongPassword());
    }

    @After
    public void tearDown() {
        driver.quit();
        //Удаление тестовых данных
        String json = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}";
        token = given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post("/api/auth/login")
                .then()
                .extract().jsonPath().get("accessToken");

        if (token != null) {
            given()
                    .header("Authorization", token)
                    .when()
                    .delete("/api/auth/user");
        }
    }
}
