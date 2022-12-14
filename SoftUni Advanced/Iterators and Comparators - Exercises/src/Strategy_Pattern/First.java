package Strategy_Pattern;

import java.util.Comparator;
import java.util.Locale;

public class First implements Comparator<Person> {
    @Override
    public int compare(Person name1, Person name2) {
        int result = Integer.compare(name1.getName().length(),name2.getName().length());
        if (result==0){
            result = Character.compare(name1.getName().toLowerCase(Locale.ROOT).charAt(0),name2.getName().toLowerCase(Locale.ROOT).charAt(0));
        }
        return result;
    }
}
