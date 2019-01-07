
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
   
    // Atributs ----------------------------------------------------------------
    
    /** \brief repesenta el partit amb tots els elements necessaris per fer la simulacio*/
    private Partit _partit;
    
    
    // Metodes Publics --------------------------------------------------------
    
    
    public void inicialitzaDades() throws Exception{
                   
        SubjectArbitre subject = Comite.getInstance();
        List<Equip> equips= fromCSV(new EquipCSVEntity(),llegirFitxer(FITXER_EQUIPS));
        List<Arbitre> arbitres = fromCSV(new ArbitreCSVEntity(),llegirFitxer(FITXER_ARBITRES));
        
        List<Entrenador> entrenadors = fromCSV(new EntrenadorCSVEntity(equips, subject), llegirFitxer(FITXER_ENTRENADORS));
        List<Missatge> missatges = fromCSV(new MissatgeCSVEntity(entrenadors), llegirFitxer(FITXER_MISSATGES));
        List<Jugador> jugadors = fromCSV(new JugadorCSVEntity(equips,subject), llegirFitxer(FITXER_JUGADORS));
        List<Sancio> sancions = fromCSV(new SancioCSVEntity(equips), llegirFitxer(FITXER_SANCIONS));
        
        List<Partit> partits = fromCSV(new PartitCSVEntity(arbitres, equips), llegirFitxer(FITXER_PARTIT)); 
        
        _partit = partits.get(0);
    }
    
    
    // Metodes Privats ---------------------------------------------------------
    
    private List fromCSV(CSVEntity parser, List<String> linies) throws Exception{
        
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
