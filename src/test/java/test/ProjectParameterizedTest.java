package test;

import data.AccountData;
import data.ProjectData;
import generator.TestProjectData;
import generator.TestProjectDataList;
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
public class ProjectParameterizedTest extends AuthBase {

    private final TestProjectData projectData;

    public ProjectParameterizedTest(TestProjectData projectData) {
        this.projectData = projectData;
    }

    @Parameterized.Parameters
    public static Collection<TestProjectData[]> testData() throws Exception {
        JAXBContext context = JAXBContext.newInstance(TestProjectDataList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TestProjectDataList projectList = (TestProjectDataList) unmarshaller.unmarshal(new File("projects.xml"));

        return projectList.getProjects().stream()
                .map(pd -> new TestProjectData[]{pd})
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
    public void testAddProjectWithXmlData() {
        app.getProjectHelper().addProject(new ProjectData(projectData.getProjectName()));
        Assert.assertTrue(app.getProjectHelper()
                .isElementVisible(By.xpath(String.format("//h1[@class='project-title' and text()='%s']", projectData.getProjectName()))));
    }
}
