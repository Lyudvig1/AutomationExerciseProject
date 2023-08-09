package test;

import org.testng.annotations.Test;

public class ScrollUpDownTest extends BaseTest {
    @Test(description = "TC_25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void verifyScrollUpDownWithArrowButton() {
        app.homePage.scrollDownAndVerifyFooterHeader();
        app.homePage.clickArrowToMoveUpwardAndVerifySliderText();
    }
}
