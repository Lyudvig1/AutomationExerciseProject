package test;

import org.testng.annotations.Test;
import testdata.StaticData;

public class SearchProductTest extends BaseTest {
    @Test(description = "TC_9: Search Product")
   public void searchProduct() {
        app.homePage.navigateToProductsPage();
        app.productsPage.verifyAllProductsHeaderVisibility()
                .searchProduct(StaticData.PRODUCT_NAME)
                .verifySearchedProductsHeaderVisibility()
                .verifyAllProductsAreVisibleInSearchResults();
    }
}
