package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDTO {
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "agent")
    private AgentNameDTO agentName;
    @XmlElement(name = "apartment")
    private ApartmentIdDTO apartmentId;
    @XmlElement(name = "publishedOn")
    private String publishedOn;

    public OfferDTO() {
    }

    public OfferDTO(BigDecimal price, AgentNameDTO agentName, ApartmentIdDTO apartmentId, String publishedOn) {
        this.price = price;
        this.agentName = agentName;
        this.apartmentId = apartmentId;
        this.publishedOn = publishedOn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentNameDTO getAgentName() {
        return agentName;
    }

    public void setAgentName(AgentNameDTO agentName) {
        this.agentName = agentName;
    }

    public ApartmentIdDTO getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(ApartmentIdDTO apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public boolean isValid() {
        if (price.doubleValue() <= 0) {
            return false;
        }
        return true;
    }
}
