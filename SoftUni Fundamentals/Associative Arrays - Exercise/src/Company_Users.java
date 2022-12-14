import java.util.*;

public class Company_Users {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>> company = new LinkedHashMap<>();
        while (!command.equals("End")){
            String[] user = command.split(" -> ");
                company.putIfAbsent(user[0],new ArrayList<>());
                if (!company.get(user[0]).contains(user[1])){
                company.get(user[0]).add(user[1]);}
            command=scanner.nextLine();
        }
        for (Map.Entry<String,List<String>> elem:company.entrySet()) {
            System.out.println(elem.getKey());
            for (String id: elem.getValue()) {
                System.out.println("-- "+id);
            }
        }
    }
}
