package dao;

import inerfaces.Dao;
import java.util.List;
import model.Entidade;
import util.Arquivo;

public class GenericDao<T extends Entidade> implements Dao<T>{

    protected String nomeArquivo;

    public GenericDao(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void salvar(T entidade) throws Exception {
        try {
            //recupera a lista
            List<T> lista =  this.buscarLista();
            
            entidade.setId(1L + lista.size());
            
            //adiciona o objeto
            lista.add(entidade);
            
            // salva o arquivo
            Arquivo.gravar(lista, this.nomeArquivo);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void alterar(T entidade) throws Exception {
        try{
            
            //recupera a lista
            List<T> lista =  this.buscarLista();
            
            for (Entidade obj : lista) {
                if(obj.getId().equals(entidade.getId())){
                    lista.remove(entidade);
                    
                    //adiciona o objeto
                    lista.add(entidade);
                    break;
                }
            }
            
            // salva o arquivo
            Arquivo.gravar(lista, this.nomeArquivo);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletar(T entidade) throws Exception {
        try {
            List<T> lista =  this.buscarLista();
            
            for (Entidade obj : lista) {
                if(obj.getId().equals(entidade.getId())){
                    obj.setAtivo(false);
                    break;
                }
            }
            Arquivo.gravar(lista, this.nomeArquivo);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public T selecionar(Long id) throws Exception {
        try {
            //recupera a lista
            List<T> lista =  this.buscarLista();
            
            for (Entidade obj : lista) {
                if(obj.getId().equals(id)){
                   return (T)obj;
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    
    protected List<T> buscarLista() throws Exception {
        //recupera a lista
        return (List<T>)Arquivo.recuperar(this.nomeArquivo);
    }
}
