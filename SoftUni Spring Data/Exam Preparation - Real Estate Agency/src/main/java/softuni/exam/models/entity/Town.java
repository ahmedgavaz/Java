package softuni.exam.models.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String townName;
    @Column
    private Integer population;

  /*  @OneToMany
    private Set<Agent> agents;

    @OneToMany
    private Set<Apartment> apartments;*/

    public Town(int id, String townName, Integer population) {
        this.id = id;
        this.townName = townName;
        this.population = population;
    }

    public Town() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
