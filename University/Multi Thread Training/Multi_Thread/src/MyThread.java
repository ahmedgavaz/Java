import java.util.Scanner;

public class MyThread implements Runnable {
    private Thread thread;
    private String name;
    private static int money=0;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try{
                Scanner scanner = new Scanner(System.in);
                int adding = Integer.parseInt(scanner.nextLine());
                addMoney(adding);
                System.out.println(money);
            }catch (Exception e){
                break;
            }
        }
    }

    private synchronized void printMoney(){
        System.out.println(money);
    }

    private synchronized void addMoney(int adding) {
        money += adding;
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this,name);
            thread.start();
        }
    }
}
