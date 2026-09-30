package qa.framework.utils;

import java.util.UUID;

public class RandomDataUtil {

    public static String randomEmail() {
        return "user_" + UUID.randomUUID() + "@mail.com";
    }

    public static String randomUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0,5);
    }
}