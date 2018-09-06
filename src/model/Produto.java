package model;

import java.io.Serializable;

public class Produto extends Entidade implements Serializable{

    private String nome;
    private String tipoEmbalagem;
    private Double quantidadeEmbalagem;
    private Double valor;

    public Produto() {
        super();
    }

    public Produto(String nome, String tipoEmbalagem, Double quantidadeEmbalagem, Double valor) {
        this.nome = nome;
        this.tipoEmbalagem = tipoEmbalagem;
        this.quantidadeEmbalagem = quantidadeEmbalagem;
        this.valor = valor;
        this.ativo = true;
        
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }
    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }
    public Double getQuantidadeEmbalagem() {
        return quantidadeEmbalagem;
    }
    public void setQuantidadeEmbalagem(Double quantidadeEmbalagem) {
        this.quantidadeEmbalagem = quantidadeEmbalagem;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.getTipoEmbalagem() + " - " + this.getQuantidadeEmbalagem();
    }
    
    
}
