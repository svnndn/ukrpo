package manager;

import helper.LoginHelper;
import helper.NavigationHelper;
import helper.TaskHelper;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Getter
    private NavigationHelper navigationHelper;
    @Getter
    private LoginHelper loginHelper;
    @Getter
    private TaskHelper taskHelper;

    public ApplicationManager() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginHelper = new LoginHelper(driver);
        taskHelper = new TaskHelper(driver);
        navigationHelper = new NavigationHelper(driver, "https://try.vikunja.io/");
    }

    public void stop() {
        driver.quit();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}
