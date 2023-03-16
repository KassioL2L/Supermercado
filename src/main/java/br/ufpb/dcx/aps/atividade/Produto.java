package br.ufpb.dcx.aps.atividade;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String codigo;
    private String nome = "";
    private BigDecimal preco;

    public Produto(String codigo, String nome, BigDecimal preco) {
        setCodigo(codigo);
        setNome(nome);
        setPreco(preco);
    }

    public Produto(String codigo, String nome) {
        this(codigo, nome, BigDecimal.ZERO);
    }

    public Produto(String codigo) {
        this(codigo, "");
    }

    public String getCodigo() {
        return codigo;
    }

    private void setCodigo(String codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("O código do produto não pode ser null");
        }
        if (codigo.isEmpty()) {
            throw new IllegalArgumentException("O código do produto não pode ser vazio");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O nome do produto não pode ser null");
        }
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode conter apenas espaços vazios");
        }
        if (nome.matches("\\d+")) {
            throw new IllegalArgumentException("O nome do produto não pode conter apenas números");
        }
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null) {
            throw new IllegalArgumentException("O valor do produto não pode ser null");
        }
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor do produto não pode ser negativo");
        }
        this.preco = preco;
    }

    public void setPreco(String preco) {
        setPreco(new BigDecimal(preco));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return codigo.equals(produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
