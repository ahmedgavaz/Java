package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Student extends Person{

    @Column
    private Double averageGrade;

    @Column
    private Integer attendance;

    @ManyToMany()
    @JoinTable(name = "students_courses",
    joinColumns  = @JoinColumn(name = "students_id", referencedColumnName = "id"),
    inverseJoinColumns =@JoinColumn(name = "courses_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String phoneNumber, Double averageGrade, Integer attendance) {
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

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
}
