package exceptionsAndErrorHandling.validPerson;

public class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    private void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in the range [0...120]");
        }
    }

    private void setLastName(String lastName) {
        if (StringUtil.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("The last name cannot be null or empty!");
        }
        this.lastName = lastName;
    }

    private void setFirstName(String firstName) {
        if (StringUtil.isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("The first name cannot be null or empty!");
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
