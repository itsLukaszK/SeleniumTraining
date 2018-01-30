package cucumber_steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.Mobile;
import pages.ProductsComparisonList;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC_04 {
    private WebDriver driver = new FirefoxDriver();
    private HomePage homePage = new HomePage(driver);
    private Mobile mobile = new Mobile(driver);
    private ProductsComparisonList productsComparisonList = new ProductsComparisonList(driver);

    @Before
    public void beforeTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @Given("^Add '(.*)' to compare$")
    public void addMobileToCompare(String mobileName) {
        mobile.addMobileToCompare(mobileName);
    }


    @When("^Click '(.*)' Mobile button$")
    public void clickP0MobileButton(String p0) {
        switch (p0) {
            case "Compare":
                mobile.clickCompareButton();
                break;
            default:
                assertTrue(false, "Wrong button");
                break;
        }
    }

    @Then("^'Compare Products' popup window containing the selected products: '(.*)' and '(.*)' is opened and closed$")
    public void compareProductsPopupWindowContainingTheSelectedProductsP0AndP1IsOpened(String p0, String p1) {
        String mainWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
        assertTrue(productsComparisonList.getHeader().getText().equalsIgnoreCase("Compare Products"));
        assertTrue(productsComparisonList.doesTheWindowContainTheSelectedProducts(p0, p1));
        driver.close();
        driver.switchTo().window(mainWindow);
        assertEquals(driver.getTitle(), "Mobile");
    }
}
