package view;

import br.com.model.dao.AberturaDao;
import br.com.model.dao.CandidatoDao;
import br.com.model.dao.CronogramaDao;
import br.com.model.entity.Abertura;
import br.com.model.entity.Candidato;
import br.com.model.entity.Cronograma;
import java.awt.Component;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import util.Datas;

/**
 *
 * @author Jader
 */
public class janAbertura extends javax.swing.JFrame {

    private Abertura abertura = new Abertura();

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
        jButtonVoltar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanelInstalacao = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        horadeinicio = new javax.swing.JLabel();
        textoajudaemissor = new javax.swing.JLabel();
        jTextFieldLocalSessao = new javax.swing.JTextField();
        jTextFieldEmissorPortaria = new javax.swing.JTextField();
        EmissorPortaria = new javax.swing.JLabel();
        LocalSessao = new javax.swing.JLabel();
        textoAjudaLocalSessao = new javax.swing.JLabel();
        PortariaNomeacao = new javax.swing.JLabel();
        textoajudaPortaria = new javax.swing.JLabel();
        jTextPortariaNomeacao = new javax.swing.JTextField();
        jButtonCriarAta = new javax.swing.JButton();
        jTextFieldHoraInstalacao = new javax.swing.JTextField();
        jPanelCronograma = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCronogramaAbertura = new javax.swing.JTable();
        jButtonCronograma = new javax.swing.JButton();
        jPanelCandidato = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListCandidatoAbertura = new javax.swing.JList();
        marqueoscadidatos = new javax.swing.JLabel();
        horadeinicio2 = new javax.swing.JLabel();
        CriarAtaAbertura = new javax.swing.JButton();
        jTextFieldHoraInstalacao1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldEdital.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abertura");
        setResizable(false);

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/back.png"))); // NOI18N
        jButtonVoltar.setMnemonic('v');
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jButtonVoltar.setBounds(90, 550, 120, 40);
        jLayeredPane1.add(jButtonVoltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/cancel.png"))); // NOI18N
        jButtonCancelar.setMnemonic('c');
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jButtonCancelar.setBounds(210, 550, 120, 40);
        jLayeredPane1.add(jButtonCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonProximo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/next.png"))); // NOI18N
        jButtonProximo.setMnemonic('p');
        jButtonProximo.setText("Próximo");
        jButtonProximo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });
        jButtonProximo.setBounds(330, 550, 120, 40);
        jLayeredPane1.add(jButtonProximo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane5.setToolTipText("");

        horadeinicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        horadeinicio.setText("Hora de início da sessão de instalação da comissão examinadora:");
        horadeinicio.setBounds(60, 50, 420, 17);
        jLayeredPane2.add(horadeinicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textoajudaemissor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textoajudaemissor.setText("Exemplo: \"Reitora da Universidade Federal do Pampa\" (esta informação constará na ata)");
        textoajudaemissor.setBounds(60, 290, 410, 20);
        jLayeredPane2.add(textoajudaemissor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldLocalSessao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldLocalSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLocalSessaoActionPerformed(evt);
            }
        });
        jTextFieldLocalSessao.setBounds(60, 150, 340, 30);
        jLayeredPane2.add(jTextFieldLocalSessao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldEmissorPortaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldEmissorPortaria.setBounds(60, 320, 340, 30);
        jLayeredPane2.add(jTextFieldEmissorPortaria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        EmissorPortaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EmissorPortaria.setText("Emissor da portaria de nomeação da banca");
        EmissorPortaria.setBounds(60, 270, 380, 17);
        jLayeredPane2.add(EmissorPortaria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LocalSessao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LocalSessao.setText("Local da sessão de instalação da comissão examinadora");
        LocalSessao.setBounds(60, 110, 380, 17);
        jLayeredPane2.add(LocalSessao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textoAjudaLocalSessao.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textoAjudaLocalSessao.setText("Exemplo: sala cento e doze do Campus Alegrete");
        textoAjudaLocalSessao.setBounds(60, 130, 220, 13);
        jLayeredPane2.add(textoAjudaLocalSessao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PortariaNomeacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PortariaNomeacao.setText("Portaria de nomeação da banca");
        PortariaNomeacao.setBounds(60, 190, 380, 17);
        jLayeredPane2.add(PortariaNomeacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textoajudaPortaria.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textoajudaPortaria.setText("Exemplo: 005/2008(esta informação constará na ata)");
        textoajudaPortaria.setBounds(60, 210, 260, 20);
        jLayeredPane2.add(textoajudaPortaria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextPortariaNomeacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextPortariaNomeacao.setBounds(60, 230, 90, 30);
        jLayeredPane2.add(jTextPortariaNomeacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonCriarAta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCriarAta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/ataa.png"))); // NOI18N
        jButtonCriarAta.setText("Cria ata de instalação da comissão examinadora");
        jButtonCriarAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarAtaActionPerformed(evt);
            }
        });
        jButtonCriarAta.setBounds(70, 380, 390, 40);
        jLayeredPane2.add(jButtonCriarAta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldHoraInstalacao.setBounds(60, 70, 70, 30);
        jLayeredPane2.add(jTextFieldHoraInstalacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelInstalacaoLayout = new javax.swing.GroupLayout(jPanelInstalacao);
        jPanelInstalacao.setLayout(jPanelInstalacaoLayout);
        jPanelInstalacaoLayout.setHorizontalGroup(
            jPanelInstalacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstalacaoLayout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanelInstalacaoLayout.setVerticalGroup(
            jPanelInstalacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Instalação", jPanelInstalacao);

        jTableCronogramaAbertura.setModel(new javax.swing.table.DefaultTableModel(
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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCronogramaAbertura.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableCronogramaAbertura);

        jScrollPane2.setBounds(30, 30, 460, 370);
        jLayeredPane3.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonCronograma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCronograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/cronograma.png"))); // NOI18N
        jButtonCronograma.setText("Cria Cronograma");
        jButtonCronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCronogramaActionPerformed(evt);
            }
        });
        jButtonCronograma.setBounds(70, 410, 370, 40);
        jLayeredPane3.add(jButtonCronograma, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelCronogramaLayout = new javax.swing.GroupLayout(jPanelCronograma);
        jPanelCronograma.setLayout(jPanelCronogramaLayout);
        jPanelCronogramaLayout.setHorizontalGroup(
            jPanelCronogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        jPanelCronogramaLayout.setVerticalGroup(
            jPanelCronogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Cronograma", jPanelCronograma);

        jScrollPane3.setViewportView(jListCandidatoAbertura);

        jScrollPane3.setBounds(50, 40, 430, 310);
        jLayeredPane4.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        marqueoscadidatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marqueoscadidatos.setText("Marque os candidatos presentes na sessão de abertura do concurso:");
        marqueoscadidatos.setBounds(50, 10, 450, 17);
        jLayeredPane4.add(marqueoscadidatos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        horadeinicio2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        horadeinicio2.setText("Hora de início da sessão de instalação da comissão examinadora:");
        horadeinicio2.setBounds(50, 360, 420, 17);
        jLayeredPane4.add(horadeinicio2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        CriarAtaAbertura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CriarAtaAbertura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/ataa.png"))); // NOI18N
        CriarAtaAbertura.setText("Criar ata da sessão de abertura do concurso");
        CriarAtaAbertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarAtaAberturaActionPerformed(evt);
            }
        });
        CriarAtaAbertura.setBounds(80, 420, 360, 40);
        jLayeredPane4.add(CriarAtaAbertura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldHoraInstalacao1.setBounds(50, 380, 70, 30);
        jLayeredPane4.add(jTextFieldHoraInstalacao1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelCandidatoLayout = new javax.swing.GroupLayout(jPanelCandidato);
        jPanelCandidato.setLayout(jPanelCandidatoLayout);
        jPanelCandidatoLayout.setHorizontalGroup(
            jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        jPanelCandidatoLayout.setVerticalGroup(
            jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Abertura", jPanelCandidato);

        jTabbedPane5.setBounds(0, 50, 520, 500);
        jLayeredPane1.add(jTabbedPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Abertura");
        jLabel1.setBounds(220, 10, 100, 29);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-536)/2, (screenSize.height-642)/2, 536, 642);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCriarAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarAtaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCriarAtaActionPerformed

    private void jTextFieldLocalSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLocalSessaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLocalSessaoActionPerformed

    private void jButtonCronogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCronogramaActionPerformed

        for (int i = 0; i < 10; i++) {

            String atividade = (String) jTableCronogramaAbertura.getModel().getValueAt(i, 0);
            Cronograma cronograma = new Cronograma();
            cronograma.setAtividade(atividade);

            Date data = Datas.getData((String) jTableCronogramaAbertura.getModel().getValueAt(i, 1));
            //Date data = (Date) jTableCronogramaAbertura.getModel().getValueAt(i, 1);
            cronograma.setData(data);

            Date hora = Datas.convertStringToTime((String) jTableCronogramaAbertura.getModel().getValueAt(i, 2));
            //Date hora = (Date) jTableCronogramaAbertura.getModel().getValueAt(i, 2);
            cronograma.setHorario(hora);
            //System.out.println("Horas: " + hora.toString() + " Cron: " + cronograma.getHorario().toString());

            String local = (String) jTableCronogramaAbertura.getModel().getValueAt(i, 3);
            cronograma.setLocal(local);

            cronograma.setIdConcurso(1);

            CronogramaDao cronogramaDao = new CronogramaDao();
            try {
                cronogramaDao.inserir(cronograma);
            } catch (SQLException ex) {
                Logger.getLogger(janAbertura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }






    }//GEN-LAST:event_jButtonCronogramaActionPerformed

    private void CriarAtaAberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarAtaAberturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CriarAtaAberturaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        int nextTab = jTabbedPane5.getSelectedIndex() - 1;
        if (nextTab >= 0) {
            jTabbedPane5.setSelectedIndex(nextTab);
        }
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed
        Component component = jTabbedPane5.getSelectedComponent();
        if (component == jPanelInstalacao) {
            //concurso.setMinisterio(jTextFieldMinisterio.getText());
            Date HoraInicio = Datas.convertStringToTime(jTextFieldHoraInstalacao.getText());
            abertura.setHoraInicio(HoraInicio);
            abertura.setLocal(jTextFieldLocalSessao.getText());
            abertura.setPortaria(jTextPortariaNomeacao.getText());
            abertura.setEmissor(jTextFieldEmissorPortaria.getText());
            abertura.setIdConcurso(1);


            AberturaDao aberturaDao = new AberturaDao();
            try {
                aberturaDao.inserir(abertura);
            } catch (SQLException ex) {
                Logger.getLogger(janAbertura.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (component == jPanelCronograma) {
//            jcom
//            pres.setSexo(null);
//            Examinador presidente = new Examinador();
//            presidente.set
//            
//            BancaExaminadora bancaExaminadora = new BancaExaminadora();
//            bancaExaminadora.
        } else if (component == jPanelCandidato) {
            CandidatoDao cdao = new CandidatoDao();
            List<Candidato> candidato = null;
            try {
                candidato = cdao.pesquisarTodos();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            DefaultListModel<Candidato> candiModel = new DefaultListModel<>();
            System.out.println("Antes");
            for (Candidato candi : candidato) {
                System.out.println("Dentro do for");
                candiModel.addElement(candi);
            }
            //jComboBoxCampus.setModel(campiModel);
            jListCandidatoAbertura.setModel(candiModel);
        } else {

            int nextTab = jTabbedPane5.getSelectedIndex() + 1;
            if (nextTab < jTabbedPane5.getTabCount()) {
                jTabbedPane5.setSelectedIndex(nextTab);
            }
        }
    }//GEN-LAST:event_jButtonProximoActionPerformed

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
    private javax.swing.JLabel horadeinicio;
    private javax.swing.JLabel horadeinicio2;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCriarAta;
    private javax.swing.JButton jButtonCronograma;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JList jListCandidatoAbertura;
    private javax.swing.JPanel jPanelCandidato;
    private javax.swing.JPanel jPanelCronograma;
    private javax.swing.JPanel jPanelInstalacao;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTableCronogramaAbertura;
    private javax.swing.JTextField jTextFieldEdital;
    private javax.swing.JTextField jTextFieldEmissorPortaria;
    private javax.swing.JTextField jTextFieldHoraInstalacao;
    private javax.swing.JTextField jTextFieldHoraInstalacao1;
    private javax.swing.JTextField jTextFieldLocalSessao;
    private javax.swing.JTextField jTextPortariaNomeacao;
    private javax.swing.JLabel marqueoscadidatos;
    private javax.swing.JLabel textoAjudaLocalSessao;
    private javax.swing.JLabel textoajudaPortaria;
    private javax.swing.JLabel textoajudaemissor;
    // End of variables declaration//GEN-END:variables
}
