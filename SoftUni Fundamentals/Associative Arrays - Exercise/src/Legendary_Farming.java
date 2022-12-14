import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Legendary_Farming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean bol = true;
        Map<String, Integer> resources = new LinkedHashMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();
        resources.put("motes", 0);
        resources.put("shards", 0);
        resources.put("fragments", 0);
        while (true) {
            String[] elements = scanner.nextLine().toLowerCase(Locale.ROOT).split(" ");
            for (int i = 0; i < elements.length; i += 2) {
                if (elements[i + 1].equals("motes") || elements[i + 1].equals("shards") || elements[i + 1].equals("fragments")) {
                    resources.put(elements[i + 1], resources.get(elements[i + 1]) + Integer.parseInt(elements[i]));
                    if (resources.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        resources.put(elements[i + 1], resources.get(elements[i + 1]) - 250);
                        bol = false;
                        break;
                    }
                    if (resources.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        resources.put(elements[i + 1], resources.get(elements[i + 1]) - 250);
                        bol = false;
                        break;
                    }
                    if (resources.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        resources.put(elements[i + 1], resources.get(elements[i + 1]) - 250);
                        bol = false;
                        break;
                    }
                } else {
                    if (!junk.containsKey(elements[i + 1])) {
                        junk.put(elements[i + 1], Integer.parseInt(elements[i]));
                    } else {
                        junk.put(elements[i + 1], junk.get(elements[i + 1]) + Integer.parseInt(elements[i]));
                    }
                }
            }
            if (bol == false) {
                break;
            }
        }
        System.out.println("shards: " + resources.get("shards"));
        System.out.println("fragments: " + resources.get("fragments"));
        System.out.println("motes: " + resources.get("motes"));
        for (Map.Entry<String, Integer> elem : junk.entrySet()) {
            System.out.printf("%s: %d%n", elem.getKey(), elem.getValue());
        }
    }
}
