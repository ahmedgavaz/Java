import java.util.*;

public class Student_Academy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentList = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());
            studentList.putIfAbsent(name,new ArrayList<>());
            studentList.get(name).add(grade);
        }
        /*studentList.entrySet().stream().filter(e->e.getValue().stream().mapToDouble(x ->x).average().orElse(0.0)>=4.5).
                forEach(entry ->{
                    double avg=entry.getValue().stream().mapToDouble(x->x).average().orElse(0.0);
                    System.out.printf("%s -> %.2f%n",entry.getKey(),avg);
                });*/
        for (Map.Entry<String,List<Double>>elem:studentList.entrySet()) {
            double average = elem.getValue().stream().mapToDouble(x->x).average().orElse(0.0);
            if (average>=4.5)
            System.out.printf("%s -> %.2f%n",elem.getKey(),average);
        }
    }
}
