import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class WritingFile implements Runnable {
    private Thread thread;

    public WritingFile() {

    }

    @Override
    public void run() {
       /* Thread writingThread = new Thread(() -> writing());
        Thread readingThread = new Thread(this::reading);
        writingThread.start();
        readingThread.start();*/
        writing();
        reading();
        /*Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        while (!message.equals("end")){
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"));
                bufferedWriter.write(message);
                BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
                while (bufferedReader)
            } catch (IOException e) {
                System.out.println("Error");
            }

            message=scanner.nextLine();
        }*/
    }

    private void writing() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Path.of("file.txt").toFile(), true));) {
           /* for (int i = 0; i < 10; i++) {
                bufferedWriter.write(Integer.toString(i));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }*/
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            while (!str.equals("end")) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                reading();
                str = scanner.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void reading() {
        FileReader fileReader = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"))) {
            while (true) {
                String str = bufferedReader.readLine();
                if (str == null) {
                    break;
                }
                System.out.println(str);
                if (str.contains("\u001a")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
}
