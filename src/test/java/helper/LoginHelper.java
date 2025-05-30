package helper;

import data.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelper extends HelperBase {
    private static final By USERNAME_BY = By.id("username");
    private static final By PASSWORD_BY = By.id("password");

    public LoginHelper(WebDriver driver) {
        super(driver);
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
