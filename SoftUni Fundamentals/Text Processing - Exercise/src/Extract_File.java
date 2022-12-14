import java.util.Scanner;

public class Extract_File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*String[] file = scanner.nextLine().split("\\.");
        int index = file[0].lastIndexOf("\\");
        String name = "";
        for (int i = index+1; i < file[0].length() ; i++) {
            name+=file[0].charAt(i);
        }
        System.out.println("File name: "+name);
        System.out.println("File extension: "+file[1]);*/
        String[] file = scanner.nextLine().split("\\\\");
        String[] index = file[file.length-1].split("\\.");
        System.out.println("File name: "+index[0]);
        System.out.println("File extension: "+index[1]);
    }
}
