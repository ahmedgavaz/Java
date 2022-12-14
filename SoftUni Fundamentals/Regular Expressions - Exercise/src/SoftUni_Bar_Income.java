import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUni_Bar_Income {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("%(?<Customer>[A-Z][a-z]+)%[^$|.]*?<(?<Product>\\w+)>[^$|.]*?\\|(?<Count>\\d+)\\|[^$%|.]*?(?<Price>[0-9]+\\.?[0-9]+)\\$");
        String input = scanner.nextLine();
        double sum =0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                double total=Double.parseDouble(matcher.group("Count"))*Double.parseDouble(matcher.group("Price"));
                sum+=total;
                System.out.printf("%s: %s - %.2f%n",matcher.group("Customer"),matcher.group("Product"),total);
            }
            input= scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",sum);
    }
}
