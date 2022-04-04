package _03_UniversitySystem.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "_03_students")
public class Student extends Person {

    @Column(name = "average_grade")
    private Double averageGrade;

    @Column(name = "attendance")
    private int attendance;

    @ManyToMany
    @JoinTable(name = "_03_students_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))
    private Set<Course> courses;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String phoneNumber, Double averageGrade, int attendance) {
        super(firstName, lastName, phoneNumber);
        this.averageGrade = averageGrade;
        this.attendance = attendance;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
