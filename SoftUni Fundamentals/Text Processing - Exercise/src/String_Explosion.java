import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class String_Explosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        Map<Integer,Integer> position = new LinkedHashMap<>();
        for (int i = text.length()-1; i >=0; i--) {
            if (text.charAt(i)=='>'){
                position.put(i+1,text.charAt(i+1)-48);
            }
        }
        /*for (int i = 0; i < text.length()&&explosion>0; i++) {
            if (text.charAt(i)=='>'){
                if(text.charAt(i+1)=='>'){
                    continue;
                }
                text.replace(i+1,i+2,"");
                explosion--;
            }
            if (i+1==text.length()){
                i=0;
            }
        }

        for (int i = 0; i < explosion; i++) {
            int position = text.indexOf(">");
            while (text.charAt(position)=='>' && text.charAt(position+1)=='>'){
                position++;
            }
            text.replace(position+1,position+2,"");
        }*/

        for (Map.Entry pos:position.entrySet()) {
            int condition = (int) pos.getKey()+(int) pos.getValue();
            for (int i = (int) pos.getKey(); i <condition&& i<text.length(); i++) {
                if (text.charAt(i)=='>'){
                    condition++;
                    continue;
                }
                else
                    text.replace(i,i+1,"");
                    condition--;
                    i--;
            }
        }
        System.out.println(text);
    }
}
