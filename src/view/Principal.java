package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDialog;

public class Principal extends javax.swing.JFrame {

    JPanelCliente jPanelCliente;
    JPanelVenda jPanelVenda;
    JPanelControleEstoque JPanelControleEstoque;
    JPanelRelatorioPorPeriodo JPanelRelatorioPorPeriodo;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConteudo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemProoduto = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemVender = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemEstoque = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemRelatorioVendas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Posto de Gasolina Batista");

        jPanelConteudo.setAutoscrolls(true);

        jMenu1.setText("Cadastro");

        jMenuItemProoduto.setText("Produto");
        jMenuItemProoduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProodutoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemProoduto);

        jMenuItem2.setText("Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vendas");

        jMenuItemVender.setText("Vender");
        jMenuItemVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVenderActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemVender);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Estoque");

        jMenuItemEstoque.setText("Reservatorios");
        jMenuItemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstoqueActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemEstoque);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Relatorio");

        jMenuItemRelatorioVendas.setText("Vendas");
        jMenuItemRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioVendasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemRelatorioVendas);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemProodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProodutoActionPerformed
        JDialog dialog  = new JDialog(this);
        
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.add(new JPanelProduto(), BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocation(300, 300);
        dialog.setTitle("Produtos");
        dialog.setVisible(true);
//        dialog.setLocationRelativeTo(this);
        this.repaint();
    }//GEN-LAST:event_jMenuItemProodutoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        this.jPanelConteudo.removeAll();
        
        this.jPanelCliente = new JPanelCliente();
        this.jPanelConteudo.add(this.jPanelCliente);
        this.repaint();
        
        //jPanelConteudo.add(new JPanelCliente(), BorderLayout.CENTER);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVenderActionPerformed
        this.jPanelConteudo.removeAll();
        
        this.jPanelVenda = new JPanelVenda();
        Dimension d = new Dimension(this.jPanelVenda.getPreferredSize().width, this.jPanelVenda.getPreferredSize().height);
        this.setPreferredSize(d);
        this.repaint();
        this.jPanelConteudo.add(new JPanelVenda());
        this.repaint();
    }//GEN-LAST:event_jMenuItemVenderActionPerformed

    private void jMenuItemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstoqueActionPerformed
        
        this.jPanelConteudo.removeAll();
        
        this.JPanelControleEstoque = new JPanelControleEstoque();
        this.jPanelConteudo.add(this.JPanelControleEstoque);
        this.repaint();
        
    }//GEN-LAST:event_jMenuItemEstoqueActionPerformed

    private void jMenuItemRelatorioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioVendasActionPerformed
        this.jPanelConteudo.removeAll();
        
        this.JPanelRelatorioPorPeriodo = new JPanelRelatorioPorPeriodo();
        this.jPanelConteudo.add(this.JPanelRelatorioPorPeriodo);
        this.repaint();
    }//GEN-LAST:event_jMenuItemRelatorioVendasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemEstoque;
    private javax.swing.JMenuItem jMenuItemProoduto;
    private javax.swing.JMenuItem jMenuItemRelatorioVendas;
    private javax.swing.JMenuItem jMenuItemVender;
    private javax.swing.JPanel jPanelConteudo;
    // End of variables declaration//GEN-END:variables
}
