import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC_02 {
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    Mobile mobile = new Mobile(driver);

    @BeforeTest
    public void beforeTest() {
        homePage.goToHomePage();
        assertEquals(driver.getTitle(), "Home page");
    }

    @Test
    public void verifyThatCostsOfProductInListPageAndDetailsPageAreEqual() {
        homePage.clickMobileButton();
        assertEquals(driver.getTitle(), "Mobile");
        String sonyXperiaPrice_Mobile = mobile.getProductPrice("Sony Xperia");
        mobile.goToProductPage("Sony Xperia");
        //TODO getProductPrice (Product)
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
