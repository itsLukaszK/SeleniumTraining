package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilePage {
    private WebDriver driver;

    public FilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String fileName;

    public static String newFileName;

    public WebElement getEditThisFileButton() {
        return editThisFileButton;
    }

    @FindBy(css = "button.btn-octicon[aria-label='Edit this file']")
    WebElement editThisFileButton;

    public void clickEditThisFileButton() {
        editThisFileButton.click();
    }

    public static String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public boolean isCommitTitleCorrect() {
        String commitTitle = "Rename " + getFileName() + " to " + getNewFileName();
        String cssSelector = "a[title='" + commitTitle + "']";
        return driver.findElements(By.cssSelector(cssSelector)).size() > 0;
    }
}
