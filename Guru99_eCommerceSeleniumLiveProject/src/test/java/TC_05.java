import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class TC_05 {
    private WebDriver driver = new FirefoxDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 10);
    private HomePage homePage = new HomePage(driver, wait);

    @BeforeTest
    public void beforeTest() {
        homePage.goToHomePage();
        assertEquals(driver.getTitle(), "Home page");
    }

    @Test
    public void createAccountAndShareWishlist() {
        homePage.clickAccountButton();
    }
}
