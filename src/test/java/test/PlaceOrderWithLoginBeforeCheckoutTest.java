package test;

import org.testng.annotations.Test;
import testdata.DynamicData;
import testdata.StaticData;


public class PlaceOrderWithLoginBeforeCheckoutTest extends BaseTest {
    @Test(description = "TC_16: Place Order Login before Checkout")
    public void orderAfterLogin() {
        app.homePage.navigateToSignupLoginPage();
        app.loginPage.login(StaticData.DEFAULT_USER_EMAIL, StaticData.DEFAULT_USER_PASSWORD);
        app.homePage.verifyTopUserNameVisibility();
        app.homePage.navigateToProductsPage();
        app.productsPage.addProductToCart();
        app.homePage.navigateToCartPage();
        app.cartPage.verifyCartPageVisibility();
        app.cartPage.verifyAddedProductsVisibilityInCart();
        app.cartPage.navigateToCheckoutPage();
        app.checkoutPage.verifyAddressDetails();
        app.checkoutPage.verifyAddedProductsVisibilityInCheckoutPage();
        app.checkoutPage.addCommentToTextAreaAndGoToPaymentPage(DynamicData.companyName);
        app.paymentPage.fillPaymentDetails(DynamicData.userName, DynamicData.randomNumber);
        app.paymentPage.verifySuccessMessageVisibility(StaticData.SUCCESS_MESSAGE);
        app.homePage.deleteAccount();
        app.deleteAccountPage.verifyDeletedAccountHeaderIsVisibleAndContinue();
    }
}
