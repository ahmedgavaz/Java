package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDTOWrapper {
    @XmlElement(name = "offer")
    List<OfferDTO> list;

    public List<OfferDTO> getList() {
        return list;
    }

    public void setList(List<OfferDTO> list) {
        this.list = list;
    }

    public OfferDTOWrapper() {
    }

    public OfferDTOWrapper(List<OfferDTO> list) {
        this.list = list;
    }
}
