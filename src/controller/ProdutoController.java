package controller;

import dao.ProdutoDao;
import model.Produto;

public class ProdutoController extends GenericCotroller<Produto> {
    
    public ProdutoController() {
        super(new Produto(), new ProdutoDao());
    }

    @Override
    public void limpar() {
        this.entidade = new Produto();
    }
    
}
