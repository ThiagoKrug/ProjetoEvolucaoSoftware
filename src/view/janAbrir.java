/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.com.model.dao.ConcursoDao;
import br.com.model.entity.Concurso;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Datas;

/**
 *
 * @author thiago
 */
public class janAbrir extends javax.swing.JFrame {
    private JLabel status;

    /**
     * Creates new form janAbrir
     */
    public janAbrir(JLabel status) {
        initComponents();

        this.status = status;
        ConcursoDao concursoDao = new ConcursoDao();
        List<Concurso> concursos = null;
        try {
            concursos = concursoDao.pesquisarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Edital");
        dtm.addColumn("Área");
        dtm.addColumn("Classe do Concurso");
        dtm.addColumn("Data de Início");
        for (Concurso concurso : concursos) {
            dtm.addRow(new Object[]{
                concurso.getIdConcurso(),
                concurso.getEdital(),
                concurso.getArea(),
                concurso.getClasseConcurso().getNome(),
                Datas.getDate(concurso.getDataInicio())
            });
        }
        jTableConcursos.setModel(dtm);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConcursos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonAbrirConcurso = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(null);

        jTableConcursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Edital", "Área", "Classe do Concurso", "Data de Início"
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
        jScrollPane1.setViewportView(jTableConcursos);
        jTableConcursos.getColumnModel().getColumn(0).setResizable(false);
        jTableConcursos.getColumnModel().getColumn(1).setResizable(false);
        jTableConcursos.getColumnModel().getColumn(2).setResizable(false);
        jTableConcursos.getColumnModel().getColumn(3).setResizable(false);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 470, 310);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Abrir Concurso");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(170, 10, 160, 29);

        jButtonAbrirConcurso.setText("Abrir Concurso");
        jButtonAbrirConcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirConcursoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAbrirConcurso);
        jButtonAbrirConcurso.setBounds(60, 380, 120, 30);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancelar);
        jButtonCancelar.setBounds(300, 380, 120, 30);

        jPanel2.setBounds(0, 0, 490, 430);
        jLayeredPane1.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbrirConcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirConcursoActionPerformed
        int linha = jTableConcursos.getSelectedRow();
        if (linha >= 0) {
            int id = (Integer) jTableConcursos.getModel().getValueAt(linha, 0);
            ConcursoDao concursoDao = new ConcursoDao();
            try {
                janMenu.CONCURSO = concursoDao.pesquisarPorId(id);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            this.status.setText(
                    " Edital: " + janMenu.CONCURSO.getEdital() + 
                    " | Área: " + janMenu.CONCURSO.getArea() + 
                    " | Classe do Concurso: " + janMenu.CONCURSO.getClasseConcurso().getNome());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Concurso");
        }
    }//GEN-LAST:event_jButtonAbrirConcursoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirConcurso;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConcursos;
    // End of variables declaration//GEN-END:variables
}
