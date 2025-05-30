package helper;

import data.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskHelper extends HelperBase {
    private static final By TASK_ADD_FIELD_BY = By.xpath("//*[contains(@id, task-add-textarea)]");

    public TaskHelper(WebDriver driver) {
        super(driver);
    }

    public void addTask(TaskData taskData) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement taskField = wait.until(ExpectedConditions.elementToBeClickable(TASK_ADD_FIELD_BY));
        taskField.click();
        driver.findElement(TASK_ADD_FIELD_BY).sendKeys(taskData.getTaskName());
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/main/div/div[1]/div/p[2]/button")).click();
    }
}
