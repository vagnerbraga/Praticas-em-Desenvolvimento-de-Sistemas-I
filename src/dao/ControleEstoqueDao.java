package dao;

import inerfaces.Dao;
import model.ControleEstoque;
import model.Produto;
import util.Arquivo;

public class ControleEstoqueDao extends GenericDao<ControleEstoque>{

    public ControleEstoqueDao() {
        super(Arquivo.ESTOQUE_DAT);
    }

}
