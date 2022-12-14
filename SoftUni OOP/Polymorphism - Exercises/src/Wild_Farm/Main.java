package Wild_Farm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String oddInput = scanner.nextLine();
        List<Animal> list = new LinkedList<>();
        while (!oddInput.equals("End")) {
            String[] inputOdd = oddInput.split("\\s+");
            Animal animal=extracted(inputOdd);
            String[] inputEven = scanner.nextLine().split("\\s+");
            if (inputEven[0].equals("End")){
                break;
            }
            Food food= extractFood(inputEven);
            animal.eatFood(food);
            animal.makeSound();
            list.add(animal);
            oddInput = scanner.nextLine();
        }
        list.forEach(e->{
            System.out.println(e);
        });
    }

    private static Food extractFood(String inputEven[]){
        switch (inputEven[0]){
            case "Vegetable":
                Vegetable vegetable = new Vegetable(Integer.parseInt(inputEven[1]));
                return vegetable;
            case "Meat":
                Meat meat = new Meat(Integer.parseInt(inputEven[1]));
                return meat;
            default:
                throw new IllegalArgumentException("Not an animal...");
        }
    }

    private static Animal extracted(String inputOdd[]) {
        switch (inputOdd[0]) {
            case "Cat":
                Cat cat = new Cat(inputOdd[1], inputOdd[0], Double.parseDouble(inputOdd[2]), inputOdd[3], inputOdd[4]);
                return cat;
            case "Zebra":
                Zebra zebra = new Zebra(inputOdd[1], inputOdd[0], Double.parseDouble(inputOdd[2]), inputOdd[3]);
                return zebra;
            case "Tiger":
                Tiger tiger = new Tiger(inputOdd[1], inputOdd[0], Double.parseDouble(inputOdd[2]), inputOdd[3]);
                return tiger;
            case "Mouse":
                Mouse mouse = new Mouse(inputOdd[1], inputOdd[0], Double.parseDouble(inputOdd[2]), inputOdd[3]);
                return mouse;
            default:
                return null;
        }
    }
}
