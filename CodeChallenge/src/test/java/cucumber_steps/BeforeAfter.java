package cucumber_steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CreateANewRepository.getRepositoryName;
import static pages.MainPage.getMainPage;
import static pages.SignIn.getUSERNAME;

public class BeforeAfter {
    static WebDriver driver;
    static CreateANewRepository createANewRepository;
    private MainPage mainPage;
    private Repository repository;
    private Options options;
    private WebDriverWait wait;
    private HomePage homePage;

    @Before
    public void beforeTest() {
        driver = new FirefoxDriver();
        createANewRepository = new CreateANewRepository(driver);
        mainPage = new MainPage(driver);
        repository = new Repository(driver);
        options = new Options(driver);
        wait = new WebDriverWait(driver, 10L);
        homePage = new HomePage(driver);
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.goToMainPage();
        assertEquals(driver.getTitle(), "The world's leading software development platform · GitHub");
    }

    @After("@DeleteAndQuitAfter")
    public void deleteAndQuitAfterTest() {
        driver.get(getMainPage() + getUSERNAME() + "/" + getRepositoryName());
        repository.clickSettingsLink();
        assertTrue(wait.until(ExpectedConditions.titleIs("Options")));
        options.clickDeleteThisRepositoryButton();
        options.inputRepositoryName(getRepositoryName());
        options.confirmDeletingTheRepository();
        options.provideSudoPasswordIfRequired();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getUserMenuButton()));
        mainPage.goToMainPage();
        homePage.signOut();
        driver.quit();
    }

    @After("@QuitAfter")
    public void quitAfterTest() {
        mainPage.goToMainPage();
        homePage.signOut();
        driver.quit();
    }
}
