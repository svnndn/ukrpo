package test;

import data.AccountData;
import data.TaskData;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import util.RandomDataUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VikunjaTest extends TestBase {

    @Test
    public void test1_Login() {
        AccountData accountData = new AccountData("demo", "demo");
        app.getNavigationHelper().openHomePage();
        app.getLoginHelper().login(accountData);

        Assert.assertTrue(app.getLoginHelper().isElementVisible(By.xpath("//*[contains(@id, 'task-add')]")));
    }

    @Test
    public void test2_AddTask() {
        TaskData taskData = new TaskData("new task");
        app.getTaskHelper().addTask(taskData);

        Assert.assertTrue(app.getTaskHelper().isElementVisible(By.xpath("//a[@class='task-link' and text()='new task']")));
    }

    @Test
    public void test3_EditTask() {
        TaskData taskData = new TaskData(RandomDataUtil.generateRandomText());
        app.getTaskHelper().editTask(taskData);
        app.getNavigationHelper().openHomePage();

        Assert.assertTrue(app.getTaskHelper().isElementVisible(By.xpath(String.format("//a[@class='task-link' and text()='%s']", taskData.getTaskName()))));
    }
}