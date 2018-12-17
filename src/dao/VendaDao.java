package dao;

import enumered.FormaPagamentoEnum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import util.Connection;

public class VendaDao extends GenericDao<Venda>{

//    public VendaDao() {
//        super(Arquivo.VENDA_DAT);
//    }
    
    @Override
    public void salvar(Venda entidade) throws Exception {
    
        String sql = "INSERT INTO posto_combustivel.venda (total_venda, total_pago,"
                 + " quantidade_dias, forma_pagamento, id_cliente) VALUES (?, ?, ?, ?, ? )";
        
        try {
            this.con = new Connection().getConnection();

            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setDouble(1, 0.00);
            ps.setDouble(2, 0.00);
            ps.setInt(3, entidade.getQuantidadeDias());
            ps.setInt(4, entidade.getFormaPagamento().ordinal());
            ps.setLong(5, entidade.getCliente().getId());
            
            ps.executeUpdate();
            
            ps = this.con.prepareStatement("select LAST_INSERT_ID() as id");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                entidade.setId(rs.getLong("id"));
            }
            rs.close();
            ps.close();    
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.close();
        }
    }

    @Override
    public void alterar(Venda entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Venda entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda selecionar(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> buscarLista(Venda entidade) throws Exception {
        
        String sql = "SELECT v.id, v.ativo, v.data, v.total_venda,"
                + " v.total_pago, v.quantidade_dias, v.forma_pagamento,"
                + " v.pago, v.id_cliente, c.nome as nome_cliente, c.id as id_cliente"
                + " FROM posto_combustivel.venda v"
                + " join posto_combustivel.cliente c ON (v.id_cliente = c.id)";
        
        List<Venda> list = new ArrayList<>();
        
        try {
            this.con = new Connection().getConnection();
            
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                list.add(this.populaDados(rs));
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

    @Override
    public String pesquisar(Venda entidade) throws Exception {
        String strPesquisa = "";
        
        if(entidade.getCliente() != null && entidade.getCliente().getNome() != null){
            strPesquisa += " and c.nome like '%"+ entidade.getCliente().getNome() + "%'";
        }
        
        return this.ajustaWhere(strPesquisa);
        
    }

    public void addItem(Venda venda, ItemVenda item) throws Exception{
        String sql = "INSERT INTO posto_combustivel.item_venda "
                + " (id_venda, id_produto, valor, quantidade)"
                + " VALUES (?, ?, ?, ?)";
        
        try {
            this.con = new Connection().getConnection();
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setLong(1, venda.getId());
            ps.setLong(2, item.getProduto().getId());
            ps.setDouble(3, item.getProduto().getValor());
            ps.setDouble(4, item.getQuantidade());
            ps.execute();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.close();
        }
    }
    
    public void removeItem(Venda venda, ItemVenda item) throws Exception{
        String sql = "DELETE FROM  posto_combustivel.item_venda "
                + " WHERE id = ? and id_venda = ? and id_produto = ?";
        
        try {
            this.con = new Connection().getConnection();
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setLong(1, item.getId());
            ps.setLong(2, venda.getId());
            ps.setLong(3, item.getProduto().getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }

    private Venda populaDados(ResultSet rs) throws Exception{
        if(rs != null){
            try {
                Cliente c = new Cliente(rs.getLong("id_cliente"), rs.getString("nome_cliente"));
                Venda v = new Venda(c, rs.getDate("data"), rs.getDouble("total_venda"), rs.getDouble("total_pago"), rs.getInt("quantidade_dias"), FormaPagamentoEnum.values()[rs.getInt("forma_pagamento")], rs.getBoolean("pago"));
                v.setId(rs.getLong("id"));
                v.setItens(this.getItens(v));
                return v;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }
    
    public List<ItemVenda> getItens(Venda venda) throws Exception {
        String sql = " select i.id, i.id_venda, i.id_produto, i.valor, "
                + " i.quantidade, p.id as id_produto, p.nome as nome_produto"
                + " from posto_combustivel.item_venda i"
                + " join posto_combustivel.produto p ON (i.id_produto = p.id) "
                + " where i.id_venda = ? ";
        List<ItemVenda> list = new ArrayList<>();
        try {
            this.con = new Connection().getConnection();
                       
            PreparedStatement ps = this.con.prepareStatement(sql);
            
            ps.setLong(1, venda.getId());
                  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                list.add(this.populaItem(rs));
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
    
    private ItemVenda populaItem(ResultSet rs) throws Exception{
        if(rs != null){
            try {
                Produto p = new Produto(rs.getLong("id_produto"), rs.getString("nome_produto"), null, null, null);
                return new ItemVenda(p, rs.getInt("quantidade"), rs.getDouble("valor"));
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }
}
