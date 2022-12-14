package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table
public class CreditCard extends BillingDetail{
    @Column
    private String cardType;

    @Column
    private Date expirationMonth;

    @Column
    private Date expirationYear;

    public CreditCard() {
        super();
    }

    public CreditCard(String number, User owner, String cardType, Date expirationMonth, Date expirationYear) {
        super(number, owner);
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Date expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Date getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Date expirationYear) {
        this.expirationYear = expirationYear;
    }
}
