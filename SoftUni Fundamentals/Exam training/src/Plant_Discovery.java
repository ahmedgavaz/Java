import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Plant_Discovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Integer> plantRarity = new LinkedHashMap<>();
        Map<String,Double> plantRating = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] plant = scanner.nextLine().split("<->");
            if (plantRarity.containsKey(plant[0])){
                plantRarity.replace(plant[0],Integer.parseInt(plant[1]));
            }else{
                plantRarity.put(plant[0],Integer.parseInt(plant[1]));
            }
            plantRating.put(plant[0],0.0);
        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")){
            String[] commands = command.split("[: -]+");
            if (!plantRarity.containsKey(commands[1])){
                System.out.println("error");
                command= scanner.nextLine();
                continue;
            }
            switch (commands[0]){
                case "Rate":
                    if (plantRating.get(commands[1])!=0){
                        double newRating = (plantRating.get(commands[1])+Double.parseDouble(commands[2]))/2;
                        plantRating.replace(commands[1],newRating);}
                    else {
                        plantRating.put(commands[1],Double.parseDouble(commands[2]));
                    }
                    break;
                case "Update":
                    plantRarity.replace(commands[1],Integer.parseInt(commands[2]));
                    break;
                case "Reset":
                    plantRating.put(commands[1],0.0);
                    break;
            }
            command= scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String,Integer> entry: plantRarity.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",entry.getKey(),entry.getValue(),plantRating.get(entry.getKey()));
        }
    }
}
