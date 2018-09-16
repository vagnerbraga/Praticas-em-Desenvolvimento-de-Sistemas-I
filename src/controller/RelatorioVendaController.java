package controller;

import dao.VendaDao;
import model.Venda;

public class RelatorioVendaController extends GenericCotroller<Venda>{
    
    public RelatorioVendaController() {
        super(new Venda(), new VendaDao());
    }

}
