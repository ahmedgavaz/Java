package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.validateDoubleInput;

/**
 *the characteristics of the object voucher are defined
 * @author Daniela Dolenska
 */
public class Voucher {
    private static int count =1;
    private int voucherId;
    private String voucherType;
    private double voucherPrice;
    private double voucherDiscount;

    private Voucher( String voucherType, double voucherPrice, double voucherDiscount) {
        this.voucherId = count;
        this.voucherType = voucherType;
        this.voucherPrice = voucherPrice;
        this.voucherDiscount = voucherDiscount;
        count++;
    }

    /**
     * defines how the visualisations of the object voucher will be displayed
     * @return the object voucher with its parameters
     */
    @Override
    public String toString() {
        return "Voucher {"+ "Voucher ID: " + voucherId + ", Voucher type: " + voucherType+ ", Voucher price: " + voucherPrice + ", Voucher discount: " + voucherDiscount + '}';        
     }

    public int getVoucherId() {
        return voucherId;
    }


    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public double getVoucherPrice() {
        return voucherPrice;
    }

    public void setVoucherPrice(double voucherPrice) {
        this.voucherPrice = voucherPrice;
    }

    public double getVoucherDiscount() {
        return voucherDiscount;
    }

    public void setVoucherDiscount(double voucherDiscount) {
        this.voucherDiscount = voucherDiscount;
    }
    
    /**
     * asks the user to enter voucher type, discount and price and then creates a voucher object
     * the input of the user is checked for errors
     * @return gives the newly created voucher object
     */
    public static Voucher createVoucher(){
        String voucherType =  validateStringInput(ENTER_VOUCHER_TYPE);
        double voucherPrice = validateDoubleInput(ENTER_VOUCHER_PRICE);
        double voucherDiscount = validateDoubleInput(ENTER_VOUCHER_DISCOUNT);
        while (voucherDiscount<=0 || voucherDiscount>100){
            System.out.println("You should input number between 0 and 100!");
            voucherDiscount = validateDoubleInput(ENTER_VOUCHER_DISCOUNT);
        }
        return new Voucher(voucherType,voucherPrice,voucherDiscount);
    }
    
    /**
     * sets the type, discount and price of the voucher, which the user wants to update
     * the input of the user is checked for errors
     */
    public void updateVoucher(){
        String voucherType =  validateStringInput(ENTER_VOUCHER_TYPE);
        setVoucherType(voucherType);
        double voucherPrice = validateDoubleInput(ENTER_VOUCHER_PRICE);
        setVoucherPrice(voucherPrice);
        double voucherDiscount = validateDoubleInput(ENTER_VOUCHER_DISCOUNT);
        setVoucherDiscount(voucherDiscount);
    }
}
