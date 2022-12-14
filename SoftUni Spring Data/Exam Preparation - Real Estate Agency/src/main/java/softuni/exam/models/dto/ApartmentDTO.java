package softuni.exam.models.dto;

import softuni.exam.models.ApartmentType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentDTO {
    @XmlElement(name = "apartmentType")
    private ApartmentType apartmentType;
    @XmlElement(name = "area")
    private Double area;
    @XmlElement(name = "town")
    private String town;

    public ApartmentDTO(ApartmentType apartmentType, Double area, String  town) {
        this.apartmentType = apartmentType;
        this.area = area;
        this.town = town;
    }

    public ApartmentDTO() {
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

    public String  getTown() {
        return town;
    }

    public void setTown(String  town) {
        this.town = town;
    }
    public boolean isValid(){
        if (area<40){
            return false;
        }else {
            return true;
        }
    }
}
