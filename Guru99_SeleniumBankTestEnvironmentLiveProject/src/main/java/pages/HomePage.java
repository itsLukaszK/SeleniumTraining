package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    private String validUserId = "mngr112190";
    private String invalidUserId = "rgnm112190"; //MNGR112190 is correct - it's a BUG!
    private String validPassword = "UgygApU";
    private String invalidPassword = "UpAgygU"; //uGYGaPu is correct - it's a BUG!
    public static String homePageAddress = "http://www.demo.guru99.com/V4/";

    @FindBy(xpath = "//input[@type=\"text\" and @name=\"uid\"]")
    WebElement userIdField;

    @FindBy(xpath = "//input[@type=\"password\" and @name=\"password\"]")
    WebElement passwordField;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCorrectUserId() {
        userIdField.clear();
        userIdField.sendKeys(validUserId);
    }

    public void enterIncorrectUserId() {
        userIdField.clear();
        userIdField.sendKeys(invalidUserId);
    }

    public void enterCorrectPassword() {
        passwordField.clear();
        passwordField.sendKeys(validPassword);
    }

    public void enterIncorrectPassword() {
        passwordField.clear();
        passwordField.sendKeys(invalidPassword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getValidUserId() {
        return validUserId;
    }
}
