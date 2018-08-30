package model;

public class ControleEstoque extends Entidade {
    
    private Produto produto;
    private Double quantidade;

    public ControleEstoque() {
    
    }

    public ControleEstoque(Produto produto, Double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    
}
