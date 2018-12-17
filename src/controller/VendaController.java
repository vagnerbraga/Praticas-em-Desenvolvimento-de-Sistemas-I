package controller;

import dao.VendaDao;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class VendaController extends GenericCotroller<Venda>{
    
    public VendaController() {
        super(new Venda(), new VendaDao());
    }
    
    public void addItem(Produto produto, Integer quantidade) throws Exception{
        
        try {
            ItemVenda item = new ItemVenda(produto, quantidade, produto.getValor());
            ((VendaDao)this.dao).addItem(this.entidade, item);
        
            this.entidade.getItens().clear();
            this.entidade.getItens().addAll(((VendaDao)this.dao).getItens(this.entidade));
            
        } catch (Exception e) {
            throw e;
        }
        //this.entidade.getItens().add(new ItemVenda(produto, quantidade, produto.getValor()));
    }
    
    public void limpar(){
        this.entidade = new Venda();
    }
}
