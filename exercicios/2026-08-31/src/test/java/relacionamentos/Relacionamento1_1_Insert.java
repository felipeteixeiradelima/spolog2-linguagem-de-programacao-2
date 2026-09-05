package relacionamentos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.onetoone.Curso;
import model.onetoone.Estudante;
import util.JpaUtil;

import java.math.BigDecimal;

public class Relacionamento1_1_Insert {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Curso curso = new Curso("Sistemas de Informação", 3500);
        manager.persist(curso);

        Estudante estudante = new Estudante("Amanda Jen", 'F', false, BigDecimal.valueOf(9.5));
        estudante.setCurso(curso);
        manager.persist(estudante);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }
}
