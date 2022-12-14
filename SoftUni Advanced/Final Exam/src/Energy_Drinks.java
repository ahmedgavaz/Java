import java.util.*;

public class Energy_Drinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] milligrams = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] drinks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> milligram = new ArrayDeque<>();
        ArrayDeque<Integer> drink = new ArrayDeque<>();
        for (int i = 0; i < milligrams.length; i++) {
            milligram.push(milligrams[i]);
        }
        for (int i = 0; i < drinks.length; i++) {
            drink.offer(drinks[i]);
        }
        int stamat = 0;
        while (milligram.size() > 0 && drink.size() > 0) {
            if (milligram.peek() * drink.peek() + stamat <= 300) {
                stamat += milligram.pop() * drink.poll();
            } else {
                milligram.pop();
                int dr = drink.poll();
                drink.offer(dr);
                if (stamat >= 30) {
                    stamat -= 30;
                }
            }
        }
        if (drink.size()==0) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.print("Drinks left: ");
            int size = drink.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    System.out.print(drink.poll());
                } else {
                    System.out.print(drink.poll() + ", ");
                }
            }
            System.out.println();
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamat);
    }
}
