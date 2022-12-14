import java.util.Scanner;

public class Character_Multiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        int sum =0;
        if (words[0].length()>words[1].length()){
            sum=suma(words[1],words[0]);
            for (int i = words[1].length(); i < words[0].length() ; i++) {
                sum+=words[0].charAt(i);
            }
        }
        else if (words[1].length()>words[0].length()){
            sum=suma(words[0],words[1]);
            for (int i = words[0].length(); i < words[1].length() ; i++) {
                sum+=words[1].charAt(i);
            }
        }else{
            sum=suma(words[1],words[0]);
        }
        System.out.println(sum);
    }
    public static int suma(String first,String second){
        int sum = 0;
        for (int i = 0; i < first.length(); i++) {
            sum+=first.charAt(i)*second.charAt(i);
        }
        return sum;
    }
}
