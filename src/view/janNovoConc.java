package view;

import br.com.model.dao.BancaExaminadoraDao;
import br.com.model.dao.CampusDao;
import br.com.model.dao.CandidatoDao;
import br.com.model.dao.ClasseConcursoDao;
import br.com.model.dao.ConcursoDao;
import br.com.model.dao.ExaminadorDao;
import br.com.model.dao.PessoaDao;
import br.com.model.dao.TitulacaoDao;
import br.com.model.entity.BancaExaminadora;
import br.com.model.entity.Campus;
import br.com.model.entity.Candidato;
import br.com.model.entity.ClasseConcurso;
import br.com.model.entity.Concurso;
import br.com.model.entity.Examinador;
import br.com.model.entity.Pessoa;
import br.com.model.entity.Titulacao;
import java.awt.Component;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Douglas F. Almeida
 */
public class janNovoConc extends javax.swing.JFrame {

    private Concurso concurso;
    private Validator validator;
    Component component; 
            
            

    /**
     * Creates new form janNovoConc
     */
    public janNovoConc() {
        super("Configurações do Concurso");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        concurso = janMenu.CONCURSO;
        initComponents();

        this.preenheDadosDefault();
        this.setsFields();
        
        component = jTabbedPane5.getSelectedComponent();
    }

    private void setsFields() {
        Concurso concurso = janMenu.CONCURSO;
        if (concurso != null) {

            // dados gerais
            jTextFieldMinisterio.setText(concurso.getMinisterio());
            jTextFieldInstituicao.setText(concurso.getInstituicao());
            for (int i = 0; i < jComboBoxCampus.getModel().getSize(); i++) {
                Campus campus = (Campus) jComboBoxCampus.getModel().getElementAt(i);
                if (campus.getIdCampus() == concurso.getCampus().getIdCampus()) {
                    jComboBoxCampus.getModel().setSelectedItem(campus);
                    break;
                }
            }
            jTextFieldArea.setText(concurso.getArea());
            jTextFieldEdital.setText(concurso.getEdital());
            jDateChooserDataInicio.setDate(concurso.getDataInicio());
            for (int i = 0; i < jComboBoxClasse.getModel().getSize(); i++) {
                ClasseConcurso classeConcurso = (ClasseConcurso) jComboBoxClasse.getModel().getElementAt(i);
                if (classeConcurso.getIdClasseConcurso() == concurso.getClasseConcurso().getIdClasseConcurso()) {
                    jComboBoxClasse.getModel().setSelectedItem(classeConcurso);
                    break;
                }
            }

            // banca examinadora
            BancaExaminadora bancaExaminadora = concurso.getBancaExaminadora();
            if (bancaExaminadora != null) {
                Examinador presidente = bancaExaminadora.getPresidenteDoBanco();
                if (presidente != null) {
                    jTextFieldPresidente.setText(presidente.getPessoa().getNome());

                    for (int i = 0; i < jComboBoxPresidenteTitulo.getModel().getSize(); i++) {
                        Titulacao titulacao = (Titulacao) jComboBoxPresidenteTitulo.getModel().getElementAt(i);
                        if (titulacao.getIdTitulacao() == presidente.getIdTitulacao()) {
                            jComboBoxPresidenteTitulo.getModel().setSelectedItem(titulacao);
                            break;
                        }
                    }

                    for (int i = 0; i < jComboBoxPresidenteSexo.getModel().getSize(); i++) {
                        String sexo = (String) jComboBoxPresidenteSexo.getModel().getElementAt(i);
                        String s = sexo.substring(0, 1);
                        // se M de masculino do combobox é igual a M de masculino do examinador
                        if (s.equalsIgnoreCase(presidente.getPessoa().getSexo().substring(0, 1))) {
                            jComboBoxPresidenteSexo.getModel().setSelectedItem(sexo);
                            break;
                        }
                    }
                }

                Examinador examinador2 = bancaExaminadora.getExaminador2DoBanco();
                if (examinador2 != null) {
                    jTextFieldExaminador1Nome.setText(examinador2.getPessoa().getNome());

                    for (int i = 0; i < jComboBoxExaminador1Titulo.getModel().getSize(); i++) {
                        Titulacao titulacao = (Titulacao) jComboBoxExaminador1Titulo.getModel().getElementAt(i);
                        if (titulacao.getIdTitulacao() == examinador2.getIdTitulacao()) {
                            jComboBoxExaminador1Titulo.getModel().setSelectedItem(titulacao);
                            break;
                        }
                    }

                    for (int i = 0; i < jComboBoxExaminador1Sexo.getModel().getSize(); i++) {
                        String sexo = (String) jComboBoxExaminador1Sexo.getModel().getElementAt(i);
                        String s = sexo.substring(0, 1);
                        // se M de masculino do combobox é igual a M de masculino do examinador
                        if (s.equalsIgnoreCase(examinador2.getPessoa().getSexo().substring(0, 1))) {
                            jComboBoxExaminador1Sexo.getModel().setSelectedItem(sexo);
                            break;
                        }
                    }
                }


                Examinador examinador3 = bancaExaminadora.getExaminador3DoBanco();
                if (examinador3 != null) {
                    jTextFieldExaminador2Nome.setText(examinador3.getPessoa().getNome());

                    for (int i = 0; i < jComboBoxExaminador2Titulo.getModel().getSize(); i++) {
                        Titulacao titulacao = (Titulacao) jComboBoxExaminador2Titulo.getModel().getElementAt(i);
                        if (titulacao.getIdTitulacao() == examinador3.getIdTitulacao()) {
                            jComboBoxExaminador2Titulo.getModel().setSelectedItem(titulacao);
                            break;
                        }
                    }

                    for (int i = 0; i < jComboBoxExaminador2Sexo.getModel().getSize(); i++) {
                        String sexo = (String) jComboBoxExaminador2Sexo.getModel().getElementAt(i);
                        String s = sexo.substring(0, 1);
                        // se M de masculino do combobox é igual a M de masculino do examinador
                        if (s.equalsIgnoreCase(examinador3.getPessoa().getSexo().substring(0, 1))) {
                            jComboBoxExaminador2Sexo.getModel().setSelectedItem(sexo);
                            break;
                        }
                    }
                }
            }

            // candidatos
            List<Candidato> candidatos = concurso.getCandidatos();
            if (candidatos != null) {
                DefaultTableModel dtm = (DefaultTableModel) jTableCandidatos.getModel();
                for (Candidato candidato : candidatos) {
                    dtm.addRow(new Object[]{
                        candidato.getIdCandidato(),
                        candidato.getNome()
                    });
                }
            }


            // provas do concurso


        }
    }

    private void preenheDadosDefault() {
        ListCellRenderer lcr = new ListCellRenderer();
        jComboBoxClasse.setRenderer(lcr.createListCellRenderer(ClasseConcurso.class, "getNome"));
        jComboBoxCampus.setRenderer(lcr.createListCellRenderer(Campus.class, "getCidadeCampus"));

        DefaultListCellRenderer dfcrTitulacao = lcr.createListCellRenderer(Titulacao.class, "getTitulacao");
        jComboBoxPresidenteTitulo.setRenderer(dfcrTitulacao);
        jComboBoxExaminador1Titulo.setRenderer(dfcrTitulacao);
        jComboBoxExaminador2Titulo.setRenderer(dfcrTitulacao);

        TitulacaoDao tdao = new TitulacaoDao();
        List<Titulacao> titulos = null;
        try {
            titulos = tdao.pesquisarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultComboBoxModel<Titulacao> titulacaoPresidenteModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Titulacao> titulacaoExaminador1Model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Titulacao> titulacaoExaminador2Model = new DefaultComboBoxModel<>();
        for (Titulacao titulacao : titulos) {
            titulacaoPresidenteModel.addElement(titulacao);
            titulacaoExaminador1Model.addElement(titulacao);
            titulacaoExaminador2Model.addElement(titulacao);
        }
        jComboBoxPresidenteTitulo.setModel(titulacaoPresidenteModel);
        jComboBoxExaminador1Titulo.setModel(titulacaoExaminador1Model);
        jComboBoxExaminador2Titulo.setModel(titulacaoExaminador2Model);

        ClasseConcursoDao ccdao = new ClasseConcursoDao();
        List<ClasseConcurso> classesConcurso = null;
        try {
            classesConcurso = ccdao.pesquisarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultComboBoxModel<ClasseConcurso> classesConcursoModel = new DefaultComboBoxModel<>();
        for (ClasseConcurso classeConcurso : classesConcurso) {
            classesConcursoModel.addElement(classeConcurso);
        }
        jComboBoxClasse.setModel(classesConcursoModel);


        CampusDao cdao = new CampusDao();
        List<Campus> campi = null;
        try {
            campi = cdao.pesquisarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultComboBoxModel<Campus> campiModel = new DefaultComboBoxModel<>();
        for (Campus campus : campi) {
            campiModel.addElement(campus);
        }
        jComboBoxCampus.setModel(campiModel);

        DefaultTableModel dtm = new DefaultTableModel(
                new Object[][]{},
                new String[]{
            "ID", "Nome do Candidato"
        }) {
            Class[] types = new Class[]{
                int.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        jTableCandidatos.setModel(dtm);
        jTableCandidatos.getColumnModel().getColumn(0).setWidth(20);
        jTableCandidatos.getColumnModel().getColumn(0).setResizable(false);
        jTableCandidatos.getColumnModel().getColumn(1).setResizable(false);
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
        jButtonProximo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanelDadosGerais = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        ministerio = new javax.swing.JLabel();
        instituicao = new javax.swing.JLabel();
        jLabelDataInicio = new javax.swing.JLabel();
        jTextFieldMinisterio = new javax.swing.JTextField();
        jTextFieldInstituicao = new javax.swing.JTextField();
        jTextFieldEdital = new javax.swing.JTextField();
        jLabelCampus = new javax.swing.JLabel();
        classe = new javax.swing.JLabel();
        jTextFieldArea = new javax.swing.JTextField();
        jComboBoxClasse = new javax.swing.JComboBox();
        edital = new javax.swing.JLabel();
        jDateChooserDataInicio = new com.toedter.calendar.JDateChooser();
        jComboBoxCampus = new javax.swing.JComboBox();
        jPanelBancaExaminadora = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldPresidente = new javax.swing.JTextField();
        jComboBoxPresidenteTitulo = new javax.swing.JComboBox();
        jComboBoxPresidenteSexo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldExaminador1Nome = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxExaminador1Titulo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxExaminador1Sexo = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxExaminador2Sexo = new javax.swing.JComboBox();
        jTextFieldExaminador2Nome = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxExaminador2Titulo = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanelCandidatos = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldCandidatoNome = new javax.swing.JTextField();
        jComboBoxCandidatoSexo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCandidatos = new javax.swing.JTable();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jDateChooserCandidatoDataNascimento = new com.toedter.calendar.JDateChooser();
        jPanelProvasConcurso = new javax.swing.JPanel();
        jCheckBoxProvaEscrita = new javax.swing.JCheckBox();
        jCheckBoxProvaDeTitulos = new javax.swing.JCheckBox();
        jCheckBoxProvaMemorial = new javax.swing.JCheckBox();
        jCheckBoxProvaDidatica = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Concurso");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Configurações do Concurso");
        jLabel1.setBounds(220, 10, 350, 29);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        jButtonProximo.setBounds(600, 450, 120, 40);
        jLayeredPane1.add(jButtonProximo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/cancel.png"))); // NOI18N
        jButtonCancelar.setMnemonic('c');
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jButtonCancelar.setBounds(480, 450, 120, 40);
        jLayeredPane1.add(jButtonCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/back.png"))); // NOI18N
        jButtonVoltar.setMnemonic('v');
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jButtonVoltar.setBounds(360, 450, 120, 40);
        jLayeredPane1.add(jButtonVoltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane5.setToolTipText("");
        jTabbedPane5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane5StateChanged(evt);
            }
        });
        jTabbedPane5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTabbedPane5FocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Área:");
        jLabel2.setBounds(370, 150, 50, 17);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ministerio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ministerio.setText("Ministério:");
        ministerio.setBounds(210, 50, 70, 17);
        jLayeredPane2.add(ministerio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        instituicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        instituicao.setText("Instituição:");
        instituicao.setBounds(210, 100, 70, 17);
        jLayeredPane2.add(instituicao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelDataInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDataInicio.setText("*Data de Início:");
        jLabelDataInicio.setBounds(370, 200, 100, 17);
        jLayeredPane2.add(jLabelDataInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldMinisterio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldMinisterio.setBounds(210, 70, 320, 30);
        jLayeredPane2.add(jTextFieldMinisterio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldInstituicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldInstituicao.setBounds(210, 120, 320, 30);
        jLayeredPane2.add(jTextFieldInstituicao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldEdital.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldEdital.setBounds(210, 220, 150, 30);
        jLayeredPane2.add(jTextFieldEdital, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelCampus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCampus.setText("Campus:");
        jLabelCampus.setBounds(210, 150, 70, 17);
        jLayeredPane2.add(jLabelCampus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        classe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classe.setText("Classe do Concurso:");
        classe.setBounds(210, 270, 140, 17);
        jLayeredPane2.add(classe, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldArea.setBounds(370, 170, 160, 30);
        jLayeredPane2.add(jTextFieldArea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxClasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adjunto", "Assistente", "Auxiliar", "Substituto" }));
        jComboBoxClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClasseActionPerformed(evt);
            }
        });
        jComboBoxClasse.setBounds(340, 260, 190, 30);
        jLayeredPane2.add(jComboBoxClasse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        edital.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edital.setText("Edital:");
        edital.setBounds(210, 200, 50, 17);
        jLayeredPane2.add(edital, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDateChooserDataInicio.setBounds(370, 220, 160, 30);
        jLayeredPane2.add(jDateChooserDataInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxCampus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCampus.setMinimumSize(new java.awt.Dimension(75, 20));
        jComboBoxCampus.setBounds(210, 170, 150, 30);
        jLayeredPane2.add(jComboBoxCampus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelDadosGeraisLayout = new javax.swing.GroupLayout(jPanelDadosGerais);
        jPanelDadosGerais.setLayout(jPanelDadosGeraisLayout);
        jPanelDadosGeraisLayout.setHorizontalGroup(
            jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
        );
        jPanelDadosGeraisLayout.setVerticalGroup(
            jPanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Dados Gerais", jPanelDadosGerais);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Presidente:");
        jLabel9.setBounds(200, 10, 70, 17);
        jLayeredPane3.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Sexo:");
        jLabel10.setBounds(370, 60, 50, 17);
        jLayeredPane3.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldPresidente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPresidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPresidenteActionPerformed(evt);
            }
        });
        jTextFieldPresidente.setBounds(200, 30, 280, 30);
        jLayeredPane3.add(jTextFieldPresidente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxPresidenteTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxPresidenteTitulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professor Titular", "Professor Associado", "Professor Adjunto", "Outro", " " }));
        jComboBoxPresidenteTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPresidenteTituloActionPerformed(evt);
            }
        });
        jComboBoxPresidenteTitulo.setBounds(200, 80, 160, 30);
        jLayeredPane3.add(jComboBoxPresidenteTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxPresidenteSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxPresidenteSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jComboBoxPresidenteSexo.setBounds(370, 80, 110, 30);
        jLayeredPane3.add(jComboBoxPresidenteSexo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Título:");
        jLabel12.setBounds(200, 60, 70, 20);
        jLayeredPane3.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSeparator1.setBounds(0, 240, 730, 10);
        jLayeredPane3.add(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Examinador:");
        jLabel13.setBounds(200, 130, 90, 17);
        jLayeredPane3.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldExaminador1Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldExaminador1Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldExaminador1NomeActionPerformed(evt);
            }
        });
        jTextFieldExaminador1Nome.setBounds(200, 150, 280, 30);
        jLayeredPane3.add(jTextFieldExaminador1Nome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Título:");
        jLabel14.setBounds(200, 180, 70, 20);
        jLayeredPane3.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxExaminador1Titulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxExaminador1Titulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professor Titular", "Professor Associado", "Professor Adjunto", "Outro", " " }));
        jComboBoxExaminador1Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxExaminador1TituloActionPerformed(evt);
            }
        });
        jComboBoxExaminador1Titulo.setBounds(200, 200, 160, 30);
        jLayeredPane3.add(jComboBoxExaminador1Titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Sexo:");
        jLabel16.setBounds(370, 180, 50, 17);
        jLayeredPane3.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxExaminador1Sexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxExaminador1Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jComboBoxExaminador1Sexo.setBounds(370, 200, 110, 30);
        jLayeredPane3.add(jComboBoxExaminador1Sexo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSeparator2.setBounds(0, 120, 730, 20);
        jLayeredPane3.add(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxExaminador2Sexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxExaminador2Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jComboBoxExaminador2Sexo.setBounds(370, 320, 110, 30);
        jLayeredPane3.add(jComboBoxExaminador2Sexo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldExaminador2Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldExaminador2Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldExaminador2NomeActionPerformed(evt);
            }
        });
        jTextFieldExaminador2Nome.setBounds(200, 270, 280, 30);
        jLayeredPane3.add(jTextFieldExaminador2Nome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Título:");
        jLabel25.setBounds(200, 300, 70, 20);
        jLayeredPane3.add(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxExaminador2Titulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxExaminador2Titulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professor Titular", "Professor Associado", "Professor Adjunto", "Outro", " " }));
        jComboBoxExaminador2Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxExaminador2TituloActionPerformed(evt);
            }
        });
        jComboBoxExaminador2Titulo.setBounds(200, 320, 160, 30);
        jLayeredPane3.add(jComboBoxExaminador2Titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Examinador:");
        jLabel26.setBounds(200, 250, 90, 17);
        jLayeredPane3.add(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Sexo:");
        jLabel27.setBounds(370, 300, 50, 17);
        jLayeredPane3.add(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelBancaExaminadoraLayout = new javax.swing.GroupLayout(jPanelBancaExaminadora);
        jPanelBancaExaminadora.setLayout(jPanelBancaExaminadoraLayout);
        jPanelBancaExaminadoraLayout.setHorizontalGroup(
            jPanelBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
        );
        jPanelBancaExaminadoraLayout.setVerticalGroup(
            jPanelBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Banca Examinadora", jPanelBancaExaminadora);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Nome:");
        jLabel21.setBounds(10, 90, 41, 17);
        jLayeredPane4.add(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Sexo:");
        jLabel22.setBounds(260, 90, 36, 17);
        jLayeredPane4.add(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextFieldCandidatoNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCandidatoNome.setBounds(10, 110, 240, 30);
        jLayeredPane4.add(jTextFieldCandidatoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBoxCandidatoSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxCandidatoSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jComboBoxCandidatoSexo.setBounds(260, 110, 110, 30);
        jLayeredPane4.add(jComboBoxCandidatoSexo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTableCandidatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Candidatos:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCandidatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableCandidatos);
        jTableCandidatos.getColumnModel().getColumn(0).setResizable(false);

        jScrollPane1.setBounds(390, 80, 340, 190);
        jLayeredPane4.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/excluir.png"))); // NOI18N
        jButtonExcluir.setMnemonic('x');
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setBounds(250, 200, 120, 33);
        jLayeredPane4.add(jButtonExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/edt.png"))); // NOI18N
        jButtonEditar.setMnemonic('e');
        jButtonEditar.setText("Editar");
        jButtonEditar.setBounds(130, 200, 120, 33);
        jLayeredPane4.add(jButtonEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/add.png"))); // NOI18N
        jButtonAdicionar.setMnemonic('a');
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });
        jButtonAdicionar.setBounds(10, 200, 120, 33);
        jLayeredPane4.add(jButtonAdicionar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Data de Nascimento:");
        jLabel24.setBounds(10, 140, 140, 17);
        jLayeredPane4.add(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSeparator3.setBounds(0, 300, 730, 10);
        jLayeredPane4.add(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setBounds(380, 50, 10, 250);
        jLayeredPane4.add(jSeparator4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jSeparator5.setBounds(0, 50, 730, 10);
        jLayeredPane4.add(jSeparator5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDateChooserCandidatoDataNascimento.setBounds(10, 160, 150, 30);
        jLayeredPane4.add(jDateChooserCandidatoDataNascimento, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelCandidatosLayout = new javax.swing.GroupLayout(jPanelCandidatos);
        jPanelCandidatos.setLayout(jPanelCandidatosLayout);
        jPanelCandidatosLayout.setHorizontalGroup(
            jPanelCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCandidatosLayout.createSequentialGroup()
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanelCandidatosLayout.setVerticalGroup(
            jPanelCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Candidatos", jPanelCandidatos);

        jCheckBoxProvaEscrita.setText("Prova Escrita");

        jCheckBoxProvaDeTitulos.setText("Prova de Titulos");

        jCheckBoxProvaMemorial.setText("Prova Memorial");

        jCheckBoxProvaDidatica.setText("Prova Didática");
        jCheckBoxProvaDidatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProvaDidaticaActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecione os tipos de provas que fazem parte desse concurso.");

        javax.swing.GroupLayout jPanelProvasConcursoLayout = new javax.swing.GroupLayout(jPanelProvasConcurso);
        jPanelProvasConcurso.setLayout(jPanelProvasConcursoLayout);
        jPanelProvasConcursoLayout.setHorizontalGroup(
            jPanelProvasConcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProvasConcursoLayout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(jPanelProvasConcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanelProvasConcursoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelProvasConcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxProvaDeTitulos)
                            .addComponent(jCheckBoxProvaMemorial)
                            .addComponent(jCheckBoxProvaDidatica)
                            .addComponent(jCheckBoxProvaEscrita))))
                .addGap(184, 184, 184))
        );
        jPanelProvasConcursoLayout.setVerticalGroup(
            jPanelProvasConcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProvasConcursoLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxProvaEscrita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxProvaDeTitulos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxProvaMemorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxProvaDidatica)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Provas do Concurso", jPanelProvasConcurso);

        jTabbedPane5.setBounds(0, 50, 740, 380);
        jLayeredPane1.add(jTabbedPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-756)/2, (screenSize.height-545)/2, 756, 545);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClasseActionPerformed

    private void jTextFieldPresidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPresidenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPresidenteActionPerformed

    private void jComboBoxPresidenteTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPresidenteTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPresidenteTituloActionPerformed

    private void jTextFieldExaminador1NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldExaminador1NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldExaminador1NomeActionPerformed

    private void jComboBoxExaminador1TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxExaminador1TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxExaminador1TituloActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed

        Component component = jTabbedPane5.getSelectedComponent();
        if (component == jPanelDadosGerais) {
            
            this.salvaDadosGerais();
        } else if (component == jPanelBancaExaminadora) {
            this.salvaBancaExaminadora();
        } else if (component == jPanelCandidatos) {
            this.salvaCandidatos();
        } else if (component == jPanelProvasConcurso) {
        }

        int nextTab = jTabbedPane5.getSelectedIndex() + 1;
        
        if (nextTab < jTabbedPane5.getTabCount()) {
            jTabbedPane5.setSelectedIndex(nextTab);
        }
        component = jTabbedPane5.getSelectedComponent();
         verificaBotoes(component);
        

    }//GEN-LAST:event_jButtonProximoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
       
        int nextTab = jTabbedPane5.getSelectedIndex() - 1;
        if (nextTab >= 0) {
            jTabbedPane5.setSelectedIndex(nextTab);
        }
        component = jTabbedPane5.getSelectedComponent();
         verificaBotoes(component);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void verificaBotoes(Component component){
        if (component == jPanelDadosGerais) {
            jButtonProximo.setVisible(true);
            jButtonVoltar.setVisible(false);
        } else if (component == jPanelBancaExaminadora) {
            jButtonProximo.setVisible(true);
            jButtonVoltar.setVisible(true);
        } else if (component == jPanelCandidatos) {
            jButtonProximo.setVisible(true);
            jButtonVoltar.setVisible(true);
        } else if (component == jPanelProvasConcurso) {
            jButtonProximo.setVisible(false);
            jButtonVoltar.setVisible(true);
        }

        
    
    }
    private void jCheckBoxProvaDidaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProvaDidaticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxProvaDidaticaActionPerformed

    private void jTextFieldExaminador2NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldExaminador2NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldExaminador2NomeActionPerformed

    private void jComboBoxExaminador2TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxExaminador2TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxExaminador2TituloActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        CandidatoDao cdao = new CandidatoDao();

        Candidato candidato = new Candidato();
        candidato.setNome(jTextFieldCandidatoNome.getText());
        candidato.setSexo(((String) jComboBoxCandidatoSexo.getSelectedItem()).substring(0, 1));
        candidato.setDataNascimento(jDateChooserCandidatoDataNascimento.getDate());
        candidato.setIdConcurso(concurso.getIdConcurso());
        candidato.setIdConcurso(Integer.valueOf(concurso.getIdConcurso()));
        try {
            cdao.inserir(candidato);
            DefaultTableModel dtm = (DefaultTableModel) jTableCandidatos.getModel();
            dtm.addRow(new Object[]{
                candidato.getIdCandidato(),
                candidato.getNome()
            });
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        jTextFieldCandidatoNome.setText("");
        jComboBoxCandidatoSexo.setSelectedIndex(0);
        jDateChooserCandidatoDataNascimento.setDate(null);
        
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void salvaDadosGerais() {
        if (concurso == null) {
            concurso = new Concurso();
            ConcursoDao cdao = new ConcursoDao();
            try {
                cdao.inserir(concurso);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        concurso.setMinisterio(jTextFieldMinisterio.getText());
        concurso.setInstituicao(jTextFieldInstituicao.getText());
        concurso.setCampus((Campus) jComboBoxCampus.getSelectedItem());
        concurso.setArea(jTextFieldArea.getText());
        concurso.setEdital(jTextFieldEdital.getText());
        concurso.setDataInicio(jDateChooserDataInicio.getDate());
        concurso.setClasseConcurso((ClasseConcurso) jComboBoxClasse.getSelectedItem());

        Set<ConstraintViolation<Concurso>> constraintViolations = validator.validate(concurso);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Concurso> constraintViolation : constraintViolations) {
                System.out.println("O atributo " + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
                JOptionPane.showMessageDialog(this, "O campo " + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            ConcursoDao cdao = new ConcursoDao();
            try {
                if (concurso.getIdConcurso() == 0) {
                    cdao.inserir(concurso);
                } else {
                    cdao.alterar(concurso);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void salvaBancaExaminadora() {
        PessoaDao pdao = new PessoaDao();
        ExaminadorDao edao = new ExaminadorDao();
        BancaExaminadoraDao bedao = new BancaExaminadoraDao();

        BancaExaminadora bExaminadora = concurso.getBancaExaminadora();
        if (bExaminadora != null) {
            Examinador presidente = bExaminadora.getPresidente();
            presidente.getPessoa().setNome(jTextFieldPresidente.getText());
            presidente.getPessoa().setSexo(jComboBoxPresidenteSexo.getSelectedItem().toString().substring(0, 1));
            Titulacao titulacaoPresidente = (Titulacao) jComboBoxPresidenteTitulo.getSelectedItem();
            presidente.setTitulacao(titulacaoPresidente);
            presidente.setIdTitulacao(titulacaoPresidente.getIdTitulacao());

            Examinador examinador2 = bExaminadora.getExaminador2();
            examinador2.getPessoa().setNome(jTextFieldExaminador1Nome.getText());
            examinador2.getPessoa().setSexo(jComboBoxExaminador1Sexo.getSelectedItem().toString().substring(0, 1));
            Titulacao titulacaoExaminador1 = (Titulacao) jComboBoxExaminador1Titulo.getSelectedItem();
            examinador2.setTitulacao(titulacaoExaminador1);
            examinador2.setIdTitulacao(titulacaoExaminador1.getIdTitulacao());

            Examinador examinador3 = bExaminadora.getExaminador3();
            examinador3.getPessoa().setNome(jTextFieldExaminador2Nome.getText());
            examinador3.getPessoa().setSexo(jComboBoxExaminador2Sexo.getSelectedItem().toString().substring(0, 1));
            Titulacao titulacaoExaminador2 = (Titulacao) jComboBoxExaminador2Titulo.getSelectedItem();
            examinador3.setTitulacao(titulacaoExaminador2);
            examinador3.setIdTitulacao(titulacaoExaminador2.getIdTitulacao());

            try {
                pdao.alterar(presidente.getPessoa());
                pdao.alterar(examinador2.getPessoa());
                pdao.alterar(examinador3.getPessoa());

                edao.alterar(presidente);
                edao.alterar(examinador2);
                edao.alterar(examinador3);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Pessoa pres = new Pessoa();
            pres.setNome(jTextFieldPresidente.getText());
            pres.setSexo(jComboBoxPresidenteSexo.getSelectedItem().toString().substring(0, 1));

            Pessoa exam1 = new Pessoa();
            exam1.setNome(jTextFieldExaminador1Nome.getText());
            exam1.setSexo(jComboBoxExaminador1Sexo.getSelectedItem().toString().substring(0, 1));

            Pessoa exam2 = new Pessoa();
            exam2.setNome(jTextFieldExaminador2Nome.getText());
            exam2.setSexo(jComboBoxExaminador2Sexo.getSelectedItem().toString().substring(0, 1));

            try {
                pdao.inserir(pres);
                pdao.inserir(exam1);
                pdao.inserir(exam2);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            Examinador presidente = new Examinador();
            presidente.setIdPessoa(pres.getIdPessoa());
            Titulacao titulacaoPresidente = (Titulacao) jComboBoxPresidenteTitulo.getSelectedItem();
            presidente.setIdTitulacao(titulacaoPresidente.getIdTitulacao());
            presidente.setPessoa(pres);
            presidente.setTitulacao(titulacaoPresidente);

            Examinador examinador2 = new Examinador();
            examinador2.setIdPessoa(exam1.getIdPessoa());
            Titulacao titulacaoExaminador1 = (Titulacao) jComboBoxExaminador1Titulo.getSelectedItem();
            examinador2.setIdTitulacao(titulacaoExaminador1.getIdTitulacao());
            examinador2.setPessoa(exam1);
            examinador2.setTitulacao(titulacaoExaminador1);

            Examinador examinador3 = new Examinador();
            examinador3.setIdPessoa(exam2.getIdPessoa());
            Titulacao titulacaoExaminador2 = (Titulacao) jComboBoxExaminador2Titulo.getSelectedItem();
            examinador3.setIdTitulacao(titulacaoExaminador2.getIdTitulacao());
            examinador3.setPessoa(exam2);
            examinador3.setTitulacao(titulacaoExaminador2);

            try {
                edao.inserir(presidente);
                edao.inserir(examinador2);
                edao.inserir(examinador3);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            BancaExaminadora bancaExaminadora = new BancaExaminadora();
            bancaExaminadora.setIdConcurso(concurso.getIdConcurso());
            bancaExaminadora.setPresidente(presidente);
            bancaExaminadora.setExaminador2(examinador2);
            bancaExaminadora.setExaminador3(examinador3);

            try {
                bedao.inserir(bancaExaminadora);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            concurso.setBancaExaminadora(bancaExaminadora);
        }
    }

    private void salvaCandidatos() {
    }

    private void jTabbedPane5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane5FocusGained
        component = jTabbedPane5.getSelectedComponent();
         verificaBotoes(component);
    }//GEN-LAST:event_jTabbedPane5FocusGained

    private void jTabbedPane5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane5FocusLost
        component = jTabbedPane5.getSelectedComponent();
         verificaBotoes(component);
    }//GEN-LAST:event_jTabbedPane5FocusLost

    private void jTabbedPane5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane5StateChanged
       component = jTabbedPane5.getSelectedComponent();
         verificaBotoes(component);
    }//GEN-LAST:event_jTabbedPane5StateChanged

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
            java.util.logging.Logger.getLogger(janNovoConc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janNovoConc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janNovoConc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janNovoConc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janNovoConc().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel classe;
    private javax.swing.JLabel edital;
    private javax.swing.JLabel instituicao;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JCheckBox jCheckBoxProvaDeTitulos;
    private javax.swing.JCheckBox jCheckBoxProvaDidatica;
    private javax.swing.JCheckBox jCheckBoxProvaEscrita;
    private javax.swing.JCheckBox jCheckBoxProvaMemorial;
    private javax.swing.JComboBox jComboBoxCampus;
    private javax.swing.JComboBox jComboBoxCandidatoSexo;
    private javax.swing.JComboBox jComboBoxClasse;
    private javax.swing.JComboBox jComboBoxExaminador1Sexo;
    private javax.swing.JComboBox jComboBoxExaminador1Titulo;
    private javax.swing.JComboBox jComboBoxExaminador2Sexo;
    private javax.swing.JComboBox jComboBoxExaminador2Titulo;
    private javax.swing.JComboBox jComboBoxPresidenteSexo;
    private javax.swing.JComboBox jComboBoxPresidenteTitulo;
    private com.toedter.calendar.JDateChooser jDateChooserCandidatoDataNascimento;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCampus;
    private javax.swing.JLabel jLabelDataInicio;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JPanel jPanelBancaExaminadora;
    private javax.swing.JPanel jPanelCandidatos;
    private javax.swing.JPanel jPanelDadosGerais;
    private javax.swing.JPanel jPanelProvasConcurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTableCandidatos;
    private javax.swing.JTextField jTextFieldArea;
    private javax.swing.JTextField jTextFieldCandidatoNome;
    private javax.swing.JTextField jTextFieldEdital;
    private javax.swing.JTextField jTextFieldExaminador1Nome;
    private javax.swing.JTextField jTextFieldExaminador2Nome;
    private javax.swing.JTextField jTextFieldInstituicao;
    private javax.swing.JTextField jTextFieldMinisterio;
    private javax.swing.JTextField jTextFieldPresidente;
    private javax.swing.JLabel ministerio;
    // End of variables declaration//GEN-END:variables
}
