import java.util.Scanner;

public class World_Swimming_Record {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance =  Double.parseDouble(scanner.nextLine());
        double time = Double.parseDouble(scanner.nextLine());
        double slow = Math.floor(distance / 15) * 12.5;
        double sum = distance * time + slow;
        if (record > sum){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",sum);
        }
        else System.out.printf("No, he failed! He was %.2f seconds slower.",sum-record);
    }
}
