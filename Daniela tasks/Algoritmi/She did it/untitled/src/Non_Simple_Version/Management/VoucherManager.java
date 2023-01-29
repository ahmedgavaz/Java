package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Extra;
import Non_Simple_Version.Objects.MaintenanceAndRepair;
import Non_Simple_Version.Objects.Voucher;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

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
        System.out.println(ADDED_MESSAGE + voucher.toString());
        returnToSubMenu();
    }

    /**
     * asks user for voucher id to update, and if there is such an id in the list, it will be updated
     * if the voucher list is empty nothing will be done
     */
    public static void updateVoucher() {
        if (voucherList.size() == 0) {
            System.out.println(NO_VOUCHERS_IN_THE_LIST);
        } else {
            Integer ID = validateIDFromVoucherList(VOUCHER_ID_FOR_UPDATE);
            if (ID == null) {
                return;
            }
            for (Voucher voucher : voucherList) {
                if (voucher.getVoucherId() == ID) {
                    voucher.updateVoucher();
                    System.out.println(UPDATE + voucher.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for voucher id to delete, if there is a voucher with such an id, it will be deleted
     * if the voucher list is empty nothing will be done
     */
    public static void deleteVoucher() {
        if (voucherList.size() == 0) {
            System.out.println(NO_VOUCHERS_IN_THE_LIST);
        } else {
            Integer ID = validateIDFromVoucherList(VOUCHER_ID_FOR_DELETING);
            if (ID == null) {
                return;
            }

            int size = voucherList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (voucherList.get(i).getVoucherId() == ID) {
                    voucherList.remove(i);
                    System.out.println(DELETION);
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
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            System.out.println(EMPLOYEES_BY_ID);
            for (Voucher voucher : voucherList) {
                System.out.println(voucher.toString());
            }
        }
        returnToSubMenu();
    }

    public static Integer validateIDFromVoucherList(String str) {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < voucherList.size(); i++) {
                    if (voucherList.get(i).getVoucherId() == value) {
                        return value;
                    }
                }
                throw new NoSuchElementException(NO_VOUCHER_WITH_THIS_ID);
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
     * searches for voucher that have a particular characteristic, such as voucher id, price, discount and type
     * all vouchers owning this attribute will be displayed
     */
    public static void searchVoucher() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Voucher> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < voucherList.size(); i++) {
            if (String.valueOf(voucherList.get(i).getVoucherId()).equals(attribute) ||
                    String.valueOf(voucherList.get(i).getVoucherPrice()).equals(attribute) ||
                    String.valueOf(voucherList.get(i).getVoucherDiscount()).equals(attribute) ||
                    voucherList.get(i).getVoucherType().equals(attribute)) {
                isFound = true;
                list.add(voucherList.get(i));
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
