import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Addresses_with_Employee_Count {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.createQuery("select a from Address a order by a.employees.size desc",Address.class).setMaxResults(10).getResultList().
                forEach(e-> System.out.println(e.getText()+", "+e.getTown().getName()+" - "+e.getEmployees().size()+" employees"));
        entityManager.close();
    }
}
