import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Increase_Salaries {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("Update Employee e set e.salary = e.salary * 1.12 where e.department.id in (1, 2, 4, 11)").executeUpdate();
        entityManager.createQuery("Select e from Employee e where e.department.name in ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class).
                getResultList().forEach(e-> System.out.printf("%s %s ($%.2f)\n",e.getFirstName(),e.getLastName(),e.getSalary()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
