package workingWithAbstraction.lab.StudentSystem;

public class StudentSystem {

    StudentsData repo = new StudentsData();

    public void ParseCommand(String[] tokens) {
        if (tokens[0].equals("Create")) {
            ActionMenu.addStudent(tokens, repo);
        } else if (tokens[0].equals("Show")) {
            ActionMenu.printStudent(tokens, repo);
        }
    }
}
