import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Scanner;

public class Contain_Employee {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        Long count = entityManager.createQuery("Select count(*) from Employee where firstName=:fn and lastName=:ln", Long.class).setParameter("fn",names[0]).setParameter("ln",names[1]).getSingleResult();
        if (count>0){
            System.out.print("Yes");
        }else{
            System.out.println("No");
        }
        entityManager.close();
    }
}
