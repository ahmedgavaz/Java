package Black_Box_Integer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class clazz = BlackBoxInt.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
        String input = scanner.nextLine();
        Method[] methods = clazz.getDeclaredMethods();
        Field value = clazz.getDeclaredField("innerValue") ;
        value.setAccessible(true);
        while (!input.equals("END")){
            String commands[]=input.split("_");
            switch (commands[0]){
                case "add":
                    Method add = clazz.getDeclaredMethod("add", int.class);
                    add.setAccessible(true);
                    add.invoke(blackBoxInt, Integer.parseInt(commands[1]));
                    System.out.println(value.get(blackBoxInt));
                    break;
                case "subtract":
                    Method subtract = clazz.getDeclaredMethod("subtract", int.class);
                    subtract.setAccessible(true);
                    subtract.invoke(blackBoxInt, Integer.parseInt(commands[1]));
                    System.out.println(value.get(blackBoxInt));
                    break;
                case "multiply":
                    Method multiply = clazz.getDeclaredMethod("multiply", int.class);
                    multiply.setAccessible(true);
                    multiply.invoke(blackBoxInt, Integer.parseInt(commands[1]));
                    System.out.println(value.get(blackBoxInt));
                    break;
                case "divide":
                    Method divide = clazz.getDeclaredMethod("divide", int.class);
                    divide.setAccessible(true);
                    divide.invoke(blackBoxInt, Integer.parseInt(commands[1]));
                    System.out.println(value.get(blackBoxInt));
                    break;
                case "leftShift":
                    Method leftShift = clazz.getDeclaredMethod("leftShift", int.class);
                    leftShift.setAccessible(true);
                    leftShift.invoke(blackBoxInt, Integer.parseInt(commands[1]));
                    System.out.println(value.get(blackBoxInt));
                    break;
                case "rightShift":
                    Method rightShift = clazz.getDeclaredMethod("rightShift", int.class);
                    rightShift.setAccessible(true);
                    rightShift.invoke(blackBoxInt, Integer.parseInt(commands[1]));
                    System.out.println(value.get(blackBoxInt));
                    break;
            }
            input= scanner.nextLine();
        }
    }
}
