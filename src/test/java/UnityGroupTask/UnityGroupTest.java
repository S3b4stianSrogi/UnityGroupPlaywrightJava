package UnityGroupTask;

import Base.BaseTest;
import org.testng.annotations.Test;

public class UnityGroupTest extends BaseTest {

    @Test
    public void goToShopTab() {
        utilityPage.goToTab("Sklep");
        shopPage.addProductToCart("Test Product");
        shopPage.goToCart("Test Product");
        cartPage.validateProductInCart("Test Product", "$10.00", "1", "$10.00");

    }
}