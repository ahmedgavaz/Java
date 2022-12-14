import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<Double>> productList = new LinkedHashMap<>();
        while (!command.equals("buy")){
            String[] product = command.split(" ");
            if (!productList.containsKey(product[0])){
                productList.put(product[0],new ArrayList<>());
                productList.get(product[0]).add(0,Double.parseDouble(product[1]));
                productList.get(product[0]).add(1,Double.parseDouble(product[2]));
            }else{
                double count = productList.get(product[0]).get(1);
                productList.get(product[0]).set(0,Double.parseDouble(product[1]));
                productList.get(product[0]).set(1,count+Double.parseDouble(product[2]));
            }
            command = scanner.nextLine();
        }
        productList.entrySet().forEach(x-> System.out.printf("%s -> %.2f%n",x.getKey(),x.getValue().get(0)*x.getValue().get(1)));
    }
}
