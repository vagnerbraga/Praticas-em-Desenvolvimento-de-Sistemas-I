package util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entidade;

public class Arquivo {
    
    public static final String CLIENTE_DAT = "cliente.dat";
    public static final String PRODUTO_DAT = "produto.dat";
    public static final String ESTOQUE_DAT = "estoque.dat";
    public static final String VENDA_DAT = "venda.dat";
    
    public static void gravar(List lista, String nomeArquivo) throws Exception {

        try {
            verificaCriaArquivo(nomeArquivo);
            FileOutputStream fs = new FileOutputStream(nomeArquivo);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            
            os.writeObject(lista);
            os.close();
        
        } catch (Exception e) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
    }
    
    public static Object recuperar(String nomeArquivo) throws Exception {
       ObjectInputStream ios = null;
        try {
            verificaCriaArquivo(nomeArquivo);
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ios = new ObjectInputStream(fis);
            
            return ios.readObject();
            
        } catch (EOFException eof){
            
            System.out.println("util.Arquivo.recuperar()- [ Arquivo vazio ] ");
        } catch (Exception e) {
            throw e;
        } finally{
            if(ios != null)
                ios.close();
        }
        return new ArrayList<>();
    }
    
    public static void verificaCriaArquivo(String nomeArquivo) throws Exception{
        try {
            File f = new File(nomeArquivo);
            if(!f.exists())
                f.createNewFile();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void limparArquivo(String nomeArquivo){
        
        try {
            File f = new File(nomeArquivo);
            f.delete();
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
