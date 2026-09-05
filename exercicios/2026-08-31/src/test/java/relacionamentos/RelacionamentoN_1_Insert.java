package relacionamentos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.manytoone.Curso;
import model.manytoone.Estudante;
import util.JpaUtil;

import java.math.BigDecimal;

public class RelacionamentoN_1_Insert {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Curso curso = new Curso("Sistemas de Informação", 3500);
        manager.persist(curso);

        Estudante estudante1 = new Estudante("Felipe Teixeira de Lima", 'M', true, BigDecimal.valueOf(9));
        estudante1.setCurso(curso);
        manager.persist(estudante1);

        Estudante estudante2 = new Estudante("Thiago Ferreira Galvao", 'M', false, BigDecimal.valueOf(8.7));
        estudante2.setCurso(curso);
        manager.persist(estudante2);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }
}
