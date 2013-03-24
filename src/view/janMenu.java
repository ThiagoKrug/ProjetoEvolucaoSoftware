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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNovo = new javax.swing.JMenuItem();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemSalvar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu- GCP");
        setResizable(false);

        jLayeredPane1.setBackground(new java.awt.Color(204, 204, 204));

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/save.png"))); // NOI18N
        jButtonSalvar.setToolTipText("Salvar Concurso");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jButtonSalvar.setBounds(80, 0, 40, 40);
        jLayeredPane1.add(jButtonSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonEscrita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/prova1.png"))); // NOI18N
        jButtonEscrita.setMnemonic('E');
        jButtonEscrita.setText("Prova Escrita");
        jButtonEscrita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEscrita.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonEscrita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEscrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscritaActionPerformed(evt);
            }
        });
        jButtonEscrita.setBounds(210, 60, 140, 110);
        jLayeredPane1.add(jButtonEscrita, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/results.png"))); // NOI18N
        jButtonResultado.setMnemonic('r');
        jButtonResultado.setText("Resultados");
        jButtonResultado.setHideActionText(true);
        jButtonResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonResultado.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonResultado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultadoActionPerformed(evt);
            }
        });
        jButtonResultado.setBounds(350, 170, 140, 110);
        jLayeredPane1.add(jButtonResultado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonMemorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/prova5.png"))); // NOI18N
        jButtonMemorial.setMnemonic('m');
        jButtonMemorial.setText("Prova de Memorial");
        jButtonMemorial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMemorial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMemorial.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonMemorial.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemorialActionPerformed(evt);
            }
        });
        jButtonMemorial.setBounds(210, 170, 140, 110);
        jLayeredPane1.add(jButtonMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonDidatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/prova7.png"))); // NOI18N
        jButtonDidatica.setMnemonic('d');
        jButtonDidatica.setText("Prova Didática");
        jButtonDidatica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDidatica.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonDidatica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDidatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDidaticaActionPerformed(evt);
            }
        });
        jButtonDidatica.setBounds(70, 170, 140, 110);
        jLayeredPane1.add(jButtonDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonTitulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/prova6.png"))); // NOI18N
        jButtonTitulos.setMnemonic('T');
        jButtonTitulos.setText("Prova de Títulos");
        jButtonTitulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTitulos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonTitulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTitulosActionPerformed(evt);
            }
        });
        jButtonTitulos.setBounds(350, 60, 140, 110);
        jLayeredPane1.add(jButtonTitulos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAbertura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/abertura.png"))); // NOI18N
        jButtonAbertura.setMnemonic('a');
        jButtonAbertura.setText("Abertura");
        jButtonAbertura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAbertura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAbertura.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonAbertura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAbertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAberturaActionPerformed(evt);
            }
        });
        jButtonAbertura.setBounds(70, 60, 140, 110);
        jLayeredPane1.add(jButtonAbertura, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/new_page.png"))); // NOI18N
        jButtonNovo.setToolTipText("Novo Concurso");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jButtonNovo.setBounds(0, 0, 40, 40);
        jLayeredPane1.add(jButtonNovo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/folder.png"))); // NOI18N
        jButtonAbrir.setToolTipText("Abrir Concurso");
        jButtonAbrir.setBounds(40, 0, 40, 40);
        jLayeredPane1.add(jButtonAbrir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Arquivo");

        jMenuItemNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNovo.setText("Novo");
        jMenuItemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNovo);

        jMenuItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAbrir);

        jMenuItemSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalvar.setText("Salvar");
        jMenuItemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalvar);
        jMenu1.add(jSeparator1);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opções");

        jMenuItem5.setText("Configurações");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem6.setText("Dicas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItemSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemSobre);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(579, 372));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        
        janNovoConc NovoConcurso = new janNovoConc();
        NovoConcurso.setVisible(true);
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEscritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscritaActionPerformed
       
        janProvaEscrita ProvaEscrita = new janProvaEscrita();
        ProvaEscrita.setVisible(true);
        
    }//GEN-LAST:event_jButtonEscritaActionPerformed

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButtonResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultadoActionPerformed
        
        janResultados Resultado = new janResultados();
        Resultado.setVisible(true);
        
    }//GEN-LAST:event_jButtonResultadoActionPerformed

    private void jButtonDidaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDidaticaActionPerformed
        
        janProvaDidatica Didatica =  new janProvaDidatica();
        Didatica.setVisible(true);
        
    }//GEN-LAST:event_jButtonDidaticaActionPerformed

    private void jButtonMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemorialActionPerformed
        
        janProvaMemorial ProvaMemorial = new janProvaMemorial();
        ProvaMemorial.setVisible(true);
        
    }//GEN-LAST:event_jButtonMemorialActionPerformed

    private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSalvarActionPerformed

    private void jMenuItemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoActionPerformed
       
        janNovoConc NovoConcurso = new janNovoConc();
        NovoConcurso.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemNovoActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jButtonAberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAberturaActionPerformed
        
        janAbertura Abertura = new janAbertura();
        Abertura.setVisible(true);
        
    }//GEN-LAST:event_jButtonAberturaActionPerformed

    private void jButtonTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTitulosActionPerformed
        
        janProvaTitulos Titulos = new janProvaTitulos();
        Titulos.setVisible(true);
        
    }//GEN-LAST:event_jButtonTitulosActionPerformed

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        janSobre.main(null);
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemNovo;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSalvar;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
