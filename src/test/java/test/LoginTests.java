package test;

import data.AccountData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import util.Settings;

public class LoginTests extends TestBase {
    @Test
    public void Test1_LoginWithValidData() {
        try {
            app.getLoginHelper().logout();
        } catch (Exception e) {
            System.out.println("Logout failed");
        }
        AccountData accountData = new AccountData(Settings.getInstance().getValidUsername(), Settings.getInstance().getValidPassword());
        app.getNavigationHelper().openHomePage();
        app.getLoginHelper().login(accountData);

        Assert.assertTrue(app.getLoginHelper().isElementVisible(By.xpath("//*[contains(@id, 'task-add')]")));
    }

    @Test
    public void Test2_LoginWithInvalidData() {
        try {
            app.getLoginHelper().logout();
        } catch (Exception e) {
            System.out.println("Logout failed");;
        }
        AccountData accountData = new AccountData(Settings.getInstance().getInvalidUsername(), Settings.getInstance().getInvalidPassword());
        app.getNavigationHelper().openHomePage();
        app.getLoginHelper().login(accountData);

        Assert.assertTrue(app.getLoginHelper().isElementVisible(By.xpath("//*[@class=\"message danger\"]")));
    }
}
