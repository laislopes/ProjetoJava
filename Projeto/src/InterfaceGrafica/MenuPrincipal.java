
package InterfaceGrafica;

import Codigo.PessoaFisicaTableModel;
import Codigo.PessoaJuridicaTableModel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class MenuPrincipal extends javax.swing.JFrame {

    PessoaFisicaTableModel tableModelPF = new PessoaFisicaTableModel();
    PessoaJuridicaTableModel tableModelPJ = new PessoaJuridicaTableModel();
    CadastroPessoaFisica cadastroPF = new CadastroPessoaFisica(tableModelPF);
    CadastroPessoaJuridica cadastroPJ = new CadastroPessoaJuridica(tableModelPJ);
    ConsultaPessoaFisica consultaPF = new ConsultaPessoaFisica(tableModelPF,cadastroPF);
    ConsultaPessoaJuridica consultaPJ =  new ConsultaPessoaJuridica(tableModelPJ,cadastroPJ);
    

    Image image = new ImageIcon(this.getClass().getResource("/Imagens/Bank.png")).getImage();
    
    public MenuPrincipal() {
        initComponents();
        this.setIconImage(image);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/ByteBankMain.png"));
        Image image2 = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemMenuCadastrarClientes = new javax.swing.JMenu();
        itemMenuCadastroPF = new javax.swing.JMenuItem();
        itemMenuCadastroPJ = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemMenuConsultaPF = new javax.swing.JMenuItem();
        itemMenuConsultaPJ = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ByteBank");
        setResizable(false);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1350, 747));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Clientes.png"))); // NOI18N
        jMenu1.setText("Clientes");

        itemMenuCadastrarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cadastro.png"))); // NOI18N
        itemMenuCadastrarClientes.setText("Cadastrar Clientes");

        itemMenuCadastroPF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PF.png"))); // NOI18N
        itemMenuCadastroPF.setText("Pessoa Física");
        itemMenuCadastroPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCadastroPFActionPerformed(evt);
            }
        });
        itemMenuCadastrarClientes.add(itemMenuCadastroPF);

        itemMenuCadastroPJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PJ.png"))); // NOI18N
        itemMenuCadastroPJ.setText("Pessoa Jurídica");
        itemMenuCadastroPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCadastroPJActionPerformed(evt);
            }
        });
        itemMenuCadastrarClientes.add(itemMenuCadastroPJ);

        jMenu1.add(itemMenuCadastrarClientes);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta.png"))); // NOI18N
        jMenu3.setText("Consultar Clientes");

        itemMenuConsultaPF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PF.png"))); // NOI18N
        itemMenuConsultaPF.setText("Pessoa Física");
        itemMenuConsultaPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuConsultaPFActionPerformed(evt);
            }
        });
        jMenu3.add(itemMenuConsultaPF);

        itemMenuConsultaPJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PJ.png"))); // NOI18N
        itemMenuConsultaPJ.setText("Pessoa Jurídica");
        itemMenuConsultaPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuConsultaPJActionPerformed(evt);
            }
        });
        jMenu3.add(itemMenuConsultaPJ);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/contas.png"))); // NOI18N
        jMenu2.setText("Contas");

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/aberturaConta.png"))); // NOI18N
        jMenu4.setText("Abertura de Conta");

        jMenuItem2.setText("Conta Corrente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/poup24.png"))); // NOI18N
        jMenuItem3.setText("Conta Poupança");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenu2.add(jMenu4);

        jMenu5.setText("Encerramento de Conta");

        jMenuItem1.setText("Conta Corrente");
        jMenu5.add(jMenuItem1);

        jMenuItem4.setText("Conta Poupança");
        jMenu5.add(jMenuItem4);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuCadastroPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCadastroPFActionPerformed
        jDesktopPane1.add(cadastroPF);
        cadastroPF.setVisible(true);
    }//GEN-LAST:event_itemMenuCadastroPFActionPerformed

    private void itemMenuCadastroPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCadastroPJActionPerformed
        jDesktopPane1.add(cadastroPJ);
        cadastroPJ.setVisible(true);
    }//GEN-LAST:event_itemMenuCadastroPJActionPerformed

    private void itemMenuConsultaPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuConsultaPJActionPerformed
        jDesktopPane1.add(consultaPJ);
        consultaPJ.setVisible(true);
    }//GEN-LAST:event_itemMenuConsultaPJActionPerformed

    private void itemMenuConsultaPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuConsultaPFActionPerformed
        jDesktopPane1.add(consultaPF);
        consultaPF.setVisible(true);
    }//GEN-LAST:event_itemMenuConsultaPFActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

  
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu itemMenuCadastrarClientes;
    private javax.swing.JMenuItem itemMenuCadastroPF;
    private javax.swing.JMenuItem itemMenuCadastroPJ;
    private javax.swing.JMenuItem itemMenuConsultaPF;
    private javax.swing.JMenuItem itemMenuConsultaPJ;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
