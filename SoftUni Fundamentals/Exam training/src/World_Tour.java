import java.util.Scanner;

public class World_Tour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder travel = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Travel")){
            String[] typeOfCommand=command.split(":");
            switch (typeOfCommand[0]){
                case "Add Stop":
                    if (Integer.parseInt(typeOfCommand[1]) < travel.length() && Integer.parseInt(typeOfCommand[1])>=0) {
                        travel.insert(Integer.parseInt(typeOfCommand[1]),typeOfCommand[2]);
                    }
                    break;
                case  "Remove Stop":
                    if (Integer.parseInt(typeOfCommand[1]) < travel.length() && Integer.parseInt(typeOfCommand[2])<travel.length() &&
                            Integer.parseInt(typeOfCommand[1])>=0 && Integer.parseInt(typeOfCommand[2])>=0){
                        travel.replace(Integer.parseInt(typeOfCommand[1]),Integer.parseInt(typeOfCommand[2])+1,"");
                    }
                    break;
                case "Switch":
                    int oldStringIndex= travel.indexOf(typeOfCommand[1]);
                    if (oldStringIndex>=0){
                        travel.replace(oldStringIndex,typeOfCommand[1].length()+oldStringIndex,typeOfCommand[2]);
                    }
                    break;
            }
            System.out.println(travel);
            command= scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: "+travel);
    }
}
