package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static pages.FilePage.getFileName;
import static pages.FilePage.getNewFileName;

public class PullRequests {
    private WebDriver driver;

    public PullRequests(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getPullRequestsButton() {
        return pullRequestsButton;
    }

    @FindBy(css = "a[data-selected-links^='repo_pulls']")
    WebElement pullRequestsButton;

    public WebElement getMergePullRequestButton() {
        return mergePullRequestButton;
    }

    @FindBy(xpath = "//button[contains(text(), 'Merge pull request')]")
    WebElement mergePullRequestButton;

    @FindBy(xpath = "//button[contains(text(), 'Confirm  merge')]")
    WebElement confirmMergeButton;

    @FindAll(@FindBy(xpath = "//h4[text()='Pull request successfully merged and closed']"))
    List<WebElement> pullRequestConfirmations;

    @FindBy(css = "a.tabnav-tab[href$=\"pull/1\"]")
    WebElement conversationButton;

    public void clickPullRequestsButton() throws InterruptedException {
        Thread.sleep(2000);
        pullRequestsButton.click();
    }

    public boolean isPullRequestTitleCorrect() {
        String pullRequestTitle = "Rename " + getFileName() + " to " + getNewFileName();
        String xpath = "//a[contains(text(), '" + pullRequestTitle + "')]";
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public void chooseThePullRequestToBeAccepted() throws InterruptedException {
        Thread.sleep(2000);
        String pullRequestTitle = "Rename " + getFileName() + " to " + getNewFileName();
        String xpath = "//a[contains(text(), '" + pullRequestTitle + "')]";
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
        conversationButton.click();
        Thread.sleep(2000);

    }

    public void clickMergePullRequestButton() {
        mergePullRequestButton.click();
    }

    public boolean hasPullRequestBeenAccepted() {
        return pullRequestConfirmations.size() > 0;
    }

    public void clickConfirmMergeButton() {
        confirmMergeButton.click();
    }

    public WebElement getConfirmMergeButton() {
        return confirmMergeButton;
    }
}
