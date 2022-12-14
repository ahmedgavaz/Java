import java.io.File;

public class Get_Folder_Size {
    public static void main(String[] args) {
        String path = "D:\\Java\\SoftUni Advanced\\Streams, Files and Directories - Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder= new File(path);
        File[] files = folder.listFiles();
        int size=0;
        for (File f:files) {
            size+=f.length();
        }
        System.out.println("Folder size: "+size);
    }
}
