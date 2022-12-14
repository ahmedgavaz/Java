import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class Advertisement_Message {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random rnd = new Random();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int a = rnd.nextInt(phrases.length);
            int b = rnd.nextInt(events.length);
            int c = rnd.nextInt(authors.length);
            int d = rnd.nextInt(cities.length);
            System.out.printf("%s %s %s - %s%n", phrases[a], events[b], authors[c], cities[d]);
        }
    }
}
