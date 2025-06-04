package generator;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "ArrayOfTaskData")
public class TestTaskDataList {
    private List<TestTaskData> tasks;

    @XmlElement(name = "TaskData")
    public List<TestTaskData> getTasks() {
        return tasks;
    }

    public void setTasks(List<TestTaskData> tasks) {
        this.tasks = tasks;
    }
}
