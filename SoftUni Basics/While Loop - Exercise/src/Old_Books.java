import java.util.Scanner;

public class Old_Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        int br = 0;
        String book1 = scanner.nextLine();
        while (!book1.equals("No More Books")){
            if (book.equals(book1)){
                System.out.printf("You checked %d books and found it.",br);
                return;
            }
            br = br + 1;
            book1 = scanner.nextLine();
        }
        System.out.println("The book you search is not here!");
        System.out.printf("You checked %d books.",br);
    }
}
