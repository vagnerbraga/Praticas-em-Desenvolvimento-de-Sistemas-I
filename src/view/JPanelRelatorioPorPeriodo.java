/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RelatorioVendaController;
import dao.ClienteDao;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import model.Cliente;
import model.Venda;
import util.Configura;
import util.Data;
import util.IReportManager;
import util.Mensagem;

/**
 *
 * @author vagner
 */
public class JPanelRelatorioPorPeriodo extends javax.swing.JPanel {

    /**
     * Creates new form JPanelRelatorioPorPeriodo
     */
    
    private RelatorioVendaController controller;
    private List<Cliente> clientes;
    private Venda venda;
    public JPanelRelatorioPorPeriodo() {
        
        try {
            initComponents();
            this.controller = new RelatorioVendaController();
            this.clientes = new ClienteDao().buscarLista(null);
            this.controller.buscarLista();
            this.venda = new Venda();
            this.jPanelItensVendas.setVisible(false);
            
            this.atualizaTabelaVendas();
            this.atualizaComboCliente();
        } catch (Exception ex) {
            Logger.getLogger(JPanelRelatorioPorPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDataInicio = new javax.swing.JTextField();
        jTextFieldDataFim = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1Vendas = new javax.swing.JTable();
        jPanelItensVendas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableItensVenda = new javax.swing.JTable();
        jButtonImprimir = new javax.swing.JButton();

        jLabel1.setText("Cliente:");

        jLabel2.setText("Data Inicio:");

        jLabel3.setText("Data Fim:");

        jTextFieldDataInicio.setColumns(10);

        jTextFieldDataFim.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1Vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1Vendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1VendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1Vendas);

        jTableItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableItensVenda);

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelItensVendasLayout = new javax.swing.GroupLayout(jPanelItensVendas);
        jPanelItensVendas.setLayout(jPanelItensVendasLayout);
        jPanelItensVendasLayout.setHorizontalGroup(
            jPanelItensVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItensVendasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonImprimir)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanelItensVendasLayout.setVerticalGroup(
            jPanelItensVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButtonImprimir)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(98, 98, 98)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelItensVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelItensVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(this.validaDados()){
            
            Date dataInicio = Data.converteStringToDate(this.jTextFieldDataInicio.getText());
            
            if(dataInicio == null){
                Mensagem.mostrar(this, "Date de inicio não é valida");
                this.jTextFieldDataInicio.requestFocus();
                this.repaint();
                return;
            }
            
            Date dataFim = Data.converteStringToDate(this.jTextFieldDataFim.getText());
            
            if(dataFim == null){
                Mensagem.mostrar(this, "Date de fim não é valida");
                this.jTextFieldDataFim.requestFocus();
                this.repaint();
                return;
            }
            
            this.controller.pesquisaVendas(this.clientes.get(this.jComboBoxCliente.getSelectedIndex()), dataInicio, dataFim);
            this.atualizaTabelaVendas();
            this.repaint();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1VendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1VendasMouseClicked
        
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        
        this.venda = this.controller.lista.get(row);
        
        if(this.venda.getId() !=null){
            
            Configura.tabela(this.jTableItensVenda, this.venda.getItens());
            
            this.jPanelItensVendas.setVisible(true);
            
        }else{
            this.jPanelItensVendas.setVisible(false);
        }
        
        
    }//GEN-LAST:event_jTable1VendasMouseClicked

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        
        if(this.venda!=null && this.venda.getId()!= null){
            
            Map<String, Object> map = new HashMap<String, Object>();
            
            IReportManager.show(map, Arrays.asList(this.venda));
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelItensVendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1Vendas;
    private javax.swing.JTable jTableItensVenda;
    private javax.swing.JTextField jTextFieldDataFim;
    private javax.swing.JTextField jTextFieldDataInicio;
    // End of variables declaration//GEN-END:variables

    private void atualizaTabelaVendas() {
        try {
            Configura.tabela(this.jTable1Vendas, this.controller.lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizaComboCliente() {
        try {
            Configura.ComboBox(this.jComboBoxCliente, this.clientes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validaDados() {
        
        if(jComboBoxCliente.getSelectedIndex() <0){
            Mensagem.mostrar(this, "Favor selecionar pelo menos um cliente para fazer a pesquisa.");
            return false;
        }
        
        if(jTextFieldDataInicio.getText().trim().isEmpty()){
            Mensagem.mostrar(this, "Campo de data de inicio não poder ser vazio.");
            this.jTextFieldDataInicio.requestFocus();
            return false;
        }
        
        if(jTextFieldDataFim.getText().trim().isEmpty()){
            Mensagem.mostrar(this, "Campo de data de fim não poder ser vazio.");
            this.jTextFieldDataFim.requestFocus();
            return false;
        }
        return true;
    }
}
