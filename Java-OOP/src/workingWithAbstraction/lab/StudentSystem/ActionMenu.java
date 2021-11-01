package workingWithAbstraction.lab.StudentSystem;

public class ActionMenu {

    public static void addStudent(String[] tokens, StudentsData repo) {
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        double grade = Double.parseDouble(tokens[3]);
        if (!repo.getStudentsData().containsKey(name)) {
            Student newStudent = new Student(name, age, grade);
            repo.getStudentsData().put(name, newStudent);
        }
    }

    public static void printStudent(String[] tokens, StudentsData repo) {
        String name = tokens[1];
        if (repo.getStudentsData().containsKey(name)) {
            Student student = repo.getStudentsData().get(name);
            StringBuilder output = new StringBuilder();
            output.append(String.format("%s is %d years old.", student.getName(), student.getAge()));
            if (student.getGrade() >= 5.00) {
                output.append(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output.append(" Average student.");
            } else {
                output.append(" Very nice person.");
            }
            output.append(System.lineSeparator());
            System.out.println(output.toString().trim());
        }
    }
}
