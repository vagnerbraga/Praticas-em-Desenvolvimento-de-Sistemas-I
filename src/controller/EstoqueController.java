package controller;

import dao.ControleEstoqueDao;
import model.ControleEstoque;

public class EstoqueController extends GenericCotroller<ControleEstoque>{
    
    public EstoqueController() {
        super(new ControleEstoque(), new ControleEstoqueDao());
    }

    @Override
    public void gravar() {
        
//        this.buscarLista();
//        //verifica se já tem cadastro
//        this.lista.forEach((it)->{
//            if(it.getProduto().getId().equals(this.entidade.getProduto().getId())){
//                this.entidade.setQuantidade(this.entidade.getQuantidade()+ it.getQuantidade());
//                this.entidade.setId(it.getId());
//            }
//        });
        
        super.gravar();
    }
    
    
    
    public void limpar(){
        this.entidade = new ControleEstoque();
    }
}
