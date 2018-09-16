package util;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class MyCellRenderer extends DefaultTableCellRenderer {
    
    /**
     * Creates a new instance of MyCellRenderer
     */
    public MyCellRenderer() {
        super();
    }
    
   public Component getTableCellRendererComponent (
            javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = (JLabel)super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        TableModel tm = table.getModel();
        if (isSelected) {
            label.setForeground(Color.BLACK);
            label.setBackground(new Color(153,204,255));
        } else {
            label.setForeground(Color.BLACK);
            label.setBackground(Color.getHSBColor(100, 40, 190));
        }
        return label;
    }
    
}
