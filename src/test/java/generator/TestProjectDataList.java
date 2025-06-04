package generator;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "projects")
public class TestProjectDataList {
    private List<TestProjectData> projects;

    @XmlElement(name = "project")
    public List<TestProjectData> getProjects() {
        return projects;
    }

    public void setProjects(List<TestProjectData> projects) {
        this.projects = projects;
    }
}
