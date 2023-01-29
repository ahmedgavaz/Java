package Non_Simple_Version.Management;

import Non_Simple_Version.Objects.Extra;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static Non_Simple_Version.Validators.*;
import static Non_Simple_Version.Validators.returnToSubMenu;

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
        System.out.println("You added :\n" + extra.toString());
        returnToSubMenu();
    }

    /**
     * asks user for extra id to update, and if there is such an id in the list,
     * the extra will be updated if the extra list is empty nothing will be done
     */
    public static void updateExtra() {
        if (extraList.size() == 0) {
            System.out.println("Currently no extras in the list! \n Please add a new extras!");
        } else {
            Integer ID = validateIDFromExtrasList("Which extra ID do you want to update?");
            if (ID == null) {
                return;
            }
            for (Extra extra : extraList) {
                if (extra.getExtraID() == ID) {
                    extra.updateExtra();
                    System.out.println("You updated successfully: " + extra.toString());
                }
            }
        }
        returnToSubMenu();
    }

    /**
     * asks the user for extra id to delete, if there is an extra with such an
     * id, it will be deleted if the extra list is empty nothing will be done
     */
    public static void deleteExtra() {
        if (extraList.size() == 0) {
            System.out.println("Currently no extras in the list! \n Please add a new extra!");
        } else {
            Integer ID = validateIDFromExtrasList("Which extra ID do you want to delete?");
            if (ID == null) {
                return;
            }
            int size = extraList.size() - 1;
            for (int i = size; i >= 0; i--) {
                if (extraList.get(i).getExtraID() == ID) {
                    extraList.remove(i);
                    System.out.println("You deleted successfully. ");
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
            System.out.println("Currently no extras in the list!\nPlease add a new extras!");
        } else {
            System.out.println("Extras currently in list by their respective ID are:");
            for (Extra extra : extraList) {
                System.out.println(extra.toString());
            }
        }
        returnToSubMenu();
    }

    /**
     * checks whether there is an extra in the list with the same id
     *
     * @param str output message on the console
     * @return returns the extra or null if it does not exist
     */
    public static Integer validateIDFromExtrasList(String str) {
        try {
            System.out.println(str);
            int value = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < extraList.size(); i++) {
                if (extraList.get(i).getExtraID() == value) {
                    return value;
                }
            }
            throw new NoSuchElementException("Extra with this id doesn't exist!");
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
     * asks the user to enter a specific attribute searches for extras that have
     * a particular characteristic, such as extra ID, price and type all extras
     * owning this attribute will be displayed
     */
    public static void searchExtra() {
        System.out.print("\nEnter an attribute for searching: ");
        String attribute = scanner.nextLine();
        List<Extra> list = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < extraList.size(); i++) {
            if (String.valueOf(extraList.get(i).getExtraID()).equals(attribute)
                    || String.valueOf(extraList.get(i).getExtraPrice()).equals(attribute)
                    || extraList.get(i).getExtraType().equals(attribute)) {
                isFound = true;
                list.add(extraList.get(i));
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
