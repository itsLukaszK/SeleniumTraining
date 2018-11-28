package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String HOME_PAGE = "http://live.guru99.com/";

    @FindBy(xpath = "//a[@href=\"http://live.guru99.com/index.php/mobile.html\" and @class=\"level0 \"]")
    WebElement mobileButton;

    public void goToHomePage() {
        driver.get(HOME_PAGE);
    }

    public void clickMobileButton() {
        mobileButton.click();
    }

    @FindBy(css = ".skip-link.skip-account[data-target-element='#header-account']")
    WebElement accountButton;

    public enum HomePageButtons {
        MOBILE,
        ACCOUNT
    }

    public void clickButton(HomePageButtons button) {
        switch (button) {
            case MOBILE:
                mobileButton.click();
                break;
            case ACCOUNT:
                accountButton.click();
        }
    }
}
