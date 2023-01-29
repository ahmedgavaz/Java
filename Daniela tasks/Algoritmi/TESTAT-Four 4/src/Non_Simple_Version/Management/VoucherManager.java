package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Voucher;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static Non_Simple_Version.Validators.*;
import static Non_Simple_Version.Validators.returnToSubMenu;

/**
 * deals with the functionalities that the voucher menu presents
 *
 * @author Daniela Dolenska
 */
public class VoucherManager {

    /**
     * array of type Voucher that stores all the created bookings
     */
    private static ArrayList<Voucher> voucherList = new ArrayList<>();

    /**
     * creates and adds another voucher in the booking list
     */
    public static void addVoucher() {
        Voucher voucher = Voucher.createVoucher();
        voucherList.add(voucher);
        System.out.println("You added :\n" + voucher.toString());
        returnToSubMenu();
    }

    /**
     * asks user for voucher id to update, and if there is such an id in the
     * list, it will be updated if the voucher list is empty nothing will be
     * done
     */
    public static void updateVoucher() {
        if (voucherList.size() == 0) {
            System.out.println("Currently no vouchers in the list!\nPlease add a new voucher!");
        } else {
            Integer ID = validateIDFromVoucherList("Which voucher ID do you want to update?");
            if (ID == null) {
                return;
            }
            for (Voucher voucher : voucherList) {
                if (voucher.getVoucherId() == ID) {
                    voucher.updateVoucher();
                    System.out.println("You updated successfully: " + voucher.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for voucher id to delete, if there is a voucher with such
     * an id, it will be deleted if the voucher list is empty nothing will be
     * done
     */
    public static void deleteVoucher() {
        if (voucherList.size() == 0) {
            System.out.println("Currently no vouchers in the list!\nPlease add a new voucher!");
        } else {
            Integer ID = validateIDFromVoucherList("Please, select the ID for the voucher you wish to delete:");
            if (ID == null) {
                return;
            }

            int size = voucherList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (voucherList.get(i).getVoucherId() == ID) {
                    voucherList.remove(i);
                    System.out.println("You deleted successfully. ");
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * all created vouchers in the list will be displayed on the console
     */
    public static void listVouchers() {

        if (voucherList.size() == 0) {
            System.out.println("Currently no vouchers in the list!\nPlease add a new voucher!");
        } else {
            System.out.println("Vouchers currently in list by their respective ID are:");
            for (Voucher voucher : voucherList) {
                System.out.println(voucher.toString());
            }
        }
        returnToSubMenu();
    }

    /**
     * checks whether there is a voucher in the list with the same id
     *
     * @param str output message on the console
     * @return returns the boat or null if it does not exist
     */
    public static Integer validateIDFromVoucherList(String str) {
        try {
            System.out.print(str);
            int value = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < voucherList.size(); i++) {
                if (voucherList.get(i).getVoucherId() == value) {
                    return value;
                }
            }
            throw new NoSuchElementException("Voucher with this id doesn't exist!");
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            returnToSubMenu();
            return null;
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.\n");
            returnToSubMenu();
            return null;
        }
    }

    /**
     * asks the user to enter a specific attribute searches for voucher that
     * have a particular characteristic, such as voucher id, price, discount and
     * type all vouchers owning this attribute will be displayed
     */
    public static void searchVoucher() {
        System.out.print("\nEnter an attribute for searching: ");
        String attribute = scanner.nextLine();
        List<Voucher> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < voucherList.size(); i++) {
            if (String.valueOf(voucherList.get(i).getVoucherId()).equals(attribute)
                    || String.valueOf(voucherList.get(i).getVoucherPrice()).equals(attribute)
                    || String.valueOf(voucherList.get(i).getVoucherDiscount()).equals(attribute)
                    || voucherList.get(i).getVoucherType().equals(attribute)) {
                isFound = true;
                list.add(voucherList.get(i));
            }
        }
        if (!isFound) {
            System.out.println("No element is found.");
        } else {
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        returnToSubMenu();
    }
}
