package model.manytoonebidirecional;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String nome;

    @Column
    private Character sexo;

    @Column
    private Boolean pcd;

    @Column(precision = 3, scale = 1)
    private BigDecimal ira;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public Estudante() {
    }

    public Estudante(String nome, Character sexo, Boolean pcd, BigDecimal ira) {
        this.nome = nome;
        this.sexo = sexo;
        this.pcd = pcd;
        this.ira = ira;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estudante estudante = (Estudante) o;
        return Objects.equals(id, estudante.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Boolean getPcd() {
        return pcd;
    }

    public void setPcd(Boolean pcd) {
        this.pcd = pcd;
    }

    public BigDecimal getIra() {
        return ira;
    }

    public void setIra(BigDecimal ira) {
        this.ira = ira;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
