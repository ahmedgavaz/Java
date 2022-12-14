package Car_Salesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        LinkedList<Car> cars= new LinkedList<>();
        Map<String,Engine> engines= new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Engine eng=null;
            if (input.length==2){
                eng= new Engine(input[0],input[1],"n/a","n/a");
            }else if (input.length==4){
                eng= new Engine(input[0],input[1],input[2],input[3]);
            }else if (input.length==3 && (input[2].charAt(0)>='0') && (input[2].charAt(0)<='9')){
                eng= new Engine(input[0],input[1],input[2],"n/a");
            }else{
                eng= new Engine(input[0],input[1],"n/a",input[2]);
            }
            engines.put(eng.getModel(),eng);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car=null;
            if (input.length==2){
                car= new Car(input[0],input[1],"n/a","n/a");
            }else if (input.length==4){
                car= new Car(input[0],input[1],input[2],input[3]);
            }else if (input.length==3 && (input[2].charAt(0)>='0') && (input[2].charAt(0)<='9')){
                car= new Car(input[0],input[1],input[2],"n/a");
            }else{
                car= new Car(input[0],input[1],"n/a",input[2]);
            }
            cars.add(car);
        }
        cars.forEach(e1->{
            System.out.println(e1.getModel()+":");
            System.out.println(e1.getEngine()+":");
            System.out.println("Power: "+engines.get(e1.getEngine()).getPower());
            System.out.println("Displacement: "+engines.get(e1.getEngine()).getDisplacement());
            System.out.println("Efficiency: "+engines.get(e1.getEngine()).getEfficiency());
            System.out.println("Weight: "+ e1.getWeight());
            System.out.println("Color: "+ e1.getColor());
        });
    }
}
