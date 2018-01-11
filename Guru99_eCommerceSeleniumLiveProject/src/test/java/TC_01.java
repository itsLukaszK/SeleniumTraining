import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC_01 {
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    Mobile mobile = new Mobile(driver);

    @BeforeTest
    public void beforeTest(){
        homePage.goToHomePage();
    }

    @Test
    public void verifyItemsInMobileListPageCanBeSortedByName(){
        assertEquals(driver.getTitle(), "Home page");
        homePage.clickMobileButton();
        assertEquals(driver.getTitle(), "Mobile");
        mobile.selectSortByValue("Name");
        assertTrue(mobile.areProductsSortedByName());
    }
}
