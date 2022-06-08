import java.util.Scanner;

public class Summer_Outfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();
        String outfit = "";
        String shoes = "";
        switch (day){
            case "Morning":
                if (degrees <= 18 && degrees >= 10){
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                }else if (degrees <= 24){
                    outfit = "Shirt";
                    shoes = "Moccasins";
                }else {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                }
                break;
            case "Afternoon":
                if (degrees <= 18 && degrees >= 10){
                    outfit = "Shirt";
                    shoes = "Moccasins";
                }else if (degrees <= 24){
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                }else {
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                }
                break;
            case "Evening":
                if (degrees <= 18 && degrees >= 10){
                    outfit = "Shirt";
                    shoes = "Moccasins";
                }else if (degrees <= 24){
                    outfit = "Shirt";
                    shoes = "Moccasins";
                }else {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                }
                break;
        }
        System.out.printf("It's %d degrees, get your %s and %s.",degrees,outfit,shoes);
    }
}
