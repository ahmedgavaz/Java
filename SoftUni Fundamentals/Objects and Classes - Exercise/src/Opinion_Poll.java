import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opinion_Poll {
    public static class Person{
        String name;
        int age;

        public Person(String name,int age){
            this.name=name;
            this.age=age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] person = scanner.nextLine().split(" ");
            String firstName = person[0];
            int ages = Integer.parseInt(person[1]);
            Person onePerson = new Person(firstName,ages);
            people.add(onePerson);
        }
        for (Person temp:people) {
            if (temp.getAge()>30){
                System.out.println(temp.getName()+ " - " + temp.getAge());
            }
        }
    }
}
