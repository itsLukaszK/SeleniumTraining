import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManagerHomePage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static pages.HomePage.homePageAddress;

public class SS1_VerifyTheLoginSection {

    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    ManagerHomePage managerHomePage = new ManagerHomePage(driver);

    @Test
    public void verifyTheLoginSection() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homePageAddress);
        assertEquals("Guru99 Bank Home Page", driver.getTitle());
        homePage.enterCorrectUserId();
        homePage.enterCorrectPassword();
        homePage.clickLoginButton();
        assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
        assertEquals("Manger Id : " + homePage.getValidUserId(), managerHomePage.getManagerIdInformation());
        driver.quit();
    }
}
