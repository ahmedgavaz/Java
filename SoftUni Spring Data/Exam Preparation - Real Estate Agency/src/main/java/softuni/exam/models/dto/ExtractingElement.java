package softuni.exam.models.dto;

import java.math.BigDecimal;

public class ExtractingElement {
    private String firstName;
    private String agentLastName;
    private int offerId;
    private Double apartmentArea;
    private String townName;
    private BigDecimal offerPrice;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public Double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(Double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
    }

    public ExtractingElement() {
    }

    public ExtractingElement(String firstName, String lastName, int offerId, Double apartmentArea, String townName, BigDecimal offerPrice) {
        this.firstName = firstName;
        this.agentLastName = lastName;
        this.offerId = offerId;
        this.apartmentArea = apartmentArea;
        this.townName = townName;
        this.offerPrice = offerPrice;
    }
}
