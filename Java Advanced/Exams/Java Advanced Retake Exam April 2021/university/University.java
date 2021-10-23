package Exams.JavaAdvancedRetakeExamApril2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    int capacity;
    List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.capacity < this.students.size()) {
            return "No seats in the university";
        } else if (!studentsContainsStudent(this.students, student)) {
            this.students.add(student);
            return String.format("Added student %s %s", student.firstName, student.lastName);
        } else {
            return "Student is already in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (studentsContainsStudent(this.students, student)) {
            students.remove(findStudentIndex(this.students, student));
            return String.format("Removed student %s %s", student.firstName, student.lastName);
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).firstName.equals(firstName)
                    && students.get(i).lastName.equals(lastName)) {
                index = i;
            }
        }
        if (index != -1) {
            return this.students.get(index);
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.students.size(); i++) {
            output.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n",
                    this.students.get(i).firstName,
                    this.students.get(i).lastName,
                    this.students.get(i).bestSubject));
        }
        return output.toString().trim();
    }

    private int findStudentIndex(List<Student> students, Student student) {
        int index = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).firstName.equals(student.firstName)
                    && students.get(i).lastName.equals(student.lastName)
                    && students.get(i).bestSubject.equals(student.bestSubject)) {
                index = i;
            }
        }
        return index;
    }

    private boolean studentsContainsStudent(List<Student> students, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).firstName.equals(student.firstName)
                    && students.get(i).lastName.equals(student.lastName)) {
                return true;
            }
        }
        return false;
    }
}
