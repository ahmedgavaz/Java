import java.util.*;
public class Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] elementsLine = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(elementsLine));
        }
        elements.forEach(e-> System.out.print(e+" "));
    }
}
