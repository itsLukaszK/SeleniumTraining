package cucumber_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.*;

import static cucumber_steps.BeforeAfter.driver;
import static cucumber_steps.BeforeAfter.wait;
import static org.testng.Assert.assertEquals;
import static page_objects.MainPage.setMainPageAddress;

public class AmazonFeatureSteps {
    private MainPage mainPage = new MainPage(driver);
    private CameraPhotoVideo cameraPhotoVideo = new CameraPhotoVideo(driver);
    private Departments departments = new Departments(driver);
    private BestSellersBestCameraPhoto bestSellersBestCameraPhoto = new BestSellersBestCameraPhoto(driver);
    private BestSellersBestDigitalCameras bestSellersBestDigitalCameras = new BestSellersBestDigitalCameras(driver);
    private Product product = new Product(driver);
    private ShoppingCart shoppingCart = new ShoppingCart(driver);

    @Given("^User is visiting '(.*)' site$")
    public void userIsVisitingWebAddressSite(String webAddress) {
        setMainPageAddress(webAddress);
        mainPage.goToMainPageAddress();
        wait.until(ExpectedConditions.titleIs(mainPage.getExpectedMainPageTitle()));
    }

    @When("^User goes into Best Sellers in Digital Cameras$")
    public void userGoesIntoBestSellersInDigitalCameras() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getDepartmentsButton()));
        mainPage.clickDepartmentsButton();
        wait.until(ExpectedConditions.elementToBeClickable(departments.getCameraPhotoVideoLink()));
        departments.clickCameraPhotoVideoLink();
        wait.until(ExpectedConditions.elementToBeClickable(cameraPhotoVideo.getBestSellersLink()));
        cameraPhotoVideo.clickBestSellersLink();
        wait.until(ExpectedConditions.elementToBeClickable(bestSellersBestCameraPhoto.getDigitalCamerasLink()));
        bestSellersBestCameraPhoto.clickDigitalCamerasLink();
        wait.until(ExpectedConditions.titleIs(bestSellersBestDigitalCameras.getExpectedBestSellersBestDigitalCamerasPageTitle()));
    }

    @When("^User opens details of product number '(.*)' from the list and gets the name of the product$")
    public void userOpensDetailsOfProductNumberProductNumberFromTheList(int productNumber) {
        productNumber--;
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(bestSellersBestDigitalCameras.getDigitalCameraProductsListCssLocator()), 20));
        wait.until(ExpectedConditions.elementToBeClickable(bestSellersBestDigitalCameras.getDigitalCameraProduct(productNumber)));
        bestSellersBestDigitalCameras.setDigitalCameraProductName(productNumber);
        bestSellersBestDigitalCameras.clickDigitalCameraProduct(productNumber);
        wait.until(ExpectedConditions.titleContains("Amazon.com : "));
        wait.until(ExpectedConditions.titleContains(" : Camera & Photo"));
    }

    @When("^User adds '(.*)' or maximum available number of pieces of the product to the shopping cart and gets the price of the product$")
    public void userAddsQuantityPiecesOfTheProductToTheShoppingCartAndGetsThePriceOfTheProduct(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(product.getProductPrice()));
        product.setBigDecimalProductPrice();
        try {
            wait.until(ExpectedConditions.visibilityOf(product.getQuantitySelect()));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(product.getQuantitySelect()));
                product.selectQuantityOfProducts(quantity);
            } catch (NoSuchElementException e) {
                product.selectHighestAvailableQuantityOfProducts();
                quantity = product.getHighestAvailableQuantityOfProducts();
            }
        } catch (TimeoutException e) {
            quantity = "1";
        }
        product.setBigDecimalQuantity(quantity);
        product.calculateBigDecimalSubtotal();
        wait.until(ExpectedConditions.elementToBeClickable(product.getAddToCartButton()));
        product.clickAddToCartButton();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(product.getNoThanksButton()));
            product.clickNoThanksButton();
        } catch (TimeoutException e) {
        }
        wait.until(ExpectedConditions.visibilityOf(shoppingCart.getAddedToCartConfirmation()));
    }

    @Then("^The correct product was added$")
    public void theCorrectProductWasAdded() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getCartButton()));
        mainPage.clickCartButton();
        wait.until(ExpectedConditions.visibilityOf(shoppingCart.getProductTitle()));
        assertEquals(shoppingCart.getProductTitleText(), bestSellersBestDigitalCameras.getDigitalCameraProductName());
    }

    @Then("^The subtotal price sum is correct$")
    public void theSubtotalPriceSumIsCorrect() {
        wait.until(ExpectedConditions.visibilityOf(shoppingCart.getSubtotalDisplayed()));
        shoppingCart.setBigDecimalSubtotalDisplayed();
        assertEquals(product.getBigDecimalCalculatedSubtotal(), shoppingCart.getBigDecimalSubtotalDisplayed());
    }
}
