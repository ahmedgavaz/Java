package Pokemon_Trainer;


import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<Pokemon>> pokemon = new LinkedHashMap<>();
        Map<String, Integer> badges = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Tournament")) {
            String[] commands = command.split("\\s+");
            Trainer trainer;
            Pokemon pokemon1;
            pokemon1 = new Pokemon(commands[1], commands[2], Integer.parseInt(commands[3]));
            trainer = new Trainer(commands[0], 0, new ArrayList<>());
            if (!pokemon.containsKey(commands[0])) {
                pokemon.put(commands[0], new ArrayList<Pokemon>());
            }
            pokemon.get(commands[0]).add(pokemon1);
            badges.put(commands[0], 0);
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        Function<Pokemon, Pokemon> edit = a -> {
            a.setHealth(a.getHealth() - 10);
            return a;
        };
        while (!command.equals("End")) {
            String nz = command;
            pokemon.entrySet().stream().map(e -> {
                if (isPokemonInList(nz, e.getValue())) {
                    badges.put(e.getKey(), badges.get(e.getKey()) + 1);
                } else {
                    e.getValue().stream().map(edit).filter(a -> a.getHealth() > 0).collect(Collectors.toList());
                }
                e.getValue().stream().filter(a -> a.getHealth() > 0).collect(Collectors.toList());
                return e;
            }).collect(Collectors.toList());
            for (Map.Entry elem : pokemon.entrySet()) {
                deleting((List<Pokemon>) elem.getValue());
            }
            command = scanner.nextLine();
        }
        badges.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList()).forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue() + " " + pokemon.get(e.getKey()).size());
        });
    }

    public static boolean isPokemonInList(String element, List<Pokemon> list) {
        for (Pokemon elem : list) {
            if (elem.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptyPokemon(Pokemon list) {
        if (list.getHealth() <= 0) {
            return true;
        }
        return false;
    }

    public static void deleting(List<Pokemon> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (isEmptyPokemon(list.get(i))) {
                list.remove(i);
            }
        }
    }
}
