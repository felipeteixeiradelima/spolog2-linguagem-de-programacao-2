package relacionamentos;

import jakarta.persistence.EntityManager;
import model.manytomany.Curso;
import model.manytomany.Estudante;
import util.JpaUtil;

public class RelacionamentoN_N_Select {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        Estudante estudante = manager.find(Estudante.class, 2L);
        System.out.println("Cursos do(a) Estudante '" + estudante.getNome() + "': ");
        for (Curso curso : estudante.getCursos()) {
            System.out.println(curso.getDescricao());
        }

        manager.close();
        JpaUtil.close();
    }
}
