import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courseMap = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] course = command.split(" : ");
            courseMap.putIfAbsent(course[0],new ArrayList<>());
            courseMap.get(course[0]).add(course[1]);
            command= scanner.nextLine();
        }
        courseMap.entrySet().stream().sorted((e1,e2)-> Integer.valueOf(e2.getValue().size()).compareTo(Integer.valueOf(e1.getValue().size())));
        for (Map.Entry<String,List<String>> elem:courseMap.entrySet()) {
            System.out.printf("%s: %s%n",elem.getKey(),elem.getValue().size());
            for (String student: elem.getValue()) {
                System.out.printf("-- %s%n",student);
            }
        }
    }
}
