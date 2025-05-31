package helper;

import data.AccountData;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginHelper extends HelperBase {
    private static final By USERNAME_BY = By.id("username");
    private static final By PASSWORD_BY = By.id("password");

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData accountData) {
        WebElement usernameField = driver.findElement(USERNAME_BY);
        usernameField.sendKeys(accountData.getUsername());
        isElementPresent(PASSWORD_BY);
        WebElement passwordField = driver.findElement(PASSWORD_BY);
        passwordField.sendKeys(accountData.getPassword());
        isElementPresent(By.cssSelector(".button"));
        driver.findElement(By.cssSelector(".button")).click();
    }
}
