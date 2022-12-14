package Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Class> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] newPerson = scanner.nextLine().split(" ");
            Class student = new Class(newPerson[0],newPerson[1],Double.parseDouble(newPerson[2]));
            students.add(student);
        }
        students.sort(Comparator.comparing(Class::getGrade).reversed());
        for (Class temp:students) {
            System.out.println(temp);
        }
    }
}
