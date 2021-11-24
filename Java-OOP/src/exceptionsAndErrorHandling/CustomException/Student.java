package exceptionsAndErrorHandling.CustomException;

public class Student {
    String name;
    String email;

    public Student (String name, String email) {
        this.setName(name);
    }

    private void setName(String name) {
        try {
            if (StringUtils.isValidName(name)) {
                this.name = name;
            }
        } catch (InvalidPersonNameException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
