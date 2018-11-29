package dao;

import inerfaces.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ControleEstoque;
import model.Produto;
import util.Arquivo;

public class ControleEstoqueDao extends GenericDao<ControleEstoque>{

    @Override
    public void salvar(ControleEstoque entidade) throws Exception {
        
        String sql = "SELECT e.id_produto, e.quantidade"
                + " FROM posto_combustivel.estoque e "
                + " where e.id_produto = ? ";
        
        String sqlInsert = "insert into posto_combustivel.estoque ( id_produto, quantidade)"
                + " values (?, ?) ";
        PreparedStatement ps;
        try {
            this.con = new util.Connection().getConnection();
            
            this.con.setAutoCommit(false);
            
            ps = this.con.prepareStatement(sql);
            ps.setLong(1, entidade.getProduto().getId());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){//caso exista adiciona quantidade
                this.adicionarQuantidade(entidade, this.con);
            }else{//caso nao exista faz insert
                
                ps = this.con.prepareStatement(sqlInsert);
                
                ps.setLong(1, entidade.getProduto().getId());
                ps.setDouble(2, entidade.getQuantidade());
                ps.executeUpdate();
            }
            
            ps.close();
            rs.close();
            this.con.commit();
            
        } catch (Exception e) {
            this.con.rollback();
            throw e;
        }finally{
            this.con.setAutoCommit(true);
            this.close();
        }
    }
    
    private void adicionarQuantidade(ControleEstoque entidade, Connection conn) throws Exception {
        String sql = " update  posto_combustivel.estoque set estoque.quantidade = (estoque.quantidade + ?) "
                + " where estoque.id_produto = ? ";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setDouble(1, entidade.getQuantidade());            
            ps.setLong(2, entidade.getProduto().getId());
            ps.executeUpdate();            
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void remover(ControleEstoque entidade) throws Exception {
        String sql = "SELECT e.id_produto, e.quantidade"
                + " FROM posto_combustivel.estoque e "
                + " where e.id_produto = ? ";
        
        PreparedStatement ps;
        try {
            this.con = new util.Connection().getConnection();
            
            ps = this.con.prepareStatement(sql);
            ps.setLong(1, entidade.getId());

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                if((rs.getDouble("quantidade") - entidade.getQuantidade()) >= 0.00){
                    this.removerQuantidade(entidade, this.con);
                }else{
                    throw new IllegalArgumentException("Saldo induficiente para retirada");
                }                
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    private void removerQuantidade(ControleEstoque entidade, Connection conn) throws Exception {
        String sql = " update  posto_combustivel.estoque set quantidade = (quantidade - ?) "
                + " where id_produto = ? ";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            
            ps.setLong(1, entidade.getId());
            ps.setDouble(2, entidade.getQuantidade());
            ps.executeQuery();            
            
        } catch (Exception e) {
            throw e;
        }
    }  

    @Override
    public void alterar(ControleEstoque entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(ControleEstoque entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ControleEstoque selecionar(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ControleEstoque> buscarLista(ControleEstoque entidade) throws Exception {
        
        String sql = "SELECT e.id_produto, e.quantidade "
                + " FROM posto_combustivel.estoque e "+ this.pesquisar(entidade);
        
        List<ControleEstoque> lista = new ArrayList<ControleEstoque>();
        try {
            this.con = new util.Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            ControleEstoque c = null;
            while (rs.next()) {
                Produto p = new ProdutoDao().selecionar(rs.getLong("id_produto"));
                
                lista.add(new ControleEstoque(p, rs.getDouble("quantidade")));                
            }
            rs.close();
            ps.close();
                        
        } catch (Exception e) {
            throw  e;
        }finally{
            this.con.close();
        }
        return lista;
    }

    @Override
    public String pesquisar(ControleEstoque entidade) throws Exception {
        return "";
    }

}
