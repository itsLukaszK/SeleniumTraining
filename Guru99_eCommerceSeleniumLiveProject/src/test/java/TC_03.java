import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Mobile;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC_03 {
    private WebDriver driver = new FirefoxDriver();
    private HomePage homePage = new HomePage(driver);
    private Mobile mobile = new Mobile(driver);
    private ShoppingCart shoppingCart = new ShoppingCart(driver);

    @BeforeTest
    public void beforeTest() {
        homePage.goToHomePage();
        assertEquals(driver.getTitle(), "Home page");
    }

    @Test
    public void verifyThatYouCannotAddMoreProductsInCartThanTheProductsAvailableInStore() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        homePage.clickMobileButton();
        assertEquals(driver.getTitle(), "Mobile");
        mobile.addProductToCart("Sony Xperia");
        shoppingCart.changeQuantityOfProductInCartTo("MOB001", "501");
        assertEquals(shoppingCart.getErrorMessage(), "* The maximum quantity allowed for purchase is 500.");
        shoppingCart.emptyCart();
        assertTrue(shoppingCart.isCartEmpty());
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
