package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    public void pomClick(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
