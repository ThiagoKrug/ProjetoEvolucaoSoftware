/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Gaattuso
 */
public class janMenu extends javax.swing.JFrame {

    /**
     * Creates new form janMenu
     */
    public janMenu() {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEscrita = new javax.swing.JButton();
        jButtonResultado = new javax.swing.JButton();
        jButtonMemorial = new javax.swing.JButton();
        jButtonDidatica = new javax.swing.JButton();
        jButtonTitulos = new javax.swing.JButton();
        jButtonAbertura = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonAbrir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\save.png")); // NOI18N
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jButtonSalvar.setBounds(80, 0, 40, 40);
        jLayeredPane1.add(jButtonSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonEscrita.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\prova1.png")); // NOI18N
        jButtonEscrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscritaActionPerformed(evt);
            }
        });
        jButtonEscrita.setBounds(100, 110, 90, 90);
        jLayeredPane1.add(jButtonEscrita, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonResultado.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\results.png")); // NOI18N
        jButtonResultado.setBounds(460, 110, 90, 90);
        jLayeredPane1.add(jButtonResultado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonMemorial.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\prova5.png")); // NOI18N
        jButtonMemorial.setBounds(370, 110, 90, 90);
        jLayeredPane1.add(jButtonMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonDidatica.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\prova7.png")); // NOI18N
        jButtonDidatica.setBounds(280, 110, 90, 90);
        jLayeredPane1.add(jButtonDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonTitulos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\prova6.png")); // NOI18N
        jButtonTitulos.setBounds(190, 110, 90, 90);
        jLayeredPane1.add(jButtonTitulos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAbertura.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\abertura.png")); // NOI18N
        jButtonAbertura.setBounds(10, 110, 90, 90);
        jLayeredPane1.add(jButtonAbertura, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonNovo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\new_page.png")); // NOI18N
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jButtonNovo.setBounds(0, 0, 40, 40);
        jLayeredPane1.add(jButtonNovo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAbrir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sendeski\\Documents\\NetBeansProjects\\ProjetoEvolucaoSoftware\\ProjetoEvolucaoSoftware\\src\\view\\icones\\folder.png")); // NOI18N
        jButtonAbrir.setBounds(40, 0, 40, 40);
        jLayeredPane1.add(jButtonAbrir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Abertura");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBounds(14, 204, 80, 15);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Prova Escrita");
        jLabel2.setBounds(104, 204, 80, 15);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Prova de Títulos");
        jLabel3.setBounds(194, 204, 80, 15);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Prova Didática");
        jLabel4.setBounds(284, 204, 80, 15);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Prova Memorial");
        jLabel5.setBounds(374, 204, 80, 15);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Resultados");
        jLabel6.setBounds(464, 204, 80, 15);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Arquivos ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Novo");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Salvar");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Sair");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opções");

        jMenuItem5.setText("Configurações");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        jMenuItem6.setText("Dicas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Sobre");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEscritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscritaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEscritaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(janMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbertura;
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonDidatica;
    private javax.swing.JButton jButtonEscrita;
    private javax.swing.JButton jButtonMemorial;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonResultado;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonTitulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
