
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * \brief Representa els jugadors que estan a la banqueta d'un equip
 * @file Banqueta.java
 */
public class Banqueta {
    
    // Constants --------------------------------------------------------------
    
    final static int MAX_JUGADORS_BANQUETA=12;
    
    
    // Atributs ---------------------------------------------------------------
   
    /* \brief Jugadors que estan a pista guardats en format  <DORSAL,JUGADOR> */
    private Map _jugadors;
    
     /* \brief Equip dels jugadors que conte la Banqueta */
    private Equip _equip;
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Constructor d'una nova Banqueta
     * @param equip Identifica l'equip del qual son els jugadors
     */
    public Banqueta(Equip equip){
        _jugadors = new HashMap();
        _equip = equip;
 
    }
    
    
    // Metodes Publics -------------------------------------------------------
    
    /**
     * @pre True
     * @return Cert si s'ha arribat al limit de jugadors. Fals altrament.
     */
    public boolean plena(){
        return _jugadors.size()>=MAX_JUGADORS_BANQUETA;
    }
    
    /**
     * @pre jug != null
     * @post jug afegit a banqueta
     * @param jug Jugador que es vol afegir a la banqueta
     * @throws Exception Si Banqueta plena no es pot afegir jug. Es llança excepcio
     */
    public void AfegirJugador(Jugador jug) throws Exception{
        if(plena())
            throw new Exception("La banqueta ja esta plena. Ho hi caben més jugadors");
        
        _jugadors.put(jug.getDorsal(), jug);
    }
    
    /**
     * @pre jug != null
     * @post jug Eliminat de la banqueta. Si el jugador no hi era no es realitza cap acció
     * @param jug Jugador a treure de la banqueta
     */
    public void treureJugador(Jugador jug){
        if (_jugadors.containsKey(jug.getDorsal()))
            _jugadors.remove(jug.getDorsal());
    }
    
    
    /**
     * @pre Cert
     * @post S'ha enviat missatge a tots els jugadors 
     * @param missatge String que s'ha d'enviar als jugadors
     */
    public void enviarMissatge(String missatge){
        Iterator itJugadors= _jugadors.values().iterator();
        
        while(itJugadors.hasNext()){
            ((Jugador)itJugadors.next()).rebreMissatgeEntrenador(missatge);
        }
    }
}
