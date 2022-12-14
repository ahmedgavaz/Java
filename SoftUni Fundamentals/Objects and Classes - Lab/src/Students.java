import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static class Student {
        String firstName;
        String lastName;
        Integer age;
        String homeTown;

        public Student(String firstName, String lastName, Integer age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public Integer getAge() {
            return age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Student> listStudents = new ArrayList<>();
        while (!command.equals("end")) {
            String[] info = command.split(" ");
            String name = info[0];
            String lastName = info[1];
            int age = Integer.parseInt(info[2]);
            String town = info[3];
            int index =isNameInArray(listStudents,name,lastName);
            if (index!=-1){
                Student edit = listStudents.get(index);
                edit.setAge(age);
                edit.setHomeTown(town);
                listStudents.set(index,edit);
            }else{
            Student temp = new Student(name, lastName, age, town);
            listStudents.add(temp);}
            command = scanner.nextLine();
        }
        String city = scanner.nextLine();
        for (Student temp : listStudents) {
            if (temp.getHomeTown().equals(city)) {
                System.out.printf("%s %s is %d years old%n", temp.getFirstName(), temp.getLastName(), temp.getAge());
            }
        }
    }
    public static Integer isNameInArray(List<Student> listStudents,String firstName,String lastName){
        for (int i = 0; i < listStudents.size(); i++) {
            Student temp = listStudents.get(i);
            if (temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName)){
                return i;
            }
        }
        return -1;
    }
}
