package dao;

import inerfaces.Dao;
import java.util.List;
import model.Cliente;
import util.Arquivo;

public class ClienteDao implements Dao<Cliente>{

    @Override
    public void salvar(Cliente entidade) throws Exception {
        try {
            //recupera a lista
            List<Cliente> lista =  (List<Cliente>)Arquivo.recuperar(Arquivo.CLIENTE_DAT);
            
            entidade.setId(1L + lista.size());
            
            //adiciona o objeto
            lista.add(entidade);
            
            // salva o arquivo
            Arquivo.gravar(lista, Arquivo.CLIENTE_DAT);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void alterar(Cliente entidade) throws Exception {
        try {
            
            //recupera a lista
            List<Cliente> lista =  (List<Cliente>)Arquivo.recuperar(Arquivo.CLIENTE_DAT);
            
            for (Cliente cliente : lista) {
                if(cliente.getId().equals(entidade.getId())){
                    lista.remove(cliente);
                    
                    //adiciona o objeto
                    lista.add(entidade);
                    break;
                }
            }
            
            // salva o arquivo
            Arquivo.gravar(lista, Arquivo.CLIENTE_DAT);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletar(Cliente entidade) throws Exception {
        
        try {
            //recupera a lista
            List<Cliente> lista =  (List<Cliente>)Arquivo.recuperar(Arquivo.CLIENTE_DAT);
            
            for (Cliente cliente : lista) {
                if(cliente.getId().equals(entidade.getId())){
                    cliente.setAtivo(false);
                    break;
                }
            }
            Arquivo.gravar(lista, Arquivo.CLIENTE_DAT);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Cliente selecionar(Long id) throws Exception {
        
        try {
            //recupera a lista
            List<Cliente> lista =  (List<Cliente>)Arquivo.recuperar(Arquivo.CLIENTE_DAT);
            
            for (Cliente cliente : lista) {
                if(cliente.getId().equals(id)){
                   return cliente;
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    
}
