import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Order_by_Age {
    public static class Person {
        String name;
        String ID;
        Integer age;

        public Person(String name, String ID, Integer age) {
            this.name=name;
            this.ID=ID;
            this.age=age;
        }

        public Integer getAge() {
            return age;
        }

        public String toString(){
            return String.format("%s with ID: %s is %d years old.",this.name,this.ID,this.age);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] person = command.split(" ");
            Person singlePerson = new Person(person[0],person[1],Integer.parseInt(person[2]));
            people.add(singlePerson);
            command= scanner.nextLine();
        }
        people.sort(Comparator.comparing(Person::getAge));
        for (Person temp:people) {
            System.out.println(temp);
        }
    }
}
