package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
    private WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String USERNAME = "rFctLTZfoB";
    private static final String PASSWORD = "weqzUIlE4G";

    @FindBy(id = "login_field")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "input.btn")
    WebElement signInButton;


    public void inputCorrectUsername() {
        usernameInput.clear();
        usernameInput.sendKeys(USERNAME);
    }

    public void inputCorrectPassword() {
        passwordInput.clear();
        passwordInput.sendKeys(PASSWORD);
    }

    public void clickSignInButton() {
        signInButton.submit();
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }
}
