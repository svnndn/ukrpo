package helper;

import data.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskHelper extends HelperBase {
    private static final By TASK_ADD_FIELD_BY = By.xpath("//*[contains(@id, task-add-textarea)]");

    public TaskHelper(WebDriver driver) {
        super(driver);
    }

    public void addTask(TaskData taskData) {
        isElementPresent(TASK_ADD_FIELD_BY);
        driver.findElement(TASK_ADD_FIELD_BY).click();
        driver.findElement(TASK_ADD_FIELD_BY).sendKeys(taskData.getTaskName());
        driver.findElement(By.cssSelector(".is-small:nth-child(1)")).click();
    }
}
