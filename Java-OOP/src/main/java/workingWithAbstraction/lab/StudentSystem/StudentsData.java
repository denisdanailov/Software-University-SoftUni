package workingWithAbstraction.lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentsData {
    private Map<String, Student> studentsData;

    public StudentsData() {
        this.studentsData = new HashMap<String, Student>();
    }

    public Map<String, Student> getStudentsData() {
        return this.studentsData;
    }
}
