package Non_Simple_Version.Objects;

import static Non_Simple_Version.Management.BoatManager.validateIDFromBoatList;
import static Non_Simple_Version.Management.ExtrasManager.validateIDFromExtrasList;
import static Non_Simple_Version.Management.TouristManager.validateIDFromTouristList;

/**
 * the characteristics of the object booking are defined. In order for this
 * class to function properly first tourists, extras as well as boats should be
 * created, because these are the elements of which one booking consists of.
 *
 * @author Daniela Dolenska
 */
public class Booking {

    private static int count = 1;
    private int bookingID;
    private int boatID;
    private int touristID;
    private int extraID;

    /**
     * constructor that creates an instance of the class
     *
     * @param boatID characteristic of the object - boat id
     * @param touristID characteristic of the object - tourist id
     * @param extraID characteristic of the object boat - extra id
     */
    private Booking(int boatID, int touristID, int extraID) {
        this.bookingID = count;
        this.boatID = boatID;
        this.touristID = touristID;
        this.extraID = extraID;
        count++;
    }

    /**
     * defines how the visualisations of the object booking will be displayed
     *
     * @return the object booking with its parameters
     */
    @Override
    public String toString() {
        return "Booking {" + "Booking ID: " + bookingID + ", Boat ID: " + boatID + ", Tourist ID: " + touristID + ", Extra ID: " + extraID + '}';
    }

    /**
     * gets the booking id
     *
     * @return the booking id
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * gets the boat id
     *
     * @return the boat id
     */
    public int getBoatID() {
        return boatID;
    }

    /**
     * sets the new boat id
     *
     * @param boatID the new boat id
     */
    public void setBoatID(int boatID) {
        this.boatID = boatID;
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
     * sets the new tourist id
     *
     * @param touristID the new tourist id
     */
    public void setTouristID(int touristID) {
        this.touristID = touristID;
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
     * sets the new extra id
     *
     * @param extraID the new extra id
     */
    public void setExtraID(int extraID) {
        this.extraID = extraID;
    }

    /**
     * asks the user to enter boat ID, tourist ID and extra ID and then creates
     * a booking object the input of the user is checked for errors
     *
     * @return gives the newly created booking object
     */
    public static Booking createBooking() {
        Integer boatID = validateIDFromBoatList("Enter booking boat id: ");
        if (boatID == null) {
            return null;
        }
        Integer touristID = validateIDFromTouristList("Enter booking tourist id: ");
        if (touristID == null) {
            return null;
        }
        Integer extraID = validateIDFromExtrasList("Enter booking extra id: ");
        if (extraID == null) {
            return null;
        }
        return new Booking(boatID, touristID, extraID);
    }

    /**
     * sets the boat ID, tourist ID and extra ID which the user wants to update
     * the input of the user is checked for errors
     */
    public void updateBooking() {
        Integer boatID = validateIDFromBoatList("Enter booking boat id: ");
        if (boatID == null) {
            return;
        }
        setBoatID(boatID);
        Integer touristID = validateIDFromTouristList("Enter booking tourist id: ");
        if (touristID == null) {
            return;
        }
        setTouristID(touristID);
        Integer extraID = validateIDFromExtrasList("Enter booking extra id: ");
        if (extraID == null) {
            return;
        }
        setExtraID(extraID);
    }
}
