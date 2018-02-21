package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Repository {
    private WebDriver driver;

    public Repository(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href$='/settings']")
    WebElement settingsLink;

    public void clickSettingsLink() {
        settingsLink.click();
    }

    public void openAFile(String fileName) {
        WebElement fileLink = driver.findElement(By.cssSelector("a[title='" + fileName + "']"));
        fileLink.click();
    }

}
