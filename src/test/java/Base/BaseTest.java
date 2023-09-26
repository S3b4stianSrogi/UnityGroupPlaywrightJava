package Base;

import java.util.Properties;

import inzyniersiFactory.PlaywrigtFactory;
import inzyniersiPages.CartPage;
import inzyniersiPages.ShopPage;
import inzyniersiPages.UtilityPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

public class BaseTest {
    PlaywrigtFactory pf;
    Page page;
    Properties prop;

    protected UtilityPage utilityPage;
    protected ShopPage shopPage;
    protected CartPage cartPage;

    @BeforeTest
    public void setup() {
        pf = new PlaywrigtFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        utilityPage = new UtilityPage(page);
        shopPage = new ShopPage(page);
        cartPage = new CartPage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }

}