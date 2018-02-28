package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CameraPhotoVideo {
    // Implementation

    private WebDriver driver;

    public CameraPhotoVideo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // WebElements

    @FindBy(xpath = "//span[@class='nav-a-content'][text()='Best Sellers']")
    WebElement bestSellersLink;


    // Getters

    public WebElement getBestSellersLink() {
        return bestSellersLink;
    }


    // Methods

    public void clickBestSellersLink() {
        bestSellersLink.click();
    }
}
