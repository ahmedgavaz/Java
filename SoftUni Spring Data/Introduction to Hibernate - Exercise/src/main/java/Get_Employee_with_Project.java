import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Get_Employee_with_Project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id= scanner.nextInt();
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        Employee employee =entityManager.createQuery("select e from Employee e where e.id=:idd", Employee.class).setParameter("idd",id).getSingleResult();
        System.out.println(employee.getFirstName()+" "+employee.getLastName()+ " - "+employee.getJobTitle());
        employee.getProjects().stream().sorted((a,b)->a.getName().compareTo(b.getName())).forEach(e-> System.out.println("\t"+e.getName()));
        entityManager.close();
    }
}
