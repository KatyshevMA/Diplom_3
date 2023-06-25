import PageObject.Account;
import PageObject.MainPage;
import PageObject.Registration;
import PageObject.Restore;
import SystemSettings.SelectBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestAuthorization {

    private WebDriver driver;
    private MainPage mainPage;
    private Account accountPage;
    private Registration registrationPage;
    private Restore restorePage;

    private String email = "authclient987654321@mmm.ru";
    private String password = "123456";


    @Before
    public void setUp() {
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
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkAuthByAccountEnter() {
        mainPage.clickButtonAccountEnter();
        accountPage = new Account(driver);
        accountPage.waitForLoadAccountPage();
        accountPage.inputEmail(email);
        accountPage.inputPassword(password);
        accountPage.clickButtonEntry();
        Assert.assertTrue(mainPage.getDisplayedButtonCreateOrder());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void checkAuthByPersonalAccount() {
        mainPage.clickButtonPersonalAccount();
        accountPage = new Account(driver);
        accountPage.waitForLoadAccountPage();
        accountPage.inputEmail(email);
        accountPage.inputPassword(password);
        accountPage.clickButtonEntry();
        Assert.assertTrue(mainPage.getDisplayedButtonCreateOrder());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkAuthByRegistrationPage() {
        mainPage.clickButtonPersonalAccount();
        accountPage = new Account(driver);
        accountPage.waitForLoadAccountPage();
        accountPage.clickButtonRegistration();
        registrationPage = new Registration(driver);
        registrationPage.waitForLoadRegistrationPage();
        registrationPage.clickButtonEntry();
        accountPage.waitForLoadAccountPage();
        accountPage.inputEmail(email);
        accountPage.inputPassword(password);
        accountPage.clickButtonEntry();
        Assert.assertTrue(mainPage.getDisplayedButtonCreateOrder());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void checkAuthByRestorePage() {
        mainPage.clickButtonPersonalAccount();
        accountPage = new Account(driver);
        accountPage.waitForLoadAccountPage();
        accountPage.clickButtonRestore();
        restorePage = new Restore(driver);
        restorePage.waitForLoadRestorePage();
        restorePage.clickButtonEntry();
        accountPage.waitForLoadAccountPage();
        accountPage.inputEmail(email);
        accountPage.inputPassword(password);
        accountPage.clickButtonEntry();
        Assert.assertTrue(mainPage.getDisplayedButtonCreateOrder());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
