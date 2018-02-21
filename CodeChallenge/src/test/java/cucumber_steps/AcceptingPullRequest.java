package cucumber_steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PullRequests;

import static cucumber_steps.BeforeAfter.driver;
import static org.testng.Assert.assertTrue;

public class AcceptingPullRequest {
    PullRequests pullRequests = new PullRequests(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10L);

    @When("^User accepts pull request$")
    public void userAcceptsPullRequest() throws InterruptedException {
        pullRequests.chooseThePullRequestToBeAccepted();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='This branch has no conflicts with the base branch']")));
        wait.until(ExpectedConditions.visibilityOf(pullRequests.getMergePullRequestButton()));
        pullRequests.clickMergePullRequestButton();
        wait.until(ExpectedConditions.elementToBeClickable(pullRequests.getConfirmMergeButton()));
        pullRequests.clickConfirmMergeButton();
    }

    @Then("^The pull request has been accepted$")
    public void thePullRequestHasBeenAccepted() {
        assertTrue(pullRequests.hasPullRequestBeenAccepted());
    }
}
