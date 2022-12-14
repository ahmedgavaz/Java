import java.util.Scanner;

public class Multiply_Big_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number=scanner.nextLine();
        int second=Integer.parseInt(scanner.nextLine());
        if (second==0||number.equals("0")|| second>9||second<0){
            System.out.println(0);
        }else{
            StringBuilder result = new StringBuilder();
            int ost=0;
            for (int i = number.length()-1; i >=0 ; i--) {
                int num=Integer.parseInt(String.valueOf(number.charAt(i)));
                result.append(String.valueOf((num * second+ost) % 10));
                ost=(num*second+ost)/10;
            }
            if (ost!=0){
                result.append(ost);
            }
            result.reverse();
            boolean bol =true;
            for (int i = 0; i < result.length(); i++) {
                if (bol==false){
                    break;
                }
                if(result.charAt(i)=='0'){
                    result.replace(i,i+1,"");
                    i--;
                }else{
                    bol=false;
                }
            }
            System.out.println(result);
        }
    }
}
