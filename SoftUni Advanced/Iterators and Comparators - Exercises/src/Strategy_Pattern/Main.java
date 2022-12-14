package Strategy_Pattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> tree1 = new TreeSet<Person>(new First());
        TreeSet<Person> tree2 = new TreeSet<Person>(new Second());
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            Person person = new Person(command[0],Integer.parseInt(command[1]));
            tree1.add(person);
            tree2.add(person);
        }
        for (Person elem:tree1) {
            System.out.println(elem.getName()+" "+elem.getAge());
        }
        for (Person elem:tree2) {
            System.out.println(elem.getName()+" "+elem.getAge());
        }
    }
}
