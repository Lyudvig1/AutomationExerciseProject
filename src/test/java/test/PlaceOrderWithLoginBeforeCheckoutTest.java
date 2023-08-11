package test;

import org.testng.annotations.Test;
import testdata.DynamicData;
import testdata.StaticData;


public class PlaceOrderWithLoginBeforeCheckoutTest extends BaseTest {
    @Test(description = "TC_16: Place Order Login before Checkout")
    public void orderAfterLogin() {
        app.homePage.navigateToSignupLoginPage();
        app.loginPage.login(StaticData.DEFAULT_USER_EMAIL, StaticData.DEFAULT_USER_PASSWORD);
        app.homePage.verifyTopUserNameVisibility()
                .navigateToProductsPage();
        app.productsPage.addProductToCart();
        app.homePage.navigateToCartPage();
        app.cartPage.verifyCartPageVisibility()
                .verifyAddedProductsVisibilityInCart()
                .navigateToCheckoutPage();
        app.checkoutPage.verifyAddressDetails()
                .verifyAddedProductsVisibilityInCheckoutPage()
                .addCommentToTextAreaAndGoToPaymentPage(DynamicData.companyName);
        app.paymentPage.fillPaymentDetails(DynamicData.userName, DynamicData.randomNumber)
                .verifySuccessMessageVisibility(StaticData.SUCCESS_MESSAGE);
        app.homePage.deleteAccount();
        app.deleteAccountPage.verifyDeletedAccountHeaderIsVisibleAndContinue();
    }
}
