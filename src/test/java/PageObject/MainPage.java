package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    //Кнопка Личный кабинет
    private By buttonPersonalAccount = By.xpath(".//nav[@class='AppHeader_header__nav__g5hnF']/a");

    //Кнопка Конструктор
    private By buttonConstructor = By.className("AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo");

    //Кнопка Войти в аккаунт
    private By buttonAccountEnter = By.xpath(".//button[text()='Войти в аккаунт']");

    //Локатор для прогрузки страницы (иконка)
    private By iconLoadingDown = By.xpath(".//img[@alt = 'Перетяните булочку сюда (низ)']");

    //Кнопка Оформить заказ
    private By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForLoadMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(iconLoadingDown));
        return driver.findElement(iconLoadingDown).isDisplayed();
    }

    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    public void clickButtonAccountEnter() {
        driver.findElement(buttonAccountEnter).click();
    }

    public boolean getDisplayedButtonCreateOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }

}
