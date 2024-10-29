package praktikum.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvComfig;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор отображения кнопки входа на главной странице
    private final By loginButton = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");
    // Локатор отображения кнопки оформления заказа на главной странице
    private final By orderButton = By.xpath(".//button[contains(@class, button_button_size_large__G21Vg) and contains(text(), 'Оформить заказ')]");
    // Локатор отображения кнопки "Личный кабинет" на главной странице
    private final By personalAccountButton = By.xpath(".//p[contains(@class, 'AppHeader_header__linkText__3q_va') and text()='Личный Кабинет']");

    @Step("Открываю веб страницу")
    public void open() {
        driver.get(EnvComfig.BASE_URL);
    }

    @Step("Нажимаю на кнопку \"Войти в аккаунт\"")
    public void clickLoginButton() {
        WebElement inputElement = driver.findElement(loginButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        inputElement.click();
    }

    @Step("Проверяю отображение кнопки \"Оформить заказ\"")
    public void checkOrderButton() {
        WebElement inputElement = driver.findElement(orderButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        Assert.assertTrue(inputElement.isDisplayed());
    }

    @Step("Нажимаю на кнопку \"Личный Кабинет\"")
    public void clickPersonalAccountButton() {
        WebElement inputElement = driver.findElement(personalAccountButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        inputElement.click();
    }
}
