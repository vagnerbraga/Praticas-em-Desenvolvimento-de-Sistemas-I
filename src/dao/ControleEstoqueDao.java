package dao;

import inerfaces.Dao;
import model.ControleEstoque;
import util.Arquivo;

public class ControleEstoqueDao extends GenericDao<ControleEstoque>{

    public ControleEstoqueDao() {
        super(Arquivo.ESTOQUE_DAT);
    }
    
}
