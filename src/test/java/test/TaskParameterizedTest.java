package test;

import data.AccountData;
import generator.TestTaskData;
import generator.TestTaskDataList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import manager.ApplicationManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskParameterizedTest extends TestBase {

    private TestTaskData taskData;

    public TaskParameterizedTest(TestTaskData taskData) {
        this.taskData = taskData;
    }

    @Parameterized.Parameters
    public static Collection<TestTaskData[]> testData() throws Exception {
        JAXBContext context = JAXBContext.newInstance(TestTaskDataList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TestTaskDataList taskList = (TestTaskDataList) unmarshaller.unmarshal(new File("tasks.xml"));

        return taskList.getTasks().stream()
                .map(td -> new TestTaskData[]{td})
                .toList();
    }

    @BeforeClass
    public static void setUpClass() {
        if (app == null) {
            app = ApplicationManager.getInstance();
        }

        AccountData accountData = new AccountData("demo", "demo");
        app.getNavigationHelper().openHomePage();
        app.getLoginHelper().login(accountData);
    }


    @Test
    public void testAddTaskWithXmlData() {
        app.getTaskHelper().addTask(new data.TaskData(taskData.getTaskName()));
        Assert.assertTrue(app.getTaskHelper()
                .isElementVisible(By.xpath(String.format("//a[@class='task-link' and text()='%s']", taskData.getTaskName()))));
    }
}
