package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SimpleTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void openPageTest() throws Exception {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
    }
}
