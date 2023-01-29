import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Създаване на файл
        File file = Path.of("ahmed.txt").toFile();
        if (!file.exists()) {
            file.createNewFile();
        }
       /* //Извеждане на обект
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        ddz d = new ddz("Ahmed" , 12);
        outputStream.writeObject(d);

        //Четене на обект
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ddz a = (ddz )objectInputStream.readObject();
        System.out.println(a.getName());

        //Четене на цял файл с обекти
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        while (fileInputStream.available()!=0){
        ddz a = (ddz )objectInputStream.readObject();
        System.out.println(a.getName());}

        //Ако файла съществува
        FileWriter fileWriter = new FileWriter(file, true);
        //Ако не съществува
        //FileWriter fileWriter = new FileWriter(file);
        //Писане във файл - не е бинарно
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.newLine();
        bufferedWriter.write("Ahmed Gavaz");
        bufferedWriter.newLine();
        bufferedWriter.write("Ahmed");
        bufferedWriter.close();
        fileWriter.close();

        //Четене от файл - не е бинарно
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println(bufferedReader.readLine());
        fileReader.close();
        bufferedReader.close();*/

        //Пишене в двойчен файл
        File file1 = Path.of("ahmed1.dat").toFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
      /*  ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeDouble(123.4351);
        outputStream.flush();
        outputStream.close();*/
        printWriter.println(12.321);
        fileOutputStream.close();

        //Четене от двоичен файл
        FileInputStream fileInputStream = new FileInputStream(file1);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        double string = objectInputStream.readDouble();
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
        System.out.println(string);
        objectInputStream.close();
    }
}