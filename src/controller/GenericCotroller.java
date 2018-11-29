package controller;

import inerfaces.Dao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import model.Entidade;

public abstract class GenericCotroller<T extends Entidade> {
    
    public T entidade;
    public List<T> lista;
    protected Dao<T> dao;

    public GenericCotroller(T entidade, Dao<T> dao) {
        this.entidade = entidade;
        this.lista = new ArrayList<>();
        this.dao = dao;
    }
    
    public void gravar(){
        try {
            
            if(this.entidade.getId() !=null){
                this.dao.alterar(this.entidade);
            }else{
                this.dao.salvar(this.entidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public abstract void limpar();
    
    public void deletar(){
        try {
            if(this.entidade.getId() !=null){
                this.dao.deletar(entidade);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void selecionar(){
        try {
            this.entidade = this.dao.selecionar(this.entidade.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void buscarLista(){
        try {
            this.lista = this.dao.buscarLista(this.entidade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getObjectToJtable(java.awt.event.MouseEvent evt){
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        this.entidade = this.lista.get(row);        
    }
    
}
