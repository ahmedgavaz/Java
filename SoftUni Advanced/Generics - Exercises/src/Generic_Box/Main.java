package Generic_Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Задача 1
        Scanner scanner = new Scanner(System.in);
        Box<String> list = new Box<>();
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            list.add(scanner.nextLine());
        }
        System.out.println(list);*/
        /* Задача 2
        Scanner scanner = new Scanner(System.in);
        Box<Integer> list = new Box<>();
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println(list);*/
        /* Задача 3
        Scanner scanner = new Scanner(System.in);
        Box<String> list = new Box<>();
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            list.add(scanner.nextLine());
        }
        String[] indexes = scanner.nextLine().split("\\s+");
        list.swap(Integer.parseInt(indexes[0]),Integer.parseInt(indexes[1]));
        System.out.println(list);*/
        /* Задача 4
        Scanner scanner = new Scanner(System.in);
        Box<Integer> list = new Box<>();
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        String[] indexes = scanner.nextLine().split("\\s+");
        list.swap(Integer.parseInt(indexes[0]),Integer.parseInt(indexes[1]));
        System.out.println(list);*/
        /* Задача 5
        Scanner scanner = new Scanner(System.in);
        Box<String> list = new Box<>();
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            list.add(scanner.nextLine());
        }
        String element = scanner.nextLine();
        System.out.println(list.count(element));*/
        // Задача 6
        Scanner scanner = new Scanner(System.in);
        Box<Double> list = new Box<>();
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            list.add(Double.parseDouble(scanner.nextLine()));
        }
        Double element = Double.parseDouble(scanner.nextLine());;
        System.out.println(list.count(element));
    }
}
