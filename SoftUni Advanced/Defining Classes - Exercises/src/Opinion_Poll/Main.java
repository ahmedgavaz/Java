package Opinion_Poll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            if (Integer.parseInt(arr[1])>30){
                Person onePerson= new Person(arr[0],Integer.parseInt(arr[1]));
                list.add(onePerson);
            }
        }
        list.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).forEach(e-> System.out.println(e.getName() +" - " + e.getAge()));
    }
}
