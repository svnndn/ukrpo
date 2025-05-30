package test;

import data.AccountData;
import data.TaskData;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import util.RandomDataUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VikunjaTest extends TestBase {
    @Test
    public void test1_Login() {
        AccountData accountData = new AccountData("demo", "demo");
        getApp().getNavigationHelper().openHomePage();
        getApp().maximizeWindow();
        getApp().getLoginHelper().login(accountData);
    }

    @Test
    public void test2_AddTask() {
        TaskData taskData = new TaskData(RandomDataUtil.generateRandomText());
        getApp().getTaskHelper().addTask(taskData);
    }
}