/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Jader
 */
public class janAbertura extends javax.swing.JFrame {

    /**
     * Creates new form janAbertura
     */
    public janAbertura() {
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

        jTextFieldEdital = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        horadeinicio = new javax.swing.JLabel();
        textoajudaemissor = new javax.swing.JLabel();
        jTextFieldLocalSessao = new javax.swing.JTextField();
        jTextFieldEmissorPortaria = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        EmissorPortaria = new javax.swing.JLabel();
        LocalSessao = new javax.swing.JLabel();
        textoAjudaLocalSessao = new javax.swing.JLabel();
        PortariaNomeacao = new javax.swing.JLabel();
        textoajudaPortaria = new javax.swing.JLabel();
        jTextPortariaNomeacao = new javax.swing.JTextField();
        jButtonCriarAta = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePresencaMemorial = new javax.swing.JTable();
        jButtonAdicionar2 = new javax.swing.JButton();
        jButtonAdicionar5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListListaPontos = new javax.swing.JList();
        marqueoscadidatos = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        horadeinicio2 = new javax.swing.JLabel();
        CriarAtaAbertura = new javax.swing.JButton();
        fechar = new javax.swing.JButton();

        jTextFieldEdital.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane5.setToolTipText("");

        horadeinicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        horadeinicio.setText("Hora de início da sessão de instalação da comissão examinadora:");
        horadeinicio.setBounds(10, 10, 350, 17);
        jLayeredPane2.add(horadeinicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textoajudaemissor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textoajudaemissor.setText("Exemplo: \"Reitora da Universidade Federal do Pampa\" (esta informação constará na ata)");
        textoajudaemissor.setBounds(20, 220, 410, 20);
        jLayeredPane2.add(textoajudaemissor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldLocalSessao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldLocalSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLocalSessaoActionPerformed(evt);
            }
        });
        jTextFieldLocalSessao.setBounds(20, 100, 320, 23);
        jLayeredPane2.add(jTextFieldLocalSessao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldEmissorPortaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldEmissorPortaria.setBounds(20, 240, 320, 23);
        jLayeredPane2.add(jTextFieldEmissorPortaria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSpinner1.setBounds(50, 30, 29, 20);
        jLayeredPane2.add(jSpinner1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSpinner2.setBounds(20, 30, 29, 20);
        jLayeredPane2.add(jSpinner2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        EmissorPortaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EmissorPortaria.setText("Emissor da portaria de nomeação da banca");
        EmissorPortaria.setBounds(10, 200, 380, 17);
        jLayeredPane2.add(EmissorPortaria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LocalSessao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LocalSessao.setText("Local da sessão de instalação da comissão examinadora");
        LocalSessao.setBounds(10, 60, 380, 17);
        jLayeredPane2.add(LocalSessao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textoAjudaLocalSessao.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textoAjudaLocalSessao.setText("Exemplo: sala cento e doze do Campus Alegrete");
        textoAjudaLocalSessao.setBounds(20, 80, 220, 13);
        jLayeredPane2.add(textoAjudaLocalSessao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PortariaNomeacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PortariaNomeacao.setText("Portaria de nomeação da banca");
        PortariaNomeacao.setBounds(10, 130, 380, 17);
        jLayeredPane2.add(PortariaNomeacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textoajudaPortaria.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textoajudaPortaria.setText("Exemplo: 005/2008(esta informação constará na ata)");
        textoajudaPortaria.setBounds(20, 150, 260, 20);
        jLayeredPane2.add(textoajudaPortaria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextPortariaNomeacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextPortariaNomeacao.setBounds(20, 170, 320, 23);
        jLayeredPane2.add(jTextPortariaNomeacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonCriarAta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCriarAta.setText("Cria ata de instalação da comissão examinadora");
        jButtonCriarAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarAtaActionPerformed(evt);
            }
        });
        jButtonCriarAta.setBounds(30, 300, 510, 25);
        jLayeredPane2.add(jButtonCriarAta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonFechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        jButtonFechar.setBounds(430, 480, 150, 25);
        jLayeredPane2.add(jButtonFechar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Instalação", jPanel1);

        jTablePresencaMemorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Atividade", "Data", "Horário", "Local"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePresencaMemorial.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTablePresencaMemorial);

        jScrollPane2.setBounds(60, 30, 370, 390);
        jLayeredPane3.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionar2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAdicionar2.setText("Cria cronograma");
        jButtonAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar2ActionPerformed(evt);
            }
        });
        jButtonAdicionar2.setBounds(60, 440, 370, 25);
        jLayeredPane3.add(jButtonAdicionar2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionar5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAdicionar5.setText("Fechar");
        jButtonAdicionar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar5ActionPerformed(evt);
            }
        });
        jButtonAdicionar5.setBounds(430, 480, 150, 25);
        jLayeredPane3.add(jButtonAdicionar5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Cronograma", jPanel2);

        jScrollPane3.setViewportView(jListListaPontos);

        jScrollPane3.setBounds(20, 40, 400, 310);
        jLayeredPane4.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        marqueoscadidatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marqueoscadidatos.setText("Marque os candidatos presentes na sessão de abertura do concurso:");
        marqueoscadidatos.setBounds(10, 10, 450, 17);
        jLayeredPane4.add(marqueoscadidatos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSpinner3.setBounds(30, 380, 29, 20);
        jLayeredPane4.add(jSpinner3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSpinner4.setBounds(60, 380, 29, 20);
        jLayeredPane4.add(jSpinner4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        horadeinicio2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        horadeinicio2.setText("Hora de início da sessão de instalação da comissão examinadora:");
        horadeinicio2.setBounds(20, 360, 350, 17);
        jLayeredPane4.add(horadeinicio2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        CriarAtaAbertura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CriarAtaAbertura.setText("Criar ata da sessão de abertura do concurso");
        CriarAtaAbertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarAtaAberturaActionPerformed(evt);
            }
        });
        CriarAtaAbertura.setBounds(30, 420, 370, 25);
        jLayeredPane4.add(CriarAtaAbertura, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 421, Short.MAX_VALUE)
                .addComponent(fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechar)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Abertura", jPanel3);

        jTabbedPane5.setBounds(0, 50, 590, 560);
        jLayeredPane1.add(jTabbedPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCriarAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarAtaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCriarAtaActionPerformed

    private void jTextFieldLocalSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLocalSessaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLocalSessaoActionPerformed

    private void jButtonAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAdicionar2ActionPerformed

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecharActionPerformed

    private void CriarAtaAberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarAtaAberturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CriarAtaAberturaActionPerformed

    private void jButtonAdicionar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAdicionar5ActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFecharActionPerformed

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
            java.util.logging.Logger.getLogger(janAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janAbertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janAbertura().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CriarAtaAbertura;
    private javax.swing.JLabel EmissorPortaria;
    private javax.swing.JLabel LocalSessao;
    private javax.swing.JLabel PortariaNomeacao;
    private javax.swing.JButton fechar;
    private javax.swing.JLabel horadeinicio;
    private javax.swing.JLabel horadeinicio2;
    private javax.swing.JButton jButtonAdicionar2;
    private javax.swing.JButton jButtonAdicionar5;
    private javax.swing.JButton jButtonCriarAta;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JList jListListaPontos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTablePresencaMemorial;
    private javax.swing.JTextField jTextFieldEdital;
    private javax.swing.JTextField jTextFieldEmissorPortaria;
    private javax.swing.JTextField jTextFieldLocalSessao;
    private javax.swing.JTextField jTextPortariaNomeacao;
    private javax.swing.JLabel marqueoscadidatos;
    private javax.swing.JLabel textoAjudaLocalSessao;
    private javax.swing.JLabel textoajudaPortaria;
    private javax.swing.JLabel textoajudaemissor;
    // End of variables declaration//GEN-END:variables
}
