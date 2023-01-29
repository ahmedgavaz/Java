package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Employee;
import Non_Simple_Version.Objects.Extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

public class ExtrasManager {
    private static ArrayList<Extra> extraList = new ArrayList<>();

    public static void addExtra() {
        Extra extra = validateExtraInput(extraList);
        extraList.add(extra);
        System.out.println(ADDED_MESSAGE + extra.toString());
        returnToSubMenu();
    }

    public static void updateExtra() {
        if (extraList.size() == 0) {
            System.out.println(NO_EXTRAS_IN_THE_LIST);
        } else {
            System.out.println(EXTRAS_BY_ID);
            for (Extra extra : extraList) {
                System.out.println(extra.toString());
            }
            int ID = validateIdInExtraList(extraList,EXTRA_ID_FOR_UPDATE);

            for (Extra extra:extraList) {
                if (extra.getExtraID()==ID){
                    extra.updateExtra();
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

    public static void deleteExtra() {
        if (extraList.size() == 0) {
            System.out.println(NO_EXTRAS_IN_THE_LIST);
        } else {
            System.out.println(EXTRAS_BY_ID);
            for (Extra extra : extraList) {
                System.out.println(extra.toString());
            }
            int givenID = validateIdInExtraList(extraList,EXTRA_ID_FOR_DELETING);
            int size = extraList.size()-1;
            for (int i = size; i >=0 ; i--) {
                if (extraList.get(i).getExtraID()==givenID){
                    extraList.remove(i);
                }
            }
        }
        returnToSubMenu();
    }

    public static void listExtras() {
        if (extraList.size() == 0) {
            System.out.println(NO_EMPLOYEES_IN_THE_LIST);
        } else {
            System.out.println(EMPLOYEES_BY_ID);
            for (Extra extra : extraList) {
                System.out.println(extra.toString());
            }
        }
        returnToSubMenu();
    }
    public static Integer validateIDFromExtrasList(String str){
        do {
            try {
                System.out.println(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < extraList.size(); i++) {
                    if (extraList.get(i).getExtraID() == value) {
                        return value;
                    }
                }
                throw new IllegalArgumentException(NO_EXTRA_WITH_THIS_ID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        } while (true);
    }
    public static void searchExtra() {
        System.out.print(INPUT_ATTRIBUTE);
        String attribute = scanner.nextLine();
        List<Extra> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < extraList.size(); i++) {
            if (String.valueOf(extraList.get(i).getExtraID()).equals(attribute) ||
                    String.valueOf(extraList.get(i).getExtraPrice()).equals(attribute) ||
                    extraList.get(i).getExtraType().equals(attribute)) {
                isFound = true;
                list.add(extraList.get(i));
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
