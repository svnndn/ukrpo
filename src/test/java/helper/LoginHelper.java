package helper;

import data.AccountData;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelper extends HelperBase {
    private static final By USERNAME_BY = By.id("username");
    private static final By PASSWORD_BY = By.id("password");

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData accountData) {
        if (isLoggedIn()) {
            if (isLoggedIn(accountData.getUsername())) {
                return;
            }
            logout();
        }

        WebElement usernameField = driver.findElement(USERNAME_BY);
        usernameField.sendKeys(accountData.getUsername());
        isElementPresent(PASSWORD_BY);
        WebElement passwordField = driver.findElement(PASSWORD_BY);
        passwordField.sendKeys(accountData.getPassword());
        isElementPresent(By.cssSelector(".button"));
        driver.findElement(By.cssSelector(".button")).click();
    }

    public boolean isLoggedIn()
    {
        return isElementVisible(By.xpath("//*[@class='username' and text()='demo']"));
    }

    public boolean isLoggedIn(String username)
    {
        if (!isLoggedIn()) {
            return false;
        }
        try {
            String currentUser = driver.findElement(
                            By.xpath("//*[@class='username']")).getText();

            return currentUser.equals(username);
        } catch (Exception e){
            System.out.println("Username не совпадает");
            return false;
        }
    }

    public void logout() {
        if (isLoggedIn()) {
            driver.findElement(By.xpath("//button[contains(@class, 'username-dropdown')]")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.dropdown-item:nth-child(4)")));
            logoutButton.click();
        }
    }

}
