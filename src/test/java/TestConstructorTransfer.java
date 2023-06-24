import PageObject.MainPage;
import PageObject.OrderBar;
import SystemSettings.SelectBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestConstructorTransfer {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderBar orderBar;


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
        mainPage.clickButtonOrderBar();
        orderBar = new OrderBar(driver);
        orderBar.waitForLoadOrderBar();
    }

    @Test
    @DisplayName("Переход в конструктор по клику на «Конструктор»")
    public void checkConstructorTransferByButtonConstructor() {
        mainPage.clickButtonConstructor();
        Assert.assertTrue(mainPage.waitForLoadMainPage());
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип Stellar Burgers")
    public void checkConstructorTransferByLogo() {
        mainPage.clickLogo();
        Assert.assertTrue(mainPage.waitForLoadMainPage());
    }

    @After
    public void tearDown() {
        // закрой браузер
        driver.quit();
    }
}
