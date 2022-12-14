import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match_Phone_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern =Pattern.compile("\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        List<String> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.group());
        }
        System.out.println(String.join(", ",list));
    }
}
