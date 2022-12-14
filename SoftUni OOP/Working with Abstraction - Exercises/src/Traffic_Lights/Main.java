package Traffic_Lights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lights = scanner.nextLine().split("\\s+");
        int n= Integer.parseInt(scanner.nextLine());
        List<Light> list = new ArrayList<>();
        for (String elem:lights) {
            Light light = new Light(Color.valueOf(elem));
            list.add(light);
        }
        for (int i = 0; i < n; i++) {
            list.forEach(elem->{
                        elem.changeColor();
                        System.out.printf("%s ",elem.getColor());
                    }
                    );
            System.out.println();
        }
    }
}
