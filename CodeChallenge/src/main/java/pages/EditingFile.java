package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class EditingFile {
    private WebDriver driver;

    public EditingFile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input.form-control.js-blob-filename")
    WebElement fileNameInput;

    public WebElement getCommitChangesButton() {
        return commitChangesButton;
    }

    @FindBy(xpath = "//button[contains(text(), 'Commit changes')]")
    WebElement commitChangesButton;

    @FindBy(css = "input[value='quick-pull']")
    WebElement choosePullRequestInput;

    public WebElement getProposeFileChangeButton() {
        return proposeFileChangeButton;
    }

    @FindBy(xpath = "//button[text()='Propose file change']")
    WebElement proposeFileChangeButton;

    public void changeTheNameOfTheFileTo(String newFileName) throws InterruptedException {
        fileNameInput.clear();
        fileNameInput.sendKeys(newFileName);
        assertTrue(fileNameInput.getAttribute("value").equals(newFileName));
        Thread.sleep(2000);
    }

    public void clickCommitChangesButton(){
        commitChangesButton.submit();
    }

    public void choosePullRequest(){
        choosePullRequestInput.click();
    }

    public void clickProposeFileChangeButton(){
        proposeFileChangeButton.submit();
    }

}
