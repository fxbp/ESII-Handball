
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author fbullich
 */
public abstract class AgrupacioJugadors {
    
    // Atributs ---------------------------------------------------------------
    
    /** \brief estipula quin es el limit de jugadors de l'agrupacio*/
    private int _limit;
    
    /* \brief Jugadors que estan a pista guardats en format  <DORSAL,JUGADOR> */
    private Map _jugadors;
    
     /* \brief Equip dels jugadors que conte la Banqueta */
    private Equip _equip;
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Constructor d'una nova AgrupacioJugadors
     * @param equip Identifica l'equip del qual son els jugadors
     * @param limit Estableix quina es la capacitat maxima de l'agruapacio
     */
    public AgrupacioJugadors(Equip equip, int limit){
        _jugadors = new HashMap();
        _equip = equip;
        _limit=limit;
 
    }
    
    
    // Metodes Publics -------------------------------------------------------
    
    /**
     * @pre True
     * @return Cert si s'ha arribat al limit de jugadors. Fals altrament.
     */
    public final boolean plena(){
        return _jugadors.size()>= _limit;
    }
    
    /**
     * @pre jug != null
     * @post jug afegit a Agrupacio
     * @param jug Jugador que es vol afegir a la Agrupacio
     * @throws Exception Si AgrupacioJugadors plena no es pot afegir jug. Es llança excepcio
     */
    public final void AfegirJugador(Jugador jug) throws Exception{
        if(plena())
            throw new Exception("La banqueta ja esta plena. Ho hi caben més jugadors");
        
        _jugadors.put(jug.getDorsal(), jug);
    }
    
    /**
     * @pre jug != null
     * @post jug Eliminat de la Agrupacio. Si el jugador no hi era no es realitza cap acció
     * @param jug Jugador a treure de la Agrupacio
     */
    public final void treureJugador(Jugador jug){
        if (_jugadors.containsKey(jug.getDorsal()))
            _jugadors.remove(jug.getDorsal());
    }
    
    
    /**
     * @pre Cert
     * @post S'ha enviat missatge a tots els jugadors 
     * @param missatge String que s'ha d'enviar als jugadors
     */
    public final void enviarMissatge(String missatge){
        Iterator itJugadors= _jugadors.values().iterator();
        
        while(itJugadors.hasNext()){
            ((Jugador)itJugadors.next()).rebreMissatgeEntrenador(missatge);
        }
    }
}
