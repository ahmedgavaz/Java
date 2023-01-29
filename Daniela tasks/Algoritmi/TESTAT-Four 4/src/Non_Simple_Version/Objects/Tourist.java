/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Non_Simple_Version.Objects;

import static Non_Simple_Version.Validators.*;
import static Non_Simple_Version.Management.VoucherManager.validateIDFromVoucherList;
import java.io.Serializable;

/**
 * the characteristics of the object tourist are defined. In order for this class
 * to function properly first vouchers should be created, because one of the
 * tourist characteristics is voucherID that he owns.
 *
 * @author Daniela Dolenska
 */
public class Tourist implements Serializable{

    public static int count = 1;
    private int touristID;
    private String touristName;
    private boolean hasBoatDrivingLicense;
    private int voucherID;
    private String destination;

    /**
     * constructor that creates an instance of the class
     *
     * @param touristName name of the tourist
     * @param boatDrivingLicense whether the tourist have a driving license to
     * drive a boat
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
     * constructor that creates an instance of the class
     *
     * @param touristName name of the tourist
     * @param drivingLicense whether the tourist have a driving license to
     * drive a boat
     * @param destination ID of the voucher that the tourist possesses
     */
    public Tourist(String touristName, boolean drivingLicense, String destination) {
        this.touristID = count;
        this.touristName = touristName;
        this.hasBoatDrivingLicense = drivingLicense;
        this.voucherID = 0;
        this.destination=destination;
        count++;
    }


    /**
     * defines how the visualisations of the object tourist will be displayed
     *
     * @return the object tourist with its parameters
     */
    @Override
    public String toString() {
        return "Tourist {" + "Tourist ID: " + touristID + ", Name: " + touristName + ", Owns boat driving license: " + hasBoatDrivingLicense + ", Voucher ID: " + voucherID + '}';
    }

    /**
     * gets the tourist id
     *
     * @return the tourist id
     */
    public int getTouristID() {
        return touristID;
    }
    /**
     * gets the destination
     *
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }
/**
     * sets the new destination
     *
     * @param destination the new tourist id
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }
    /**
     * sets the new tourist id
     *
     * @param touristID the new tourist id
     */
    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    /**
     * gets the tourist name
     *
     * @return the tourist name
     */
    public String getTouristName() {
        return touristName;
    }

    /**
     * sets the new tourist name
     *
     * @param touristName the new tourist name
     */
    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    /**
     * gets whether the tourist have driving license
     *
     * @return true or false depending on whether the tourist have driving
     * license
     */
    public boolean getBoatDrivingLicense() {
        return hasBoatDrivingLicense;
    }

    /**
     * sets whether the tourist have driving license
     *
     * @param boatDrivingLicense the new realisation whether the tourist have
     * driving license
     */
    public void setBoatDrivingLicense(boolean boatDrivingLicense) {
        this.hasBoatDrivingLicense = boatDrivingLicense;
    }

    /**
     * gest the voucher id
     *
     * @return the voucher id
     */
    public int getVoucherID() {
        return voucherID;
    }

    /**
     * sets the new voucher id
     *
     * @param voucherID the new voucher id
     */
    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    /**
     * asks the user to enter tourist name, whether he owns a boat driving
     * license and voucher ID the input of the user is checked for errors
     *
     * @return gives the newly created tourist object
     */
    public static Tourist createTourist() {
        String touristName = validateStringInput("Enter tourist name: ");
        boolean drivingLicense = validateDrivingLicenseInput("Does the tourist have a boat license? Enter Y/N: ");
        Integer touristVoucherID = validateIDFromVoucherList("Enter tourist voucher ID: ");
        if (touristVoucherID == null) {
            return null;

        }
        return new Tourist(touristName, drivingLicense, touristVoucherID);
    }

    /**
     * sets the new name, presence of boat driving license and voucher ID of the
     * tourist the input of the user is checked for errors
     */
    public void updateTourist() {
        String touristName = validateStringInput("Enter tourist name: ");
        setTouristName(touristName);
        boolean drivingLicense = validateDrivingLicenseInput("Does the tourist have a boat license? Enter Y/N: ");
        setBoatDrivingLicense(drivingLicense);
        Integer touristVoucherID = validateIDFromVoucherList("Enter tourist voucher ID: ");
        if (touristVoucherID == null) {
            return;
        }
        setVoucherID(touristVoucherID);
    }
}
