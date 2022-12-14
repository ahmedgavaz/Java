import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Wild_ZOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> food = new LinkedHashMap<>();
        Map<String,Integer> area = new LinkedHashMap<>();
        Map<String,String> namesAndArea = new LinkedHashMap<>();
        String str = scanner.nextLine();
        while (!str.equals("EndDay")){
            String[] command = Arrays.stream(str.split("[:\\s+\\-]")).filter(e->e.length()>0).toArray(String[]::new);
            switch (command[0]){
                case "Add":
                    if (food.containsKey(command[1])){
                        int existed = food.get(command[1]);
                        food.put(command[1],existed+Integer.parseInt(command[2]));
                    }
                    else{
                        namesAndArea.put(command[1],command[3]);
                        food.put(command[1],Integer.parseInt(command[2]));
                        if (area.containsKey(command[3])){
                            area.put(command[3],area.get(command[3])+1);
                        }else {
                            area.put(command[3],1);
                        }
                    }
                    break;
                case "Feed":
                    if (food.containsKey(command[1])){
                        int reducing = Integer.parseInt(command[2]);
                        int contained = food.get(command[1]);
                        if (contained-reducing<=0){
                            food.remove(command[1]);
                            String ar=namesAndArea.get(command[1]);
                            namesAndArea.remove(command[1]);
                            area.put(ar,area.get(ar)-1);
                            if (area.get(ar)<=0){
                                area.remove(ar);
                            }
                            System.out.printf("%s was successfully fed%n",command[1]);
                        }else{
                            food.put(command[1],contained-reducing);
                        }
                    }
                    break;
            }
            str= scanner.nextLine();
        }
        System.out.println("Animals:");
        for (Map.Entry elem:food.entrySet()) {
            System.out.printf(" %s -> %dg%n",elem.getKey(),elem.getValue());
        }
        System.out.println("Areas with hungry animals:");
        for (Map.Entry entry:area.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
    }
}
