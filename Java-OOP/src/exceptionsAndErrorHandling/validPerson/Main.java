package exceptionsAndErrorHandling.validPerson;

public class Main {
    public static void main(String[] args) {

        try {
            Person peter = new Person("Franco", "Aimee", 19);
            Person noName = new Person("", "Aimee", 19);
            Person noLastName = new Person("Franco", "", 19);
            Person negativeAge = new Person("Franco", "Aimee", -1);
            Person tooOld = new Person("Franco", "Aimee", 121);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }
}
