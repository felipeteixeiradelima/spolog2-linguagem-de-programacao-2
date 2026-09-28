package servlet;

import entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.JpaUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/CursoController")
public class CursoController extends HttpServlet {
    EntityManager manager;
    EntityTransaction transaction;
    RequestDispatcher destino;

    public CursoController() {
        manager = JpaUtil.getEntityManager();
        transaction = manager.getTransaction();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cursos", consultaCursos());
        destino = getServletContext().getRequestDispatcher("/curso/resultado/consulta.jsp");
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        String descricao = request.getParameter("txDescricao");
        Integer cargaHoraria = null;

        if (request.getParameter("op").equals("exclusao") || request.getParameter("op").equals("alteracao"))
            id = Long.parseLong(request.getParameter("txId"));

        try {
            if (request.getParameter("op").equals("insercao") || request.getParameter("op").equals("alteracao")) {
                if (!(request.getParameter("txCargaHoraria") == (null)))
                    cargaHoraria = Integer.parseInt(request.getParameter("txCargaHoraria"));
            }
            if (request.getParameter("op").equals("insercao")) {
                try {
                    insereCurso(descricao, cargaHoraria);
                    request.setAttribute("resultado", true);
                } catch (Exception e) {
                    request.setAttribute("resultado", false);
                }
                destino = getServletContext().getRequestDispatcher("/curso/resultado/insercao.jsp");
            } else if (request.getParameter("op").equals("alteracao")) {
                try {
                    alteraCurso(id, descricao, cargaHoraria);
                    request.setAttribute("resultado", true);
                } catch (Exception e) {
                    request.setAttribute("resultado", false);
                }
                destino = getServletContext().getRequestDispatcher("/curso/resultado/alteracao.jsp");
            } else if (request.getParameter("op").equals("exclusao")) {
                try {
                    excluiCurso(id);
                    request.setAttribute("resultado", true);
                } catch (Exception e) {
                    request.setAttribute("resultado", false);
                }
                destino = getServletContext().getRequestDispatcher("/curso/resultado/exclusao.jsp");
            }
            destino.forward(request, response);
        } catch (Exception e) {
            destino = getServletContext().getRequestDispatcher("/erroEntrada.jsp");
            destino.forward(request, response);
        }
    }

    public List<Curso> consultaCursos() {
        TypedQuery<Curso> query = manager.createQuery("select c from Curso c", Curso.class);
        return query.getResultList();
    }

    public void insereCurso(String descricao, Integer cargaHoraria) {
        transaction.begin();
        Curso curso = new Curso(descricao, cargaHoraria);
        manager.persist(curso);
        transaction.commit();
    }

    public void alteraCurso(Long id, String descricao, Integer cargaHoraria) {
        transaction.begin();
        Curso curso = manager.find(Curso.class, id);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        transaction.commit();
    }

    public void excluiCurso(Long id) {
        transaction.begin();
        Curso curso = manager.find(Curso.class, id);
        manager.remove(curso);
        transaction.commit();
    }
}
