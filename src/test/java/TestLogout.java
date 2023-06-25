import PageObject.MainPage;
import PageObject.Account;
import SystemSettings.SelectBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLogout {
    private WebDriver driver;
    private MainPage mainPage;
    private Account accountPage;

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
        mainPage.clickButtonAccountEnter();
        accountPage = new Account(driver);
        accountPage.waitForLoadAccountPage();
        accountPage.inputEmail(email);
        accountPage.inputPassword(password);
        accountPage.clickButtonEntry();
        mainPage.getDisplayedButtonCreateOrder();
        mainPage.clickButtonPersonalAccount();
        accountPage.waitForDisplayedExitButton();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void checkAuthByAccountEnter() {
        accountPage.clickButtonExit();
        Assert.assertTrue(accountPage.waitForLoadAccountPage());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
