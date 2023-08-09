package test;

import org.testng.annotations.Test;
import testdata.DynamicData;


public class SignupTest extends BaseTest {

    @Test(description = "TC_1: Register User")
    public void signUp() {
        app.homePage.navigateToSignupLoginPage();
        app.loginPage.verifySignUpHeaderVisibility();
        app.loginPage.createUser(DynamicData.userName, DynamicData.emailAddress);
        app.signUpPage.verifyAccountInfoHeaderVisibility();
        app.signUpPage.fillAccountDetails(DynamicData.userName, DynamicData.emailAddress, DynamicData.password);
        app.signUpPage.fillAddressDetails(DynamicData.userName, DynamicData.lastName, DynamicData.companyName, DynamicData.address, DynamicData.stateName, DynamicData.cityName, DynamicData.zipcode, DynamicData.mobileNumber);
        app.accountCreatedPage.verifyAccountCreatedHeaderIsVisibleAndContinue();
        app.homePage.verifyTopUserNameVisibility();
        app.homePage.deleteAccount();
        app.deleteAccountPage.verifyDeletedAccountHeaderIsVisibleAndContinue();
    }
}
