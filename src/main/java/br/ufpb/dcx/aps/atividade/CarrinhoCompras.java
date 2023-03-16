package br.ufpb.dcx.aps.atividade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CarrinhoCompras {
    private Map<String, ItemCarrinho> itensCarrinho;

    public CarrinhoCompras() {
        this.itensCarrinho = new HashMap<>();
    }

    public void addProduto(Produto produto) {
        addProduto(produto, 1);
    }

    public void addProduto(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Argumento inválido: produto = null");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Argumento inválido: quantidade = " + quantidade);
        }
        ItemCarrinho itemCarrinho = itensCarrinho.get(produto.getCodigo());
        if (itemCarrinho == null) {
            itemCarrinho = new ItemCarrinho(produto, 0);
            itensCarrinho.put(produto.getCodigo(), itemCarrinho);
        }
        itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() + quantidade);
    }

    public ItemCarrinho getItem(String codigo) {
        return itensCarrinho.get(codigo);
    }

    public void setQuantidade(String codigo, int quantidade) {
        if (codigo == null) {
            throw new IllegalArgumentException("Código de produto inválido: null");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inválida: " + quantidade);
        }
        ItemCarrinho itemCarrinho = itensCarrinho.get(codigo);
        if (itemCarrinho == null) {
            throw new CarrinhoComprasException("Produto inexistente! código:'" + codigo + "'");
        }
        if (quantidade == 0) {
            itensCarrinho.remove(codigo);
        } else {
            itemCarrinho.setQuantidade(quantidade);
        }
    }

    public boolean existe(String codigo) {
        return itensCarrinho.containsKey(codigo);
    }

    public void removerProduto(String codigo) {
        itensCarrinho.remove(codigo);
    }

    public int getQuantidadeItens() {
        int quantidade = 0;
        for (ItemCarrinho itemCarrinho : itensCarrinho.values()) {
            quantidade += itemCarrinho.getQuantidade();
        }
        return quantidade;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrinho itemCarrinho : itensCarrinho.values()) {
            BigDecimal preco = itemCarrinho.getProduto().getPreco();
            BigDecimal quantidade = new BigDecimal(itemCarrinho.getQuantidade());
            total = total.add(preco.multiply(quantidade));
        }
        return total;
    }
}
