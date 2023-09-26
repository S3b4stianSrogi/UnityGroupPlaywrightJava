package inzyniersiPages;

import com.microsoft.playwright.Page;

public class UtilityPage {
    private final Page page;
    private final String navBar = ".wp-block-page-list";

    public UtilityPage(Page page) {
        this.page = page;
    }


    public void goToTab(String tabName) {
        page.locator(navBar).getByText(tabName).click();

    }
}
