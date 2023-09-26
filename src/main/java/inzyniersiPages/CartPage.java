package inzyniersiPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class CartPage {

    private final Page page;
    private final String productPriceRow = "td.product-price";
    private final String productQuantityRow = "td.product-quantity div input";

    private final String productSubTotalRow = "td.product-subtotal";

    public CartPage(Page page) {
        this.page = page;
    }

    public void validateProductInCart(String productName, String price, String quantity, String subTotal) {

        Locator productNames = page.getByText(productName, new Page.GetByTextOptions().setExact(true));
        Locator productPrice = page.locator(productPriceRow);
        Locator productQuantity = page.locator(productQuantityRow);
        Locator productSubtotal = page.locator(productSubTotalRow).filter();
        assertThat(productNames).hasText(productName);
        assertThat(productPrice).hasText(price);
        assertThat(productQuantity).hasValue(quantity);
        assertThat(productSubtotal).hasText(subTotal);
    }
}
