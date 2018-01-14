import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

class ShoppingCart {
    private WebDriver driver;

    ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.button.btn-update")
    WebElement updateButton;

    @FindBy(css = "p.item-msg.error")
    WebElement errorMessage;

    @FindBy(id = "empty_cart_button")
    WebElement emptyCartButton;

    @FindBy(css = "div.page-title > h1")
    WebElement pageTitleHeader;

    @FindBy(css = "div.cart-empty > p")
    WebElement cartEmptyParagraph;

    void changeQuantityOfProductInCartTo(String sku, String quantity) {
        WebElement quantityInputBox = driver.findElement(By.xpath("//input[@type='text' and @data-cart-item-id='" + sku + "']"));
        quantityInputBox.clear();
        quantityInputBox.sendKeys(quantity);
        updateButton.click();
    }

    String getErrorMessage() {
        return errorMessage.getText();
    }

    void emptyCart() {
        emptyCartButton.click();
    }

    boolean isCartEmpty() {
        return Objects.equals(pageTitleHeader.getText(), "SHOPPING CART IS EMPTY") && Objects.equals(cartEmptyParagraph.getText(), "You have no items in your shopping cart.");
    }
}
