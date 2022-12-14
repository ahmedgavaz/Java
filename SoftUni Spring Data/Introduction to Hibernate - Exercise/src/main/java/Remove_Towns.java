import com.mysql.cj.sasl.ScramShaSaslClient;
import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Remove_Towns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.getTransaction().begin();
        Town town = entityManager.createQuery("select t from Town t where name like :city", Town.class).setParameter("city", city).getSingleResult();
        List<Employee> employees = entityManager.createQuery("select e from Employee e where e.address.id= :city", Employee.class).setParameter("city", town.getId()).getResultList();
        employees.forEach(entityManager::remove);
        List<Address> addresses = entityManager.createQuery("select a from Address a where a.town.id= :city", Address.class).setParameter("city", town.getId()).getResultList();
        addresses.forEach(e -> entityManager.remove(e));
        //entityManager.createQuery("delete Town where name = :city").setParameter("city",city).executeUpdate();
        entityManager.remove(town);
        entityManager.getTransaction().commit();
        entityManager.close();
        if (addresses.size() > 1) {
            System.out.printf("%d address in %s deleted", addresses.size(), city);
        } else if (addresses.size() == 1) {
            System.out.printf("1 address in %s deleted", city);
        }
    }
}
