package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateANewRepository {
    private WebDriver driver;

    public CreateANewRepository(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String repositoryName;

    public static String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    @FindBy(id = "repository_name")
    WebElement repositoryNameInput;

    @FindBy(id = "repository_auto_init")
    WebElement initializeThisRepositoryWithAReadmeBox;

    @FindBy(css = "button.btn.btn-primary")
    WebElement createRepositoryButton;

    public void inputRepositoryName() {
        repositoryNameInput.clear();
        repositoryNameInput.sendKeys(getRepositoryName());
    }

    public void selectInitializeThisRepositoryWithAReadmeBox() {
        if (!initializeThisRepositoryWithAReadmeBox.isSelected()) initializeThisRepositoryWithAReadmeBox.click();
    }

    public void clickCreateRepositoryButton() {
        createRepositoryButton.submit();
    }
}
