package praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.DriverRule;
import praktikum.UserCredentials;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;

public class LoginTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Успешный вход по кнопке «Войти в аккаунт» на главной")
    public void successLogin() {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver, user);
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.createUser(user);
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        mainPage.checkOrderButton();
        loginPage.fetchAuthTokenFromLocalStorage();
        loginPage.deleteUser();
    }
}
