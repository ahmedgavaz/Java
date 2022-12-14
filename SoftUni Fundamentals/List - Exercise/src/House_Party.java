import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class House_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < commands; i++) {
            String[] partyGuest = scanner.nextLine().split(" ");
            if (partyGuest[2].equals("going!")) {
                boolean bol = true;
                for (String name : names) {
                    if (name.equals(partyGuest[0])) {
                        System.out.println(partyGuest[0] + " is already in the list!");
                        bol = false;
                        continue;
                    }
                }
                if (bol == true) {
                    names.add(partyGuest[0]);
                }
            } else {
                boolean bol = true;
                for (String name : names) {
                    if (name.equals(partyGuest[0])) {
                        names.remove(partyGuest[0]);
                        bol = false;
                        break;
                    }
                }
                if (bol == true) {
                    System.out.println(partyGuest[0] + " is not in the list!");
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
