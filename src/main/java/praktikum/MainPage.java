package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.EnvComfig.EXPLICIT_WAIT;

public class MainPage {
    private final WebDriver driver;

    private final By kabinet = By.cssSelector(".AppHeader_header__linkText__3q_va");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(EnvComfig.BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(kabinet));
    }
}
