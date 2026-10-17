package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPlaced {
    private final WebDriverWait wait;

    public OrderPlaced(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By ButtonModal = By.cssSelector("div.Order_Modal__YZ-d3 button.Button_Button__ra12g.Button_Middle__1CSJM"); // нашли локатор кнопки модального окна

    public WebElement getModalButton() {

        return wait.until(ExpectedConditions.elementToBeClickable(ButtonModal));
    }
}
