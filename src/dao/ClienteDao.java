package dao;

import model.Cliente;
import util.Arquivo;

public class ClienteDao extends GenericDao<Cliente>{

    public ClienteDao() {
        super(Arquivo.CLIENTE_DAT);
    }
    
}
