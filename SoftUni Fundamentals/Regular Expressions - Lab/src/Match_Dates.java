import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match_Dates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern =Pattern.compile("(?<Day>\\d{2})([\\/.-])(?<Month>[A-Z][a-z]{2})\\2(?<Year>\\d{4})");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",matcher.group("Day"),matcher.group("Month"),matcher.group("Year"));
        }
    }
}
