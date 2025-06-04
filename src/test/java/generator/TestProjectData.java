package generator;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
public class TestProjectData {
    private String projectName;

    public TestProjectData() {
    }

    public TestProjectData(String projectName) {
        this.projectName = projectName;
    }

    @XmlElement(name = "projectName")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
