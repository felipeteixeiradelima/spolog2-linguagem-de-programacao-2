package relacionamentos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.manytomany.Curso;
import model.manytomany.Estudante;
import util.JpaUtil;

import java.math.BigDecimal;

public class RelacionamentoN_N_Insert {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Curso curso1 = new Curso("Sistemas de Informação", 3500);
        manager.persist(curso1);

        Curso curso2 = new Curso("Engenharia da Computação", 4500);
        manager.persist(curso2);

        Curso curso3 = new Curso("Biologia", 3800);
        manager.persist(curso3);

        Estudante estudante1 = new Estudante("Felipe Teixeira de Lima", 'M', true, BigDecimal.valueOf(9));
        estudante1.getCursos().add(curso1);
        estudante1.getCursos().add(curso3);
        manager.persist(estudante1);

        Estudante estudante2 = new Estudante("Yasmin Monteiro Marques", 'F', false, BigDecimal.valueOf(9.7));
        estudante2.getCursos().add(curso1);
        estudante2.getCursos().add(curso2);
        manager.persist(estudante2);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }
}
