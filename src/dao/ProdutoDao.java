package dao;

import inerfaces.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.Connection;

public class ProdutoDao extends GenericDao<Produto>{

    @Override
    public void salvar(Produto entidade) throws Exception {
        String sql = " INSERT INTO posto_combustivel.produto ("
                + " nome, tipo_embalagem, quantidade_embalagem, valor"
                + " ) VALUES (?, ?, ?, ?) ";
        
        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getTipoEmbalagem());
            ps.setDouble(3, entidade.getQuantidadeEmbalagem());
            ps.setDouble(4, entidade.getValor());
            ps.executeUpdate();
            ps.close();                  
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            this.close();
        }
    }

    @Override
    public void alterar(Produto entidade) throws Exception {
        
        String sql = "UPDATE posto_combustivel.produto SET "
                + " ativo = ?, nome = ?, tipo_embalagem = ?, quantidade_embalagem = ?,"
                + " valor = ?  "
                + " WHERE id = ? ";
 
        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setBoolean(1, entidade.isAtivo());
            ps.setString(2, entidade.getNome());
            ps.setString(3, entidade.getTipoEmbalagem());
            ps.setDouble(4, entidade.getQuantidadeEmbalagem());
            ps.setDouble(5, entidade.getValor());
            ps.setLong(6, entidade.getId());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (Exception e) {
            throw  e;
        }finally{
            this.close();
        }
        
    }

    @Override
    public void deletar(Produto entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto selecionar(Long id) throws Exception {
        String sql = "SELECT p.id, p.ativo, p.nome, p.tipo_embalagem, "
                + " p.quantidade_embalagem, p.valor"
                + " FROM posto_combustivel.produto as p "
                + " where p.id = ? ";

        Produto p = new Produto();
        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
                        
            if (rs.next()) {
              p = this.populaObjeto(rs);
            }
             rs.close();
             ps.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.close();
        }
        return p;
    }

    @Override
    public List<Produto> buscarLista(Produto entidade) throws Exception {
        
        String sql = "SELECT p.id, p.ativo, p.nome, p.tipo_embalagem, "
                + " p.quantidade_embalagem, p.valor"
                + " FROM posto_combustivel.produto as p " + this.pesquisar(entidade);

        List<Produto> lista = new ArrayList<>();
        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(this.populaObjeto(rs));
            }
             rs.close();
             ps.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.close();
        }
        return lista;
    }

    @Override
    public String pesquisar(Produto entidade) throws Exception {
        String sql = "";
        if(entidade != null){
            
            if(entidade.getId() !=null && entidade.getId() > 0L)
                sql += " AND p.id  = "+ entidade.getId();
            
            if(entidade.getNome() !=null && !entidade.getNome().trim().isEmpty())
                sql += " AND p.nome like '%"+ entidade.getNome() +"'";
            return ajustaWhere(sql);
        }else{
            return sql;
        }    
        
    }
    
    private Produto populaObjeto(ResultSet rs) throws Exception{
        return new Produto(rs.getLong("id"), rs.getString("nome"), rs.getString("tipo_embalagem"), rs.getDouble("quantidade_embalagem"), rs.getDouble("valor"));
    }
    
}
