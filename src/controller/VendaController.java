package controller;

import dao.VendaDao;
import inerfaces.Dao;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class VendaController extends GenericCotroller<Venda>{
    
    public VendaController() {
        super(new Venda(), new VendaDao());
    }
    
    public void addItem(Produto produto, Integer quantidade){        
        this.entidade.getItens().add(new ItemVenda(produto, quantidade, produto.getValor()));
    }
    
    public void limpar(){
        this.entidade = new Venda();
    }
}
