package test;

import org.testng.annotations.Test;
import testdata.DynamicData;


public class SignupTest extends BaseTest {

    @Test(description = "TC_1: Register User")
   public void signUp() {
        app.homePage.navigateToSignupLoginPage();
        app.loginPage.verifySignUpHeaderVisibility()
                .createUser(DynamicData.userName, DynamicData.emailAddress);
        app.signUpPage.verifyAccountInfoHeaderVisibility()
                .fillAccountDetails(DynamicData.userName, DynamicData.emailAddress, DynamicData.password)
                .fillAddressDetails(DynamicData.userName, DynamicData.lastName, DynamicData.companyName, DynamicData.address, DynamicData.stateName, DynamicData.cityName, DynamicData.zipcode, DynamicData.mobileNumber);
        app.accountCreatedPage.verifyAccountCreatedHeaderIsVisibleAndContinue();
        app.homePage.verifyTopUserNameVisibility()
                .deleteAccount();
        app.deleteAccountPage.verifyDeletedAccountHeaderIsVisibleAndContinue();
    }
}
