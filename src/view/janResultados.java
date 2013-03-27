/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.com.model.dao.BancaExaminadoraDao;
import br.com.model.dao.CandidatoDao;
import br.com.model.dao.ExaminadorDao;
import br.com.model.dao.ProvaDidaticaDao;
import br.com.model.dao.ProvaEscritaDao;
import br.com.model.dao.ProvaMemorialDao;
import br.com.model.dao.ProvaTitulosDao;
import br.com.model.entity.BancaExaminadora;
import br.com.model.entity.Candidato;
import br.com.model.entity.Concurso;
import br.com.model.entity.Examinador;
import br.com.model.entity.Notas_ProvaDidatica;
import br.com.model.entity.ProvaDidatica;
import br.com.model.entity.ProvaEscrita;
import br.com.model.entity.ProvaMemorial;
import br.com.model.entity.ProvaTitulos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sendeski
 */
public class janResultados extends javax.swing.JFrame {

    private Concurso concurso;
    private List<Candidato> candidatos = null;

    /**
     * Creates new form janResultados
     */
    public janResultados() {
        initComponents();
        this.concurso = janMenu.CONCURSO;
        this.setFields();
        this.preencheTabelaResultadoResumo();
        this.preencherDadosComboCandidato();
        this.iniciaTabelaResultado();
        //this.preencheTabelaResultadoCandidato();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelNotasCandidato = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCandidatoResulatdos = new javax.swing.JTable();
        jComboBoxCandidatos = new javax.swing.JComboBox();
        jButtonSalvarNotas = new javax.swing.JButton();
        jPanelResumo = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldLocal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResumoResultados = new javax.swing.JTable();
        jTextFieldHorario = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAtas = new javax.swing.JMenu();
        jMenuItemResProvaEsc = new javax.swing.JMenuItem();
        jMenuItemResProvDidad = new javax.swing.JMenuItem();
        jMenuItemResFinalConc = new javax.swing.JMenuItem();
        jMenuPlanilhas = new javax.swing.JMenu();
        jMenuItemListNotProvaEsc = new javax.swing.JMenuItem();
        jMenuItemListNotProvaDidat = new javax.swing.JMenuItem();
        jMenuItemPlanilhaDeminstNotFinal = new javax.swing.JMenuItem();
        jMenuParecerFinal = new javax.swing.JMenu();
        jMenuItemParecBanca = new javax.swing.JMenuItem();

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resultados");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanelNotasCandidato.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Resultados");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Escolha o Candidato:");

        jTableCandidatoResulatdos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Examinador", "Títulos", "Escrita", "Didática", "Memorial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCandidatoResulatdos);

        jComboBoxCandidatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Candidato 1", "Candidato 2", "Candidato 3", "Candidato 4" }));
        jComboBoxCandidatos.setPreferredSize(new java.awt.Dimension(56, 30));
        jComboBoxCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxCandidatosMouseClicked(evt);
            }
        });
        jComboBoxCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCandidatosActionPerformed(evt);
            }
        });

        jButtonSalvarNotas.setText("Salvar Notas");
        jButtonSalvarNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarNotasMouseClicked(evt);
            }
        });
        jButtonSalvarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarNotasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNotasCandidatoLayout = new javax.swing.GroupLayout(jPanelNotasCandidato);
        jPanelNotasCandidato.setLayout(jPanelNotasCandidatoLayout);
        jPanelNotasCandidatoLayout.setHorizontalGroup(
            jPanelNotasCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNotasCandidatoLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelNotasCandidatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNotasCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNotasCandidatoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvarNotas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNotasCandidatoLayout.setVerticalGroup(
            jPanelNotasCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNotasCandidatoLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNotasCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelNotasCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBoxCandidatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonSalvarNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Notas por Candidato", jPanelNotasCandidato);

        jPanelResumo.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resultados");
        jLabel1.setBounds(0, 0, 550, 22);
        jLayeredPane2.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Local:");
        jLabel2.setBounds(10, 30, 36, 17);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLocalActionPerformed(evt);
            }
        });
        jTextFieldLocal.setBounds(10, 50, 280, 30);
        jLayeredPane2.add(jTextFieldLocal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Horário:");
        jLabel3.setBounds(300, 30, 49, 17);
        jLayeredPane2.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTableResumoResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Posição", "Nome", "Média"
            }
        ));
        jScrollPane1.setViewportView(jTableResumoResultados);

        jScrollPane1.setBounds(10, 90, 510, 140);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldHorario.setBounds(300, 50, 90, 30);
        jLayeredPane2.add(jTextFieldHorario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelResumoLayout = new javax.swing.GroupLayout(jPanelResumo);
        jPanelResumo.setLayout(jPanelResumoLayout);
        jPanelResumoLayout.setHorizontalGroup(
            jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        jPanelResumoLayout.setVerticalGroup(
            jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Resumo", jPanelResumo);

        jTabbedPane1.setBounds(0, 0, 550, 320);
        jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenuAtas.setBackground(new java.awt.Color(255, 255, 255));
        jMenuAtas.setText("Atas");

        jMenuItemResProvaEsc.setText("Sessão de Divulgação do Resultado da Prova Escrita");
        jMenuAtas.add(jMenuItemResProvaEsc);

        jMenuItemResProvDidad.setText("Sessão de Divulgação do Resultado da Prova Didática");
        jMenuAtas.add(jMenuItemResProvDidad);

        jMenuItemResFinalConc.setText("Sessão de Divulgação do Resultado Final do Concurso");
        jMenuAtas.add(jMenuItemResFinalConc);

        jMenuBar1.add(jMenuAtas);

        jMenuPlanilhas.setBackground(new java.awt.Color(255, 255, 255));
        jMenuPlanilhas.setText("Planilhas");

        jMenuItemListNotProvaEsc.setText("Listagem de Notas da Prova Escrita");
        jMenuPlanilhas.add(jMenuItemListNotProvaEsc);

        jMenuItemListNotProvaDidat.setText("Listagem de Notas da Prova Didática");
        jMenuPlanilhas.add(jMenuItemListNotProvaDidat);

        jMenuItemPlanilhaDeminstNotFinal.setText("Planilha Demonstrativa das Notas Finais");
        jMenuItemPlanilhaDeminstNotFinal.setToolTipText("Do candidato Selecionado");
        jMenuPlanilhas.add(jMenuItemPlanilhaDeminstNotFinal);

        jMenuBar1.add(jMenuPlanilhas);

        jMenuParecerFinal.setText("Parecer Final");

        jMenuItemParecBanca.setText("Gerar Parecer Final da Banca");
        jMenuParecerFinal.add(jMenuItemParecBanca);

        jMenuBar1.add(jMenuParecerFinal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-565)/2, (screenSize.height-384)/2, 565, 384);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLocalActionPerformed

    private void jComboBoxCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCandidatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCandidatosActionPerformed

    private void jButtonSalvarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarNotasActionPerformed
    }//GEN-LAST:event_jButtonSalvarNotasActionPerformed

    private void jComboBoxCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxCandidatosMouseClicked
 
        BancaExaminadoraDao bancaDao = new BancaExaminadoraDao();
        BancaExaminadora banca = null;

        try {
            banca = bancaDao.pesquisarPorIdConcurso(concurso.getIdConcurso());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        String[] colunas = {"Examinador", "Títulos", "Escrita", "Didática", "Memorial"};
        jTableCandidatoResulatdos.setModel(new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        });

        jTableCandidatoResulatdos.setRowSelectionAllowed(true);
        jTableCandidatoResulatdos.getTableHeader().setReorderingAllowed(false);

        DefaultTableModel modelo = (DefaultTableModel) jTableCandidatoResulatdos.getModel();
        modelo.setNumRows(0);
        modelo.addRow(new String[]{
                    banca.getPresidenteDoBanco().getPessoa().getNome()
                });
        modelo.addRow(new String[]{
                    banca.getExaminador2DoBanco().getPessoa().getNome()
                });

        modelo.addRow(new String[]{
                    banca.getExaminador3DoBanco().getPessoa().getNome()
                });
    }//GEN-LAST:event_jComboBoxCandidatosMouseClicked

    private void jButtonSalvarNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarNotasMouseClicked
     Candidato canditi = (Candidato)jComboBoxCandidatos.getSelectedItem();
     
        
    }//GEN-LAST:event_jButtonSalvarNotasMouseClicked

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
            java.util.logging.Logger.getLogger(janResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janResultados().setVisible(true);
            }
        });
    }

    public void setFields() {
        Concurso concurso = janMenu.CONCURSO;
        if (concurso != null) {

            //Candidato candidato = null;
            for (int i = 0; i < jComboBoxCandidatos.getModel().getSize(); i++) {
                String candidato = (String) jComboBoxCandidatos.getModel().getElementAt(i);
                //FAZER ESSE IF FUNCIONAR DIREITO, EU QUERO O OBJETO !@#$
                //candidato = (Candidato) jComboBoxCandidatos.getModel().getSelectedItem();
                //System.out.println(candidato.getNome());
                //if (candidato.getIdConcurso() == concurso.getIdConcurso()) {
                jComboBoxCandidatos.getModel().setSelectedItem(candidato);
                //  break;
                //}
            }
        }
    }

    public void iniciaTabelaResultado(){
        BancaExaminadoraDao bancaDao = new BancaExaminadoraDao();
        BancaExaminadora banca = null;

        try {
            banca = bancaDao.pesquisarPorIdConcurso(concurso.getIdConcurso());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        String[] colunas = {"Examinador", "Títulos", "Escrita", "Didática", "Memorial"};
        jTableCandidatoResulatdos.setModel(new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        });

        jTableCandidatoResulatdos.setRowSelectionAllowed(true);
        jTableCandidatoResulatdos.getTableHeader().setReorderingAllowed(false);

        DefaultTableModel modelo = (DefaultTableModel) jTableCandidatoResulatdos.getModel();
        modelo.setNumRows(0);
        modelo.addRow(new String[]{
                    banca.getPresidenteDoBanco().getPessoa().getNome()
                });
        modelo.addRow(new String[]{
                    banca.getExaminador2DoBanco().getPessoa().getNome()
                });

        modelo.addRow(new String[]{
                    banca.getExaminador3DoBanco().getPessoa().getNome()
                });
    }
    
    public void preencherDadosComboCandidato() {
        this.concurso = janMenu.CONCURSO;
        ListCellRenderer lcr = new ListCellRenderer();
        jComboBoxCandidatos.setRenderer(lcr.createListCellRenderer(Candidato.class, "getNome"));
        CandidatoDao cdao = new CandidatoDao();

        try {
            candidatos = cdao.pesquisarPorIdConcurso(concurso.getIdConcurso());
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Concurso não encontrado");
        }
        DefaultComboBoxModel<Candidato> candidatoModel = new DefaultComboBoxModel<>();
        for (Candidato candidato : candidatos) {
            candidatoModel.addElement(candidato);
        }
        jComboBoxCandidatos.setModel(candidatoModel);

    }

    public void preencheTabelaResultadoResumo() {
        CandidatoDao cdao = new CandidatoDao();
        List<Candidato> candidatos = null;
        try {
            candidatos = cdao.pesquisarPorIdConcurso(concurso.getIdConcurso());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Integer media = null;
        String posicao = null;
        DefaultTableModel dtm = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome", "Média", "Posição"
                }) {
            Class[] types = new Class[]{
                String.class, int.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        for (Candidato candidato : candidatos) {
            dtm.addRow(new Object[]{
                        candidato.getNome(),
                        media,
                        posicao});
        }
        jTableResumoResultados.setModel(dtm);
        jTableResumoResultados.getColumnModel().getColumn(0).setResizable(false);
        jTableResumoResultados.getColumnModel().getColumn(1).setResizable(false);
        jTableResumoResultados.getColumnModel().getColumn(2).setResizable(false);
    }

    public void preencheTabelaResultadoCandidato() {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvarNotas;
    private javax.swing.JComboBox jComboBoxCandidatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenuAtas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItemListNotProvaDidat;
    private javax.swing.JMenuItem jMenuItemListNotProvaEsc;
    private javax.swing.JMenuItem jMenuItemParecBanca;
    private javax.swing.JMenuItem jMenuItemPlanilhaDeminstNotFinal;
    private javax.swing.JMenuItem jMenuItemResFinalConc;
    private javax.swing.JMenuItem jMenuItemResProvDidad;
    private javax.swing.JMenuItem jMenuItemResProvaEsc;
    private javax.swing.JMenu jMenuParecerFinal;
    private javax.swing.JMenu jMenuPlanilhas;
    private javax.swing.JPanel jPanelNotasCandidato;
    private javax.swing.JPanel jPanelResumo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCandidatoResulatdos;
    private javax.swing.JTable jTableResumoResultados;
    private javax.swing.JTextField jTextFieldHorario;
    private javax.swing.JTextField jTextFieldLocal;
    // End of variables declaration//GEN-END:variables
}
