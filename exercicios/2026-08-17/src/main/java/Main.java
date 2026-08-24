import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.close();
    }
}
