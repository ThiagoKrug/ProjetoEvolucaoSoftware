package view;

import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author thiago
 */
public class ListCellRenderer {

    public DefaultListCellRenderer createListCellRenderer(final Class classe, final String metodo) {
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value.getClass().equals(classe)) {
                    try {
                        setText((String) value.getClass().getMethod(metodo, null).invoke(value, null));
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    } catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                    } catch (InvocationTargetException ex) {
                        ex.printStackTrace();
                    } catch (NoSuchMethodException ex) {
                        ex.printStackTrace();
                    } catch (SecurityException ex) {
                        ex.printStackTrace();
                    }
                }
                return this;
            }
        };
        return dlcr;
    }
}
