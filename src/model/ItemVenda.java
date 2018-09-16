package model;

import java.io.Serializable;
import java.util.Vector;

public class ItemVenda extends Entidade implements Serializable{

    private Produto produto;
    private Integer quantidade;
    private Double valor;

    public ItemVenda() {
        super();
        this.valor = 0.00;
    }

    public ItemVenda(Produto produto, Integer quantidade, Double valor) {
        this();
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Double getValorTotal(){
      return this.valor * this.quantidade;  
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

    @Override
    public Vector toVectorDados() {
        Vector<String> v = new Vector<String>();
        v.addElement(this.produto.getNome());
        v.addElement(this.quantidade.toString());        
        v.addElement(this.valor.toString());
        v.addElement(this.getValorTotal().toString()); 
        return v;
    }

    @Override
    public Vector<String> toVectorColumn() {
       Vector<String> columnNames = new Vector<String>();
       columnNames.addElement("Produto");
       columnNames.addElement("Quantidade");
       columnNames.addElement("valor Unit.");
       columnNames.addElement("valor Total");
        return columnNames;
    }
    
}