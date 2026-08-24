package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "tb_estudantes")
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
}
