package view;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thiago
 */
public class ConcursoTableModel extends AbstractTableModel {

    private String[] columnNames = {"Edital",
        "Área",
        "Classe do Concurso",
        "Data de Início"};
    private Object[][] data = {
        {"teste", "area", "classe", "data"}
    };

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
    }
}
