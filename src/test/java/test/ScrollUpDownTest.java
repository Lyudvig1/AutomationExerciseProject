package test;

import org.testng.annotations.Test;
import static share.App.*;

public class ScrollUpDownTest extends BaseTest {
    @Test(description = "TC_25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
   public void verifyScrollUpDownWithArrowButton() {
        homePage.scrollDownAndVerifyFooterHeader()
                .clickArrowToMoveUpwardAndVerifySliderText();
    }
}
