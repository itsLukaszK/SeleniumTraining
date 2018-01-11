import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManagerHomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static pages.HomePage.homePageAddress;
import static test_data.TestDataFromExcel.getDataFromExcel;

public class SS1ToSS4_VerifyTheLoginSection_DataFromXlsx {
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    ManagerHomePage managerHomePage = new ManagerHomePage(driver);
    WebDriverWait webDriverWait = new WebDriverWait(driver, 10);


    // I've prepared this test to practice using Excel spreadsheets in Selenium. IMO, it would be easier to parametrize
    // the script by using Gherkin notation (Cucumber).
    @Test
    public void SS1ToSS4_VerifyTheLoginSection_DataFromXlsx() throws IOException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String[][] usernameAndPasswordTable = getDataFromExcel(System.getProperty("user.dir") + "\\UsernameAndPasswordTestData.xlsx", "Arkusz1");
        for (int i = 1; i < usernameAndPasswordTable.length; i++) {
            driver.get(homePageAddress);
            assertEquals("Guru99 Bank Home Page", driver.getTitle());
            String isUserIdValid = usernameAndPasswordTable[i][0];
            String isPasswordValid = usernameAndPasswordTable[i][1];
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
                managerHomePage.logOut();
            } else {
                Alert alert = driver.switchTo().alert();
                assertEquals("User or Password is not valid", alert.getText());
                alert.accept();
            }
            webDriverWait.until(ExpectedConditions.titleIs("Guru99 Bank Home Page"));
        }
        driver.quit();
    }
}
