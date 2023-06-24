import PageObject.MainPage;
import PageObject.OrderBar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestConstructorTransfer {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderBar orderBar;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickButtonOrderBar();
        orderBar = new OrderBar(driver);
        orderBar.waitForLoadOrderBar();
    }

    @Test
    public void checkConstructorTransferByButtonConstructor() {
        mainPage.clickButtonConstructor();
        Assert.assertTrue(mainPage.waitForLoadMainPage());
    }

    @Test
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
