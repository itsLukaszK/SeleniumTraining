import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Mobile;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC_02 {
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    Mobile mobile = new Mobile(driver);
    Product product = new Product(driver);

    @BeforeTest
    public void beforeTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.goToHomePage();
        assertEquals(driver.getTitle(), "Home page");
    }

    @Test
    public void verifyThatCostsOfProductInListPageAndDetailsPageAreEqual() {
        homePage.clickMobileButton();
        assertEquals(driver.getTitle(), "Mobile");
        String sonyXperiaPrice_Mobile = mobile.getProductPrice("Sony Xperia");
        mobile.goToProductPage("Sony Xperia");
        String sonyXperiaPrice_Product = product.getProductPrice();
        assertTrue(Objects.equals(sonyXperiaPrice_Mobile, sonyXperiaPrice_Product));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
