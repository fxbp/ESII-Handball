
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * \brief Representa un jugador del joc de handbol
 * @file Jugador.java
 */
public class Jugador extends Personatge
        implements ObserverArbitre {
  
    // Atributs ----------------------------------------------------------------
    
    
    /** \brief Pes en KG del jugador */
    private double _pes;
    
    /** \brief alçada en cm del Jugador*/
    private int _alcada;
    
    /** \brief dorsal del jugador durant el partit*/
    private int _dorsal;
    
    /** \brief numero de gols que ha fet el jugador durant el partit*/
    private int _gols;
        
    /** \brief Representa la llista de sancions que pot tenir un jugador */
    private List<Sancio> _sancions;
    
    /** \brief Represneta els jugadors a pista de l'equip. Els jugadors que siguin a pista son els que estan jugant */
    private Pista _pista;
    
    
    /** \brief Representa la banqueta de l'equip. El jugador sera a la banqueta si no es a pista o l'exclouen */
    private Banqueta _banqueta;
    
    /** \brief atribut auxiliar per determinar que un jugador estar exclos. Aquest atribut redundant s'utilitza per no haber d'implementar el concepte del temps */
    private boolean _exclos;
    
    // Constructors -----------------------------------------------------------
    
    /**
     * Crea un Personatge Jugador amb els parametres corresponents
     * @param nom nom del jugador
     * @param cognom cognom del jugador
     * @param numLlicencia número de llicencia del jugador
     * @param pes pes del jugador en kg
     * @param alcada alçada del jugador en cm
     * @param dorsal número dorsal del jugador
     * @param banqueta Banqueta on anira el jugador mentre no estigui jugant
     * @param pista Pista on va el jugador mentre esta jugant
     */
    public Jugador(String nom, String cognom, String numLlicencia, double pes, int alcada, int dorsal, Banqueta banqueta, Pista pista) {
        super(nom, cognom, numLlicencia);
        
        _pes=pes;
        _alcada=alcada;
        _dorsal=dorsal;
        _gols=0;
        _sancions=new ArrayList();
        _banqueta=banqueta;
        _pista=pista;
        _exclos=false;
    }
      
    
    
    // Metodes Publics --------------------------------------------------------
    
    /**
     * @pre True
     * @return Número enter que representa el número de dorsal del Jugador
     */
    public int getDorsal(){
        return _dorsal;
    }
    
    /**
     * @pre True
     * @return True si el jugador te una Targeta Vermella. Fals altrament.
     */
    public boolean expulsat(){
        Iterator itSancions = _sancions.iterator();
        boolean expulsat=false;
        while(!expulsat && itSancions.hasNext()){
            expulsat = ((Sancio)itSancions.next()).getTipus()==Sancio.TipusSancio.Vermella;
        }
        
        return expulsat;
    }
   
    /**
     * @pre True
     * @return Cert si el jugador està exclòs actualment. Fals altrament.
     */
    public boolean exclos(){
        return _exclos;
    }
    
    /**
     * \brief el Jugador s'anota un gol
     * @pre True
     * @post el nombre de gols del jugador ha estat incrementat en 1
     */
    public void anotarGol(){
        _gols++;
    }
    
    
    /**
     * @pre tipus != null && part > 0 && minut > 0
     * @post S'ha sancionat al jugador amb el tipus corresponent. S'han aplicat les sancions derivades de tipus amb les sancions que pogues tenir ja el jugador
     * @param tipus Sancio que s'ha d'aplicar al jugador
     * @param part part en la que s'esta sancionant al jugador 
     * @param minut minut de la part en que el jugador rep la sancio
     * @throws Exception Si no es pot realitzar alguna accio correctament
     */
    public void rebreAmonestacio(Sancio.TipusSancio tipus, int part, int minut) throws Exception{
       
        switch(tipus){
            case Groga:
                aplicarTargetaGroga(tipus,part,minut);
                break;                
            default:
                //implementar resta de sancions
                break;
        }
        
        
    }
    
    /**
     * @pre Cert
     * @post S'ha mostrat per pantalla el missatge que ha rebut de l'entrenador
     * @param missatge missatge que envia l'entrenador
     */
    public void rebreMissatgeEntrenador(String missatge){
        // En aquesta implementació farem que aquest metode escrigui a la consola
        System.out.println("Dorsal " + Integer.toString(_dorsal) +": L'entrenador m'ha enviat: ");
        System.out.println(missatge);
        System.out.println();
    }
   
    
    /**
     * @pre True
     * @post el Jugador ha anat a la Banqueta. El jugador ha sortit de pista si hi era
     * @throws Exception Si no es pot afegir el jugador a la banqueta
     */
    public void entrarBanqueta() throws Exception{
        _pista.treureJugador(this);
        if (!_banqueta.plena())
         _banqueta.AfegirJugador(this);
    }
    
    /**
     * @pre True
     * @post el jugador ha anat a Pista. El jugador ha sortit de la banqueta si hi era
     * @throws Exception Si no es pot afegir el jugador a pista
     */
    public void entrarPista() throws Exception{
        _banqueta.treureJugador(this);
        if (!_pista.plena())
            _pista.AfegirJugador(this);
    }
    
    
    
    // Metodes del Patro ObserverArbitre
    
    @Override
    public void updateAmonestacio(int dorsal, Sancio.TipusSancio tipus, int part, int minut) throws Exception{
        if (dorsal == _dorsal){
            rebreAmonestacio(tipus, part, minut);
        }
    }
    
    
    // Metodes Privats ------------------------------------------------------
    
    
    /**
     * @pre tipus != null && part > 0 && minut > 0
     * @post Aplica una targeta groga al jugador. Aplica més sancions si el jugador s'ha d'expulsar o excloure com a resultat de rebre una nova targeta groga
     * @param tipus Sancio que s'ha d'aplicar al jugador
     * @param part part en la que s'esta sancionant al jugador 
     * @param minut minut de la part en que el jugador rep la sancio
     * @throws Exception si no  es pot realitzar alguna acció correctament
     */
    private void aplicarTargetaGroga(Sancio.TipusSancio tipus, int part, int minut) throws Exception{
        int groguesPart=0;
        int exclusions=0;
        
        Iterator itSancions= _sancions.iterator();
        
        while(itSancions.hasNext()){
            Sancio sancioActual=(Sancio)itSancions.next();
            if (sancioActual.getPart() == part && sancioActual.getTipus() == Sancio.TipusSancio.Groga)
                groguesPart++;
            
            if (sancioActual.getTipus() == Sancio.TipusSancio.Exclusio)
                exclusions++;
        }
        
        //afegir la sancio actual
        _sancions.add(new Sancio(minut,part,tipus));
        
        if ( groguesPart>=1){
            //implica com a minim 1 Exclusio{
            
            if (exclusions>=2){
                // si ja tenia 2 exclusions i ara n'afegim 1 de nova --> expulsio directe
                _sancions.add(new Sancio(minut,part,Sancio.TipusSancio.Vermella));
            }
            else{
                // aplicar la exclusio de 2 minuts 
                _sancions.add(new Sancio(minut,part,Sancio.TipusSancio.Exclusio));
            }
            // en ambdós cassos el jugador pasara a la banqueta           
            entrarBanqueta();            
        }
            
    }
}
