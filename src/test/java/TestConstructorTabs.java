import PageObject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestConstructorTabs {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
    }

    @Test
    public void checkTransferToTabSauces() {
        mainPage.clickTabSauces();
        Assert.assertTrue(mainPage.getDisplayedActiveTabSauces());
    }

    @Test
    public void checkTransferToTabStuffings() {
        mainPage.clickTabNStuffings();
        Assert.assertTrue(mainPage.getDisplayedActiveTabStuffings());
    }

    @Test
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
