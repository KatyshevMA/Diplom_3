import PageObject.MainPage;
import SystemSettings.SelectBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestConstructorTabs {
    private WebDriver driver;
    private MainPage mainPage;

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
    @DisplayName("Переход к разделу «Булки»")
    public void checkTransferToTabSauces() {
        mainPage.clickTabSauces();
        Assert.assertTrue(mainPage.getDisplayedActiveTabSauces());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void checkTransferToTabStuffings() {
        mainPage.clickTabNStuffings();
        Assert.assertTrue(mainPage.getDisplayedActiveTabStuffings());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void checkTransferToTabBuns() {
        mainPage.clickTabSauces();
        mainPage.clickTabBuns();
        Assert.assertTrue(mainPage.getDisplayedActiveTabBuns());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
