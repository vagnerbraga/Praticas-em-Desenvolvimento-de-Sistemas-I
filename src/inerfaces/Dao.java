package inerfaces;

import java.util.List;

public interface Dao<T> {
 
    public void salvar(T entidade) throws  Exception;
    
    public void alterar(T entidade) throws  Exception;
    
    public void deletar(T entidade) throws  Exception;
    
    public T selecionar(Long id) throws  Exception;
    
    public List<T> buscarLista() throws Exception;
        
}