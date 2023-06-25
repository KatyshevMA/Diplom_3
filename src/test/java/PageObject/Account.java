package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account {
    private WebDriver driver;

    //Инпут Email
    private By inputEmail = By.xpath(".//label[text()='Email']//following-sibling::input");

    //Инпут Пароль
    private By inputPass = By.xpath(".//label[text()='Пароль']//following-sibling::input");

    //Кнопка Войти
    private By buttonEntry = By.xpath(".//button[text()='Войти']");

    //Гиперссылка Зарегистрироваться
    private By buttonRegistration = By.xpath(".//a[text()='Зарегистрироваться']");

    //Гиперссылка Восстановить пароль
    private By buttonRestore = By.xpath(".//a[text()='Восстановить пароль']");

    //Кнопка Выход
    private By buttonExit = By.xpath(".//button[text()='Выход']");


    public Account (WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForLoadAccountPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonEntry));
        return driver.findElement(buttonEntry).isDisplayed();
    }

    public void clickButtonEntry() {
        driver.findElement(buttonEntry).click();
    }
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }
    public void clickButtonRestore() {
        driver.findElement(buttonRestore).click();
    }
    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }

    public void inputEmail(String newEmail) {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(newEmail);
    }

    public void inputPassword(String newPass) {
        driver.findElement(inputPass).click();
        driver.findElement(inputPass).sendKeys(newPass);
    }

    public boolean waitForDisplayedExitButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
        return driver.findElement(buttonExit).isDisplayed();
    }
}
