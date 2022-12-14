import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Find_Employees_by_First_Name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.createQuery("select e from Employee e where e.firstName like :pat", Employee.class).setParameter("pat",pattern+"%")
                        .getResultList().forEach(e-> System.out.printf("%s %s - %s - ($%.2f)\n",e.getFirstName(),e.getLastName(),e.getDepartment().getName(),e.getSalary()));
        entityManager.close();
    }
}
