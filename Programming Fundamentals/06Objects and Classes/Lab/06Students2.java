package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {

    static class Student {
    String firstName;
    String lastName;
    String age;
    String hometown;

    String getHometown() {
        return this.hometown;
    }
    String getFirstName() {
            return this.firstName;
    }
    String getLastName() {
        return this.lastName;
    }
    String getAge() {
            return this.age;
    }

    public Student setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }
    public Student setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }
    public Student setHometown(String hometown){
        this.hometown = hometown;
        return this;
    }
    public Student setAge (String age) {
        this.age = age;
        return this;
    }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Student> list = new ArrayList<>();

        while (!input.equals("end")) {

            String[] tokens = input.split(" ");

            Student pojo = new Student();

            pojo.setFirstName(tokens[0]);
            pojo.setLastName(tokens[1]);
            pojo.setAge(tokens[2]);
            pojo.setHometown(tokens[3]);

            boolean addToList = true;

            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getFirstName().equals(tokens[0]) && list.get(i).getLastName().equals(tokens[1])) {
                        list.get(i).setHometown(tokens[3]);
                        list.get(i).setAge(tokens[2]);
                        addToList = false;
                        break;
                    }
                }
            }
            if (addToList) {
                list.add(pojo);
            }

            input = scan.nextLine();
        }

        String hometown = scan.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (hometown.equals(list.get(i).getHometown())){
                System.out.printf("%s %s is %s years old%n",list.get(i).getFirstName(),list.get(i).getLastName(),list.get(i).getAge());
            }
        }

    }
}
