package Non_Simple_Version;

import java.util.Scanner;

public class Validators {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * the method receives as a parameter a message that should be printed on
     * the console, saying what should be entered after inserting of the
     * variable, it is checked whether it is bigger than 0, if not as output we
     * see error message the method checks for two type of errors, a number less
     * or equal to 0, or string input that cannot be parsed to integer
     *
     * @param str the method that calls this method gives it a string
     * @return an integer value bigger than 0
     */
    public static int validateIntegerInput(String str) {
        do {
            try {
                System.out.print(str);
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Invalid input! Try again.");
                }
            } catch (NumberFormatException n) {
                System.out.println("You should input a number bigger than 0! ");
            } catch (Exception e) {
                System.out.print("Invalid input! Try again. ");
            }
        } while (true);
    }

    public static int validateInteger(int value) {
        do {
            try {
                if (value > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Invalid input! Try again.");
                }
            } catch (NumberFormatException n) {
                System.out.println("You should input a number bigger than 0! ");
            }
        } while (true);
    }

    /**
     * the method receives as a parameter a message that should be printed on
     * the console, saying what should be entered after inserting of the
     * variable, it is checked whether its length is bigger that 0, if not as
     * output we see error message if the string input is empty, the loop will
     * continue as long as we receive a string of length 0
     *
     * @param str the method that calls this method gives it a string
     * @return the string input of the user
     */
    public static String validateStringInput(String str) {
        do {
            try {
                System.out.print(str);
                String value = scanner.nextLine();
                if (value.length() > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Invalid input! Try again. ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Try again. ");
            }
        } while (true);
    }

    public static String validateString(String value) {
        do {
            try {
                if (value.length() > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Invalid input! Try again. ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Try again. ");
            }
        } while (true);
    }

    /**
     * the method receives as a parameter a message that should be printed on
     * the console, saying what should be entered after inserting of the
     * variable, it is checked whether it is bigger than 0, if not as output we
     * see error message the method checks for two type of errors, a number less
     * or equal to 0, or string input that cannot be parsed to integer
     *
     * @param str the method that calls this method gives it a string
     * @return a value of type double bigger than 0
     */
    public static double validateDoubleInput(String str) {
        do {
            try {
                System.out.print(str);
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Invalid input! Try again. ");
                }
            } catch (NumberFormatException n) {
                System.out.println("You should input a number bigger than 0! ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static double validateDouble(double value) {
        do {
            try {
                if (value > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Invalid input! Try again. ");
                }
            } catch (NumberFormatException n) {
                System.out.println("You should input a number bigger than 0! ");
            }
        } while (true);
    }

    /**
     * the method prints on the console a message for the user to press enter
     */
    public static void returnToSubMenu() {
        System.out.print("\nPress ENTER to return to sub menu ");
        scanner.nextLine();
    }

    /**
     * the method receives as a parameter from the method which it is called a
     * string, saying what input should be entered then the input is checked
     * whether it is equal to "Y" or "N" if anything different than these two
     * letters is entered, an error message is printed it loops as long as we
     * receive these two values
     *
     * @param str the method that calls this method gives it a string
     * @return returns true of false depending on whether the input is Y or N
     */
    public static boolean validateDrivingLicenseInput(String str) {
        do {
            try {
                System.out.print(str);
                String value = scanner.nextLine().trim().toUpperCase();
                if (value.equals("Y")) {
                    return true;
                } else if (value.equals("N")) {
                    return false;
                } else {
                    throw new IllegalArgumentException("Invalid input! Try again. ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Try again. ");
            }
        } while (true);
    }

    /**
     * the method asks for the type of visualisation of the objects it shows the
     * possible options and gets the user input if the input is different than 1
     * or 2 the sub menu is shown
     *
     * @return
     */
    public static int typeOfView() {
        System.out.println("Choose tho correct option for visualisation(1 or 2):\n");
        System.out.println("1.Show all elements.\n");
        System.out.println("2.Search elements by attribute.\n");
        System.out.print("Enter the option for visualisation: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("You should choose 1 or 2!");
            return -1;
        }
    }
}
