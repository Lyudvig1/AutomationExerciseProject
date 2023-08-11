package share;


import org.openqa.selenium.WebDriver;
import pages.*;

/**
 * Class for shared common pages or notifications definitions.
 */
public class App {
    protected WebDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static SignUpPage signUpPage;
    public static DeleteAccountPage deleteAccountPage;
    public static AccountCreatedPage accountCreatedPage;
    public static ProductsPage productsPage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;
    public static PaymentPage paymentPage;

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
