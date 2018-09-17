package util;

import inerfaces.IPreparaDadosParaTabela;
import java.time.Clock;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Configura {
    
    /**
     * @param tabela
     * @param dados
     */
    public static void tabela(JTable tabela, List<? extends IPreparaDadosParaTabela> dados){
        
        tabela.removeAll();
        if(dados != null && !dados.isEmpty()){
            
            Vector<Vector> rowsData = new Vector<Vector>();
            
            dados.forEach((item)->{
                rowsData.addElement(item.toVectorDados());
            });
            
            tabela.setModel(new javax.swing.table.DefaultTableModel(
                rowsData, dados.get(0).toVectorColumn()
            ));
        }
    }
    
    public static JComboBox ComboBox(JComboBox combo, List lista){
        
        combo.removeAllItems();
        combo.setSelectedIndex(-1);
        lista.forEach((item) -> {
            combo.addItem(item.toString());
        });
        return combo;
    }
    
    
}
