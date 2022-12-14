import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Easter_eggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile("[@|#]+([a-z]{3,})[@|#]+[^a-zA-Z0-9]*[\\/]+([0-9]+)[\\/]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String matched = matcher.group();
            System.out.printf("You found %s %s eggs!%n",matcher.group(2),matcher.group(1));
        }
    }
}
