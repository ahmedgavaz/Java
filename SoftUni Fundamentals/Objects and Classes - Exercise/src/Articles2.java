import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    public static class Articles {
        String title;
        String content;
        String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }
        public String toString(){
            return String.format("%s - %s: %s",this.title,this.content,this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Articles> articles = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] newspaper = scanner.nextLine().split(", ");
            Articles singleArticle = new Articles(newspaper[0], newspaper[1], newspaper[2]);
            articles.add(singleArticle);
        }
        for (Articles temp:articles) {
            System.out.println(temp);
        }
    }
}
