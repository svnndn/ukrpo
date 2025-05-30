package util;

import com.github.javafaker.Faker;

public class RandomDataUtil {
    private static final Faker faker = new Faker();

    public static String generateRandomText() {
        return faker.lorem().paragraph();
    }
}