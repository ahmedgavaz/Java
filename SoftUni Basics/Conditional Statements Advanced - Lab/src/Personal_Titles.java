import java.util.Scanner;

public class Personal_Titles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double years = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();
        if (sex.equals("m")){
            if (years>=16){
                System.out.println("Mr.");
            }
            else System.out.println("Master");
        }
        if (sex.equals("f")){
            if (years>=16){
                System.out.println("Ms.");
            }
            else System.out.println("Miss");
        }
    }
}
