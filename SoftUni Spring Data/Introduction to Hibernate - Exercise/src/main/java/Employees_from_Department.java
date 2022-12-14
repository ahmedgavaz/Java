import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Employees_from_Department {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.createQuery("select e from Employee e where department.name='Research and Development' order by salary,id", Employee.class)
                .getResultList().forEach(e-> System.out.printf("%s %s from %s - $%.2f\n",e.getFirstName(),e.getLastName(),e.getDepartment().getName(),e.getSalary()));
        entityManager.close();
    }
}
