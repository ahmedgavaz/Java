package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentNameDTO {
    @XmlElement(name = "name")
    private String name;

    public AgentNameDTO() {
    }

    public AgentNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
