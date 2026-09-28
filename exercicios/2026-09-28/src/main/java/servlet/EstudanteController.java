package servlet;

import entity.Estudante;
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
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/EstudanteController")
public class EstudanteController extends HttpServlet {
    EntityManager manager;
    EntityTransaction transaction;
    RequestDispatcher destino;

    public EstudanteController() {
        manager = JpaUtil.getEntityManager();
        transaction = manager.getTransaction();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("estudantes", consultaEstudantes());
        destino = getServletContext().getRequestDispatcher("/estudante/resultado/consulta.jsp");
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        String nome = request.getParameter("txNome");
        Character sexo = 'X';
        Boolean pcd = true;
        BigDecimal ira = null;

        try {
            if (request.getParameter("op").equals("exclusao") || request.getParameter("op").equals("alteracao"))
                id = Long.parseLong(request.getParameter("txId"));

            if (request.getParameter("op").equals("insercao") || request.getParameter("op").equals("alteracao")) {
                String sexoBruto = request.getParameter("rdSexo");
                if (sexoBruto != null && !sexoBruto.isEmpty()) sexo = sexoBruto.charAt(0);
                if (request.getParameter("ckPcd") == null) pcd = false;
                if (!(request.getParameter("txIra") == (null)))
                    ira = new BigDecimal(request.getParameter("txIra").replace(",", "."));
            }

            if (request.getParameter("op").equals("insercao")) {
                try {
                    insereEstudante(nome, sexo, pcd, ira);
                    request.setAttribute("resultado", true);
                } catch (Exception e) {
                    request.setAttribute("resultado", false);
                }
                destino = getServletContext().getRequestDispatcher("/estudante/resultado/insercao.jsp");
            } else if (request.getParameter("op").equals("alteracao")) {
                try {
                    alteraEstudante(id, nome, sexo, pcd, ira);
                    request.setAttribute("resultado", true);
                } catch (Exception e) {
                    request.setAttribute("resultado", false);
                }
                destino = getServletContext().getRequestDispatcher("/estudante/resultado/alteracao.jsp");
            } else if (request.getParameter("op").equals("exclusao")) {
                try {
                    excluiEstudante(id);
                    request.setAttribute("resultado", true);
                } catch (Exception e) {
                    request.setAttribute("resultado", false);
                }
                destino = getServletContext().getRequestDispatcher("/estudante/resultado/exclusao.jsp");
            }
            destino.forward(request, response);
        } catch (Exception e) {
            destino = getServletContext().getRequestDispatcher("/erroEntrada.jsp");
            destino.forward(request, response);
        }
    }

    public List<Estudante> consultaEstudantes() {
        TypedQuery<Estudante> query = manager.createQuery("select l from Estudante l", Estudante.class);
        return query.getResultList();
    }

    public void insereEstudante(String nome, Character sexo, Boolean pcd, BigDecimal ira) {
        transaction.begin();
        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setSexo(sexo);
        estudante.setPcd(pcd);
        estudante.setIra(ira);
        manager.persist(estudante);
        transaction.commit();
    }

    public void alteraEstudante(Long id, String nome, Character sexo, Boolean pcd, BigDecimal ira) {
        transaction.begin();
        Estudante Estudante = manager.find(Estudante.class, id);
        Estudante.setNome(nome);
        Estudante.setSexo(sexo);
        Estudante.setPcd(pcd);
        Estudante.setIra(ira);
        transaction.commit();
    }

    public void excluiEstudante(Long id) {
        transaction.begin();
        Estudante estudante = manager.find(Estudante.class, id);
        manager.remove(estudante);
        transaction.commit();
    }
}
