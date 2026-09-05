package relacionamentos;

import jakarta.persistence.EntityManager;
import model.onetoone.Estudante;
import util.JpaUtil;

import java.util.List;


public class Relacionamento1_1_Select {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        List<Estudante> estudantes = manager.createQuery("select e from Estudante e inner join fetch e.curso", Estudante.class).getResultList();
        String formato = "%1$-3s %2$-50s %3$-8s %4$-8s %5$-8s %6$-50s%n";

        System.out.printf(formato, "ID", " | NOME", " | SEXO", " | PCD", " | IRA", " | CURSO");
        for (Estudante estudante : estudantes) {
            System.out.printf(formato,
                              estudante.getId(),
                              " | " + estudante.getNome(),
                              " | " + estudante.getSexo(),
                              " | " + estudante.getPcd(),
                              " | " + estudante.getIra(),
                              " | " + estudante.getCurso().getDescricao());
        }

        manager.close();
        JpaUtil.close();
    }
}
