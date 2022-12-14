import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Destination_Mapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<String> destinations = new ArrayList<>();
        Pattern pattern=Pattern.compile("([\\/=])([A-Z][a-zA-Z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        int points = 0;
        while (matcher.find()){
            destinations.add(matcher.group(2));
            points += matcher.group(2).length();
        }
        System.out.println("Destinations: "+String.join(", ",destinations));
        System.out.println("Travel Points: "+points);
    }
}
