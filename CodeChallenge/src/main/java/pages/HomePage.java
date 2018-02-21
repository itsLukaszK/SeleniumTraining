package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.CreateANewRepository.getRepositoryName;
import static pages.SignIn.getUSERNAME;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "summary.HeaderNavlink[aria-label='Create new…']")
    WebElement createNewButton;

    @FindBy(css = "a.dropdown-item[href='/new']")
    WebElement newRepositoryDropdownItem;

    @FindBy(css = "div#js-flash-container div.container")
    WebElement deletingConfirmationText;

    public WebElement getUserMenuButton() {
        return userMenuButton;
    }

    @FindBy(css = "summary.HeaderNavlink.name")
    WebElement userMenuButton;

    @FindBy(css = "form.logout-form button.dropdown-item")
    WebElement signOutButton;

    public void selectNewRepositoryDropdownItem() {
        createNewButton.click();
        newRepositoryDropdownItem.click();
    }

    public boolean isDeletingConfirmationDisplayed() {
        String expectedDeletingConfirmation = "Your repository \"" + getUSERNAME() + "/" + getRepositoryName() + "\" was successfully deleted. ";
        return expectedDeletingConfirmation.trim().equals(deletingConfirmationText.getText().trim());
    }

    public void signOut() {
        userMenuButton.click();
        signOutButton.click();
    }
}
