package test;

import data.AccountData;
import manager.ApplicationManager;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import util.Settings;

public class AuthBase extends TestBase {
    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
        AccountData accountData = new AccountData(Settings.getInstance().getValidUsername(), Settings.getInstance().getValidPassword());
        System.out.println("Account username: " + accountData.getUsername());
        System.out.println("Account password: " + accountData.getPassword());
        app.getNavigationHelper().openHomePage();
        app.getLoginHelper().login(accountData);

        Assert.assertTrue(app.getLoginHelper().isElementVisible(By.xpath("//*[contains(@id, 'task-add')]")));
        System.out.println("Успешный вход");
    }
}
