package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderBar {
    private WebDriver driver;

    //Локатор для прогрузки страницы (зааголовок)
    private By headerOrderBar = By.xpath(".//h1[text()='Лента заказов']");

    public OrderBar (WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForLoadOrderBar() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderBar));
        return driver.findElement(headerOrderBar).isDisplayed();
    }
}
