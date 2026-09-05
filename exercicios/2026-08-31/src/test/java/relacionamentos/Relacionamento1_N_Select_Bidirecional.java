package relacionamentos;

import jakarta.persistence.EntityManager;
import model.manytoonebidirecional.Curso;
import model.manytoonebidirecional.Estudante;
import util.JpaUtil;

public class Relacionamento1_N_Select_Bidirecional {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        Curso curso = manager.find(Curso.class, 1L);
        System.out.println("Estudantes do curso '" + curso.getDescricao() + "':");
        for (Estudante estudante : curso.getEstudantes()) {
            System.out.println(estudante.getNome());
        }

        manager.close();
        JpaUtil.close();
    }
}
