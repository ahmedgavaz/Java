import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String,Integer> race = new LinkedHashMap<>();
        racers.forEach(e->race.put(e,0));
        String input = scanner.nextLine();
        Pattern pattern1=Pattern.compile("[A-Za-z]");
        Pattern pattern2=Pattern.compile("[0-9]");
        while (!input.equals("end of race")){
            StringBuilder name = new StringBuilder();
            Matcher matcher1=pattern1.matcher(input);
            int distance =0;
            Matcher matcher2=pattern2.matcher(input);
            while (matcher1.find()){
                name.append(matcher1.group());
            }
            while (matcher2.find()){
                distance+=Double.parseDouble(matcher2.group());
            }
            if(race.containsKey(String.valueOf(name))){
                    race.put(String.valueOf(name), race.get(String.valueOf(name))+distance);
            }
            input= scanner.nextLine();
        }
        List<String> finalists = race.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).map(entry->entry.getKey()).collect(Collectors.toList());
        System.out.println("1st place: "+finalists.get(0));
        System.out.println("2nd place: "+finalists.get(1));
        System.out.println("3rd place: "+finalists.get(2));
    }
}
