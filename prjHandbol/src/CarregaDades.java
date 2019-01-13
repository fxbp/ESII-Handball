
import java.io.BufferedReader;
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
    final static  String FITXER_ENTRENADORS="carrega/Entrenadors.csv";
    final static  String FITXER_JUGADORS="carrega/Jugadors.csv";
    final static  String FITXER_MISSATGES="carrega/missatgesEntrenador.csv";
    final static  String FITXER_SANCIONS="carrega/SancionsJugador.csv";
   
    // Atributs ----------------------------------------------------------------
    
    /** \brief repesenta el partit amb tots els elements necessaris per fer la simulacio*/
    private Partit _partit;
    
    
    // Metodes Publics --------------------------------------------------------
    
    
    /**
     * @pre True
     * @post Ha llegit i carregat les dades correspontes a cada classe per crear un partit nou
     * @throws Exception 
     */
    public void inicialitzaDades() throws Exception{
                   
        SubjectArbitre subject = ComiteSignleton.getInstance();
        List<Equip> equips= fromCSV(new EquipCSVEntity(),llegirFitxer(FITXER_EQUIPS));
        List<Arbitre> arbitres = fromCSV(new ArbitreCSVEntity(),llegirFitxer(FITXER_ARBITRES));
        
        List<Entrenador> entrenadors = fromCSV(new EntrenadorCSVEntity(equips, subject), llegirFitxer(FITXER_ENTRENADORS));
        List<Missatge> missatges = fromCSV(new MissatgeCSVEntity(entrenadors), llegirFitxer(FITXER_MISSATGES));
        List<Jugador> jugadors = fromCSV(new JugadorCSVEntity(equips,subject), llegirFitxer(FITXER_JUGADORS));
        List<Sancio> sancions = fromCSV(new SancioCSVEntity(jugadors), llegirFitxer(FITXER_SANCIONS));
        
        List<Partit> partits = fromCSV(new PartitCSVEntity(arbitres, equips), llegirFitxer(FITXER_PARTIT)); 
        
        _partit = partits.get(0);
    }
    
    /**
     * @pre dades inicialitzades
     * @return la instancia del partit un cop tots els fitxer que el formen s'han carregat
     */
    public Partit getPartit(){
        return _partit;
    }
    
    // Metodes Privats ---------------------------------------------------------
    
    /**
     * @pre parser != null && linies != null
     * @param parser objecte que sap llegir i crear nous objectes a partir de linies
     * @param linies llista que conte els registres
     * @return una llista amb els objectes corresponents al tipus de parser que ha rebut per parametre
     * @throws Exception llança exepcio si no es poden crear les linies correctament
     */
    private List fromCSV(CSVEntity parser, List<String> linies) throws Exception{
        
        List result=new ArrayList();
        for(String linia : linies){
            result.add(parser.create(linia, SEPARADOR));
        }
        return result;
    }
    
   
    /**
     * @pre fitxer es un nom de fitxer valid
     * @param fitxer nom de fitxer a llegir
     * @return retorna una llista amb els diferents registres que ha llegit de fitxer
     */
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
