package Comparing_Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Person> list = new ArrayList<>();
        while (!command.equals("END")){
            String[] splitted = command.split("\\s+");
            Person person = new Person(splitted[0],Integer.parseInt(splitted[1]),splitted[2]);
            list.add(person);
            command= scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person people = list.get(n-1);
        list.remove(n-1);
        int number=1;
        for (Person temp:list) {
            if (temp.compareTo(people)==0){
                number++;
            }
        }
        if (number==1){
            System.out.printf("No matches");
        }else{
            System.out.printf("%d %d %d",number,list.size()-number+1,list.size()+1);
        }
    }
}
