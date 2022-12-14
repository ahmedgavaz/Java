import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A_Miner_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resource = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String resource1 = scanner.nextLine();
            if (resource.containsKey(command)) {
                resource.put(command, resource.get(command) + Integer.parseInt(resource1));
            } else {
                resource.putIfAbsent(command, Integer.parseInt(resource1));
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> elem : resource.entrySet()) {
            System.out.printf("%s -> %d%n", elem.getKey(), elem.getValue());
        }
    }
}
