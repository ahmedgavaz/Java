import com.sun.xml.bind.v2.schemagen.xmlschema.Annotated;
import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Adding_a_New_Address_and_Updating_Employee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.next();
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.getTransaction().begin();
        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);
        entityManager.createQuery("Update Employee e set e.address=:newAdd where e.lastName=:ln").setParameter("newAdd",address).setParameter("ln",lastName).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
