package helper;

import data.ProjectData;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectHelper extends HelperBase {
    private static final By PROJECT_LINK_BY = By.xpath("//a[@href=\"/projects\"]");
    private static final By ADD_PROJECT_LINK_BY = By.xpath("//a[@href=\"/projects/new\"]");
    private static final By PROJECT_TITLE_INPUT_BY = By.xpath("//input[contains(@name, \"projectTitle\")]");

    public ProjectHelper(ApplicationManager manager) {super(manager);}

    public void addProject(ProjectData projectData) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement projectLink = wait.until(ExpectedConditions.elementToBeClickable(PROJECT_LINK_BY));
        projectLink.click();

        WebElement addProjectLink = wait.until(ExpectedConditions.elementToBeClickable(ADD_PROJECT_LINK_BY));
        addProjectLink.click();

        WebElement projectTitleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PROJECT_TITLE_INPUT_BY));
        projectTitleInput.clear();
        projectTitleInput.sendKeys(projectData.getProjectName());

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div/div/footer/button[2]")));
        saveButton.click();
    }

}
