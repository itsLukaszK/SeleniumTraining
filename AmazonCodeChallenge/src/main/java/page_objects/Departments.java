package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Departments {
    // Implementation

    private WebDriver driver;

    public Departments(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // WebElements

    @FindBy(xpath = "//a[@class='a-link-normal fsdLink fsdDeptLink'][text()='Camera, Photo & Video']")
    WebElement cameraPhotoVideoLink;


    // Getters

    public WebElement getCameraPhotoVideoLink() {
        return cameraPhotoVideoLink;
    }


    // Methods

    public void clickCameraPhotoVideoLink() {
        cameraPhotoVideoLink.click();
    }
}
