package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    //Кнопка Личный кабинет
    private By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");

    //Кнопка Конструктор
    private By buttonConstructor = By.xpath(".//p[text()='Конструктор']");

    //Кнопка Лента Заказов
    private By buttonOrderBar = By.xpath(".//p[text()='Лента Заказов']");

    //Кнопка Войти в аккаунт
    private By buttonAccountEnter = By.xpath(".//button[text()='Войти в аккаунт']");

    //Локатор для прогрузки страницы (иконка)
    private By iconLoadingDown = By.xpath(".//img[@alt = 'Перетяните булочку сюда (низ)']");

    //Кнопка Оформить заказ
    private By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");

    //Логотип
    private By logo = By.className("AppHeader_header__logo__2D0X2");

    //Таб Булки
    private By tabBuns = By.xpath(".//span[text()='Булки']");

    //Таб Соусы
    private By tabSauces = By.xpath(".//span[text()='Соусы']");

    //Таб Начинки
    private By tabStuffings = By.xpath(".//span[text()='Начинки']");

    //Локатор для актвиного таба булок
    private By activeTabBuns = By.xpath(".//span[text()='Булки']/parent::div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    //Локатор для актвиного таба соусов
    private By activeTabSauces = By.xpath(".//span[text()='Соусы']/parent::div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    //Локатор для актвиного таба начинки
    private By activeTabStuffings = By.xpath(".//span[text()='Начинки']/parent::div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");


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
    public void clickButtonOrderBar() {
        driver.findElement(buttonOrderBar).click();
    }
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }
    public void clickButtonAccountEnter() {
        driver.findElement(buttonAccountEnter).click();
    }
    public void clickLogo() {
        driver.findElement(logo).click();
    }


    public boolean getDisplayedButtonCreateOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
        return driver.findElement(buttonCreateOrder).isDisplayed();
    }

    public void clickTabBuns() {
        driver.findElement(tabBuns).click();
    }
    public void clickTabSauces() {
        driver.findElement(tabSauces).click();
    }
    public void clickTabNStuffings() {
        driver.findElement(tabStuffings).click();
    }

    public boolean getDisplayedActiveTabBuns() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(activeTabBuns));
        return driver.findElement(activeTabBuns).isDisplayed();
    }
    public boolean getDisplayedActiveTabSauces() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(activeTabSauces));
        return driver.findElement(activeTabSauces).isDisplayed();
    }
    public boolean getDisplayedActiveTabStuffings() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(activeTabStuffings));
        return driver.findElement(activeTabStuffings).isDisplayed();
    }
}
