import java.util.Scanner;

public class Articles {
    public static class Article{
        String title;
        String content;
        String author;

        public Article(String title,String  content, String author){
            this.title=title;
            this.content=content;
            this.author=author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public void edit(Article name, String newContent){
            name.setContent(newContent);
        }
        public  void changeAuthor(Article name, String newAuthor){
            name.setAuthor(newAuthor);
        }
        public void rename(Article name, String newTitle){
            name.setTitle(newTitle);
        }
        public String toString(){
            return String.format("%s - %s: %s",this.title,this.content,this.author);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] newArticle = scanner.nextLine().split(", ");
        Article art = new Article(newArticle[0], newArticle[1],newArticle[2]);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(": ");
            switch (command[0]){
                case "Edit":
                    art.edit(art,command[1]);
                    break;
                case "ChangeAuthor":
                    art.changeAuthor(art,command[1]);
                    break;
                case "Rename":
                    art.rename(art,command[1]);
                    break;
            }
        }
        System.out.println(art);
    }
}
