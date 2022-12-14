import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Employees_with_Salary_Over_50000 {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.createQuery("select e from Employee e where salary>50000", Employee.class).getResultList().forEach(e-> System.out.println(e.getFirstName()));
        entityManager.close();
    }
}
