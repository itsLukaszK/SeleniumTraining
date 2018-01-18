package cucumber_steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.Mobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC_04 {
    private WebDriver driver = new FirefoxDriver();
    private HomePage homePage = new HomePage(driver);
    private Mobile mobile = new Mobile(driver);

    @Before
    public void beforeTest() {
        homePage.goToHomePage();
        assertEquals(driver.getTitle(), "Home page");
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Given("^Click '(.*)' HomePage button$")
    public void clickP0HomePageButton(String p0) {
        switch (p0) {
            case "mobileButton":
                homePage.clickMobileButton();
                break;
            default:
                assertTrue(false, "Wrong button");
                break;
        }
    }

    @And("^Add '(.*)' to compare$")
    public void addMobileToCompare(String mobileName) {
        mobile.addMobileToCompare(mobileName);
    }

}
