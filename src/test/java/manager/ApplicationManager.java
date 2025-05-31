package manager;

import helper.LoginHelper;
import helper.NavigationHelper;
import helper.TaskHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager implements AutoCloseable {
    private WebDriver driver;
    private JavascriptExecutor js;

    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private TaskHelper taskHelper;

    private static final ThreadLocal<ApplicationManager> instance = ThreadLocal.withInitial(() -> null);

    private ApplicationManager() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginHelper = new LoginHelper(this);
        taskHelper = new TaskHelper(this);
        navigationHelper = new NavigationHelper(this, "https://try.vikunja.io/");
    }


    public static ApplicationManager getInstance() {
        if (instance.get() == null) {
            ApplicationManager manager = new ApplicationManager();
            instance.set(manager);
            manager.getNavigationHelper().openHomePage();
        }
        return instance.get();
    }

    public void stop() {
        try {
            driver.quit();
        } catch (Exception ignored) {
        }
    }

    @Override
    public void close() {
        stop();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public void setJs(JavascriptExecutor js) {
        this.js = js;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void setNavigationHelper(NavigationHelper navigationHelper) {
        this.navigationHelper = navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public void setLoginHelper(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public TaskHelper getTaskHelper() {
        return taskHelper;
    }

    public void setTaskHelper(TaskHelper taskHelper) {
        this.taskHelper = taskHelper;
    }
}
