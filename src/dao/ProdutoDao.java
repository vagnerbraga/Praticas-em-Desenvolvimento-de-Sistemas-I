package dao;

import inerfaces.Dao;
import model.Produto;
import util.Arquivo;

public class ProdutoDao extends GenericDao<Produto>{
    
    public ProdutoDao() {
        super(Arquivo.PRODUTO_DAT);
    }
}
