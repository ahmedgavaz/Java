package entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Medicament {
    @Id
    @Column
    private long id;

    @Column
    @NotNull
    private String name;

    @ManyToOne
    private Patient patient;

    public Medicament(String name) {
        this.name = name;
    }

    public Medicament() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
