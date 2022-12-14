package softuni.exam.models.dto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskDTO {
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "date")
    private String date;
    @XmlElementWrapper(name = "car")
    @XmlElement(name = "id")
    private List<Integer> car;
    @XmlElementWrapper(name = "mechanic")
    @XmlElement(name = "firstName")
    private List<String> mechanic;
    @XmlElementWrapper(name = "part")
    @XmlElement(name = "id")
    private List<Integer> part;

    public TaskDTO(BigDecimal price, String date, List<Integer> car, List<String> mechanic, List<Integer> part) {
        this.price = price;
        this.date = date;
        this.car = car;
        this.mechanic = mechanic;
        this.part = part;
    }

    public TaskDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Integer> getCar() {
        return car;
    }

    public void setCar(List<Integer> car) {
        this.car = car;
    }

    public List<String> getMechanic() {
        return mechanic;
    }

    public void setMechanic(List<String> mechanic) {
        this.mechanic = mechanic;
    }

    public List<Integer> getPart() {
        return part;
    }

    public void setPart(List<Integer> part) {
        this.part = part;
    }

    public boolean isValid() {
        if (price.doubleValue() <= 0) {
            return false;
        }
        return true;
    }
}
