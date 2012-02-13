 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author administrador
 */
public class ConvData {

    private SimpleDateFormat formatIso;
    private SimpleDateFormat formatBra;
    private Date date;

    public ConvData() {
        formatIso = new SimpleDateFormat("yyyy-MM-dd");
        formatBra = new SimpleDateFormat("dd/MM/yyyy");
    }

    /** 
     * Converte uma data no formato ABNT em formato ISO; 
     * @param dataBra Argumento que recebe data no formato ABNT(dd/MM/yyyy); 
     * @return Uma data no formato ISO(yyyy-MM-dd). 
     */
    public String parseDataIso(String dataBra) {
        try {
            date = formatBra.parse(dataBra);
            return (formatIso.format(date));
            
        } catch (ParseException e) {
            e.printStackTrace();
            return ("Parse Date Error");
        }
    }

    /** 
     * Converte uma data no formato ISO em formato ABNT; 
     * @param dataIso Argumento que recebe data no formato ISO(yyyy-MM-dd); 
     * @return Uma data no formato ABNT(dd/MM/yyyy). 
     */
    public String parseDataBra(String dataIso) {
        try {
            date = formatIso.parse(dataIso);
            return (formatBra.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return ("Parse Date Error");
        }
    }
}
