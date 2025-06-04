package generator;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TaskData")
public class TestTaskData {
    private String taskName;

    public TestTaskData() {}

    public TestTaskData(String taskName) {
        this.taskName = taskName;
    }

    @XmlElement(name = "TaskName")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return taskName;
    }
}
