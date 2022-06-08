import java.util.Scanner;

public class moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());
        int total = width*high*length;
        String num = scanner.nextLine();
        while (!num.equals("Done")){
            int number = Integer.parseInt(num);
            total = total - number;
            if (total<=0) {
                break;
            }
            num = scanner.nextLine();
        }
        if (total <0){
            System.out.printf("No more free space! You need %d Cubic meters more.",Math.abs(total));
        }else System.out.println(total + " Cubic meters left.");
    }
}
