package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestSellersBestCameraPhoto {
    // Implementation

    private WebDriver driver;

    public BestSellersBestCameraPhoto(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // WebElements

    @FindBy(xpath = "//a[text()='Digital Cameras']")
    WebElement digitalCamerasLink;


    // Getters

    public WebElement getDigitalCamerasLink() {
        return digitalCamerasLink;
    }


    // Methods

    public void clickDigitalCamerasLink() {
        digitalCamerasLink.click();
    }
}
