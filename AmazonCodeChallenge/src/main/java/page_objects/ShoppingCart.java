package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;

public class ShoppingCart {
    // Implementation

    private WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // WebElements

    @FindBy(xpath = "//h1[contains(text(), 'Added to Cart')]")
    WebElement addedToCartConfirmation;

    @FindBy(css = ".a-size-medium.sc-product-title")
    WebElement productTitle;

    @FindBy(css = "#sc-subtotal-amount-activecart span")
    WebElement subtotalDisplayed;


    // Fields

    private BigDecimal bigDecimalSubtotalDisplayed;


    // Getters

    public WebElement getAddedToCartConfirmation() {
        return addedToCartConfirmation;
    }

    public WebElement getProductTitle() {
        return productTitle;
    }

    public WebElement getSubtotalDisplayed() {
        return subtotalDisplayed;
    }

    public BigDecimal getBigDecimalSubtotalDisplayed() {
        return bigDecimalSubtotalDisplayed;
    }


    // Methods

    public String getProductTitleText() {
        return productTitle.getText().trim();
    }

    public void setBigDecimalSubtotalDisplayed() {
        bigDecimalSubtotalDisplayed = new BigDecimal(subtotalDisplayed.getText().substring(1).replace(",", ""));
    }
}
