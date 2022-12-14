package entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Diagnose {
    @Id
    @Column
    private long id;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String comments;

    @ManyToOne
    private Patient patient;


    public Diagnose() {
    }

    public Diagnose(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
