import PageObject.Account;
import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEntryAccount {
    private WebDriver driver;
    private MainPage mainPage;
    private Account accountPage;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
    }

    @Test
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
