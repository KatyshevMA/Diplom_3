package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
    private WebDriver driver;

    //Инпут Имя
    private By inputName = By.xpath(".//label[text()='Имя']//following-sibling::input");

    //Инпут Email
    private By inputEmail = By.xpath(".//label[text()='Email']//following-sibling::input");

    //Инпут Пароль
    private By inputPass = By.xpath(".//label[text()='Пароль']//following-sibling::input");

    //Кнопка Зарегистрироваться
    private By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");

    //Гиперссылка Войти
    private By buttonEnter = By.xpath(".//a[text()='Войти']");

    //Локатор некорректного пароля
    private By wrongPassword = By.xpath(".//p[text()='Некорректный пароль']");


    public Registration (WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForLoadRegistrationPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonRegistration));
        return driver.findElement(buttonRegistration).isDisplayed();
    }

    public void inputName(String newName) {
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys(newName);
    }

    public void inputEmail(String newEmail) {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(newEmail);
    }

    public void inputPassword(String newPass) {
        driver.findElement(inputPass).click();
        driver.findElement(inputPass).sendKeys(newPass);
    }

    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    public void clickButtonEntry() {
        driver.findElement(buttonEnter).click();
    }

    public String getWrongPassword() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(wrongPassword));
        return driver.findElement(wrongPassword).getText();
    }

}
