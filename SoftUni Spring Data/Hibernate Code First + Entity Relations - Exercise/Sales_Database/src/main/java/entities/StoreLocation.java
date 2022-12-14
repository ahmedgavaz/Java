package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class StoreLocation {
    @Id
    @Column
    int id;

    @Column
    private String locationName;

    @OneToMany(targetEntity = Sale.class,mappedBy = "storeLocation")
    private Set<Sale> sale;

    public StoreLocation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

}
