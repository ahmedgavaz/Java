package Non_Simple_Version.Objects;

import static Non_Simple_Version.Validators.*;
import static Non_Simple_Version.Validators.validateStringInput;

/**
 * the characteristics of the object extra are defined
 *
 * @author Daniela Dolenska
 */
public class Extra {

    private static int count = 1;
    private int extraID;
    private String extraType;
    private double extraPrice;

    /**
     * constructor that creates an instance of the class
     *
     * @param extraType characteristic of the object - type
     * @param extraPrice characteristic of the object - price
     */
    private Extra(String extraType, double extraPrice) {
        this.extraID = count;
        this.extraType = extraType;
        this.extraPrice = extraPrice;
        count++;
    }

    /**
     * defines how the visualisations of the object extra will be displayed
     *
     * @return the object extra with its parameters
     */
    @Override
    public String toString() {
        return "Extra {" + "Extra ID: " + extraID + ", Extra type: " + extraType + ", Extra price: " + extraPrice + '}';
    }

    /**
     * gets the extra id
     *
     * @return the extra id
     */
    public int getExtraID() {
        return extraID;
    }

    /**
     * gets the extra type
     *
     * @return the extra type
     */
    public String getExtraType() {
        return extraType;
    }

    /**
     * sets the new extra type
     *
     * @param extraType the new extra type
     */
    public void setExtraType(String extraType) {
        this.extraType = extraType;
    }

    /**
     * gets the extra price
     *
     * @return the extra price
     */
    public double getExtraPrice() {
        return extraPrice;
    }

    /**
     * sets the new extra price
     *
     * @param extraPrice the new extra price
     */
    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }

    /**
     * asks the user to enter extra type, price and then creates and then
     * creates an extra object the input of the user is checked for errors
     *
     * @return gives the newly created extra object
     */
    public static Extra createExtra() {
        String extraType = validateStringInput("Enter extra type: ");
        double extraPrice = validateDoubleInput("Enter extra price: ");
        return new Extra(extraType, extraPrice);
    }

    /**
     * sets the extra type and price of the extra, which the user wants to
     * update the input of the user is checked for errors
     */
    public void updateExtra() {
        String extraType = validateStringInput("Enter extra type: ");
        setExtraType(extraType);
        double extraPrice = validateDoubleInput("Enter extra price: ");
        setExtraPrice(extraPrice);
    }
}
