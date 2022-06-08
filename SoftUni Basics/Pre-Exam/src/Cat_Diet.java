import java.util.Scanner;

public class Cat_Diet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int percentMaznini = Integer.parseInt(scanner.nextLine());
        int percentProteini = Integer.parseInt(scanner.nextLine());
        int percentVyglehidrati = Integer.parseInt(scanner.nextLine());
        int calorii = Integer.parseInt(scanner.nextLine());
        int percentWater = Integer.parseInt(scanner.nextLine());
        double maznini = (calorii * 1.0) * percentMaznini / 100 / 9;
        double proteini = (calorii * 1.0) * percentProteini / 100 / 4;
        double vyglehidrati = (calorii * 1.0) * percentVyglehidrati / 100 / 4;
        double sum = maznini + proteini + vyglehidrati;
        double calories = calorii / sum;
        System.out.printf("%.4f", calories * (100 - percentWater) / 100);
    }
}
