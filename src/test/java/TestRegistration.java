import PageObject.Account;
import PageObject.MainPage;
import PageObject.Registration;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestRegistration {
    private WebDriver driver;
    private MainPage mainPage;
    private Account accountPage;
    private Registration registrationPage;

    private String name = "Клиент12345678111";
    private String email = "newclient12345678111@mmm.ru";
    private String password = "123456";

    private String token = "токен";


    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        driver = new ChromeDriver();
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
    public void checkRegistrationWith6SymbolsSuccess() {
        registrationPage.inputName(name);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.clickButtonRegistration();
        Assert.assertTrue(accountPage.waitForLoadAccountPage());
    }

    @Test
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
        given()
                .header("Authorization", token)
                .when()
                .delete("/api/auth/user");
    }
}
