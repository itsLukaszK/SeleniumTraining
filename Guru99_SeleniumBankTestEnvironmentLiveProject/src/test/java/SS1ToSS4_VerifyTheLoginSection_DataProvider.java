import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManagerHomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static pages.HomePage.homePageAddress;

public class SS1ToSS4_VerifyTheLoginSection_DataProvider {
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    ManagerHomePage managerHomePage = new ManagerHomePage(driver);
    WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

    @BeforeTest
    public void beforeTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homePageAddress);
    }

    @Test(dataProvider = "userIdPasswordData")
    public void SS1ToSS4_VerifyTheLoginSection_DataProvider(String userId, String password) throws IOException {
        assertEquals("Guru99 Bank Home Page", driver.getTitle());
        String isUserIdValid = userId;
        String isPasswordValid = password;
        boolean userIdValidation;
        boolean passwordValidation;
        if (isUserIdValid.equals("Valid")) {
            userIdValidation = true;
            homePage.enterCorrectUserId();
        } else {
            userIdValidation = false;
            homePage.enterIncorrectUserId();
        }
        if (isPasswordValid.equals("Valid")) {
            passwordValidation = true;
            homePage.enterCorrectPassword();
        } else {
            passwordValidation = false;
            homePage.enterIncorrectPassword();
        }
        homePage.clickLoginButton();
        if (userIdValidation == true && passwordValidation == true) {
            assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
            assertEquals("Manger Id : " + homePage.getValidUserId(), managerHomePage.getManagerIdInformation());
            managerHomePage.takeScreenshot();
            managerHomePage.logOut();
        } else {
            Alert alert = driver.switchTo().alert();
            assertEquals("User or Password is not valid", alert.getText());
            alert.accept();
        }
        webDriverWait.until(ExpectedConditions.titleIs("Guru99 Bank Home Page"));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @DataProvider(name = "userIdPasswordData")
    public Object[][] getData() {
        return new Object[][]{
                {"Valid", "Valid"},
                {"Invalid", "Valid"},
                {"Valid", "Invalid"},
                {"Invalid", "Invalid"}
        };
    }
}