package cucumber_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.MainPage;
import pages.SignIn;

import static cucumber_steps.BeforeAfter.createANewRepository;
import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CreateANewRepository.getRepositoryName;
import static pages.SignIn.getUSERNAME;

public class CreatingARepository {
    private MainPage mainPage = new MainPage(driver);
    private SignIn signIn = new SignIn(driver);
    private HomePage homePage = new HomePage(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 10L);

    @Given("^User is logged in$")
    public void userIsLoggedIn() {
        mainPage.clickSignInLink();
        assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
        signIn.inputCorrectUsername();
        signIn.inputCorrectPassword();
        signIn.clickSignInButton();
        assertTrue(wait.until(ExpectedConditions.titleIs("GitHub")));
    }

    @When("^User creates a repository called '(.*)' containing ReadMe$")
    public void userCreatesARepositoryCalledName(String name) {
        createANewRepository.setRepositoryName(name);
        homePage.selectNewRepositoryDropdownItem();
        assertEquals(driver.getTitle(), "Create a New Repository");
        createANewRepository.inputRepositoryName();
        createANewRepository.selectInitializeThisRepositoryWithAReadmeBox();
        createANewRepository.clickCreateRepositoryButton();
        assertTrue(wait.until(ExpectedConditions.titleIs(getUSERNAME() + "/" + getRepositoryName())));
    }

    @Then("^The repository has been created$")
    public boolean theRepositoryHasBeenCreated() {
        String xpath = "//a[contains(text(), '" + getRepositoryName() + "')]";
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }
}

