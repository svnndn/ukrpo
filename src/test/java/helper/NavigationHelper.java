package helper;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(WebDriver driver, String url) {
        super(driver);
        this.baseUrl = url;
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }
}
