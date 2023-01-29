package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.validateDoubleInput;

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

    @Override
    public String toString() {
        return "VoucherId : " + voucherId +
                "\nVoucherType: " + voucherType +
                "\nVoucherPrice: " + voucherPrice +
                "\nVoucherDiscount: " + voucherDiscount+"\n";
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
    public static Voucher createVoucher(){
        String voucherType =  validateStringInput(ENTER_VOUCHER_TYPE);
        double voucherPrice = validateDoubleInput(ENTER_VOUCHER_PRICE);
        double voucherDiscount = validateDoubleInput(ENTER_VOUCHER_DISCOUNT);
        return new Voucher(voucherType,voucherPrice,voucherDiscount);
    }
    public void updateVoucher(){
        String voucherType =  validateStringInput(ENTER_VOUCHER_TYPE);
        setVoucherType(voucherType);
        double voucherPrice = validateDoubleInput(ENTER_VOUCHER_PRICE);
        setVoucherPrice(voucherPrice);
        double voucherDiscount = validateDoubleInput(ENTER_VOUCHER_DISCOUNT);
        setVoucherDiscount(voucherDiscount);
    }
}
