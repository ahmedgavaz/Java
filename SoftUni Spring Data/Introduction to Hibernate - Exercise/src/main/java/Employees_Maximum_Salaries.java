import entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Employees_Maximum_Salaries {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        List<Department> list = entityManager.createQuery("select d from Department d join Employee e on e.department.id=d.id group by d.name having max(salary)>70000 or max(salary)<30000", Department.class).getResultList();
        for (Department e:list) {
            System.out.print(e.getName()+" ");
            e.getEmployees().stream().sorted((a,b)->b.getSalary().compareTo(a.getSalary())).limit(1).forEach(g-> System.out.printf("%.2f\n",g.getSalary()));
        }
      //  list.forEach(e-> System.out.println(e.getName()+" " +e.getEmployees().stream().sorted((a,b)->b.getSalary().compareTo(a.getSalary())).limit(1).forEach(g-> System.out.println(g.getSalary()));));
        entityManager.close();
    }
}
