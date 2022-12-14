import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Change_Casing {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Town t set t.name=upper(t.name) where length(t.name)<=5").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
