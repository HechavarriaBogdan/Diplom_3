package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import praktikum.UserCredentials;

public class RegistrationPage {
    private final WebDriver driver;
    private final UserCredentials user;

    public RegistrationPage(WebDriver driver, UserCredentials user) {
        this.driver = driver;
        this.user = user;
    }

    private final By registrationNameInput = By.xpath(".//fieldset[contains(@class, 'Auth_fieldset__1QzWN mb-6')][1]//input[@type='text' and @name='name']");
    private final By registrationEmailInput = By.xpath(".//fieldset[contains(@class, 'Auth_fieldset__1QzWN mb-6')][2]//input[@type='text' and @name='name']");
    private final By registrationPasswordInput = By.xpath(".//fieldset[contains(@class, 'Auth_fieldset__1QzWN mb-6')][3]//input[@type='password' and @name='Пароль']");
    private final By registrationButton = By.xpath(".//button[contains(@class, 'button_button_type_primary__1O7Bx') and contains(text(), 'Зарегистрироваться')]");

    // Метод вводит имя в поле "Имя"
    public void addRegistrationName() {
        WebElement inputElement = driver.findElement(registrationNameInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getName());
    }
    // Метод вводит адрес электронной почты в поле "email"
    public void addRegistrationEmail() {
        WebElement inputElement = driver.findElement(registrationEmailInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getEmail());
    }

    // Метод вводит пароль в поле "Пароль"
    public void addRegistrationPassword() {
        WebElement inputElement = driver.findElement(registrationPasswordInput);
        inputElement.click();
        inputElement.clear();
        inputElement.sendKeys(user.getPassword());
    }

    // Метод нажимает на кнопку "Зарегистрироваться"
    public void clickRegistrationButton() {
        WebElement inpetElement = driver.findElement(registrationButton);
        inpetElement.click();
    }

}
