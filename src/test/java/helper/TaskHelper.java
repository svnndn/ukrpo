package helper;

import data.TaskData;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskHelper extends HelperBase {
    private static final By TASK_ADD_FIELD_BY = By.xpath("//*[contains(@id, 'task-add')]");
    private static final By ADD_BUTTON = By.xpath("//button[contains(@aria-label, 'Добавить')]");

    public TaskHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addTask(TaskData taskData) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement taskField = wait.until(ExpectedConditions.elementToBeClickable(TASK_ADD_FIELD_BY));
        taskField.click();
        driver.findElement(TASK_ADD_FIELD_BY).sendKeys(taskData.getTaskName());
        driver.findElement(ADD_BUTTON).click();
    }

    public void editTask(TaskData taskData) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement task = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[@class='task-link' and text()='new task']"))));
        task.click();
        isElementPresent(By.xpath("//*[contains(@class, \"task-view\")]"));
        WebElement taskTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(@class, 'input')]")));
        taskTitle.clear();
        taskTitle.sendKeys(taskData.getTaskName());
        driver.findElement(By.cssSelector("button.button:nth-child(4)"));
    }
}
