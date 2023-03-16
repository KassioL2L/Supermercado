package br.ufpb.dcx.aps.atividade;

import java.math.BigDecimal;

public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto) {
        this(produto, 1);
    }

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto inválido: null");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida: " + quantidade);
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Valor inválido: " + quantidade);
        }
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    public void incrementar(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Valor inválido: " + quantidade);
        }
        this.quantidade += quantidade;
    }
}
