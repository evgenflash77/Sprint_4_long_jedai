package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    private final By Order_button_top = By.className("Button_Button__ra12g"); // нашли локатор верхней кнопки "Заказать""
    private final By Order_button_bottom = By.className("Button_Middle__1CSJM"); // нашли локатор нижней кнопки "Заказать"
    private final By CookieButton = By.id("rcc-confirm-button"); // нашли локатор кук

    public void openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открыли сайт
    }

    public void ClickDrop_down_list(int index) {
        String fullId = "accordion__heading-" + index;
        WebElement element = driver.findElement(By.id(fullId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.attributeToBe(element, "aria-expanded", "true"));
    }

    public void acceptCookiesIfPresent() {
        try {
            // Ждем кнопку куки максимум 5 секунд.
            // Если она есть — кликаем через JS (надежнее обычного клика).
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(CookieButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookieBtn);
            System.out.println("✅ Куки приняты");
        } catch (org.openqa.selenium.TimeoutException e) {
            // Если за 5 секунд кнопки не нашлось — значит, её не было.
            // Это НЕ ошибка, просто игнорируем и идем дальше.
            System.out.println("⚠️ Кнопки куки не было, пропускаем");
        }
    }

    public void clickOrderButtonTop(String buttonPosition) {
        WebElement button;
        if ("top".equals(buttonPosition)) {
            System.out.println("👉 Кликаем по ВЕРХНЕЙ кнопке заказа");
            button = wait.until(ExpectedConditions.elementToBeClickable(Order_button_top));
        } else {
            System.out.println("👉 Кликаем по НИЖНЕЙ кнопке заказа");
            button = wait.until(ExpectedConditions.elementToBeClickable(Order_button_bottom));
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);


    }
}