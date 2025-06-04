package generator;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestTaskDataXmlGenerator {

    public static void main(String[] args) throws Exception {
        List<TestTaskData> tasks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String title = generateRandomText();
            tasks.add(new TestTaskData(title));
        }

        TestTaskDataList taskList = new TestTaskDataList();
        taskList.setTasks(tasks);

        JAXBContext context = JAXBContext.newInstance(TestTaskDataList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(taskList, new File("tasks.xml"));
        System.out.println("Generated tasks.xml");
    }

    private static String generateRandomText() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 10 + random.nextInt(6); // 10-15 символов

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }
}
