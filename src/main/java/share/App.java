package share;


import org.openqa.selenium.WebDriver;
import pages.*;

/**
 * Class for shared common pages or notifications definitions.
 */
public class App {
    protected WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public DeleteAccountPage deleteAccountPage;
    public AccountCreatedPage accountCreatedPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public PaymentPage paymentPage;

    public App(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.signUpPage = new SignUpPage(driver);
        this.accountCreatedPage = new AccountCreatedPage(driver);
        this.deleteAccountPage = new DeleteAccountPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.paymentPage = new PaymentPage(driver);
    }
}
