package praktikum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.UserCredentials;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class LoginPage {
    private final WebDriver driver;
    private final UserCredentials user;

    public LoginPage(WebDriver driver, UserCredentials user) {
        this.driver = driver;
        this.user = user;
    }

    private final By loginEmailInput = By.xpath(".//input[contains(@class, 'input__textfield') and @type='text' and @name='name']");
    private final By loginPasswordInput = By.xpath(".//input[contains(@class, 'text_type_main-default') and @name='Пароль']");
    private final By registrationButton = By.cssSelector(".Auth_link__1fOlj[href='/register']");
    private final By loginButton = By.xpath(".//button[contains(@class, button_button_type_primary__1O7Bx) and contains(text(), 'Войти')]");
    private final By pageNameText = By.xpath(".//h2[contains(text(), 'Вход')]");

    // Метод нажимает на кнопку зарегистрироваться на странице входа
    public void clickRegistrationButton() {
        WebElement inputElement = driver.findElement(registrationButton);
        inputElement.click();
    }

    // Метод проверяет что отображается название страницы "Вход"
    public void checkLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(pageNameText));
        Assert.assertTrue(driver.findElement(pageNameText).isDisplayed());

    }

    // Метод вводит данные в поле email
    public void addLoginEmail() {
        WebElement inputElement = driver.findElement(loginEmailInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getEmail());
    }

    // Метод вводит данные в поле password
    public void addLoginPassword() {
        WebElement inputElement = driver.findElement(loginPasswordInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getPassword());
    }

    // Метод нажимает на кнопку "Войти"
    public void clickLoginButton() {
        WebElement inputElement = driver.findElement(loginButton);
        inputElement.click();
    }

    // Метод получает accessToken после успешной авторизации
    public void fetchAuthTokenFromLocalStorage() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.cssSelector("a[class^='BurgerIngredient']"), 2));

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
    }
}
