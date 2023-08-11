package test;

import org.testng.annotations.Test;
import testdata.StaticData;
import static share.App.*;

public class SearchProductTest extends BaseTest {
    @Test(description = "TC_9: Search Product")
   public void searchProduct() {
        homePage.navigateToProductsPage();
        productsPage.verifyAllProductsHeaderVisibility()
                .searchProduct(StaticData.PRODUCT_NAME)
                .verifySearchedProductsHeaderVisibility()
                .verifyAllProductsAreVisibleInSearchResults();
    }
}
