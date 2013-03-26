/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.com.model.entity.CriterioAvaliacaoDidatica;
import br.com.model.entity.Ponto_ProvaDidatica;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nasser
 */
public class janProvaDidaticaIntegracao extends javax.swing.JFrame {

    public ArrayList<CriterioAvaliacaoDidatica> listaCriterios = new ArrayList();

    /**
     * Creates new form janProvaDidaticaIntegracao
     */
    public janProvaDidaticaIntegracao() {
        initComponents();

        botao_AdicionarPontoDidatica.setEnabled(false);
        //botao_RemoverPontoDidatica.setEnabled(false);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPontoDidatica = new javax.swing.JTextField();
        botao_AdicionarPontoDidatica = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPontoDidaticaCadastrado = new javax.swing.JList();
        botao_RemoverPontoDidatica = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCriterioDidatica = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonAdicionarCriterioDidatica = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCriteriosProvaDidatica = new javax.swing.JList();
        jTextFieldPeso = new javax.swing.JTextField();
        jButtonRemoverCriteriosDidatica = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListCandidatos = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListCandidatosSelecionados = new javax.swing.JList();
        jButtonAddCandidatos = new javax.swing.JButton();
        jButtonAddTodosCandidatos = new javax.swing.JButton();
        jButtonRemoveCandidato = new javax.swing.JButton();
        jButtonRemoveTodosCandidatos = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListCandidatosSorteio = new javax.swing.JList();
        jDateChooserDataSorteio = new com.toedter.calendar.JDateChooser();
        jFormattedTextFieldHoraSorteio = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCompareceuSorteio = new javax.swing.JComboBox();
        jComboBoxListaPontos = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jButtonGravarSorteio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListCandidatosPlanilhas = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListExaminadoresPlanilhas = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListCandidatosRealizacao = new javax.swing.JList();
        jLabel12 = new javax.swing.JLabel();
        jDateChooserDataRealizacao = new com.toedter.calendar.JDateChooser();
        jFormattedTextFieldHoraRealizacao = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxCompareceuRealizacao = new javax.swing.JComboBox();
        jButtonGravarRealizacao = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Ponto:");
        jLabel2.setBounds(20, 30, 60, 30);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldPontoDidatica.setToolTipText("<html>\n<body>\n<strong>\nDigite um Ponto para a Prova Didatica.\n<strong>\n</body>\n</html>");
        jTextFieldPontoDidatica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldPontoDidaticaMouseClicked(evt);
            }
        });
        jTextFieldPontoDidatica.setBounds(80, 30, 340, 30);
        jLayeredPane2.add(jTextFieldPontoDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botao_AdicionarPontoDidatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/add.png"))); // NOI18N
        botao_AdicionarPontoDidatica.setText("Adicionar");
        botao_AdicionarPontoDidatica.setToolTipText("<html>\n<body>\n<strong>\nClique aqui para Adicionar um Ponto a Prova Didatica.\n<strong>\n</body>\n</html>");
        botao_AdicionarPontoDidatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AdicionarPontoDidaticaActionPerformed(evt);
            }
        });
        botao_AdicionarPontoDidatica.setBounds(510, 30, 120, 33);
        jLayeredPane2.add(botao_AdicionarPontoDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jListPontoDidaticaCadastrado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListPontoDidaticaCadastrado);

        jScrollPane1.setBounds(20, 130, 610, 180);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        botao_RemoverPontoDidatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/remove.png"))); // NOI18N
        botao_RemoverPontoDidatica.setText("Remover");
        botao_RemoverPontoDidatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RemoverPontoDidaticaActionPerformed(evt);
            }
        });
        botao_RemoverPontoDidatica.setBounds(510, 320, 120, 33);
        jLayeredPane2.add(botao_RemoverPontoDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel20.setText("Lista de pontos Cadastrados:");
        jLabel20.setBounds(20, 100, 260, 30);
        jLayeredPane2.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pontos", jPanel1);

        jLabel3.setText("Critério:");
        jLabel3.setBounds(20, 30, 70, 30);
        jLayeredPane3.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldCriterioDidatica.setBounds(80, 30, 340, 30);
        jLayeredPane3.add(jTextFieldCriterioDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Peso:");
        jLabel4.setBounds(20, 70, 70, 30);
        jLayeredPane3.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionarCriterioDidatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/add.png"))); // NOI18N
        jButtonAdicionarCriterioDidatica.setText("Adicionar");
        jButtonAdicionarCriterioDidatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCriterioDidaticaActionPerformed(evt);
            }
        });
        jButtonAdicionarCriterioDidatica.setBounds(510, 30, 120, 33);
        jLayeredPane3.add(jButtonAdicionarCriterioDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jListCriteriosProvaDidatica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jListCriteriosProvaDidatica);

        jScrollPane2.setBounds(20, 130, 610, 130);
        jLayeredPane3.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextFieldPeso.setBounds(80, 70, 80, 30);
        jLayeredPane3.add(jTextFieldPeso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoverCriteriosDidatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/remove.png"))); // NOI18N
        jButtonRemoverCriteriosDidatica.setText("Remover");
        jButtonRemoverCriteriosDidatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverCriteriosDidaticaActionPerformed(evt);
            }
        });
        jButtonRemoverCriteriosDidatica.setBounds(510, 280, 120, 33);
        jLayeredPane3.add(jButtonRemoverCriteriosDidatica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel19.setText("Critérios Cadastrados");
        jLabel19.setBounds(20, 100, 260, 30);
        jLayeredPane3.add(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Critérios", jPanel2);

        jListCandidatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jListCandidatos);

        jScrollPane3.setBounds(20, 70, 260, 230);
        jLayeredPane4.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jListCandidatosSelecionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jListCandidatosSelecionados);

        jScrollPane4.setBounds(430, 70, 258, 230);
        jLayeredPane4.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAddCandidatos.setText(">");
        jButtonAddCandidatos.setBounds(330, 110, 50, 25);
        jLayeredPane4.add(jButtonAddCandidatos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAddTodosCandidatos.setText(">>");
        jButtonAddTodosCandidatos.setBounds(330, 145, 50, 25);
        jLayeredPane4.add(jButtonAddTodosCandidatos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoveCandidato.setText("<");
        jButtonRemoveCandidato.setBounds(330, 180, 50, 25);
        jLayeredPane4.add(jButtonRemoveCandidato, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRemoveTodosCandidatos.setText("<<");
        jButtonRemoveTodosCandidatos.setBounds(330, 220, 50, 25);
        jLayeredPane4.add(jButtonRemoveTodosCandidatos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel16.setText("Candidatos do concurso:");
        jLabel16.setBounds(20, 50, 150, 14);
        jLayeredPane4.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel17.setText("Candidatos aptos a realização da prova:");
        jLabel17.setBounds(430, 50, 240, 14);
        jLayeredPane4.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel18.setText("Selecione os candidadtos aptos a realização da prova didática.");
        jLabel18.setBounds(20, 10, 600, 40);
        jLayeredPane4.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Candidatos", jPanel3);

        jListCandidatosSorteio.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jListCandidatosSorteio);

        jScrollPane5.setBounds(20, 70, 260, 270);
        jLayeredPane5.add(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDateChooserDataSorteio.setBounds(340, 70, 160, 30);
        jLayeredPane5.add(jDateChooserDataSorteio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextFieldHoraSorteio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextFieldHoraSorteio.setBounds(530, 70, 109, 30);
        jLayeredPane5.add(jFormattedTextFieldHoraSorteio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Hora:");
        jLabel5.setBounds(530, 40, 100, 30);
        jLayeredPane5.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxCompareceuSorteio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        jComboBoxCompareceuSorteio.setBounds(340, 140, 90, 30);
        jLayeredPane5.add(jComboBoxCompareceuSorteio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxListaPontos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxListaPontos.setBounds(340, 220, 280, 30);
        jLayeredPane5.add(jComboBoxListaPontos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("Ponto Sorteado:");
        jLabel6.setBounds(340, 180, 180, 30);
        jLayeredPane5.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonGravarSorteio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/save.png"))); // NOI18N
        jButtonGravarSorteio.setText("Gravar");
        jButtonGravarSorteio.setBounds(340, 260, 130, 50);
        jLayeredPane5.add(jButtonGravarSorteio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("Compareceu:");
        jLabel7.setBounds(340, 110, 100, 30);
        jLayeredPane5.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setText("Data:");
        jLabel8.setBounds(340, 40, 100, 30);
        jLayeredPane5.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setText("Candidatos:");
        jLabel9.setBounds(20, 30, 90, 30);
        jLayeredPane5.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sorteio", jPanel4);

        jListCandidatosPlanilhas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jListCandidatosPlanilhas);

        jScrollPane6.setBounds(20, 70, 300, 260);
        jLayeredPane6.add(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jListExaminadoresPlanilhas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(jListExaminadoresPlanilhas);

        jScrollPane7.setBounds(400, 70, 330, 150);
        jLayeredPane6.add(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("Selecione o Examinador:");
        jLabel10.setBounds(400, 40, 140, 30);
        jLayeredPane6.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setText("Selecione o Candidato:");
        jLabel11.setBounds(20, 50, 140, 10);
        jLayeredPane6.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/planilha.png"))); // NOI18N
        jButton1.setText("Gerar Planilha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(440, 240, 240, 40);
        jLayeredPane6.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/planilha.png"))); // NOI18N
        jButton2.setText("Gerar todas as Planilhas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(440, 290, 240, 40);
        jLayeredPane6.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        separador.setOrientation(javax.swing.SwingConstants.VERTICAL);
        separador.setBounds(350, 70, 10, 260);
        jLayeredPane6.add(separador, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Planilhas", jPanel5);

        jListCandidatosRealizacao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(jListCandidatosRealizacao);

        jScrollPane8.setBounds(20, 70, 260, 270);
        jLayeredPane7.add(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setText("Candidatos:");
        jLabel12.setBounds(20, 30, 90, 30);
        jLayeredPane7.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDateChooserDataRealizacao.setBounds(340, 70, 160, 30);
        jLayeredPane7.add(jDateChooserDataRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jFormattedTextFieldHoraRealizacao.setBounds(530, 70, 100, 30);
        jLayeredPane7.add(jFormattedTextFieldHoraRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setText("Data:");
        jLabel13.setBounds(340, 40, 100, 30);
        jLayeredPane7.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setText("Hora:");
        jLabel14.setBounds(530, 40, 90, 30);
        jLayeredPane7.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel15.setText("Compareceu:");
        jLabel15.setBounds(340, 110, 130, 30);
        jLayeredPane7.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxCompareceuRealizacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        jComboBoxCompareceuRealizacao.setBounds(340, 140, 90, 30);
        jLayeredPane7.add(jComboBoxCompareceuRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonGravarRealizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/save.png"))); // NOI18N
        jButtonGravarRealizacao.setText("Gravar");
        jButtonGravarRealizacao.setBounds(340, 260, 130, 50);
        jLayeredPane7.add(jButtonGravarRealizacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Realização", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Atas", jPanel7);

        jTabbedPane1.setBounds(10, 70, 760, 390);
        jLayeredPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Prova Didática");
        jLabel1.setBounds(280, 30, 300, 29);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/back.png"))); // NOI18N
        jButtonVoltar.setMnemonic('v');
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jButtonVoltar.setBounds(370, 470, 130, 40);
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
        jButtonCancelar.setBounds(500, 470, 130, 40);
        jLayeredPane1.add(jButtonCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonProximo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/next.png"))); // NOI18N
        jButtonProximo.setMnemonic('p');
        jButtonProximo.setText("Próximo");
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });
        jButtonProximo.setBounds(630, 470, 130, 40);
        jLayeredPane1.add(jButtonProximo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(791, 571));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarCriterioDidaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCriterioDidaticaActionPerformed
        CriterioAvaliacaoDidatica cad = new CriterioAvaliacaoDidatica();
        cad.setCriterio(this.jTextFieldCriterioDidatica.getText());
        try {
            cad.setPeso(Float.parseFloat(this.jTextFieldPeso.getText()));
            listaCriterios.add(cad);
            jListCriteriosProvaDidatica.removeAll();
            jListCriteriosProvaDidatica.setListData(listaCriterios.toArray());
            this.jTextFieldCriterioDidatica.setText("");
            this.jTextFieldPeso.setText("");

        } catch (NumberFormatException | NullPointerException nfe) {
            JOptionPane.showMessageDialog(this, "Valor inválido!", null, JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButtonAdicionarCriterioDidaticaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        int nextTab = jTabbedPane1.getSelectedIndex() - 1;
        if (nextTab >= 0) {
            jTabbedPane1.setSelectedIndex(nextTab);
        }
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed

        // TODO add your handling code here:
        int nextTab = jTabbedPane1.getSelectedIndex() + 1;
        if (nextTab < jTabbedPane1.getTabCount()) {
            jTabbedPane1.setSelectedIndex(nextTab);
        }
    }//GEN-LAST:event_jButtonProximoActionPerformed

    @SuppressWarnings("CallToThreadDumpStack")
    private void botao_AdicionarPontoDidaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AdicionarPontoDidaticaActionPerformed

        try {
            String pontoProvaDidatica = this.jTextFieldPontoDidatica.getText();

            if (!pontoProvaDidatica.isEmpty()) {
                /**
                 * AGORA É PROGRAMAR AS CLASSES DAO E GO!
                 */
            } else {
                JOptionPane.showMessageDialog(this, "Digite um Ponto!", null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exceptError) {
            // Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, exceptError);
            exceptError.printStackTrace();
        }
    }//GEN-LAST:event_botao_AdicionarPontoDidaticaActionPerformed

    private void jButtonRemoverCriteriosDidaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverCriteriosDidaticaActionPerformed

        if (jListCriteriosProvaDidatica.getSelectedIndex() != -1) {
            listaCriterios.remove(jListCriteriosProvaDidatica.getSelectedIndex());
            jListCriteriosProvaDidatica.setListData(listaCriterios.toArray());
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Critério!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoverCriteriosDidaticaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botao_RemoverPontoDidaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RemoverPontoDidaticaActionPerformed
        try {
            int selecao = jListPontoDidaticaCadastrado.getSelectedIndex();

            if (selecao != -1) {
                /**
                 *
                 */
            } else {

                JOptionPane.showMessageDialog(this, "Selecione um ponto!", null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exceptError) {
            // Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, exceptError);
            exceptError.printStackTrace();
        }
    }//GEN-LAST:event_botao_RemoverPontoDidaticaActionPerformed

    private void jTextFieldPontoDidaticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPontoDidaticaMouseClicked
        try {
            botao_AdicionarPontoDidatica.setEnabled(true);
        } catch (Exception exceptError) {
            // Logger.getLogger(janProvaEscrita.class.getName()).log(Level.SEVERE, null, exceptError);
            exceptError.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldPontoDidaticaMouseClicked

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
            java.util.logging.Logger.getLogger(janProvaDidaticaIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janProvaDidaticaIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janProvaDidaticaIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janProvaDidaticaIntegracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janProvaDidaticaIntegracao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_AdicionarPontoDidatica;
    private javax.swing.JButton botao_RemoverPontoDidatica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAddCandidatos;
    private javax.swing.JButton jButtonAddTodosCandidatos;
    private javax.swing.JButton jButtonAdicionarCriterioDidatica;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravarRealizacao;
    private javax.swing.JButton jButtonGravarSorteio;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonRemoveCandidato;
    private javax.swing.JButton jButtonRemoveTodosCandidatos;
    private javax.swing.JButton jButtonRemoverCriteriosDidatica;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox jComboBoxCompareceuRealizacao;
    private javax.swing.JComboBox jComboBoxCompareceuSorteio;
    private javax.swing.JComboBox jComboBoxListaPontos;
    private com.toedter.calendar.JDateChooser jDateChooserDataRealizacao;
    private com.toedter.calendar.JDateChooser jDateChooserDataSorteio;
    private javax.swing.JFormattedTextField jFormattedTextFieldHoraRealizacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldHoraSorteio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JList jListCandidatos;
    private javax.swing.JList jListCandidatosPlanilhas;
    private javax.swing.JList jListCandidatosRealizacao;
    private javax.swing.JList jListCandidatosSelecionados;
    private javax.swing.JList jListCandidatosSorteio;
    private javax.swing.JList jListCriteriosProvaDidatica;
    private javax.swing.JList jListExaminadoresPlanilhas;
    private javax.swing.JList jListPontoDidaticaCadastrado;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldCriterioDidatica;
    private javax.swing.JTextField jTextFieldPeso;
    private javax.swing.JTextField jTextFieldPontoDidatica;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
