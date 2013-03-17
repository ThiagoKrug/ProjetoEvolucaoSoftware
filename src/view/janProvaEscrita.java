package view;

import br.com.model.dao.CandidatoDao;
import br.com.model.entity.Candidato;
import br.com.model.entity.ProvaEscrita;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Douglas F. Almeida
 */
public class janProvaEscrita extends javax.swing.JFrame {

    private List<Candidato> listCandidatos;
    private ProvaEscrita provaEscrita;

    /**
     * Creates new form janNovoConc
     */
    public janProvaEscrita() {
        super("Configurações do Concurso");
        initComponents();
        this.provaEscrita = new ProvaEscrita();
        this.carregarCandidatos();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        btnProximo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCandidatosConcurso = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCandidatosAptos = new javax.swing.JList();
        jButtonAdicionarCandidato = new javax.swing.JButton();
        jButtonAdicionarTodosCandidatos = new javax.swing.JButton();
        jButtonRemoverCandidato = new javax.swing.JButton();
        jButtonRemoverTodosCandidatos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Prova Escrita");
        jLabel1.setBounds(280, 10, 300, 29);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnProximo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProximo.setText("Próximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        btnProximo.setBounds(670, 470, 90, 25);
        jLayeredPane1.add(btnProximo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(570, 470, 100, 25);
        jLayeredPane1.add(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        btnVoltar.setBounds(490, 470, 80, 25);
        jLayeredPane1.add(btnVoltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setViewportView(jListCandidatosConcurso);

        jScrollPane1.setBounds(30, 110, 270, 240);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBounds(400, 110, 10, 240);
        jLayeredPane2.add(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane2.setViewportView(jListCandidatosAptos);

        jScrollPane2.setBounds(450, 110, 280, 240);
        jLayeredPane2.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionarCandidato.setText(">");
        jButtonAdicionarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCandidatoActionPerformed(evt);
            }
        });
        jButtonAdicionarCandidato.setBounds(320, 130, 41, 23);
        jLayeredPane2.add(jButtonAdicionarCandidato, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionarTodosCandidatos.setText(">>");
        jButtonAdicionarTodosCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarTodosCandidatosActionPerformed(evt);
            }
        });
        jButtonAdicionarTodosCandidatos.setBounds(320, 160, 49, 23);
        jLayeredPane2.add(jButtonAdicionarTodosCandidatos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoverCandidato.setText("<");
        jButtonRemoverCandidato.setBounds(320, 190, 41, 23);
        jLayeredPane2.add(jButtonRemoverCandidato, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoverTodosCandidatos.setText("<<");
        jButtonRemoverTodosCandidatos.setBounds(320, 220, 49, 23);
        jLayeredPane2.add(jButtonRemoverTodosCandidatos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Selecione os candidadtos aptos a realização da prova escrita.");
        jLabel2.setBounds(30, 30, 710, 40);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Candidatos do concurso:");
        jLabel3.setBounds(30, 90, 150, 14);
        jLayeredPane2.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Candidatos aptos a realização da prova:");
        jLabel4.setBounds(450, 90, 220, 14);
        jLayeredPane2.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Candidatos Aptos A Realização", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Pontos", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Blabla", jPanel3);

        jTabbedPane5.setBounds(0, 50, 770, 400);
        jLayeredPane1.add(jTabbedPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed

        // TODO add your handling code here:
        int nextTab = jTabbedPane5.getSelectedIndex() + 1;
        if (nextTab < jTabbedPane5.getTabCount()) {
            jTabbedPane5.setSelectedIndex(nextTab);
        }

    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        int nextTab = jTabbedPane5.getSelectedIndex() - 1;
        if (nextTab >= 0) {
            jTabbedPane5.setSelectedIndex(nextTab);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jButtonAdicionarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCandidatoActionPerformed
        // TODO add your handling code here:
        int selected = this.jListCandidatosConcurso.getSelectedIndex();
        if (selected != -1) {
            Candidato c = this.listCandidatos.get(selected);
            this.provaEscrita.adicionarCandidatoApto(c);
            this.jListCandidatosAptos.setListData(this.provaEscrita.getCandidatosAptosProva().toArray());
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um candidato!",null,JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAdicionarCandidatoActionPerformed

    private void jButtonAdicionarTodosCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTodosCandidatosActionPerformed
        // TODO add your handling code here:
        this.provaEscrita.setCandidatosAptosProva((ArrayList<Candidato>) this.listCandidatos);
        this.jListCandidatosAptos.setListData(this.listCandidatos.toArray());
    }//GEN-LAST:event_jButtonAdicionarTodosCandidatosActionPerformed

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
            java.util.logging.Logger.getLogger(janProvaEscrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janProvaEscrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janProvaEscrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janProvaEscrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janProvaEscrita().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButtonAdicionarCandidato;
    private javax.swing.JButton jButtonAdicionarTodosCandidatos;
    private javax.swing.JButton jButtonRemoverCandidato;
    private javax.swing.JButton jButtonRemoverTodosCandidatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JList jListCandidatosAptos;
    private javax.swing.JList jListCandidatosConcurso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane5;
    // End of variables declaration//GEN-END:variables

    private void carregarCandidatos() {
        CandidatoDao c = new CandidatoDao();
        try {
            this.listCandidatos = c.pesquisarTodosOrdenadoPor("nome asc");
            this.jListCandidatosConcurso.removeAll();
            this.jListCandidatosConcurso.setListData(listCandidatos.toArray());
        } catch (Exception ex) {
            Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
