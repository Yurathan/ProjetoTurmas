/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.Cafe;
import Classes.CafeIterator;
import Filtro.TamanhoMax;
import Filtro.numerico;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Bene
 */
public class CadCafe extends javax.swing.JFrame {
    Cafe cafe = new Cafe();
    /**
     * Creates new form CadCafe
     */
    public CadCafe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTnovo = new javax.swing.JButton();
        BTgrava = new javax.swing.JToggleButton();
        BTcancelar = new javax.swing.JButton();
        Btfecha = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TFcodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TFdescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TFlotacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Área do café");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        BTnovo.setText("Novo");
        BTnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTnovoActionPerformed(evt);
            }
        });

        BTgrava.setText("Gravar");
        BTgrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTgravaActionPerformed(evt);
            }
        });

        BTcancelar.setText("Cancelar");
        BTcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcancelarActionPerformed(evt);
            }
        });

        Btfecha.setText("Fechar Janela");
        Btfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtfechaActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        TFcodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFcodigoFocusLost(evt);
            }
        });

        jLabel1.setText("Descrição");

        jLabel3.setText("Lotação");

        TFlotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFlotacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTnovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTgrava)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTcancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(Btfecha)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TFlotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTnovo)
                    .addComponent(BTcancelar)
                    .addComponent(BTgrava)
                    .addComponent(Btfecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFlotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFcodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFcodigoFocusLost
        // TODO add your handling code here:
        if  (!TFcodigo.getText().trim().equals("")){
            CafeIterator cafeiterator = new CafeIterator();
            cafe = cafeiterator.buscacafePelaPk(Integer.parseInt(TFcodigo.getText()));
            TFdescricao.setText(cafe.getDescricao());
            TFlotacao.setText(String.valueOf(cafe.getLotacao()));
        }
    }//GEN-LAST:event_TFcodigoFocusLost

    private void BTnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTnovoActionPerformed
        // TODO add your handling code here:
        TFcodigo.setText("");
        TFcodigo.setEditable(false);
        cafe.setPkcafe(-1);
        TFdescricao.setText("");
        TFlotacao.setText("");
    }//GEN-LAST:event_BTnovoActionPerformed

    private void BTgravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTgravaActionPerformed
        // TODO add your handling code here:
        if  (TFdescricao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Descrição está vazio.");
            return;
        } 
        
        if  (TFlotacao.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo lotação está vazio.");
        }
        
        if  (cafe.getPkcafe() == 0){
            cafe.setPkcafe(-1);
        }
        
        CafeIterator cafeiterator = new CafeIterator();
        if  (cafe.getPkcafe().equals(-1)) {
            try {
                cafe.setDescricao(TFdescricao.getText());
                cafe.setLotacao(Integer.parseInt(TFlotacao.getText()));
                cafeiterator.adicionaCafe(cafe);
                TFcodigo.setEditable(true);
                TFcodigo.setText(String.valueOf(cafeiterator.buscaPKcafe(cafe)));
            } catch (Exception ex) {

            }
            } else {
                cafe.setPkcafe(Integer.parseInt(TFcodigo.getText()));
                cafe.setDescricao(TFdescricao.getText());
                cafe.setLotacao(Integer.parseInt(TFlotacao.getText()));
            try {
                cafeiterator.alteraCafe(cafe);
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_BTgravaActionPerformed

    private void BTcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcancelarActionPerformed
        // TODO add your handling code here:
        TFcodigo.setEditable(true);
        cafe.setPkcafe(0);
    }//GEN-LAST:event_BTcancelarActionPerformed

    private void BtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtfechaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtfechaActionPerformed

    private void TFlotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFlotacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFlotacaoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        PlainDocument doc = (PlainDocument) TFcodigo.getDocument();
        doc.setDocumentFilter(new numerico());
        doc = (PlainDocument) TFlotacao.getDocument();
        doc.setDocumentFilter(new numerico());
        TFdescricao.setDocument(new TamanhoMax(45));                              
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(CadCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCafe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTcancelar;
    private javax.swing.JToggleButton BTgrava;
    private javax.swing.JButton BTnovo;
    private javax.swing.JButton Btfecha;
    private javax.swing.JTextField TFcodigo;
    private javax.swing.JTextField TFdescricao;
    private javax.swing.JTextField TFlotacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
