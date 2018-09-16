package model;

import enumered.FormaPagamentoEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import util.Constraint;
import util.Data;

public class Venda extends Entidade implements Serializable{

    private Cliente cliente;
    private Date data;
    private Double totalVenda;
    private Double totalPago;
    private int quantidadeDias;
    private FormaPagamentoEnum formaPagamento;
    private List<ItemVenda> itens;
    private boolean pago;

    public Venda(Cliente cliente, Date data, Double totalVenda, Double totalPago, int quantidadeDias, FormaPagamentoEnum formaPagamento, boolean pago) {
        this();
        this.cliente = cliente;
        this.data = data;
        this.totalVenda = totalVenda;
        this.totalPago = totalPago;
        this.quantidadeDias = quantidadeDias;
        this.formaPagamento = formaPagamento;
        this.pago = false;
    }

    public Venda() {
        this.itens = new ArrayList<>();
        this.formaPagamento = FormaPagamentoEnum.A_VISTA;
        this.quantidadeDias = 0;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Double getTotalVenda() {
        Double totalValorItens = 0.0;
        this.totalVenda = 0.00;
        
        //totalValorItens = itens.stream().map((iten) -> iten.getQuantidade() * iten.getProduto().getValor()).reduce(totalValorItens, (accumulator, _item) -> accumulator + _item);
        for (ItemVenda iten : this.itens) {
            totalValorItens += iten.getValorTotal();
        }
        
        if(this.formaPagamento.equals(FormaPagamentoEnum.A_VISTA)){
            this.totalVenda = totalValorItens * Constraint.VALOR_DESCONTO;
        }else{
            if(this.quantidadeDias > Constraint.QUANTIDADE_DIAS_PARA_ACRESSIMO){
                this.totalVenda = totalValorItens * Constraint.VALOR_ACRESSIMO;
            }else{
                this.totalVenda = totalValorItens;
            }
        }
        return this.totalVenda;
    }
    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }
    public Double getTotalPago() {
        return totalPago;
    }
    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }
    public int getQuantidadeDias() {
        return quantidadeDias;
    }
    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }
    public FormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public List<ItemVenda> getItens() {
        return itens;
    }
    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    @Override
    public Vector toVectorDados() {
        Vector<String> v = new Vector<String>();
        v.addElement(this.cliente.getNome());
        v.addElement(Data.converteDateToString(this.data));
        v.addElement(this.totalPago.toString());
        v.addElement(this.formaPagamento.getLabel()); 
        return v;
    }

    @Override
    public Vector<String> toVectorColumn() {
        Vector<String> columnNames = new Vector<String>();
       columnNames.addElement("Cliente");
       columnNames.addElement("Data");
       columnNames.addElement("valor Total.");
       columnNames.addElement("Forma Pag.");
        return columnNames;
    }
}
