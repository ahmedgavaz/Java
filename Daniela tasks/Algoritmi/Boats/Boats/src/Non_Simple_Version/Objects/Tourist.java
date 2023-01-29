/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.Management.VoucherManager.validateIDFromVoucherList;

/**
 *
 * @author danie
 */
public class Tourist {
    private static int count =1;
    private int touristID;
    private String touristName;
    private boolean hasBoatDrivingLicense;
    private int voucherID;

    private Tourist(String touristName, boolean boatDrivingLicense, int voucherID) {
        this.touristID = count;
        this.touristName = touristName;
        this.hasBoatDrivingLicense = boatDrivingLicense;
        this.voucherID = voucherID;
        count++;
    }
    
    @Override
    public String toString(){
       return "TouristID: " + touristID + "\nName: " + touristName + "\nOwns boat driving license: " + hasBoatDrivingLicense + "\nVoucherID: " + voucherID+"\n";
    }

    public int getTouristID() {
        return touristID;
    }

    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public boolean isBoatDrivingLicense() {
        return hasBoatDrivingLicense;
    }

    public void setBoatDrivingLicense(boolean boatDrivingLicense) {
        this.hasBoatDrivingLicense = boatDrivingLicense;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public static Tourist createTourist(){
        String touristName = validateStringInput(ENTER_TOURIST_NAME);
        boolean drivingLicense = validateDrivingLicenseInput(DOES_TOURIST_HAVE_DRIVING_LICENSE);
        Integer touristVoucherID = validateIDFromVoucherList(ENTER_TOURIST_VOUCHER);
        if (touristVoucherID==null){
            return null;
        }
        return new Tourist(touristName,drivingLicense,touristVoucherID);
    }
    public void updateTourist(){
        String touristName = validateStringInput(ENTER_TOURIST_NAME);
        setTouristName(touristName);
        boolean drivingLicense = validateDrivingLicenseInput(DOES_TOURIST_HAVE_DRIVING_LICENSE);
        setBoatDrivingLicense(drivingLicense);
        Integer touristVoucherID = validateIDFromVoucherList(ENTER_TOURIST_VOUCHER);
        if (touristVoucherID==null){
            return;
        }
        setVoucherID(touristVoucherID);
    }
}
