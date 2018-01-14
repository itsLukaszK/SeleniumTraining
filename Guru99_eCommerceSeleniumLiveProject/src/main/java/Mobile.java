import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Mobile {
    WebDriver driver;

    public Mobile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@onchange=\"setLocation(this.value)\" and @title=\"Sort By\"]")
    WebElement sortBySelect;

    @FindAll(@FindBy(xpath = "//h2/a"))
    List<WebElement> products;

    public void selectSortByValue(String text) {
        Select sortBy = new Select(sortBySelect);
        sortBy.selectByVisibleText(text);
    }

    public boolean areProductsSortedByName() {
        List<String> productNames = new ArrayList<String>();
        for (WebElement product :
                products) {
            productNames.add(product.getText());
        }
        List<String> productNamesToBeSortedByName = new ArrayList<String>(productNames);
        Collections.sort(productNamesToBeSortedByName);
        return productNames.equals(productNamesToBeSortedByName);
    }

    public String getProductPrice(String product) {
        String xpath = "//h2/a[text()='" + product + "']//following::span[@class='price']";
        WebElement productPrice = driver.findElement(By.xpath(xpath));
        return productPrice.getText();
    }

    public void goToProductPage(String product) {
        String xpath = "//h2/a[text()='" + product + "']";
        WebElement productButton = driver.findElement(By.xpath(xpath));
        productButton.click();
        assertEquals(driver.getTitle(), product + " - Mobile");
    }

    public void addProductToCart(String product) {
        String xpath = "//h2/a[text()='" + product + "']//following::button";
        WebElement addProductToCartButton = driver.findElement(By.xpath(xpath));
        addProductToCartButton.click();
        assertEquals(driver.getTitle(), "Shopping Cart");
    }
}
