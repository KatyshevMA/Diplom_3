import PageObject.Account;
import PageObject.MainPage;
import PageObject.Registration;
import PageObject.Restore;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
    }

    @Test
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
        // закрой браузер
        driver.quit();
    }
}
