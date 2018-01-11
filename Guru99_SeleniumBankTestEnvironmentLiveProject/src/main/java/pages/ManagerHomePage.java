package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ManagerHomePage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
    WebElement managerIdInformation;

    @FindBy(xpath = "//a[@href=\"Logout.php\"]")
    WebElement logOutButton;

    public ManagerHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logOut() {
        logOutButton.click();
        driver.switchTo().alert().accept();
    }

    public String getManagerIdInformation() {
        return managerIdInformation.getText();
    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File successfulLoginScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationOfFile = new File(System.getProperty("user.dir") + "\\successfulLoginScreenshot_" + System.currentTimeMillis() + ".JPG");
        FileUtils.copyFile(successfulLoginScreenshot, destinationOfFile);
    }
}
