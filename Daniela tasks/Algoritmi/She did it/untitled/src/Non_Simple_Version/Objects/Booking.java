package Non_Simple_Version.Objects;

import static Non_Simple_Version.Management.BoatManager.validateIDFromBoatList;
import static Non_Simple_Version.Management.ExtrasManager.validateIDFromExtrasList;
import static Non_Simple_Version.Management.TouristManager.validateIDFromTouristList;
import static Non_Simple_Version.ValidatorsAndMessages.*;

/**
 *the characteristics of the object booking are defined
 * @author Daniela Dolenska
 */
public class Booking {
    private static int count =1;
    private int bookingID;
    private int boatID;
    private int touristID;
    private int extraID;
    
    private Booking(int boatID, int touristID, int extraID) {
        this.bookingID = count;
        this.boatID = boatID;
        this.touristID = touristID;
        this.extraID = extraID;
        count++;
    }

    /**
     * defines how the visualisations of the object booking will be displayed
     * @return the object booking with its parameters
     */
    @Override
    public String toString() {
        return "Booking {"+ "Booking ID: " + bookingID + ", Boat ID: " + boatID + ", Tourist ID: "+touristID + ", Extra ID: " + extraID + '}';        
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getBoatID() {
        return boatID;
    }

    public void setBoatID(int boatID) {
        this.boatID = boatID;
    }

    public int getTouristID() {
        return touristID;
    }

    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    public int getExtraID() {
        return extraID;
    }

    public void setExtraID(int extraID) {
        this.extraID = extraID;
    }
    
    /**
     * asks the user to enter boat ID, tourist ID and extra ID and then creates a booking object
     * the input of the user is checked for errors
     * @return gives the newly created booking object
     */
    public static Booking createBooking(){
        Integer boatID = validateIDFromBoatList(ENTER_BOOKING_BOAT_ID);
        if (boatID==null){
            return null;
        }
        Integer touristID = validateIDFromTouristList(ENTER_BOOKING_TOURIST_ID);
        if (touristID==null){
            return null;
        }
        Integer extraID = validateIDFromExtrasList(ENTER_BOOKING_EXTRA_ID);
        if (extraID==null){
            return null;
        }
        return new Booking(boatID,touristID,extraID);
    }
    
    /**
     * sets the boat ID, tourist ID and extra ID which the user wants to update
     * the input of the user is checked for errors
     */
    public void updateBooking(){
        Integer boatID = validateIDFromBoatList(ENTER_BOOKING_BOAT_ID);
        if (boatID==null){
            return;
        }
        setBoatID(boatID);
        Integer touristID = validateIDFromTouristList(ENTER_BOOKING_TOURIST_ID);
        if (touristID==null){
            return;
        }
        setTouristID(touristID);
        Integer extraID = validateIDFromExtrasList(ENTER_BOOKING_EXTRA_ID);
        if (extraID==null){
            return;
        }
        setExtraID(extraID);
    }
}
