package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.validateStringInput;

/**
 *the characteristics of the object extra are defined
 * @author Daniela Dolenska
 */
public class Extra {
    private static int count =1;
    private int extraID;
    private String extraType;
    private double extraPrice;

    private Extra(String extraType, double extraPrice) {
        this.extraID = count;
        this.extraType = extraType;
        this.extraPrice = extraPrice;
        count++;
    }

    /**
     * defines how the visualisations of the object extra will be displayed
     * @return the object extra with its parameters
     */
    @Override
    public String toString() {
        return "Extra {"+ "Extra ID: " + extraID + ", Extra type: " + extraType + ", Extra price: "+extraPrice +'}';
    }

    public int getExtraID() {
        return extraID;
    }

    public String getExtraType() {
        return extraType;
    }

    public void setExtraType(String extraType) {
        this.extraType = extraType;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }
    
    /**
     * asks the user to enter extra type, price and then creates and then creates an extra object
     * the input of the user is checked for errors
     * @return gives the newly created extra object
     */
    public static Extra createExtra(){
        String extraType =  validateStringInput(ENTER_EXTRA_TYPE);
        double extraPrice = validateDoubleInput(ENTER_EXTRA_PRICE);
        return new Extra(extraType,extraPrice);
    }
    
    /**
     * sets the extra type and price of the extra, which the user wants to update
     * the input of the user is checked for errors
     */
    public void updateExtra(){
        String extraType =  validateStringInput(ENTER_EXTRA_TYPE);
        setExtraType(extraType);
        double extraPrice = validateDoubleInput(ENTER_EXTRA_PRICE);
        setExtraPrice(extraPrice);
    }
}
