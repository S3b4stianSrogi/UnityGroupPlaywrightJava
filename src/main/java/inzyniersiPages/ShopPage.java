package inzyniersiPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ShopPage {

    private final Page page;
    private final String productList = "ul.products.columns-4";
    private final String allProducts = "li.product";
    private final String addToCartBtn = ".ajax_add_to_cart";
    private final String goToCartBtn = "a.added_to_cart";

    public ShopPage(Page page) {
        this.page = page;
    }


    public void addProductToCart(String productName) {
        page.waitForSelector(productList);
        Locator products = page.locator(allProducts);
        products.locator(":scope", new Locator.LocatorOptions().setHasText(productName)).first().locator(addToCartBtn).click();
    }

    public void goToCart(String productName) {
        page.waitForSelector(productList);
        Locator products = page.locator(allProducts);
        products.locator(":scope", new Locator.LocatorOptions().setHasText(productName)).first().locator(goToCartBtn).click();
    }
}