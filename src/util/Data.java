package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    public static Date converteStringToDate(String data){
        try {
            if(data != null && !data.trim().isEmpty())
                return new SimpleDateFormat("MM/dd/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String converteDateToString(Date data){
        if(data != null)
            return new SimpleDateFormat("dd/MM/yyyy").format(data);
        return null;
    }
}
