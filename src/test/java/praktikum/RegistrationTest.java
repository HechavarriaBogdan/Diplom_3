package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import praktikum.pages.RegistrationPage;

public class RegistrationTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void successRegistration() throws Exception {
        WebDriver driver = factory.getDriver();
        UserCredentials user = UserCredentials.random();
        var mainPage = new MainPage(driver);
        var loginPage = new LoginPage(driver, user);
        var registrationPage = new RegistrationPage(driver, user);
        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.addRegistrationName();
        registrationPage.addRegistrationEmail();
        registrationPage.addRegistrationPassword();
        registrationPage.clickRegistrationButton();
        loginPage.checkLoginPage();
        loginPage.addLoginEmail();
        loginPage.addLoginPassword();
        loginPage.clickLoginButton();
        loginPage.fetchAuthTokenFromLocalStorage();
    }
}
