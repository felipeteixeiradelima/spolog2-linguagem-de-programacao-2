package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import model.Estudante;
import util.JpaUtil;

import java.math.BigDecimal;
import java.util.List;

public class EstudanteController {
    private EntityManager manager;
    private EntityTransaction transaction;

    public EstudanteController() {
        manager = JpaUtil.getEntityManager();
        transaction = manager.getTransaction();
    }

    public void insereEstudante(String nome, Character sexo, Boolean pcd, BigDecimal ira) {
        transaction.begin();
        Estudante estudante = new Estudante(nome, sexo, pcd, ira);
        manager.persist(estudante);
        transaction.commit();
    }

    public List<Estudante> consultaEstudantes() {
        TypedQuery<Estudante> query = manager.createQuery("SELECT e FROM Estudante e", Estudante.class);
        return query.getResultList();
    }

    public Estudante consultaEstudantePorId(Long id) {
        return manager.find(Estudante.class, id);
    }

    public void alteraEstudante(Long id, String nome, Character sexo, Boolean pcd, BigDecimal ira) {
        transaction.begin();

        Estudante estudante = manager.find(Estudante.class, id);
        if (estudante == null) return;

        estudante.setNome(nome);
        estudante.setSexo(sexo);
        estudante.setPcd(pcd);
        estudante.setIra(ira);

        transaction.commit();
    }

    public void excluiEstudante(Long id) {
        transaction.begin();
        Estudante estudante = manager.find(Estudante.class, id);
        manager.remove(estudante);
        transaction.commit();
    }

    public void finalizaEntityManager() {
        manager.close();
        JpaUtil.close();
    }
}
