import java.io.Reader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //Pattern p = Pattern.compile("([a-z._A-Z]+|[0-9]+)+");
        Pattern p = Pattern.compile("[a-z._A-Z]+");
        Matcher m = p.matcher(str);
        if (m.matches()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
       /* Integer i=null;
        try{
        System.out.println(i+1);}
        catch (NullPointerException n){
            System.out.println(n.getMessage());
        }*/
       /* try {
            if (str.equals("Debren")){
                System.out.println("Yes");
            }else {
                throw new NoMatcher("Debren is the best");
            }
        }catch (NoMatcher e) {
            System.out.println(e.getMessage());
        }*/

    }
}