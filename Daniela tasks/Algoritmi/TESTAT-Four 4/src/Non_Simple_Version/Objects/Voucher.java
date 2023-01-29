package Non_Simple_Version.Objects;

import static Non_Simple_Version.Validators.*;
import static Non_Simple_Version.Validators.validateDoubleInput;

/**
 * the characteristics of the object voucher are defined
 *
 * @author Daniela Dolenska
 */
public class Voucher {

    private static int count = 1;
    private int voucherId;
    private String voucherType;
    private double voucherPrice;
    private double voucherDiscount;

    /**
     * constructor that creates an instance of the class
     *
     * @param voucherType characteristic of the object - type
     * @param voucherPrice characteristic of the object - price
     * @param voucherDiscount characteristic of the object - discount
     */
    private Voucher(String voucherType, double voucherPrice, double voucherDiscount) {
        this.voucherId = count;
        this.voucherType = voucherType;
        this.voucherPrice = voucherPrice;
        this.voucherDiscount = voucherDiscount;
        count++;
    }

    /**
     * defines how the visualisations of the object voucher will be displayed
     *
     * @return the object voucher with its parameters
     */
    @Override
    public String toString() {
        return "Voucher {" + "Voucher ID: " + voucherId + ", Voucher type: " + voucherType + ", Voucher price: " + voucherPrice + ", Voucher discount: " + voucherDiscount + '}';
    }

    /**
     * gets the voucher id
     *
     * @return the voucher id
     */
    public int getVoucherId() {
        return voucherId;
    }

    /**
     * gets the voucher type
     *
     * @return the voucher type
     */
    public String getVoucherType() {
        return voucherType;
    }

    /**
     * sets the new the voucher type
     *
     * @param voucherType the new the voucher type
     */
    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    /**
     * gets the voucher price
     *
     * @return the voucher price
     */
    public double getVoucherPrice() {
        return voucherPrice;
    }

    /**
     * sets the new voucher price
     *
     * @param voucherPrice the new voucher price
     */
    public void setVoucherPrice(double voucherPrice) {
        this.voucherPrice = voucherPrice;
    }

    /**
     * gets the voucher discount
     *
     * @return the voucher discount
     */
    public double getVoucherDiscount() {
        return voucherDiscount;
    }

    /**
     * sets the new the voucher discount
     *
     * @param voucherDiscount the new the voucher discount
     */
    public void setVoucherDiscount(double voucherDiscount) {
        this.voucherDiscount = voucherDiscount;
    }

    /**
     * asks the user to enter voucher type, discount and price and then creates
     * a voucher object the input of the user is checked for errors
     *
     * @return gives the newly created voucher object
     */
    public static Voucher createVoucher() {
        String voucherType = validateStringInput("Enter voucher type: ");
        double voucherPrice = validateDoubleInput("Enter voucher price: ");
        double voucherDiscount = validateDoubleInput("Enter voucher discount: ");
        while (voucherDiscount<=0 || voucherDiscount>100){
            System.out.println("You should input number between 0 and 100!");
            voucherDiscount = validateDoubleInput("Enter voucher discount: ");
        }

        return new Voucher(voucherType, voucherPrice, voucherDiscount);
    }

    /**
     * sets the type, discount and price of the voucher, which the user wants to
     * update the input of the user is checked for errors
     */
    public void updateVoucher() {
        String voucherType = validateStringInput("Enter voucher type: ");
        setVoucherType(voucherType);
        double voucherPrice = validateDoubleInput("Enter voucher price: ");
        setVoucherPrice(voucherPrice);
        double voucherDiscount = validateDoubleInput("Enter voucher discount: ");
        setVoucherDiscount(voucherDiscount);
    }
}
