package Custom_List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();
        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] cases = command.split("\\s+");
            switch (cases[0]){
                case "Add":
                    list.add(cases[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(cases[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(cases[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(cases[1]),Integer.parseInt(cases[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(cases[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    list.sorting();
            }
            command= scanner.nextLine();
        }
    }
}
