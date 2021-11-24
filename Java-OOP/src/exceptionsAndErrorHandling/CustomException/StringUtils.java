package exceptionsAndErrorHandling.CustomException;

public class StringUtils {

    public static boolean isValidName(String name) throws InvalidPersonNameException {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isAlphabetic(name.charAt(i))) {
                throw new InvalidPersonNameException("Student name should contain only alphabetic characters!\n" +
                        "No special characters or numeric values are allowed.");
            }
        }
        return true;
    }
}
