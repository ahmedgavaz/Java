import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUni_Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        Map<String,String> parkList = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] user = scanner.nextLine().split(" ");
            switch (user[0]){
                case "register":
                    if (parkList.containsKey(user[1])){
                        System.out.println("ERROR: already registered with plate number "+user[2]);
                    }else{
                        parkList.put(user[1],user[2]);
                        System.out.printf("%s registered %s successfully%n",user[1],user[2]);
                    }
                    break;
                case "unregister":
                    if (parkList.containsKey(user[1])){
                        parkList.remove(user[1]);
                        System.out.printf("%s unregistered successfully%n",user[1]);
                    }else{
                        System.out.printf("ERROR: user %s not found%n",user[1]);
                    }
                    break;
            }
        }
        parkList.entrySet().forEach(x-> System.out.printf("%s => %s%n",x.getKey(),x.getValue()));
    }
}
