package util;

import java.text.NumberFormat;
import java.util.Locale;

public class Produto {
    private String nome;
    private String descricao;
    private String caminhoImagem;
    private double preco;

    public Produto(double preco, String caminhoImagem, String descricao, String nome) {
        this.preco = preco;
        this.caminhoImagem = caminhoImagem;
        this.descricao = descricao;
        this.nome = nome;
    }

    public Produto(String inputValue) {
        String[] atributos = inputValue.split("\\|");

        if (atributos.length > 0) this.caminhoImagem = atributos[0];
        if (atributos.length > 1) this.nome = atributos[1];
        if (atributos.length > 2) this.descricao = atributos[2];
        if (atributos.length > 3) this.preco = Double.parseDouble(atributos[3]);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public double getPreco() {
        return preco;
    }

    public String getPrecoFormatado() {
        NumberFormat formatoReais = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoReais.format(this.preco);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}