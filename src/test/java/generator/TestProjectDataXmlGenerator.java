package generator;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestProjectDataXmlGenerator {

    public static void main(String[] args) throws Exception {
        List<TestProjectData> projects = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String name = generateRandomText();
            TestProjectData project = new TestProjectData();
            project.setProjectName(name);
            projects.add(project);
        }

        TestProjectDataList projectList = new TestProjectDataList();
        projectList.setProjects(projects);

        JAXBContext context = JAXBContext.newInstance(TestProjectDataList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(projectList, new File("projects.xml"));
        System.out.println("Generated projects.xml");
    }

    private static String generateRandomText() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 10 + random.nextInt(6);

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }
}
