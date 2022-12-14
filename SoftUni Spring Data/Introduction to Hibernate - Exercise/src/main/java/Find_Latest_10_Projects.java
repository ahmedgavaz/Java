import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Find_Latest_10_Projects {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
        List<Project> list =entityManager.createQuery("select p from Project p order by p.startDate desc", Project.class).setMaxResults(10).getResultList();
                list.stream().sorted((a,b)->a.getName().compareTo(b.getName())).forEach(e-> System.out.println("Project name: "+e.getName()+System.lineSeparator()
                        +"\tProject Description: "+e.getDescription()+System.lineSeparator()+
                        "\tProject Start Date:"+e.getStartDate().format(formatter)+System.lineSeparator()+
                        "\tProject End Date:"+e.getEndDate()));
        entityManager.close();
    }
}
