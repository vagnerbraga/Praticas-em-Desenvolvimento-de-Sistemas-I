package dao;

import inerfaces.Dao;
import model.ItemVenda;
import model.Venda;
import util.Arquivo;

public class VendaDao extends GenericDao<Venda>{

    public VendaDao() {
        super(Arquivo.VENDA_DAT);
    }
    
    public void addicionarItem(Venda venda, ItemVenda item){
        
    }
    
    public void removerItem(Venda venda, ItemVenda item){
        
    }
    
}
