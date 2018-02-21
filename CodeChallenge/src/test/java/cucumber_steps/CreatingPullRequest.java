package cucumber_steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ComparingBranches;
import pages.PullRequests;

import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertTrue;

public class CreatingPullRequest {
    private ComparingBranches comparingBranches = new ComparingBranches(driver);
    private PullRequests pullRequests = new PullRequests(driver);
    private WebDriverWait wait = new WebDriverWait(driver, 10L);

    @When("^User creates pull request$")
    public void userCreatesPullRequest() {
        wait.until(ExpectedConditions.visibilityOf(comparingBranches.getCreatePullRequestButton()));
        comparingBranches.clickCreatePullRequestButton();
    }

    @Then("^The pull request has been created$")
    public void thePullRequestHasBeenCreated() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(pullRequests.getPullRequestsButton()));
        pullRequests.clickPullRequestsButton();
        assertTrue(pullRequests.isPullRequestTitleCorrect());
    }
}
