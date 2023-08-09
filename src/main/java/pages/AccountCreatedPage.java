package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class AccountCreatedPage extends BasePage<AccountCreatedPage> {

    private final By accountCratedHeader = By.xpath("//b[contains(text(), 'Account Created')]");
    private final By continueBtn = By.cssSelector("[data-qa='continue-button']");
    private final By closeBtn = By.xpath("//span[text()='Close']");
    private final By advertisementIframe = By.cssSelector("[id='ad_iframe']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public AccountCreatedPage verifyAccountCreatedHeaderIsVisibleAndContinue() {
        shouldBeVisible(accountCratedHeader);
        clickOnElement(continueBtn);
        return this;
    }
}
