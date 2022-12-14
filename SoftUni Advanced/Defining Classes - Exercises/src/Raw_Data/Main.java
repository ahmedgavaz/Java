package Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] str = scanner.nextLine().split("\\s+");
            Car car = new Car(str[0], parseInt(str[1]), parseInt(str[2]), parseInt(str[3]),
                    str[4],Double.parseDouble(str[5]), parseInt(str[6]),Double.parseDouble(str[7]),
                    parseInt(str[8]),Double.parseDouble(str[9]), parseInt(str[10]),Double.parseDouble(str[11]),
                    parseInt(str[12]));
            cars.add(car);
        }
        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                cars.stream().filter(e->e.cargo.typ.equals("fragile")).filter(e->
                        e.tires.get(0).pressure<1 || e.tires.get(1).pressure<1 ||
                                e.tires.get(2).pressure<1||e.tires.get(3).pressure<1).forEach(e-> System.out.println(e.model));
                break;
            case "flamable":
                cars.stream().filter(e->e.cargo.typ.equals("flamable")).filter(e->
                        e.engine.power>250).forEach(e-> System.out.println(e.model));
                break;
        }
    }
}
