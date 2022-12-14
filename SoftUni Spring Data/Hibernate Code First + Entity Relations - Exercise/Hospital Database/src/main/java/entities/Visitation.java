package entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Visitation {
    @Id
    @Column
    private long id;

    @Column
    @NotNull
    private Date date;

    @Column
    @NotNull
    private String comments;

    @ManyToOne
    private Patient patient;


    public Visitation() {
    }

    public Visitation(Date date, String comments) {
        this.date = date;
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
