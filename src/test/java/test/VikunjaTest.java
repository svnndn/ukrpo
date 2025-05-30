package test;

import data.AccountData;
import data.TaskData;

public class VikunjaTest extends TestBase {
    @org.junit.Test
    public void testLogin() {
        AccountData accountData = new AccountData("demo", "demo");
        getApp().getNavigationHelper().openHomePage();
        getApp().maximizeWindow();
        getApp().getLoginHelper().login(accountData);
    }

    @org.junit.Test
    public void testAddTask() {
        AccountData accountData = new AccountData("demo", "demo");
        getApp().getNavigationHelper().openHomePage();
        getApp().maximizeWindow();
        getApp().getLoginHelper().login(accountData);
        TaskData taskData = new TaskData("Новая задача");
        getApp().getTaskHelper().addTask(taskData);
    }
}