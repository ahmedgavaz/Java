import java.util.Scanner;
public class Print_and_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first =Integer.parseInt(scanner.nextLine());
        int second =Integer.parseInt(scanner.nextLine());
        int sum=0;
        if (first<second){
            for (int i = first; i <=second ; i++) {
                System.out.print(i+" ");
                sum+=i;
            }
        }
        else{
            for (int i = second; i >=first ; i--) {
                System.out.println(i+" ");
                sum+=i;
            }
        }
        System.out.printf("%n");
        System.out.printf("Sum: %d",sum);
    }
}
