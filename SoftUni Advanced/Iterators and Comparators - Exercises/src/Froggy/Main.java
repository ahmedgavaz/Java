package Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog list = new Frog();
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            List<Integer> arr = Arrays.stream(command.split(", ")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());
            list.adding(arr);
            command = scanner.nextLine();
        }
        Iterator<Integer> lake = list.iterator();
        while (lake.hasNext()) {
            System.out.print(lake.next());
            if (lake.hasNext()) {
                System.out.print(", ");
            }
        }
    }
}
