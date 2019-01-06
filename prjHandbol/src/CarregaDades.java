
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
    

    
    final static  String FITXER_ARBITRES="carrega/Arbitres.csv";
    final static  String FITXER_PARTIT="carrega/Partit.csv";
    final static  String FITXER_EQUIPS="carrega/Equips.csv";
    final static  String FITXER_ENTRENADORS="carrega/Entrenators.csv";
    final static  String FITXER_JUGADORS="carrega/Jugadors.csv";
    final static  String FITXER_MISSATGES="carrega/missatgesEntrenador.csv";
    final static  String FITXER_SANCIONS="carrega/SancionsJugador.csv";
   
    
    
    private List<Arbitre> _arbitres;
    
    public void inicialitzaDades() throws Exception{
       /**
        List<String> liniesPartit=llegirFitxer(FITXER_PARTIT);
       
        
        List<String> liniesJugadors=llegirFitxer(FITXER_JUGADORS);
        List<String> liniesSancions=llegirFitxer(FITXER_SANCIONS);

        */
               
        SubjectArbitre subject = Comite.getInstance();
        List<Equip> equips= fromCSV(new EquipCSVParser(),llegirFitxer(FITXER_EQUIPS));
        List<Arbitre> arbitres = fromCSV(new ArbitreCSVParser(),llegirFitxer(FITXER_ARBITRES));
        
        List<Entrenador> entrenadors = fromCSV(new EntrenadorCSVParser(equips, subject), llegirFitxer(FITXER_ENTRENADORS));
        List<Missatge> missatges = fromCSV(new MissatgeCSVParser(entrenadors), llegirFitxer(FITXER_MISSATGES));
        
        
    }
    
    private  List fromCSV(CSVParser parser, List<String> linies) throws Exception{
        
        List result=new ArrayList();
        for(String linia : linies){
            result.add(parser.create(linia, SEPARADOR));
        }
        return result;
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
