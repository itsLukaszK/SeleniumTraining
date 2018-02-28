package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BestSellersBestDigitalCameras {
    // Implementation

    private WebDriver driver;

    public BestSellersBestDigitalCameras(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // Fields

    private final String expectedBestSellersBestDigitalCamerasPageTitle = "Amazon Best Sellers: Best Digital Cameras";

    private final String digitalCameraProductsListCssLocator = "#zg_centerListWrapper .p13n-sc-truncated";

    private String digitalCameraProductName;


    // WebElements

    @FindAll(@FindBy(css = digitalCameraProductsListCssLocator))
    List<WebElement> digitalCameraProductsList;


    // Getters

    public WebElement getDigitalCameraProduct(int index) {
        return digitalCameraProductsList.get(index);
    }

    public String getDigitalCameraProductName() {
        return digitalCameraProductName;
    }

    public String getExpectedBestSellersBestDigitalCamerasPageTitle() {
        return expectedBestSellersBestDigitalCamerasPageTitle;
    }

    public String getDigitalCameraProductsListCssLocator() {
        return digitalCameraProductsListCssLocator;
    }


    // Setters

    public void setDigitalCameraProductName(int index) {
        if (digitalCameraProductsList.get(index).getAttribute("title") != null && !digitalCameraProductsList.get(index).getAttribute("title").equals("")) {
            digitalCameraProductName = digitalCameraProductsList.get(index).getAttribute("title");
        } else digitalCameraProductName = digitalCameraProductsList.get(index).getText();
    }


    // Methods

    public void clickDigitalCameraProduct(int index) {
        getDigitalCameraProduct(index).click();
    }
}
