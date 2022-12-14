package softuni.exam.models.dto;

import java.math.BigDecimal;

public class PartDTO {
    private String partName;

    private BigDecimal price;

    private int quantity;

    public PartDTO() {
    }

    public PartDTO(String partName, BigDecimal price, int quantity) {
        this.partName = partName;
        this.price = price;
        this.quantity = quantity;
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

    public boolean isValid() {
        if (partName.length() < 2 || partName.length() > 19 || price.doubleValue() < 10 || price.doubleValue() > 2000 || quantity <= 0) {
            return false;
        }
        return true;
    }
}
