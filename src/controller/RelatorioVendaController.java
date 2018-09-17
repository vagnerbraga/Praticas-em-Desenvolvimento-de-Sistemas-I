package controller;

import dao.VendaDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Venda;

public class RelatorioVendaController extends GenericCotroller<Venda>{
    
    public RelatorioVendaController() {
        super(new Venda(), new VendaDao());
    }
    
    public void pesquisaVendas(Cliente cliente, Date dataInicio, Date dataFim){
        
        try {
            this.buscarLista();
            
            List<Venda>  lista = new ArrayList<Venda>();
            
            this.lista.forEach((item)->{
                if(item.getCliente().getId().equals(cliente.getId())
                    && (    (item.getData().after(dataInicio) && item.getData().before(dataFim)) 
                        || (item.getData().equals(dataInicio) || item.getData().equals(dataFim) ))
                        ){
                    lista.add(item);
                }
            });
            
            this.lista.clear();
            this.lista.addAll(lista);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }

}
