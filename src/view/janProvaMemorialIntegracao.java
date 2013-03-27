/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.com.model.dao.CandidatoDao;
import br.com.model.dao.CriterioAvaliacaoDao;
import br.com.model.dao.ProvaMemorialDao;
import br.com.model.entity.Candidato;
import br.com.model.entity.CriterioAvaliacao;
import br.com.model.entity.CriterioAvaliacaoDidatica;
import br.com.model.entity.ProvaMemorial;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.validation.groups.Default;

/**
 *
 * @author Gaattuso
 */
public class janProvaMemorialIntegracao extends javax.swing.JFrame {

    ArrayList<CriterioAvaliacao> criteriosMemorial = new ArrayList();
    private List<Candidato> listCandidatos;
    private ProvaMemorial provaMemorial = new ProvaMemorial();
    private CandidatoDao cdao = new CandidatoDao();
    /**
     * Creates new form janProvaMemorial
     */
    public janProvaMemorialIntegracao() {
        super("Prova de Memorial");
        initComponents();
        
        this.listCandidatos = janMenu.CONCURSO.getCandidatos();
        DefaultListModel defaultListModel = new DefaultListModel();
        for (Candidato candidato : this.listCandidatos) {
           defaultListModel.addElement(candidato.getNome());
           
        }
        jListCandidatosMemorial.setModel(defaultListModel);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListCandidatosSelecionadosMemorial = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListCandidatosMemorial = new javax.swing.JList();
        jButtonAddTodosCandidatosMemorial = new javax.swing.JButton();
        jButtonRemoveCandidatoMemorial = new javax.swing.JButton();
        jButtonRemoveTodosCandidatosMemorial = new javax.swing.JButton();
        jButtonAddCandidatoMemorial = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCriteriosMemorial = new javax.swing.JList();
        jButtonAddCriterioMemorial = new javax.swing.JButton();
        jButtonRemoveCriterioMemorial = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCriterioMemorial = new javax.swing.JTextField();
        jTextFieldPesoMemorial = new javax.swing.JTextField();
        jTextFieldTotalPesosMemorial = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListExaminadores = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListCandidatos = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonPlanilhaMemorial = new javax.swing.JButton();
        jButtonPlanilhasMemorialTodas = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCandidatosRealizacaoMemorial = new javax.swing.JList();
        jLabel13 = new javax.swing.JLabel();
        jDateChooserDataRealizacao = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jFormattedTextFieldHoraRealizacao = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxCompareceuRealizacao = new javax.swing.JComboBox();
        jButtonGravarRealizacao = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldLocalProvaMemorial = new javax.swing.JTextField();
        jButtonAtaMemorial = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prova de Memorial");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Prova de Memorial");
        jLabel1.setBounds(200, 10, 300, 29);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jListCandidatosSelecionadosMemorial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jListCandidatosSelecionadosMemorial);

        jScrollPane3.setBounds(370, 70, 230, 250);
        jLayeredPane6.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jListCandidatosMemorial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jListCandidatosMemorial);

        jScrollPane6.setBounds(10, 70, 230, 250);
        jLayeredPane6.add(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAddTodosCandidatosMemorial.setText(">>");
        jButtonAddTodosCandidatosMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTodosCandidatosMemorialActionPerformed(evt);
            }
        });
        jButtonAddTodosCandidatosMemorial.setBounds(280, 105, 50, 25);
        jLayeredPane6.add(jButtonAddTodosCandidatosMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jButtonAddTodosCandidatosMemorial.getAccessibleContext().setAccessibleName(">>");

        jButtonRemoveCandidatoMemorial.setText("<");
        jButtonRemoveCandidatoMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveCandidatoMemorialActionPerformed(evt);
            }
        });
        jButtonRemoveCandidatoMemorial.setBounds(280, 140, 50, 25);
        jLayeredPane6.add(jButtonRemoveCandidatoMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoveTodosCandidatosMemorial.setText("<<");
        jButtonRemoveTodosCandidatosMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveTodosCandidatosMemorialActionPerformed(evt);
            }
        });
        jButtonRemoveTodosCandidatosMemorial.setBounds(280, 175, 50, 25);
        jLayeredPane6.add(jButtonRemoveTodosCandidatosMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAddCandidatoMemorial.setText(">");
        jButtonAddCandidatoMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCandidatoMemorialActionPerformed(evt);
            }
        });
        jButtonAddCandidatoMemorial.setBounds(280, 70, 50, 25);
        jLayeredPane6.add(jButtonAddCandidatoMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setText("Selecione os candidadtos aptos a realização do memorial.");
        jLabel12.setBounds(20, 0, 470, 40);
        jLayeredPane6.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel16.setText("Candidatos do concurso:");
        jLabel16.setBounds(10, 50, 150, 14);
        jLayeredPane6.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel17.setText("Candidatos aptos a realização da prova:");
        jLabel17.setBounds(370, 50, 240, 14);
        jLayeredPane6.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Candidatos", jPanel5);

        jScrollPane2.setViewportView(jListCriteriosMemorial);

        jScrollPane2.setBounds(30, 120, 580, 130);
        jLayeredPane3.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAddCriterioMemorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/add.png"))); // NOI18N
        jButtonAddCriterioMemorial.setText("Adicionar");
        jButtonAddCriterioMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCriterioMemorialActionPerformed(evt);
            }
        });
        jButtonAddCriterioMemorial.setBounds(480, 30, 120, 33);
        jLayeredPane3.add(jButtonAddCriterioMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoveCriterioMemorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/remove.png"))); // NOI18N
        jButtonRemoveCriterioMemorial.setText("Remover");
        jButtonRemoveCriterioMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveCriterioMemorialActionPerformed(evt);
            }
        });
        jButtonRemoveCriterioMemorial.setBounds(480, 280, 120, 30);
        jLayeredPane3.add(jButtonRemoveCriterioMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setText("Critério:");
        jLabel9.setBounds(30, 30, 80, 30);
        jLayeredPane3.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("Peso:");
        jLabel10.setBounds(30, 70, 60, 30);
        jLayeredPane3.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldCriterioMemorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCriterioMemorialActionPerformed(evt);
            }
        });
        jTextFieldCriterioMemorial.setBounds(80, 30, 340, 30);
        jLayeredPane3.add(jTextFieldCriterioMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldPesoMemorial.setBounds(80, 70, 80, 30);
        jLayeredPane3.add(jTextFieldPesoMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldTotalPesosMemorial.setEnabled(false);
        jTextFieldTotalPesosMemorial.setBounds(120, 270, 70, 30);
        jLayeredPane3.add(jTextFieldTotalPesosMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setText("Total de Pesos:");
        jLabel11.setBounds(30, 270, 90, 30);
        jLayeredPane3.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Critérios", jPanel2);

        jScrollPane4.setViewportView(jListExaminadores);

        jScrollPane4.setBounds(360, 40, 240, 130);
        jLayeredPane4.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jListCandidatos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jListCandidatos);

        jScrollPane5.setBounds(20, 40, 320, 180);
        jLayeredPane4.add(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Candidatos Aptos a Realizar a Prova:");
        jLabel3.setBounds(30, 20, 290, 14);
        jLayeredPane4.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Examinador:");
        jLabel4.setBounds(360, 20, 170, 14);
        jLayeredPane4.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonPlanilhaMemorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/planilha.png"))); // NOI18N
        jButtonPlanilhaMemorial.setText("Gerar Planilha de Avaliação do Candidato e Examinador Selecionado");
        jButtonPlanilhaMemorial.setBounds(20, 230, 450, 40);
        jLayeredPane4.add(jButtonPlanilhaMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonPlanilhasMemorialTodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/planilha.png"))); // NOI18N
        jButtonPlanilhasMemorialTodas.setText("Gerar Todas as Planilhas");
        jButtonPlanilhasMemorialTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlanilhasMemorialTodasActionPerformed(evt);
            }
        });
        jButtonPlanilhasMemorialTodas.setBounds(20, 270, 210, 40);
        jLayeredPane4.add(jButtonPlanilhasMemorialTodas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setForeground(new java.awt.Color(153, 0, 51));
        jLabel6.setText("Atenção: para gerar a planilha para um ");
        jLabel6.setBounds(360, 170, 230, 20);
        jLayeredPane4.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setForeground(new java.awt.Color(153, 0, 51));
        jLabel7.setText("no candidato e no examinador!");
        jLabel7.setBounds(360, 210, 250, 20);
        jLayeredPane4.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setForeground(new java.awt.Color(153, 0, 51));
        jLabel8.setText("candidato pressione a tecla Ctrl e clique ");
        jLabel8.setBounds(360, 190, 250, 20);
        jLayeredPane4.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Planilhas", jPanel3);

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Informe a Data e o Horário das Apresentações de Defesa do Memorial ");
        jLabel2.setBounds(10, 20, 420, 14);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setViewportView(jListCandidatosRealizacaoMemorial);

        jScrollPane1.setBounds(10, 60, 210, 260);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setText("Data:");
        jLabel13.setBounds(270, 50, 100, 30);
        jLayeredPane2.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDateChooserDataRealizacao.setBounds(270, 80, 160, 30);
        jLayeredPane2.add(jDateChooserDataRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setText("Hora:");
        jLabel14.setBounds(460, 50, 90, 30);
        jLayeredPane2.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextFieldHoraRealizacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextFieldHoraRealizacao.setBounds(460, 80, 100, 30);
        jLayeredPane2.add(jFormattedTextFieldHoraRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel15.setText("Compareceu:");
        jLabel15.setBounds(270, 120, 130, 30);
        jLayeredPane2.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxCompareceuRealizacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        jComboBoxCompareceuRealizacao.setBounds(270, 150, 90, 30);
        jLayeredPane2.add(jComboBoxCompareceuRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonGravarRealizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/save.png"))); // NOI18N
        jButtonGravarRealizacao.setText("Gravar");
        jButtonGravarRealizacao.setBounds(270, 270, 130, 50);
        jLayeredPane2.add(jButtonGravarRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Realização", jPanel1);

        jLabel5.setText("Local de Realização da Prova de Memorial:");
        jLabel5.setBounds(180, 100, 280, 14);
        jLayeredPane5.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldLocalProvaMemorial.setBounds(150, 122, 330, 40);
        jLayeredPane5.add(jTextFieldLocalProvaMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAtaMemorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/ataa.png"))); // NOI18N
        jButtonAtaMemorial.setText("Criar Ata de Realização da Prova de Memorial");
        jButtonAtaMemorial.setBounds(150, 170, 330, 40);
        jLayeredPane5.add(jButtonAtaMemorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Atas", jPanel4);

        jTabbedPane1.setBounds(0, 60, 630, 350);
        jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnProximo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/next.png"))); // NOI18N
        btnProximo.setMnemonic('p');
        btnProximo.setText("Próximo");
        btnProximo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        btnProximo.setBounds(500, 420, 120, 40);
        jLayeredPane1.add(btnProximo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/cancel.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(380, 420, 120, 40);
        jLayeredPane1.add(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/back.png"))); // NOI18N
        btnVoltar.setMnemonic('v');
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        btnVoltar.setBounds(260, 420, 120, 40);
        jLayeredPane1.add(btnVoltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-652)/2, (screenSize.height-526)/2, 652, 526);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        
        int nextTab = jTabbedPane1.getSelectedIndex() + 1;
        if (nextTab < jTabbedPane1.getTabCount()) {
            jTabbedPane1.setSelectedIndex(nextTab);
        }
        
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        int nextTab = jTabbedPane1.getSelectedIndex() - 1;
        if (nextTab >= 0) {
            jTabbedPane1.setSelectedIndex(nextTab);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jButtonPlanilhasMemorialTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlanilhasMemorialTodasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPlanilhasMemorialTodasActionPerformed

    private void jTextFieldCriterioMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCriterioMemorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCriterioMemorialActionPerformed

    private void jButtonAddCriterioMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCriterioMemorialActionPerformed
        
        try {                                                           
             CriterioAvaliacao ca = new CriterioAvaliacao();
             CriterioAvaliacaoDao criterioAvaliacaoDao =new CriterioAvaliacaoDao();
             ca.setCriterio(this.jTextFieldCriterioMemorial.getText());
      //       ca.set
      //       criterioAvaliacaoDao.alterar(ca);
            
            try {
                ca.setPeso(Float.parseFloat(this.jTextFieldPesoMemorial.getText()));
                criteriosMemorial.add(ca);
                jListCriteriosMemorial.removeAll();
                jListCriteriosMemorial.setListData(criteriosMemorial.toArray());
                this.jTextFieldCriterioMemorial.setText("");
                this.jTextFieldPesoMemorial.setText("");
                this.jTextFieldTotalPesosMemorial.setText(this.calculaTotalPesos(criteriosMemorial).toString());
            } catch (NumberFormatException | NullPointerException nfe) {
                JOptionPane.showMessageDialog(this, "Valor inválido!", null, JOptionPane.ERROR_MESSAGE);

            }

            
        } catch (SQLException ex) {
            Logger.getLogger(janProvaMemorialIntegracao.class.getName()).log( Level.SEVERE, null, ex);

        }

        
    }//GEN-LAST:event_jButtonAddCriterioMemorialActionPerformed

    private void jButtonRemoveCriterioMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveCriterioMemorialActionPerformed
        if(jListCriteriosMemorial.getSelectedIndex() != -1){
            criteriosMemorial.remove(jListCriteriosMemorial.getSelectedIndex());
            jListCriteriosMemorial.setListData(criteriosMemorial.toArray());
            this.jTextFieldTotalPesosMemorial.setText(this.calculaTotalPesos(criteriosMemorial).toString());
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um Critério!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoveCriterioMemorialActionPerformed

    private void jButtonAddTodosCandidatosMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTodosCandidatosMemorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddTodosCandidatosMemorialActionPerformed

    private void jButtonRemoveCandidatoMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveCandidatoMemorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRemoveCandidatoMemorialActionPerformed

    private void jButtonRemoveTodosCandidatosMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveTodosCandidatosMemorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRemoveTodosCandidatosMemorialActionPerformed

    private void jButtonAddCandidatoMemorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCandidatoMemorialActionPerformed
        int selected = this.jListCandidatosMemorial.getSelectedIndex();
        if (selected != -1) {
            Candidato c = this.listCandidatos.get(selected);
            this.provaMemorial.adicionarCandidatoApto(c);
            this.provaMemorial.setConcurso(janMenu.CONCURSO);
            this.listCandidatos.remove(c);
            this.jListCandidatosMemorial.setListData(this.listCandidatos.toArray());
            this.jListCandidatosSelecionadosMemorial.setListData(this.provaMemorial.getCandidatosAptosProva().toArray());
           // this.jListCandidatosSelecionadosMemorial.setListData(this.provaMemorial.getCandidatosAptosProva().toArray());
            try {
                c.setAptoProvaMemorial(true);
                cdao.alterar(c);
            } catch (SQLException ex) {
                Logger.getLogger(janProvaMemorial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um candidato!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddCandidatoMemorialActionPerformed

    private Float calculaTotalPesos(ArrayList<CriterioAvaliacao> c){
        Float total = 0.0f;
        for(int i = 0 ; i < c.size(); i++){
            total = total + c.get(i).getPeso();
        }
        
        return total;
    }
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
            java.util.logging.Logger.getLogger(janProvaMemorialIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janProvaMemorialIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janProvaMemorialIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janProvaMemorialIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janProvaMemorialIntegracao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButtonAddCandidatoMemorial;
    private javax.swing.JButton jButtonAddCriterioMemorial;
    private javax.swing.JButton jButtonAddTodosCandidatosMemorial;
    private javax.swing.JButton jButtonAtaMemorial;
    private javax.swing.JButton jButtonGravarRealizacao;
    private javax.swing.JButton jButtonPlanilhaMemorial;
    private javax.swing.JButton jButtonPlanilhasMemorialTodas;
    private javax.swing.JButton jButtonRemoveCandidatoMemorial;
    private javax.swing.JButton jButtonRemoveCriterioMemorial;
    private javax.swing.JButton jButtonRemoveTodosCandidatosMemorial;
    private javax.swing.JComboBox jComboBoxCompareceuRealizacao;
    private com.toedter.calendar.JDateChooser jDateChooserDataRealizacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldHoraRealizacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JList jListCandidatos;
    private javax.swing.JList jListCandidatosMemorial;
    private javax.swing.JList jListCandidatosRealizacaoMemorial;
    private javax.swing.JList jListCandidatosSelecionadosMemorial;
    private javax.swing.JList jListCriteriosMemorial;
    private javax.swing.JList jListExaminadores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldCriterioMemorial;
    private javax.swing.JTextField jTextFieldLocalProvaMemorial;
    private javax.swing.JTextField jTextFieldPesoMemorial;
    private javax.swing.JTextField jTextFieldTotalPesosMemorial;
    // End of variables declaration//GEN-END:variables
}
