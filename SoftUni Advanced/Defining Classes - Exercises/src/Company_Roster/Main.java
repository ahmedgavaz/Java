package Company_Roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Employee>> firm = new LinkedHashMap<>();;
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            Employee employee = new Employee();
            employee.setName(arr[0]);
            employee.setSalary(Double.parseDouble(arr[1]));
            employee.setPosition(arr[2]);
            employee.setDepartment(arr[3]);
            if (arr.length==4){
                employee.setAge(-1);
                employee.setEmail("n/a");
            }
            else if (!arr[4].contains("@") && arr.length==5){
                employee.setAge(Integer.parseInt(arr[4]));
                employee.setEmail("n/a");
            }else if(arr.length==6){
                employee.setAge(Integer.parseInt(arr[5]));
                employee.setEmail(arr[4]);
            }
            else if(arr.length==5 && arr[4].contains("@")){
                employee.setAge(-1);
                employee.setEmail(arr[4]);
            }
            if (!firm.containsKey(employee.getDepartment())){
                firm.put(employee.getDepartment(),new ArrayList<>());
                firm.get(employee.getDepartment()).add(employee);
            }else{
            firm.get(employee.getDepartment()).add(employee);}
        }
        String dep= String.valueOf(firm.entrySet().stream().max(Comparator.comparingDouble(e -> avg(e.getValue()))).get().getKey());
        System.out.println("Highest Average Salary: "+dep);
        List<Employee> depart = firm.get(dep);
        depart.sort(Comparator.comparingDouble(e->e.getSalary()));
        Collections.reverse(depart);
        depart.forEach(e->
                System.out.printf("%s %.2f %s %d%n",e.getName(),e.getSalary(),e.getEmail(),e.getAge()));
    }
    public static double avg(List<Employee> list){
        double av=0;
        for (int i = 0; i < list.size(); i++) {
            av+=list.get(i).getSalary();
        }
        return av/list.size();
    }
}
