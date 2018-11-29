package dao;

import enumered.SexoEnum;
import exception.ClienteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.Arquivo;
import util.Connection;

public class ClienteDao extends GenericDao<Cliente>{

    @Override
    public void salvar(Cliente entidade) throws ClienteException {

        String sql = "INSERT INTO posto_combustivel.cliente ("
                + " cpf, rg, sexo, nome) VALUES (?, ?, ?, ? )";

        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setString(1, entidade.getCpf());
            ps.setString(2, entidade.getRg());
            ps.setInt(3, entidade.getSexo().ordinal());
            ps.setString(4, entidade.getNome());
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClienteException(this.getClass().getSimpleName(), e.getMessage(), e.getCause().toString());
        }finally{
            this.close();
        }
    }

    @Override
    public void alterar(Cliente entidade) throws Exception {
        String sql = "update posto_combustivel.cliente set "
                + " cpf=?, rg=?, sexo=?, nome=? where id = ? ";

        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setString(1, entidade.getCpf());
            ps.setString(2, entidade.getRg());
            ps.setInt(3, entidade.getSexo().ordinal());
            ps.setString(4, entidade.getNome());
            ps.setLong(5, entidade.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new ClienteException(this.getClass().getSimpleName(), e.getMessage(), e.getCause().toString());
        }finally{
            this.close();
        }
    }

    @Override
    public void deletar(Cliente entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente selecionar(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> buscarLista(Cliente entidade) throws Exception {
        String sql = "select id, nome, cpf, rg, ativo, sexo  "
                + " from posto_combustivel.cliente " + this.pesquisar(entidade);
        List<Cliente> list = new ArrayList<>();
        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                list.add(this.populaObjeto(rs));
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.close();
        }
        return list;
    }
    
    private Cliente populaObjeto(ResultSet rs) throws Exception{
        return new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), SexoEnum.values()[rs.getInt("sexo")]);
    }

    @Override
    public String pesquisar(Cliente entidade) throws Exception {
    
        String sql = "";
        if(entidade != null && entidade.getId()!=null && entidade.getId()>0L)
            sql += " AND id ="+ entidade.getId();
        
        if(entidade != null && entidade.getNome() != null && !entidade.getNome().trim().isEmpty() )
            sql += " AND nome like '%"+ entidade.getNome() +"%'";
        
        return this.ajustaWhere(sql);
    }

    
}
