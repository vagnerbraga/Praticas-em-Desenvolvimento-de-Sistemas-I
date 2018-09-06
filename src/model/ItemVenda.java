package model;

import java.io.Serializable;

public class ItemVenda extends Entidade implements Serializable{

    private Produto produto;
    private Integer quantidade;

    public ItemVenda() {
        super();
    }

    public ItemVenda(Produto produto, Integer quantidade) {
        super();
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}
