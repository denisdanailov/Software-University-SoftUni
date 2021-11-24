package exceptionsAndErrorHandling.CustomException;

public class Main {
    public static void main(String[] args) {

        try {
            Student george = new Student("Jor3ko!", "george@abv.bg");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
