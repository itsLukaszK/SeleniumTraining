package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductsComparisonList {
    WebDriver driver;

    public ProductsComparisonList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(css = "h2.product-name a"))
    List<WebElement> comparedProducts;

    @FindBy(css = ".page-title h1")
    WebElement header;

    public WebElement getHeader() {
        return header;
    }

    public boolean doesTheWindowContainTheSelectedProducts(String product0, String product1) {
        List<String> comparedProductsNames = new ArrayList<>();
        for (WebElement product :
                comparedProducts) {
            comparedProductsNames.add(product.getText().toUpperCase());
        }
        return comparedProductsNames.contains(product0.toUpperCase()) && comparedProductsNames.contains(product1.toUpperCase());
    }
}
