package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ProductsPage extends BasePage<ProductsPage> {

    private final By allProductHeader = By.xpath("//h2[text()='All Products']");
    private final By searchInput = By.cssSelector("[id='search_product']");
    private final By searchBtn = By.cssSelector("[id='submit_search']");
    private final By searchedProductsHeader = By.xpath("//h2[text()='Searched Products']");
    private final By productName = By.xpath("//h2[text()='Rs. 500']");
    private final By addProductBtnList = By.cssSelector(".productinfo .add-to-cart");
    private final By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage verifyAllProductsHeaderVisibility() {
        shouldBeVisible(allProductHeader);
        return this;
    }

    public ProductsPage searchProduct(String productName) {
        clickOnElement(searchInput);
        typeText(searchInput, productName);
        clickOnElement(searchBtn);
        return this;
    }

    public ProductsPage verifySearchedProductsHeaderVisibility() {
        shouldBeVisible(searchedProductsHeader);
        return this;
    }

    public void verifyAllProductsAreVisibleInSearchResults() {
        // ToDo change soft assert with hard assert after resolving the product display issue
        SoftAssert softAssert = new SoftAssert();
        var products = getWebElements(productName);
        products.forEach(e -> {
            scrollInToView((By) e);
            softAssert.assertTrue(e.isDisplayed());
        });
    }

    public void addProductToCart() {
        Random random = new Random();
        var addProducts = getWebElements(addProductBtnList);
        var index = random.nextInt(addProducts.size());
        waitForElementExist(addProductBtnList);
        addProducts.get(index).click();
        clickOnElement(continueShoppingBtn);
    }
}
