package softuni.exam.models.dto;

import org.apache.catalina.LifecycleState;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentDTOWrapper {
    @XmlElement(name = "apartment")
    List<ApartmentDTO> list;

    public ApartmentDTOWrapper() {
    }

    public ApartmentDTOWrapper(List<ApartmentDTO> list) {
        this.list = list;
    }

    public List<ApartmentDTO> getList() {
        return list;
    }

    public void setList(List<ApartmentDTO> list) {
        this.list = list;
    }
}
