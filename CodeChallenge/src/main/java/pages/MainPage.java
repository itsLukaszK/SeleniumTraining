package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String MAIN_PAGE = "https://github.com/";

    @FindBy(css = "a.text-bold[href='/login']")
    WebElement signInLink;

    public void goToMainPage() {
        driver.get(MAIN_PAGE);
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public static String getMainPage() {
        return MAIN_PAGE;
    }
}
