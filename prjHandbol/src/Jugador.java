
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;



/**
 * \brief Representa un jugador del joc de handbol
 * @file Jugador.java
 */
public class Jugador extends Personatge
        implements ObserverArbitre {
  
    // Atributs ----------------------------------------------------------------
    private static Random random = new Random();
    
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
    
    private Equip _equip;
    
    /** \brief atribut auxiliar per determinar que un jugador estar exclos. Aquest atribut redundant s'utilitza per no haber d'implementar el concepte del temps */
    private boolean _exclos;
    
    
    /** \brief Representa l'objecte que fa de Subject en el patro observer de l'arbitre al qual es pot subscriure el jugador */
    private SubjectArbitre _subject;
    
    /** \brief es el rol que pren el jugador si no se li indica res mes */
    private Rol _rolPropi;
    
    /** \brief Representa el rol actual en el que es posiciona el jugador */
    private Rol _rolActual;
    
    
    // Constructors -----------------------------------------------------------
    
    /**
     * Crea un Personatge Jugador amb els parametres corresponents
     * @param nom nom del jugador
     * @param cognom cognom del jugador
     * @param numLlicencia número de llicencia del jugador
     * @param pes pes del jugador en kg
     * @param alcada alçada del jugador en cm
     * @param dorsal número dorsal del jugador
     * @param equip equip al qual pertany el jugador
     * @param rol Es el rol en que pren  el jugador per defecte
     */
    public Jugador(String nom, String cognom, String numLlicencia, double pes, int alcada, int dorsal, Equip equip, Rol rol) {
        super(nom, cognom, numLlicencia);
        
        _pes = pes;
        _alcada = alcada;
        _dorsal = dorsal;
        _gols = 0;
        _sancions = new ArrayList();
        _equip = equip;
        _exclos = false;
        _rolPropi = rol;
        _rolActual = rol;
    }
      
    
    
    // Metodes Publics --------------------------------------------------------
           
    /**
     * @pre subject != null
     * @post S'ha assignat el subject del patro observer arbitre
     * @param subject Objecte al qual es pot subscriure l'observer
     */
    public void setSubject(SubjectArbitre subject){
        _subject=subject;
    }
    
    /**
     * @pre Cert
     * @post L'observer s'ha subscrit al subjectArbitre si pendent. S'ha desubscrit altrament
     * @param pendent indica si l'observer ha d'estar pendent del subject o no
     */
    public void setPendentArbitre(boolean pendent){
        if (pendent)
            _subject.subscriure(this);
        else
            _subject.desubscriure(this);
    }
    
    /**
     * @pre dades inicialitzades
     * @post el jugador s'afegeix una sancio
     */
    public void afegirSancioInicial(Sancio sancio){
        _sancions.add(sancio);
    }
    
    /**
     * @pre True
     * @return Número enter que representa el número de dorsal del Jugador
     */
    public int getDorsal(){
        return _dorsal;
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
    public void rebreAmonestacio(Utils.TipusSancio tipus, int part, int minut) throws Exception{
       
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
     * @post el Jugador ha anat a la Banqueta o ha marxat del partit. El jugador ha sortit de pista si hi era
     * @param expulsat indica si el jugador ha estat expulsat
     */
    public void entrarBanqueta(boolean expulsat) {
        if(expulsat){
            setPendentArbitre(false);
            _equip.treureJugador(this);
        }
        else{
            _equip.moureABanqueta(this);
            //10% de estar distret
            setPendentArbitre(random.nextInt(10) > 1);
        }
    }
    
    /**
     * @pre True
     * @post el jugador ha anat a Pista. El jugador ha sortit de la banqueta si hi era
     */
    public void entrarPista() {
        _equip.moureAPista(this);
        setPendentArbitre(true);
    }
    
    
    // Metdoes del patro Strategy
    
    /**
    * @pre True
    * @post El jugador torna a jugar com el seu rol per defecte
    */
    public void resetRol(){
        _rolActual = _rolPropi;
    }
    
    /**
     * @pre nouRol != null
     * @post el jugador passa a jugar en el nouRol
     * @param nouRol rol que tindra el jugador a partir d'ara
     */
    public void canviaRol(Rol nouRol){
        _rolActual = nouRol;
        System.out.println("Soc " + super.toString() + ", hi he canviat al rol "+ nouRol.toString());
        System.out.println();
    }
    
    
    public void realitzaXut(){
        if(_rolActual.xutar())
            anotarGol();
    }
    
    
    // Metodes del Patro ObserverArbitre
    
    @Override
    public void updateAmonestacio(int dorsal, String idEquip, Utils.TipusSancio tipus, int part, int minut) throws Exception{
        if (_equip.hasID(idEquip) && dorsal == _dorsal){
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
    private void aplicarTargetaGroga(Utils.TipusSancio tipus, int part, int minut) throws Exception{
        int groguesPart=0;
        int exclusions=0;
        
        Iterator itSancions= _sancions.iterator();
        
        while(itSancions.hasNext()){
            Sancio sancioActual=(Sancio)itSancions.next();
            if (sancioActual.getPart() == part && sancioActual.getTipus() == Utils.TipusSancio.Groga)
                groguesPart++;
            
            if (sancioActual.getTipus() == Utils.TipusSancio.Exclusio)
                exclusions++;
        }
        
        //afegir la sancio actual
        _sancions.add(new Sancio(minut,part,tipus));
        System.out.println(toString() + ": He rebut una targeta groga!!\n");
        if ( groguesPart>=1){
            //implica com a minim 1 Exclusio{
            boolean expulsat =false;
            if (exclusions>=2){
                // si ja tenia 2 exclusions i ara n'afegim 1 de nova --> expulsio directe
                _sancions.add(new Sancio(minut,part,Utils.TipusSancio.Vermella));
                expulsat = true;                
                System.out.println(toString() + ": He estat expulsat!!\n");
            }
            else{
                // aplicar la exclusio de 2 minuts 
                _sancions.add(new Sancio(minut,part,Utils.TipusSancio.Exclusio));
                System.out.println(toString() + ": He estat exclòs!!\n");               
            }
            entrarBanqueta(expulsat);     
        }           
    }
    
    @Override
    public String toString()
    {
        return "Dorsal: "+ _dorsal + " " + super.toString() + " Rol: " + _rolActual.toString();
    }
 }
