package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage<LoginPage> {

    private final By userNameInput = By.cssSelector("[data-qa='signup-name']");
    private final By signupEmailInput = By.cssSelector("[data-qa='signup-email']");
    private final By signupBtn = By.cssSelector("[data-qa='signup-button']");
    private final By signupHeader = By.xpath("//h2[text() = 'New User Signup!']");
    private final By loginEmailInput = By.cssSelector("[data-qa='login-email']");
    private final By loginPasswordInput = By.cssSelector("[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("[data-qa='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage verifySignUpHeaderVisibility() {
        shouldBeVisible(signupHeader);
        return this;
    }

    public LoginPage createUser(String name, String email) {
        getWebElement(userNameInput).sendKeys(name);
        getWebElement(signupEmailInput).sendKeys(email);
        getWebElement(signupBtn).click();
        return this;
    }

    public LoginPage login(String email, String password) {
        typeText(loginEmailInput, email);
        typeText(loginPasswordInput, password);
        clickOnElement(loginBtn);
        return this;
    }
}
