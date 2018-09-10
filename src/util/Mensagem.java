package util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mensagem {
    
    public static void mostrar(JPanel janela, String msg){
        JOptionPane.showMessageDialog(janela, msg);
    }
    
}
