package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage<CartPage>{
    private final By shoppingCartSectionName = By.xpath("//li[text()='Shopping Cart']");
    private final By addedProducts = By.cssSelector("tbody>tr");
    private final By proceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    public CartPage(WebDriver driver){
        super(driver);
    }

    public CartPage verifyCartPageVisibility(){
        shouldBeVisible(shoppingCartSectionName);
        return this;
    }

    public CartPage verifyAddedProductsVisibilityInCart(){
        var products = getWebElements(addedProducts);
        products.forEach(e->{
            Assert.assertTrue(e.isDisplayed());
        });
        return this;
    }

    public CartPage navigateToCheckoutPage(){
        clickOnElement(proceedToCheckoutBtn);
        return this;
    }
}
