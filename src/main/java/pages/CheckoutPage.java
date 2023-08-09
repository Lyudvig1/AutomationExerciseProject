package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class CheckoutPage extends BasePage<CheckoutPage> {
    private final By deliveryAddressContent = By.xpath("//*[@id='address_delivery']/li");
    private final By billingAddressContent = By.xpath("//*[@id='address_invoice']/li");
    private final By productInCheckout = By.cssSelector("tbody>tr");
    private final By placeOrderBtn = By.xpath("//a[text()='Place Order']");
    private final By footerText = By.cssSelector("[class='pull-left']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage verifyAddressDetails() {
        compareTextLists(deliveryAddressContent, billingAddressContent, 1);
        return this;
    }

    public CheckoutPage verifyAddedProductsVisibilityInCheckoutPage() {
        var products = getWebElements(productInCheckout);
        products.forEach(e -> {
            Assert.assertTrue(e.isDisplayed());
        });
        return this;
    }

    public CheckoutPage addCommentToTextAreaAndGoToPaymentPage(String text) {
        WebElement textareaElement = driver.findElement(By.className("form-control"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]", textareaElement, text);
        driver.switchTo().defaultContent();
        scrollInToView(footerText);
        clickOnElement(placeOrderBtn);
        return this;
    }
}
