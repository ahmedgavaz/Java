package Harvesting_Fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Field>> map = creatingMap();
        Consumer<Field> consumer = e->{
            System.out.printf("%s %s %s%n", Modifier.toString(e.getModifiers()),e.getType().getSimpleName(),e.getName());
        };
        while (!input.equals("HARVEST")) {
            switch (input){
                case "public":
                    map.get("public").stream().forEach(consumer);
                    break;
                case "private":
                    map.get("private").stream().forEach(consumer);
                    break;
                case "protected":
                    map.get("protected").stream().forEach(consumer);
                    break;
                case "all":
                    map.get("all").stream().forEach(consumer);
                    break;
            }

            input = scanner.nextLine();
        }
    }
    public static Map<String,List<Field>> creatingMap(){
        Class clazz = RichSoilLand.class;
        Map<String, List<Field>> map = new HashMap<>();
        map.put("public",new ArrayList<>());
        map.put("private",new ArrayList<>());
        map.put("protected",new ArrayList<>());
        map.put("all",new ArrayList<>());
        Field[] field = clazz.getDeclaredFields();
        for (Field temp:field) {
            map.get("all").add(temp);
            switch (Modifier.toString(temp.getModifiers())){
                case "public":
                    map.get("public").add(temp);
                    break;
                case "private":
                    map.get("private").add(temp);
                    break;
                case "protected":
                    map.get("protected").add(temp);
                    break;
            }
        }
        return map;
    }
}
