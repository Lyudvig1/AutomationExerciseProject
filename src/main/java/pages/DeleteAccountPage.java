package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DeleteAccountPage extends BasePage<DeleteAccountPage> {

    private final By accountDeletedHeader = By.cssSelector("[data-qa='account-deleted']");
    private final By continueBtn = By.cssSelector("[data-qa='continue-button']");


    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    public DeleteAccountPage verifyDeletedAccountHeaderIsVisibleAndContinue() {
        shouldBeVisible(accountDeletedHeader);
        clickOnElement(continueBtn);
        return this;
    }
}
