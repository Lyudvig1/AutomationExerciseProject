package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage<HomePage> {

    private final By slider = By.xpath("//*[@id='slider-carousel']/div/div[2]/div[1]");
    private final By signUpLoginBtn = By.xpath("//a[text()=' Signup / Login']");
    private final By loggedInAsUser = By.xpath("//i[@class = 'fa fa-user']/following-sibling::b");
    private final By deleteAccountBtn = By.xpath("//a[contains(text(), ' Delete Account')]");
    private final By productsBtn = By.xpath("//a[text()=' Products']");
    private final By cartBtn = By.xpath("//a[text()=' Cart']");
    private final By subscriptionHeader = By.xpath("//h2[text()='Subscription']");
    private final By scrollUpArrow = By.cssSelector("[id='scrollUp']");
    private final By sliderText = By.cssSelector(".col-sm-6 h2");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage verifyHomePageVisibility(String title) {
        verifyPageTitle(title);
        waitForElementVisibility(slider);
        shouldBeVisible(slider);
        return this;
    }

    public HomePage navigateToSignupLoginPage() {
        clickOnElement(signUpLoginBtn);
        return this;
    }

    public HomePage navigateToProductsPage() {
        clickOnElement(productsBtn);
        return this;
    }

    public HomePage navigateToCartPage() {
        clickOnElement(cartBtn);
        return this;
    }

    public HomePage verifyTopUserNameVisibility() {
        shouldBeVisible(loggedInAsUser);
        return this;
    }

    public HomePage deleteAccount() {
        scrollInToView(deleteAccountBtn);
        clickOnElement(deleteAccountBtn);
        return this;
    }

    public HomePage scrollDownAndVerifyFooterHeader() {
        scrollPageDown(driver);
        shouldBeVisible(subscriptionHeader);
        return this;
    }


    public HomePage clickArrowToMoveUpwardAndVerifySliderText() {
        clickOnElement(scrollUpArrow);
        shouldBeVisible(sliderText);
        return this;
    }
}
