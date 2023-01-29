package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.validateStringInput;

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

    @Override
    public String toString() {
        return "ExtraID: " + extraID +
                "\nExtraType: " + extraType +
                "\nExtraPrice: " + extraPrice+"\n";
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
    public static Extra createExtra(){
        String extraType =  validateStringInput(ENTER_EXTRA_TYPE);
        double extraPrice = validateDoubleInput(ENTER_EXTRA_PRICE);
        return new Extra(extraType,extraPrice);
    }
    public void updateExtra(){
        String extraType =  validateStringInput(ENTER_EXTRA_TYPE);
        setExtraType(extraType);
        double extraPrice = validateDoubleInput(ENTER_EXTRA_PRICE);
        setExtraPrice(extraPrice);
    }
}
