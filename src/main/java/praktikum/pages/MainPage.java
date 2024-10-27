package praktikum.pages;

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

    private final By loginButton = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");

    //Метод открывает веб страницу
    public void open() {
        driver.get(EnvComfig.BASE_URL);
    }

    //Метод нажимает на кнопку "Войти в аккаунт"
    public void clickLoginButton() {
        WebElement inputElement = driver.findElement(loginButton);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        inputElement.click();
    }
}
