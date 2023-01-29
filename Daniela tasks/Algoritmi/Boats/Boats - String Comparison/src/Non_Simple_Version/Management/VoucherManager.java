package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Extra;
import Non_Simple_Version.Objects.MaintenanceAndRepair;
import Non_Simple_Version.Objects.Voucher;

import java.util.ArrayList;
import java.util.List;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

public class VoucherManager {
    private static ArrayList<Voucher> voucherList = new ArrayList<>();

    public static void addVoucher() {
        Voucher voucher = validateVoucherInput(voucherList);
        voucherList.add(voucher);
        System.out.println(ADDED_MESSAGE + voucher.toString());
        returnToSubMenu();
    }

    public static void updateVoucher() {
        if (voucherList.size() == 0) {
            System.out.println(NO_VOUCHERS_IN_THE_LIST);
        } else {
            System.out.println(VOUCHERS_BY_ID);
            for (Voucher voucher : voucherList) {
                System.out.println(voucher.toString());
            }
            int ID = validateIdInVoucherList(voucherList,VOUCHER_ID_FOR_UPDATE);

            for (Voucher voucher:voucherList) {
                if (voucher.getVoucherId()==ID){
                    voucher.updateVoucher();
                }
            }

         /*   int i = 0;
            while (i < this.boatList.size()) {
                Boat currentBoat = this.boatList.get(i);
                int currentID = currentBoat.getBoatID();

                if (currentID == oldID) {
                    currentBoat.setBoatID(newID);
                    currentBoat.setBoatType(newBoatType);
                    currentBoat.setBoatPrice(newPrice);
                }
                ++i;
            }*/
        }
        returnToSubMenu();
    }

    public static void deleteVoucher() {
        if (voucherList.size() == 0) {
            System.out.println(NO_VOUCHERS_IN_THE_LIST);
        } else {
            System.out.println(VOUCHERS_BY_ID);
            for (Voucher voucher : voucherList) {
                System.out.println(voucher.toString());
            }
            int givenID = validateIdInVoucherList(voucherList,VOUCHER_ID_FOR_DELETING);

            int size = voucherList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (voucherList.get(i).getVoucherId()==givenID){
                    voucherList.remove(i);
                }
            }
        }
        returnToSubMenu();
    }

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
    public static Integer validateIDFromVoucherList(String str){
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < voucherList.size(); i++) {
                    if (voucherList.get(i).getVoucherId() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_VOUCHER_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        } while (true);
    }
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
    }
}
