/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author vagner
 */
public class IReportManager {
    
    public static void show(Map<String, Object> parametros, List lista){
    
        try {
            JFrame frame = new JFrame();
            frame.setTitle("ThaiCreate.Com Customer Report");
            frame.setBounds(100, 100, 800,600);
            frame.getContentPane().add(new JRViewer(outroTeste(parametros, lista)));
            frame.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static JasperPrint outroTeste(Map<String, Object> parametros, List lista) throws JRException, FileNotFoundException{
                
        String fileName = "relatorio_vendas.jrxml";
        String patch = System.getProperty("user.dir")+ File.separator+ "src" + File.separator + "report" + File.separator + fileName;
        
        JasperReport report = JasperCompileManager.compileReport(patch);
        return JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(lista));
    }
    
}
