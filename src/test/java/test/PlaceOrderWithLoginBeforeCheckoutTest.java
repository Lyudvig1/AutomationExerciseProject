package test;

import org.testng.annotations.Test;
import testdata.DynamicData;
import testdata.StaticData;
import static share.App.*;


public class PlaceOrderWithLoginBeforeCheckoutTest extends BaseTest {
    @Test(description = "TC_16: Place Order Login before Checkout")
    public void orderAfterLogin() {
        homePage.navigateToSignupLoginPage();
        loginPage.login(StaticData.DEFAULT_USER_EMAIL, StaticData.DEFAULT_USER_PASSWORD);
        homePage.verifyTopUserNameVisibility()
                .navigateToProductsPage();
        productsPage.addProductToCart();
        homePage.navigateToCartPage();
        cartPage.verifyCartPageVisibility()
                .verifyAddedProductsVisibilityInCart()
                .navigateToCheckoutPage();
        checkoutPage.verifyAddressDetails()
                .verifyAddedProductsVisibilityInCheckoutPage()
                .addCommentToTextAreaAndGoToPaymentPage(DynamicData.companyName);
        paymentPage.fillPaymentDetails(DynamicData.userName, DynamicData.randomNumber)
                .verifySuccessMessageVisibility(StaticData.SUCCESS_MESSAGE);
        homePage.deleteAccount();
        deleteAccountPage.verifyDeletedAccountHeaderIsVisibleAndContinue();
    }
}
