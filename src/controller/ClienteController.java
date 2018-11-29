package controller;

import dao.ClienteDao;
import inerfaces.Dao;
import model.Cliente;

public class ClienteController extends GenericCotroller<Cliente>{
    
    public ClienteController() {
        super(new Cliente(), new ClienteDao());
    }

    @Override
    public void limpar() {
        this.entidade = new Cliente();
    }
    
    
}
