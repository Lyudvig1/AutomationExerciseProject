package test;

import org.testng.annotations.Test;
import testdata.StaticData;

public class SearchProductTest extends BaseTest {
    @Test(description = "TC_9: Search Product")
    public void searchProduct() {
        app.homePage.navigateToProductsPage();
        app.productsPage.verifyAllProductsHeaderVisibility();
        app.productsPage.searchProduct(StaticData.PRODUCT_NAME);
        app.productsPage.verifySearchedProductsHeaderVisibility();
        app.productsPage.verifyAllProductsAreVisibleInSearchResults();
    }
}
