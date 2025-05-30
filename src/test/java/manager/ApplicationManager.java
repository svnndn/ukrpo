package manager;

import helper.LoginHelper;
import helper.NavigationHelper;
import helper.TaskHelper;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager implements AutoCloseable {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Getter
    private NavigationHelper navigationHelper;
    @Getter
    private LoginHelper loginHelper;
    @Getter
    private TaskHelper taskHelper;

    private static ApplicationManager instance;

    private ApplicationManager() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        loginHelper = new LoginHelper(driver);
        taskHelper = new TaskHelper(driver);
        navigationHelper = new NavigationHelper(driver, "https://try.vikunja.io/");
        navigationHelper.openHomePage();
    }

    public static synchronized ApplicationManager getInstance() {
        if (instance == null) {
            instance = new ApplicationManager();
        }
        return instance;
    }

    public void stop() {
        if (instance != null) {
            driver.quit();
            instance = null;
        }
    }

    @Override
    public void close() {
        stop();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}
