package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;

public class Product {
    // Implementation

    private WebDriver driver;

    public Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // WebElements

    @FindBy(css = "select#quantity")
    WebElement quantitySelect;

    @FindBy(css = "input#add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(id = "siNoCoverage-announce")
    WebElement noThanksButton;

    @FindBy(id = "priceblock_ourprice")
    WebElement productPrice;


    // Fields

    private Select select;

    private BigDecimal bigDecimalProductPrice;

    private BigDecimal bigDecimalQuantity;

    private BigDecimal bigDecimalCalculatedSubtotal;


    // Getters

    public WebElement getQuantitySelect() {
        return quantitySelect;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getNoThanksButton() {
        return noThanksButton;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public BigDecimal getBigDecimalCalculatedSubtotal() {
        return bigDecimalCalculatedSubtotal;
    }


    // Setters

    public void setBigDecimalProductPrice() {
        bigDecimalProductPrice = new BigDecimal(productPrice.getText().substring(1).replace(",", ""));
    }

    public void setBigDecimalQuantity(String quantity) {
        bigDecimalQuantity = new BigDecimal(quantity);
    }


    // Methods

    public void selectQuantityOfProducts(String quantity) {
        select = new Select(quantitySelect);
        select.selectByValue(quantity);
    }

    public void selectHighestAvailableQuantityOfProducts() {
        select = new Select(quantitySelect);
        select.selectByIndex(select.getOptions().size() - 1);
    }

    public String getHighestAvailableQuantityOfProducts() {
        select = new Select(quantitySelect);
        return select.getOptions().get(select.getOptions().size() - 1).getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.submit();
    }

    public void clickNoThanksButton() {
        noThanksButton.click();
    }

    public void calculateBigDecimalSubtotal() {
        bigDecimalCalculatedSubtotal = bigDecimalProductPrice.multiply(bigDecimalQuantity);
    }
}
