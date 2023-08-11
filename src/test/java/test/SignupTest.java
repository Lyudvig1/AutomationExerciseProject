package test;

import org.testng.annotations.Test;
import testdata.DynamicData;
import static share.App.*;


public class SignupTest extends BaseTest {

    @Test(description = "TC_1: Register User")
   public void signUp() {
        homePage.navigateToSignupLoginPage();
        loginPage.verifySignUpHeaderVisibility()
                .createUser(DynamicData.userName, DynamicData.emailAddress);
        signUpPage.verifyAccountInfoHeaderVisibility()
                .fillAccountDetails(DynamicData.userName, DynamicData.emailAddress, DynamicData.password)
                .fillAddressDetails(DynamicData.userName, DynamicData.lastName, DynamicData.companyName, DynamicData.address, DynamicData.stateName, DynamicData.cityName, DynamicData.zipcode, DynamicData.mobileNumber);
        accountCreatedPage.verifyAccountCreatedHeaderIsVisibleAndContinue();
        homePage.verifyTopUserNameVisibility()
                .deleteAccount();
        deleteAccountPage.verifyDeletedAccountHeaderIsVisibleAndContinue();
    }
}
