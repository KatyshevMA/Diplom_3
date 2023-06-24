package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Restore {
    private WebDriver driver;

    //Инпут Email
    private By inputEmail = By.xpath(".//label[text()='Email']//following-sibling::input");

    //Кнопка Восстановить
    private By buttonRestore = By.xpath(".//button[text()='Восстановить']");

    //Гиперссылка Войти
    private By buttonEnter = By.xpath(".//a[text()='Войти']");


    public Restore (WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForLoadRestorePage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonRestore));
        return driver.findElement(buttonRestore).isDisplayed();
    }

    public void inputEmail(String newEmail) {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(newEmail);
    }

    public void clickButtonRestore() {
        driver.findElement(buttonRestore).click();
    }

    public void clickButtonEntry() {
        driver.findElement(buttonEnter).click();
    }
}
