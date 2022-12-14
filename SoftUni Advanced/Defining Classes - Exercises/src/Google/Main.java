package Google;

import javax.sound.midi.Soundbank;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> person = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] things = command.split("\\s+");
            if (!person.containsKey(things[0])) {
                person.put(things[0], new Person());
            }
            switch (things[1]) {
                case "company":
                    Company company = new Company(things[2], things[3], Double.parseDouble(things[4]));
                    person.get(things[0]).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(things[2], things[3]);
                    person.get(things[0]).setPokemons(pokemon);
                    break;
                case "parents":
                    Parents parents = new Parents(things[2], things[3]);
                    person.get(things[0]).setParents(parents);
                    break;
                case "children":
                    Children children = new Children(things[2], things[3]);
                    person.get(things[0]).setChildren(children);
                    break;
                case "car":
                    Car car = new Car(things[2], things[3]);
                    person.get(things[0]).setCar(car);
                    break;
            }
            command= scanner.nextLine();
        }
        command= scanner.nextLine();
        Person searched = person.get(command);
        if (person.containsKey(command)){
            System.out.println(command);
            System.out.println("Company:");
            if (searched.getCompany()!=null){
            System.out.printf("%s %s %.2f%n",searched.getCompany().getName(),searched.getCompany()
                    .getDepartment(),searched.getCompany().getSalary());}
            System.out.println("Car:");
            if (searched.getCar()!=null){
            System.out.println(searched.getCar().getModel()+" "+searched.getCar().getSpeed());}
            System.out.println("Pokemon:");
            searched.getPokemons().forEach(e->
                    System.out.println(e.getName()+" "+e.getType()));
            System.out.println("Parents:");
            searched.getParents().forEach(e->
                    System.out.println(e.getName() + " " + e.getBirthday()));
            System.out.println("Children:");
            searched.getChildren().forEach(e->
                    System.out.println(e.getChildName()+" "+ e.getChildBirthday()));
        }
    }
}
