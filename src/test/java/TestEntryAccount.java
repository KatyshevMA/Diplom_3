import PageObject.Account;
import PageObject.MainPage;
import SystemSettings.SelectBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestEntryAccount {
    private WebDriver driver;
    private MainPage mainPage;
    private Account accountPage;


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
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void checkEntryPersonalAccount() {
        mainPage.clickButtonPersonalAccount();
        accountPage = new Account(driver);
        accountPage.waitForLoadAccountPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
