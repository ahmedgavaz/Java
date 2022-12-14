package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String partName;

    @Column()
    private BigDecimal price;

    @Column
    private int quantity;

    public Part(int id, String partName, BigDecimal price, int quantity) {
        this.id = id;
        this.partName = partName;
        this.price = price;
        this.quantity = quantity;
    }

    public Part() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
