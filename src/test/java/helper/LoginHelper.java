package helper;

import data.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {
    private static final By USERNAME_BY = By.id("username");
    private static final By PASSWORD_BY = By.id("password");

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void login(AccountData accountData) {
        driver.findElement(USERNAME_BY).click();
        driver.findElement(USERNAME_BY).sendKeys(accountData.getUsername());
        driver.findElement(PASSWORD_BY).click();
        driver.findElement(PASSWORD_BY).sendKeys(accountData.getPassword());
        driver.findElement(By.cssSelector(".button")).click();
    }
}
