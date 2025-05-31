package helper;

import manager.ApplicationManager;

public class NavigationHelper extends HelperBase {
    private final String baseUrl;

    public NavigationHelper(ApplicationManager manager, String url) {
        super(manager);
        this.baseUrl = url;
    }

    public void openHomePage() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
}
