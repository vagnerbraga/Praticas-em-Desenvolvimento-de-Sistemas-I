package model;

import enumered.SexoEnum;
import java.io.Serializable;
import java.util.Vector;

public class Cliente extends Entidade implements Serializable {

    private String nome;
    private String cpf;
    private String rg;
    private SexoEnum sexo;

    public Cliente() {
        super();
        this.sexo = SexoEnum.MASCULINO;
    }

    public Cliente(Long id,String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Cliente(Long id,String nome, String cpf, String rg, SexoEnum sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.ativo = true;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public SexoEnum getSexo() {
        return sexo;
    }
    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.nome + " - "+ this.cpf;
    }
    
    
    
    @Override
    public Vector toVectorDados() {
       Vector<String> v = new Vector<String>();
        v.addElement(this.nome);
        v.addElement(this.cpf);
        v.addElement(this.rg);
        v.addElement(this.sexo.getLabel());
        return v;
    }

    @Override
    public Vector<String> toVectorColumn() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Nome");
        columnNames.addElement("CPF");
        columnNames.addElement("RG");
        columnNames.addElement("Sexo");
        return columnNames;
    }
    
}
