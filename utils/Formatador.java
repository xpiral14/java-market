package utils;

import java.text.DecimalFormat;

/**
 * Formatador
 */
public class Formatador {

    static public String decimal(double numero){
        DecimalFormat formato = new DecimalFormat("##.##");      
        
        return formato.format(numero);
    }
}