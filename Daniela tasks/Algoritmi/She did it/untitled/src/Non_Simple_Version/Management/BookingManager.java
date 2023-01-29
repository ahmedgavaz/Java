package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

/**
 * deals with the functionalities that the booking menu presents
 *
 * @author Daniela Dolenska
 */
public class BookingManager {
    /**
     * array of type Booking that stores all the created bookings
     */
    private static ArrayList<Booking> bookingList = new ArrayList<>();

    /**
     * creates and adds another booking in the booking list
     */
    public static void addBooking() {
        Booking booking = Booking.createBooking();
        if (booking == null) {
            return;
        }
        bookingList.add(booking);
        System.out.println(ADDED_MESSAGE + booking.toString());
        returnToSubMenu();
    }

    /**
     * asks user for booking id to update, and if there is such an id in the booking list, the booking will be updated
     * if the booking list is empty nothing will be done
     */
    public static void updateBooking() {
        if (bookingList.size() == 0) {
            System.out.println(NO_BOOKINGS_IN_THE_LIST);
        } else {
            Integer ID = validateIdFromBookingList(BOOKING_TO_UPDATE);
            if (ID == null) {
                return;
            }
            for (Booking booking : bookingList) {
                if (booking.getBookingID() == ID) {
                    booking.updateBooking();
                    System.out.println(UPDATE + booking.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for booking id to delete, if there is a booking with such an id, it will be deleted
     * if the booking list is empty nothing will be done
     */
    public static void deleteBooking() {
        if (bookingList.size() == 0) {
            System.out.println(NO_BOOKINGS_IN_THE_LIST);
        } else {
            Integer givenID = validateIdFromBookingList(BOOKING_ID_FOR_DELETE);
            if (givenID == null) {
                return;
            }
            int size = bookingList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (bookingList.get(i).getBookingID() == givenID) {
                    bookingList.remove(i);
                    System.out.println(DELETION);
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * all created bookings in the list will be displayed on the console
     */
    public static void listBooking() {
        if (bookingList.size() == 0) {
            System.out.println(NO_TOURIST_IN_THE_LIST);
        } else {
            System.out.println(CURRENTLY_TOURIST_IN_THE_LIST);
            for (Booking booking : bookingList) {
                System.out.println(booking.toString());
            }
        }
        returnToSubMenu();
    }

    public static Integer validateIdFromBookingList(String str) {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < bookingList.size(); i++) {
                    if (bookingList.get(i).getBookingID() == value) {
                        return value;
                    }
                }
                throw new NoSuchElementException(NO_TOURIST_WITH_THIS_ID);
            }catch (NoSuchElementException ex){
                System.out.println(ex.getMessage());
                returnToSubMenu();
                return null;
            }
            catch (Exception e) {
                System.out.println(INVALID_INPUT_MESSAGE);
                returnToSubMenu();
                return null;
            }
    }

    /**
     * asks the user to enter a specific attribute
     * searches for booking that have a particular characteristic, such as boat id, tourist id, extra id or booking id
     * all bookings owning this attribute will be displayed
     */
    public static void searchBooking() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Booking> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < bookingList.size(); i++) {
            if (String.valueOf(bookingList.get(i).getBoatID()).equals(attribute) ||
                    String.valueOf(bookingList.get(i).getBookingID()).equals(attribute) ||
                    String.valueOf(bookingList.get(i).getTouristID()).equals(attribute) ||
                    String.valueOf(bookingList.get(i).getExtraID()).equals(attribute)) {
                isFound = true;
                list.add(bookingList.get(i));
            }
        }
        if (!isFound) {
            System.out.println(NO_ELEMENT_FOUND);
        } else {
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        returnToSubMenu();
    }
}
