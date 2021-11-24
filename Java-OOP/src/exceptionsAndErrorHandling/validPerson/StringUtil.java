package exceptionsAndErrorHandling.validPerson;

public class StringUtil {

    public static boolean isNullOrEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }
}
