package softuni.exam.models.entity;

import softuni.exam.models.ApartmentType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column
    private ApartmentType apartmentType;
    @Column
    private Double area;

    @ManyToOne
    private Town town;

  /*  @OneToMany
    private Set<Offer> offers;*/

    public Apartment(int id, ApartmentType apartmentType, Double area) {
        this.id = id;
        this.apartmentType = apartmentType;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Apartment() {
    }
}
