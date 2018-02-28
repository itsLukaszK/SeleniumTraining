package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    // Implementation

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // WebElements

    @FindBy(xpath = "//span[@class='nav-line-2'][text()='Departments']")
    WebElement departmentsButton;

    @FindBy(id = "nav-cart")
    WebElement cartButton;


    // Fields

    private static String mainPageAddress;

    private final String expectedMainPageTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";


    // Getters

    public WebElement getDepartmentsButton() {
        return departmentsButton;
    }

    public String getExpectedMainPageTitle() {
        return expectedMainPageTitle;
    }

    public WebElement getCartButton() {
        return cartButton;
    }


    // Setters

    public static void setMainPageAddress(String mainPageAddress) {
        MainPage.mainPageAddress = mainPageAddress;
    }


    // Methods

    public void clickDepartmentsButton() {
        departmentsButton.click();
    }

    public void goToMainPageAddress() {
        driver.get(mainPageAddress);
    }

    public void clickCartButton() {
        cartButton.click();
    }
}
