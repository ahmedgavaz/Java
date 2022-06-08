import java.util.Scanner;

public class Basketball_Equipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int price = Integer.parseInt(scanner.nextLine());
        double aces = price * 0.6;
        double outfit = aces * 0.8;
        double ball = outfit * 0.25;
        double accessories = ball * 0.2;
        double totalPrice = price + +aces + +outfit + ball + accessories;
        System.out.println(totalPrice);
    }
}
