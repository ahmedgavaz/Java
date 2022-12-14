package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWrapperDTO {
    @XmlElement(name = "car")
    List<CarDTO> list;

    public CarWrapperDTO() {
    }

    public CarWrapperDTO(List<CarDTO> list) {
        this.list = list;
    }

    public List<CarDTO> getList() {
        return list;
    }

    public void setList(List<CarDTO> list) {
        this.list = list;
    }
}
