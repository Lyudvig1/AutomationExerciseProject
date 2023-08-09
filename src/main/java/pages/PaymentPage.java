package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class PaymentPage extends BasePage<PaymentPage> {
    private final By nameOnCardInput = By.cssSelector("[data-qa='name-on-card']");
    private final By cardNumberInput = By.cssSelector("[data-qa='card-number']");
    private final By CVCInput = By.cssSelector("[data-qa='cvc']");
    private final By expiryMonthInput = By.cssSelector("[data-qa='expiry-month']");
    private final By expiryYear = By.cssSelector("[data-qa='expiry-year']");
    private final By payAndConfirmOrderBtn = By.cssSelector("[data-qa='pay-button']");
    private final By successMessage = By.cssSelector("[id='success_message']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage fillPaymentDetails(String name, String number) {
        typeText(nameOnCardInput, name);
        typeText(cardNumberInput, number);
        typeText(CVCInput, number);
        typeText(expiryMonthInput, number);
        typeText(expiryYear, number);
        clickOnElement(payAndConfirmOrderBtn);
        return this;
    }

    public PaymentPage verifySuccessMessageVisibility(String expectedMessage) {
        driver.navigate().back();
        var actualMessage = getWebElement(successMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        shouldBeVisible(successMessage);
        return this;
    }
}
