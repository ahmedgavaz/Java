import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(">>(?<Type>[A-Za-z]+)<<(?<Price>[0-9]+.?[0-9]*)!(?<Quantity>[0-9]+)");
        List<String> furniture = new ArrayList<>();
        double sum=0;
        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                furniture.add(matcher.group("Type"));
                sum+= Double.parseDouble(matcher.group("Price"))*Double.parseDouble(matcher.group("Quantity"));
            }
            input= scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String s : furniture) {
            System.out.println(s);
        }
        System.out.printf("Total money spend: %.2f",sum);
    }
}
