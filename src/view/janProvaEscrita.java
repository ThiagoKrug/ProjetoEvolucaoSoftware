package view;

import br.com.model.dao.CandidatoDao;
import br.com.model.dao.CriterioAvaliacaoDao;
import br.com.model.dao.PontoProvaEscritaDao;
import br.com.model.entity.Candidato;
import br.com.model.entity.CriterioAvaliacao;
import br.com.model.entity.PontoProvaEscrita;
import br.com.model.entity.ProvaEscrita;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jListListaPontos = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTextoPonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonAdicionarPonto = new javax.swing.JButton();
        jButtonRemoverPonto = new javax.swing.JButton();
        jButtonGerarRelacaoPontos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListCriterios = new javax.swing.JList();
        jTextFieldTextoCriterio = new javax.swing.JTextField();
        jTextFieldCriterioPeso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonAdicionarCriterio = new javax.swing.JButton();
        jButtonRemoverCriterio = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxPontos = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

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
        jLabel4.setBounds(450, 90, 240, 14);
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

        jScrollPane3.setViewportView(jListListaPontos);

        jScrollPane3.setBounds(20, 100, 730, 230);
        jLayeredPane3.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Lista de pontos para a prova escrita:");
        jLabel5.setBounds(20, 80, 210, 14);
        jLayeredPane3.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldTextoPonto.setBounds(60, 30, 580, 30);
        jLayeredPane3.add(jTextFieldTextoPonto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Ponto:");
        jLabel6.setBounds(14, 30, 40, 30);
        jLayeredPane3.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionarPonto.setText("Adicionar");
        jButtonAdicionarPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPontoActionPerformed(evt);
            }
        });
        jButtonAdicionarPonto.setBounds(660, 30, 90, 30);
        jLayeredPane3.add(jButtonAdicionarPonto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoverPonto.setText("Remover");
        jButtonRemoverPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverPontoActionPerformed(evt);
            }
        });
        jButtonRemoverPonto.setBounds(650, 340, 100, 23);
        jLayeredPane3.add(jButtonRemoverPonto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonGerarRelacaoPontos.setText("Gerar Relação de Pontos");
        jButtonGerarRelacaoPontos.setBounds(20, 340, 200, 23);
        jLayeredPane3.add(jButtonGerarRelacaoPontos, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jScrollPane4.setViewportView(jListCriterios);

        jScrollPane4.setBounds(10, 110, 740, 210);
        jLayeredPane4.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldTextoCriterio.setBounds(60, 20, 680, 30);
        jLayeredPane4.add(jTextFieldTextoCriterio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldCriterioPeso.setBounds(60, 60, 40, 30);
        jLayeredPane4.add(jTextFieldCriterioPeso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("Peso:");
        jLabel7.setBounds(10, 60, 40, 30);
        jLayeredPane4.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setText("Critério:");
        jLabel8.setBounds(10, 20, 50, 30);
        jLayeredPane4.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionarCriterio.setText("Adicionar");
        jButtonAdicionarCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCriterioActionPerformed(evt);
            }
        });
        jButtonAdicionarCriterio.setBounds(640, 60, 100, 30);
        jLayeredPane4.add(jButtonAdicionarCriterio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoverCriterio.setText("Remover");
        jButtonRemoverCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverCriterioActionPerformed(evt);
            }
        });
        jButtonRemoverCriterio.setBounds(643, 330, 110, 23);
        jLayeredPane4.add(jButtonRemoverCriterio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Gerar Relação de Critérios");
        jButton1.setBounds(10, 330, 190, 23);
        jLayeredPane4.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jTabbedPane5.addTab("Critérios", jPanel3);

        jLabel9.setText("Ponto Sorteado:");
        jLabel9.setBounds(10, 40, 100, 30);
        jLayeredPane5.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextField1.setBounds(160, 80, 70, 30);
        jLayeredPane5.add(jFormattedTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("Hora do Sorteio:");
        jLabel10.setBounds(10, 80, 110, 30);
        jLayeredPane5.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSeparator2.setBounds(10, 140, 760, 20);
        jLayeredPane5.add(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setText("Hora do Inicio da Prova:");
        jLabel11.setBounds(10, 170, 140, 30);
        jLayeredPane5.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextField2.setBounds(160, 170, 70, 30);
        jLayeredPane5.add(jFormattedTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setText("Hora do Fim da Prova:");
        jLabel12.setBounds(10, 210, 130, 30);
        jLayeredPane5.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextField3.setBounds(160, 210, 70, 30);
        jLayeredPane5.add(jFormattedTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setText("Local da Realização:");
        jLabel13.setBounds(10, 260, 130, 30);
        jLayeredPane5.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField2.setBounds(160, 260, 350, 30);
        jLayeredPane5.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxPontos.setBounds(160, 40, 70, 30);
        jLayeredPane5.add(jComboBoxPontos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Realização", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Leitura", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Avaliação", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Resultado", jPanel7);

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
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um candidato!", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAdicionarCandidatoActionPerformed

    private void jButtonAdicionarTodosCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTodosCandidatosActionPerformed
        // TODO add your handling code here:
        this.provaEscrita.setCandidatosAptosProva((ArrayList<Candidato>) this.listCandidatos);
        this.jListCandidatosAptos.setListData(this.listCandidatos.toArray());
    }//GEN-LAST:event_jButtonAdicionarTodosCandidatosActionPerformed

    private void jButtonAdicionarPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPontoActionPerformed
        // TODO add your handling code here:
        String ponto = this.jTextFieldTextoPonto.getText();
        if (ponto.isEmpty() == false) {
            PontoProvaEscritaDao pdao = new PontoProvaEscritaDao();
            PontoProvaEscrita p = new PontoProvaEscrita();
            p.setDescricao(ponto);
            p.setProvaEscrita(this.provaEscrita);
            try {
                pdao.inserir(p);
            } catch (SQLException ex) {
                Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.provaEscrita.adicionarPonto(p);
            this.jListListaPontos.setListData(this.provaEscrita.getPontos().toArray());
            DefaultComboBoxModel lista =  (DefaultComboBoxModel) this.jComboBoxPontos.getModel();
            lista.removeAllElements();
            for (int i = 0; i < this.provaEscrita.getPontos().size(); i++) {
                lista.addElement(i+1);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escreva o ponto!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarPontoActionPerformed

    private void jButtonRemoverPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverPontoActionPerformed
        // TODO add your handling code here:
        int selected = this.jListListaPontos.getSelectedIndex();
        if (selected != -1) {
            PontoProvaEscrita p = (PontoProvaEscrita) this.jListListaPontos.getSelectedValue();
            PontoProvaEscritaDao pdao = new PontoProvaEscritaDao();
            try {
                pdao.excluir(p);
            } catch (SQLException ex) {
                Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.provaEscrita.removerPonto(p);
            this.jListListaPontos.setListData(this.provaEscrita.getPontos().toArray());
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um ponto!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoverPontoActionPerformed

    private void jButtonAdicionarCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCriterioActionPerformed
        // TODO add your handling code here:
        if (this.jTextFieldTextoCriterio.getText().isEmpty() == false && this.jTextFieldCriterioPeso.getText().isEmpty() == false) {
            CriterioAvaliacao c = new CriterioAvaliacao();
            c.setCriterio(this.jTextFieldTextoCriterio.getText());
            c.setPeso(Float.parseFloat(this.jTextFieldCriterioPeso.getText()));
            c.setProvaEscrita(this.provaEscrita);

            CriterioAvaliacaoDao cdao = new CriterioAvaliacaoDao();
            try {
                cdao.inserir(c);

            } catch (SQLException ex) {
                Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.provaEscrita.adicionarCriterioAvaliacao(c);
            this.jListCriterios.setListData(this.provaEscrita.getCriterios().toArray());

        } else {
            JOptionPane.showMessageDialog(this, "Escreva o critério e peso!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAdicionarCriterioActionPerformed

    private void jButtonRemoverCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverCriterioActionPerformed
        // TODO add your handling code here:
        int selected = this.jListCriterios.getSelectedIndex();
        if (selected != -1) {
            CriterioAvaliacao c = (CriterioAvaliacao) this.jListCriterios.getSelectedValue();
            CriterioAvaliacaoDao cdao = new CriterioAvaliacaoDao();
            try {
                cdao.excluir(c);
            } catch (SQLException ex) {
                Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.provaEscrita.removerCriterioAvaliacao(c);
            this.jListCriterios.setListData(this.provaEscrita.getCriterios().toArray());
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um critério!", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonRemoverCriterioActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdicionarCandidato;
    private javax.swing.JButton jButtonAdicionarCriterio;
    private javax.swing.JButton jButtonAdicionarPonto;
    private javax.swing.JButton jButtonAdicionarTodosCandidatos;
    private javax.swing.JButton jButtonGerarRelacaoPontos;
    private javax.swing.JButton jButtonRemoverCandidato;
    private javax.swing.JButton jButtonRemoverCriterio;
    private javax.swing.JButton jButtonRemoverPonto;
    private javax.swing.JButton jButtonRemoverTodosCandidatos;
    private javax.swing.JComboBox jComboBoxPontos;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JList jListCandidatosAptos;
    private javax.swing.JList jListCandidatosConcurso;
    private javax.swing.JList jListCriterios;
    private javax.swing.JList jListListaPontos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldCriterioPeso;
    private javax.swing.JTextField jTextFieldTextoCriterio;
    private javax.swing.JTextField jTextFieldTextoPonto;
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
