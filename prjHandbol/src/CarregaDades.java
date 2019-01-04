
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


/**
 * \brief Classe que recull les dades de fitxers i obte els objectes per el partit de handbol
 * @file CarregaDades.java
 */
public class CarregaDades {
    
    final static String SEPARADOR=";";
    

    
    final static  String FITXER_ARBITRE="carrega/Arbitres.csv";
   
    
    
    private List<Arbitre> _arbitres;
    
    public void inicialitzaDades(){
        List<String> liniesArbitres=llegirFitxer(FITXER_ARBITRE);
        
    }
    
    
    private List<String> llegirFitxer(String fitxer){
        
        List<String> linies=new ArrayList();
        BufferedReader br = null;
        try {
        
            br = new BufferedReader(new FileReader(fitxer));
            String line = br.readLine();
            //saltar la primera linia que conte la descripcio dels camps
            line =br.readLine();
            while(line != null){
                linies.add(line);
                //System.out.println(line);
                line = br.readLine();
            }
        }
        catch(Exception e){
           System.err.println(e);
        }
        
        return linies;
    }
}
