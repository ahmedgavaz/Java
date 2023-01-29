package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

public class BookingManager {
    private static ArrayList<Booking> bookingList = new ArrayList<>();

    public static void addBooking() {
        Booking booking = validateBookingInput(bookingList);
        if (booking == null) {
            return;
        }
        bookingList.add(booking);
        System.out.println(ADDED_MESSAGE + booking.toString());
        returnToSubMenu();
    }

    public static void updateBooking() {
        if (bookingList.size() == 0) {
            System.out.println(NO_BOOKINGS_IN_THE_LIST);
        } else {
            System.out.println(CURRENTLY_BOOKINGS_IN_THE_LIST);
            for (Booking booking : bookingList) {
                System.out.println(booking.toString());
            }
            int ID = validateIdInBookingList(bookingList, BOOKING_TO_UPDATE);

            for (Booking booking : bookingList) {
                if (booking.getBookingID() == ID) {
                    booking.updateBooking();
                }
            }

           /* System.out.print("Enter the new ID: ");
            int newID = ManagerInput.validateIntegerInput();
            System.out.print("Enter the new tourist name: ");
            String newName = input.nextLine();
            boolean touristLicense;
            if (inputManager.getTouristLicenseInput() == true) {
                touristLicense = true;
            } else {
                touristLicense = false;
            }
            int touristVoucherID = inputManager.getTouristVoucherIDInput();

            int i = 0;
            while (i < this.touristList.size()) {
                Tourist currentTourist = this.touristList.get(i);
                int currentID = currentTourist.getTouristID();
                if (currentID == oldID) {
                    currentTourist.setTouristID(newID);
                    currentTourist.setTouristName(newName);
                    currentTourist.setBoatDrivingLicense(touristLicense);
                    currentTourist.setVoucherID(touristVoucherID);
                }
                ++i;
            }*/
        }
        returnToSubMenu();
    }

    public static void deleteBooking() {
        if (bookingList.size() == 0) {
            System.out.println(NO_BOOKINGS_IN_THE_LIST);
        } else {
            System.out.println(CURRENTLY_BOOKINGS_IN_THE_LIST);
            for (Booking booking : bookingList) {
                System.out.println(booking.toString());
            }
            int givenID = validateIdInBookingList(bookingList, BOOKING_ID_FOR_DELETE);

            int size = bookingList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (bookingList.get(i).getBookingID() == givenID) {
                    bookingList.remove(i);
                }
            }
           /* int i = 0;
            while (i < this.touristList.size()) {
                Tourist currentTourist = this.touristList.get(i);
                int currentID = currentTourist.getTouristID();

                if (currentID == givenID) {
                    this.touristList.remove(i);
                }
                ++i;
            }*/
        }
        returnToSubMenu();
    }

     public static void listBooking() {
         if (bookingList.size() == 0) {
             System.out.println(NO_TOURIST_IN_THE_LIST);
         } else {
             System.out.println(CURRENTLY_TOURIST_IN_THE_LIST);
             for (Booking booking : bookingList) {
                 System.out.println(booking.toString());
             }
         } returnToSubMenu();
     }

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
    }
}
