package relacionamentos;

import jakarta.persistence.EntityManager;
import model.onetoonebidirecional.Curso;
import util.JpaUtil;

public class Relacionamento1_1_Select2_Bidirecional {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        Curso curso = manager.find(Curso.class, 1L);
        System.out.println("Estudante do curso '" + curso.getDescricao() + "': " + curso.getEstudante().getNome());

        manager.close();
        JpaUtil.close();
    }
}
