import com.sun.source.tree.WhileLoopTree;

import java.util.*;
import java.util.stream.Collectors;

public class Predicate_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command= scanner.nextLine();
        while (!command.equals("Party!")){
            String[] toDo=command.split("\\s+");
            switch (toDo[0]){
                case "Remove":
                    switch (toDo[1]){
                        case "StartsWith":
                            list = list.stream().filter(e->e.charAt(0)!=toDo[2].charAt(0)).collect(Collectors.toList());
                            break;
                        case "EndsWith":
                            list =list.stream().filter(e->e.charAt(e.length()-1)!=toDo[2].charAt(0)).collect(Collectors.toList());
                            break;
                        case "Length":
                            list = list.stream().filter(e->e.length()!=Integer.parseInt(toDo[2])).collect(Collectors.toList());
                            break;
                    }
                    break;
                case "Double":
                    List<String> add = new ArrayList<>();
                    switch (toDo[1]){
                        case "StartsWith":
                            list.forEach(e->{
                                if(e.charAt(0)==toDo[2].charAt(0)){
                                    add.add(e);
                                }
                            });
                            break;
                        case "EndsWith":
                            list.forEach(e->{
                                if(e.charAt(e.length()-1)==toDo[2].charAt(0)){
                                    add.add(e);
                                }
                            });
                            break;
                        case "Length":
                            list.forEach(e->{
                                if(e.length()==Integer.parseInt(toDo[2])){
                                    add.add(e);
                                }
                            });
                            break;
                    }
                    list.addAll(add);
                    add.clear();
                    break;
            }
            command= scanner.nextLine();
        }
        if (list.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            Collections.sort(list);
            System.out.println(String.join(", ",list)+ " are going to the party!");
        }
    }
}
