import java.util.Scanner;

public class Yard_Greening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Final price is: "+(a*7.61*0.82) + " lv.");
        System.out.printf("The discount is: "+a*7.61*0.18+" lv.");
    }
}
