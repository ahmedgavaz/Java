import java.util.*;

public class Hands_Of_Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("JOKER")){
            String[] name = command.split(": ");
            String[] cards = name[1].split(", ");
            Set<String> card = new LinkedHashSet<>();
            card.addAll(Arrays.asList(cards));
            if (players.containsKey(name[0])){
                card.addAll(players.get(name[0]));
                players.put(name[0],card);
            }else{
                players.put(name[0],Set.copyOf(Arrays.asList(cards)));
            }
            command= scanner.nextLine();
        }
        for (Map.Entry<String,Set<String>> elem:players.entrySet()) {
            int  sum = 0;
            for (String element:elem.getValue()) {
                int suma=0;
                if (element.startsWith("10")){
                    suma=10;
                    if (element.charAt(2)=='S'){
                        suma*=4;
                    }
                    if (element.charAt(2)=='H'){
                        suma*=3;
                    }
                    if (element.charAt(2)=='D'){
                        suma*=2;
                    }
                }else{
                for (int i = 0; i < 2; i++) {
                    switch (element.charAt(i)){
                        case'1':
                            suma+=1;
                            break;
                        case'2':
                            suma+=2;
                            break;
                        case'3':
                            suma+=3;
                            break;
                        case'4':
                            suma+=4;
                            break;
                        case'5':
                            suma+=5;
                            break;
                        case'6':
                            suma+=6;
                            break;
                        case'7':
                            suma+=7;
                            break;
                        case'8':
                            suma+=8;
                            break;
                        case'9':
                            suma+=9;
                            break;
                        case'J':
                            suma+=11;
                            break;
                        case'Q':
                            suma+=12;
                            break;
                        case'K':
                            suma+=13;
                            break;
                        case'A':
                            suma+=14;
                            break;
                        case'S':
                            suma*=4;
                            break;
                        case'H':
                            suma*=3;
                            break;
                        case'D':
                            suma*=2;
                            break;
                    }}

            }
                sum = sum +suma;}
            System.out.println(elem.getKey()+": "+sum);
            sum=0;
        }
      /*  players.forEach((key,value)->{
            int sum = 0;
            value.forEach(e->{
                int suma=0;
                if (e.startsWith("10")){
                    suma+=10;
                }else{
                    for (int i = 0; i < 2; i++) {
                    switch (e){
                        case"1":
                            suma+=1;
                            break;
                        case"2":
                            suma+=2;
                            break;
                        case"3":
                            suma+=3;
                            break;
                        case"4":
                            suma+=4;
                            break;
                        case"5":
                            suma+=5;
                            break;
                        case"6":
                            suma+=6;
                            break;
                        case"7":
                            suma+=7;
                            break;
                        case"8":
                            suma+=8;
                            break;
                        case"9":
                            suma+=9;
                        case"J":
                            suma+=11;
                            break;
                        case"Q":
                            suma+=12;
                            break;
                        case"K":
                            suma+=13;
                            break;
                        case"A":
                            suma+=14;
                            break;
                        case"S":
                            suma*=4;
                            break;
                        case"H":
                            suma*=3;
                            break;
                        case"D":
                            suma*=2;
                            break;
                    }}
                    sum = sum +suma;
                }
            });
            System.out.println(key+": "+sum);
        });*/
    }
}
