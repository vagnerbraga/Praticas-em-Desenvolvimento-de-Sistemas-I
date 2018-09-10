package model;

import java.io.Serializable;
import java.util.Vector;

public class ControleEstoque extends Entidade implements Serializable{
    
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

    @Override
    public Vector toVectorDados() {
        Vector<String> v = new Vector<String>();
        v.addElement(this.produto.getNome());
        v.addElement(this.quantidade.toString());
        return v;
    }

    @Override
    public Vector<String> toVectorColumn() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Produto");
        columnNames.addElement("Quantidade");
        return columnNames;
    }
    
}
