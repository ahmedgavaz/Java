import java.util.Scanner;

public class Beer_Kegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        double volume=Double.MIN_VALUE;
        String name="";
        for (int i = 0; i < n; i++) {
            String kegName= scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            if (volume<radius*radius*2*Math.PI*height){
                volume=radius*radius*2*Math.PI*height;
                name = kegName;
            }
        }
        System.out.println(name);
    }
}
