package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Boat;
import Non_Simple_Version.Objects.Employee;
import Non_Simple_Version.Objects.Extra;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Non_Simple_Version.ValidatorsAndMessages.*;
import static Non_Simple_Version.ValidatorsAndMessages.returnToSubMenu;

/**
 * deals with the functionalities that the extras menu presents
 *
 * @author Daniela Dolenska
 */
public class ExtrasManager {
    /**
     * array of type Extra that stores all the created extras
     */
    private static ArrayList<Extra> extraList = new ArrayList<>();

    /**
     * creates and adds another extra in the booking list
     */
    public static void addExtra() {
        Extra extra = Extra.createExtra();
        extraList.add(extra);
        System.out.println(ADDED_MESSAGE + extra.toString());
        returnToSubMenu();
    }

    /**
     * asks user for extra id to update, and if there is such an id in the list, the extra will be updated
     * if the extra list is empty nothing will be done
     */
    public static void updateExtra() {
        if (extraList.size() == 0) {
            System.out.println(NO_EXTRAS_IN_THE_LIST);
        } else {
            Integer ID = validateIDFromExtrasList(EXTRA_ID_FOR_UPDATE);
            if (ID == null) {
                return;
            }
            for (Extra extra : extraList) {
                if (extra.getExtraID() == ID) {
                    extra.updateExtra();
                    System.out.println(UPDATE + extra.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for extra id to delete, if there is an extra with such an id, it will be deleted
     * if the extra list is empty nothing will be done
     */
    public static void deleteExtra() {
        if (extraList.size() == 0) {
            System.out.println(NO_EXTRAS_IN_THE_LIST);
        } else {
            Integer ID = validateIDFromExtrasList(EXTRA_ID_FOR_DELETING);
            if (ID == null) {
                return;
            }
            int size = extraList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (extraList.get(i).getExtraID() == ID) {
                    extraList.remove(i);
                    System.out.println(DELETION);
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * all created extras in the list will be displayed on the console
     */
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

    public static Integer validateIDFromExtrasList(String str) {
            try {
                System.out.println(str);
                int value = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < extraList.size(); i++) {
                    if (extraList.get(i).getExtraID() == value) {
                        return value;
                    }
                }
                throw new NoSuchElementException(NO_EXTRA_WITH_THIS_ID);
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
     * searches for extras that have a particular characteristic, such as extra ID, price and type
     * all extras owning this attribute will be displayed
     */
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
        returnToSubMenu();
    }
}
