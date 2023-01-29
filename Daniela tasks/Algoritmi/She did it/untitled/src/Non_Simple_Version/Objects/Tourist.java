/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Objects;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.Management.VoucherManager.validateIDFromVoucherList;

/**
 *the characteristics of the object tourist are defined
 * @author Daniela Dolenska
 */
public class Tourist {
    private static int count =1;
    private int touristID;
    private String touristName;
    private boolean hasBoatDrivingLicense;
    private int voucherID;

    /**
     * constructor that creates an instance of the class
     * @param touristName name of the tourist
     * @param boatDrivingLicense whether the tourist have a driving license to drive a boat
     * @param voucherID ID of the voucher that the tourist possesses
     */
    private Tourist(String touristName, boolean boatDrivingLicense, int voucherID) {
        this.touristID = count;
        this.touristName = touristName;
        this.hasBoatDrivingLicense = boatDrivingLicense;
        this.voucherID = voucherID;
        count++;
    }
    
    /**
     * defines how the visualisations of the object tourist will be displayed
     * @return the object tourist with its parameters
     */
    @Override
    public String toString(){
       return "Tourist {" + "Tourist ID: " + touristID + ", Name: " + touristName +  ", Owns boat driving license: " + hasBoatDrivingLicense + ", Voucher ID: " + voucherID + '}';
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

    /**
     * asks the user to enter tourist name, whether he owns a boat driving license and voucher ID
     * the input of the user is checked for errors
     * @return gives the newly created tourist object
     */
    public static Tourist createTourist(){
        String touristName = validateStringInput(ENTER_TOURIST_NAME);
        boolean drivingLicense = validateDrivingLicenseInput(DOES_TOURIST_HAVE_DRIVING_LICENSE);
        Integer touristVoucherID = validateIDFromVoucherList(ENTER_TOURIST_VOUCHER);
        if (touristVoucherID==null){
            return null;
            
        }
        return new Tourist(touristName,drivingLicense,touristVoucherID);
    }
    
    /**
     * sets the new name, presence of boat driving license and voucher ID of the tourist
     * the input of the user is checked for errors
     */
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
